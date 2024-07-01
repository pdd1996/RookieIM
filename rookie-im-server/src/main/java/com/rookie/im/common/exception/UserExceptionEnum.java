package com.rookie.im.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserExceptionEnum implements ErrorEnum{


    OUT_BOUND_IMPORT_LIMIT(-1, "超出用户导入数量上限，请分批导入"),
    MODIFY_USER_INFO_ERROR(-2, "修改用户信息失败"),
    USER_NOT_EXIST(-3, "待更新用户不存在"),
    ;

    private final Integer code;
    private final String msg;
    @Override
    public Integer getErrorCode() {
        return code;
    }

    @Override
    public String getErrMsg() {
        return msg;
    }
}
