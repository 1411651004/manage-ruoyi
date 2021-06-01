package com.gzf.manage.common;

/**
 * @program: manage
 * @description: 通用常量
 * @author: Gaozf
 * @create: 2020-12-28 15:00
 **/
public class Constants {
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";
    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";
    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";
    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 验证码有效期（分钟）
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;
    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";
    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";
    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";
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
    /**
     * 令牌前缀
     */
    public static final String LOGIN_USER_KEY = "login_user_key";
    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";
    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";
    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    public static final String INSERT_SUCCESS = "新增成功";
    public static final String UPDATE_SUCCESS = "更新成功";
    public static final String DELETE_SUCCESS = "删除成功";

    /**
     * 栏目常量
     */
    public static final String CATE_NAME_NOTNULL = "栏目名称不能为空";
    public static final String CATE_KEY_NOTNULL = "栏目KEY不能为空";
    public static final String CATE_NAME_EXIST = "栏目名称已存在";
    public static final String CATE_KEY_EXIST = "栏目key已存在";
    /**
     * 模块常量
     */
    public static final String MODULE_NAME_NOTNULL = "模块名称不能为空";
    public static final String MODULE_KEY_NOTNULL = "模块KEY不能为空";
    public static final String MODULE_NAME_EXIST = "模块名称已存在";
    public static final String MODULE_KEY_EXIST = "模块key已存在";

}
