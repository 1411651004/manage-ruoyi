package com.gzf.manage.security.usersecurity;

import com.gzf.manage.common.Constants;
import com.gzf.manage.exception.BaseException;
import com.gzf.manage.exception.CaptchaExpireException;
import com.gzf.manage.exception.ServiceException;
import com.gzf.manage.manager.AsyncManager;
import com.gzf.manage.manager.factory.AsyncFactory;
import com.gzf.manage.security.usermodel.LoginUser;
import com.gzf.manage.security.utils.TokenService;
import com.gzf.manage.utils.MessageGlobalUtils;
import com.gzf.manage.utils.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 登录校验方法
 *
 * @author ruoyi
 */
@Component
public class SysLoginService {
    @Autowired
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @param code     验证码
     * @param uuid     验证码唯一标识
     * @return 结果
     */
    public String login(String username, String password, String code, String uuid) {
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username,
                    Constants.LOGIN_FAIL, MessageGlobalUtils.messageConvert("user.jcaptcha.expire")));
            //("验证码已失效");
            throw new CaptchaExpireException("user.jcaptcha.expire");
        }
        if (!code.equalsIgnoreCase(captcha)) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username,
                    Constants.LOGIN_FAIL, MessageGlobalUtils.messageConvert("user.jcaptcha.error")));
            //("验证码错误");
            throw new CaptchaExpireException("user.jcaptcha.error");
        }
        // 用户验证
        Authentication authentication = null;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                //AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
                throw new BaseException("user.password.not.match", (Object[]) null);
            } else {
                //AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage()));
                throw new ServiceException(e.getMessage());
            }
        }
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS,
                MessageGlobalUtils.messageConvert("user.login.success")));
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // 生成token
        return tokenService.createToken(loginUser);
    }
}
