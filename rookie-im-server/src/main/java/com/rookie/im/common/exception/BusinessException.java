package com.rookie.im.common.exception;

import lombok.Data;

/**
 * 业务异常：我们的限制异常
 */
@Data
public class BusinessException extends RuntimeException{

    private Integer errorCode;

    private String errMsg;

    public BusinessException() {
        super();
    }

    public BusinessException(Integer errorCode, String errMsg) {
        super(errMsg);
        this.errorCode = errorCode;
        this.errMsg = errMsg;
    }

    public BusinessException(ErrorEnum error) {
        super(error.getErrMsg());
        this.errorCode=error.getErrorCode();
        this.errMsg=error.getErrMsg();
    }

}
