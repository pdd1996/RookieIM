package com.rookie.im.user.domain.dto;

import com.rookie.im.common.annotation.IsMobile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "导入用户资料实体")
public class ModifyUserDto {

//    private Long appId;

    // 必填
    @NotNull
    @ApiModelProperty(value = "用户名",required = true)
    private String userName;

    // 必填
    @NotNull
    @IsMobile
    @ApiModelProperty(value = "手机号")
    private String mobile;

    private String email;

    private String avatar;

    private Integer sex;

    private String selfSignature;

    private Integer friendAllowType;

}
