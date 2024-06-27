package com.rookie.im.user.domain.dto;

import com.rookie.im.common.annotation.IsMobile;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {

//    private Long appId;

    // 必填
    @NotNull
    private String userName;

    // 必填
    @NotNull
    @IsMobile
    private String mobile;

    private String email;

    private String avatar;

    private Integer sex;

    private String selfSignature;

    private Integer friendAllowType;

}
