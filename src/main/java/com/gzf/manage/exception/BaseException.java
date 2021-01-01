package com.gzf.manage.exception;


import com.gzf.manage.utils.MessageGlobalUtils;
import com.gzf.manage.utils.StringUtils;
import lombok.Data;

/**
 * 基础异常
 *
 * @author gzf
 */
@Data
public class BaseException extends RuntimeException {

    /**
     * 所属模块
     */
    private String module;

    /**
     * 错误码(国际)
     */
    private String code;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    /**
     * 错误消息
     */
    private String defaultMessage;

    public BaseException(String module, String code, Object[] args, String defaultMessage) {
        this.module = module;
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    public BaseException(String module, String code, Object[] args) {
        this(module, code, args, null);
    }

    public BaseException(String module, String defaultMessage) {
        this(module, null, null, defaultMessage);
    }

    public BaseException(String code, Object[] args) {
        this(null, code, args, null);
    }

    public BaseException(String defaultMessage) {
        this(null, null, null, defaultMessage);
    }

    @Override
    public String getMessage() {
        String message = null;
        //code为国际信息码
        //如code=密码输入错误{0}次，args=3，message=密码输入错误{3}次
        if (!StringUtils.isEmpty(code)) {
            message = MessageGlobalUtils.messageConvert(code, args);
        }
        if (message == null) {
            message = defaultMessage;
        }
        return message;
    }
}
