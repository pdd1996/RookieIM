package com.rookie.im.user.domain.req;

import com.rookie.im.common.domain.req.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(value = "修改用户信息请求体")
public class ModifyUserInfoReq extends BaseRequest {

    @NotBlank(message = "用户 ID 不能为空")
    private String userId;
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "用户头像")
    private String avatar;
    @ApiModelProperty(value = "性别")
    private Integer sex;
    @ApiModelProperty(value = "用户个性签名")
    private String selfSignature;
    @ApiModelProperty(value = "加好友验证类型（Friend_AllowType） 1无需验证 2需要验证")
    private Integer friendAllowType;
    @ApiModelProperty(value = "扩展字段")
    private String extra;

}
