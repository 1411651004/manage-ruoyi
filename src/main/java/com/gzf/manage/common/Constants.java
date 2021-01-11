package com.gzf.manage.common;

/**
 * @program: manage
 * @description: 通用常量
 * @author: Gaozf
 * @create: 2020-12-28 15:00
 **/
public class Constants {

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 验证码有效期（分钟）
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";
    /**
     * 文件上传成功
     */
    public static final String UPLOAD_SUCCESS = "文件上传成功！";
    /**
     * 文件上传失败
     */
    public static final String UPLOAD_ERROR = "文件上传失败！";
}
