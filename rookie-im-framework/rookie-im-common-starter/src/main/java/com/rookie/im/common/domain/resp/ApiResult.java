package com.rookie.im.common.domain.resp;

import lombok.Data;

@Data
public class ApiResult<T> {

    private Boolean success;

    private Integer code;

    private String errMsg;

    private T data;

    public static <T> ApiResult<T> success() {
        ApiResult<T> result = new ApiResult<>();
        result.setData(null);
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> result = new ApiResult<>();
        result.setData(data);
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public static <T> ApiResult<T> fail(Integer code, String errMsg) {
        ApiResult<T> result = new ApiResult<>();
        result.setSuccess(Boolean.FALSE);
        result.setCode(code);
        result.setErrMsg(errMsg);
        return result;
    }
}
