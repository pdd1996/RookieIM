package com.rookie.im.common.domain.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "通用返回体")
public class ApiResult<T> {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    @ApiModelProperty(value = "错误码")
    private Integer code;
    @ApiModelProperty(value = "错误信息")
    private String errMsg;
    @ApiModelProperty(value = "返回对象")
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
