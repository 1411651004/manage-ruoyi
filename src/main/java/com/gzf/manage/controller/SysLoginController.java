package com.gzf.manage.controller;

import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.common.Constants;
import com.gzf.manage.entry.model.LoginBody;
import com.gzf.manage.security.usersecurity.SysLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProgramName: manage
 * @ClassName: SysLoginController
 * @description: 系统登录控制层
 * @author: Gaozf
 * @Date: 2021/1/11 15:57
 **/
@RestController
public class SysLoginController {

    @Autowired
    SysLoginService loginService;
    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }
}
