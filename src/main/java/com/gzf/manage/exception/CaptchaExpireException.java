package com.gzf.manage.exception;

/**
 * 验证码失效异常类
 *
 * @author Gaozf
 */
public class CaptchaExpireException extends BaseException {

    public CaptchaExpireException() {
        super(null, "user.jcaptcha.expire", null, null);
    }
}
