package com.rookie.im.user.domain.dto;

import lombok.Data;

@Data
public class UserEntity {

    private Long appId;
    private String userName;

    private String mobile;

    private String email;

    private String avatar;

    private Integer sex;

    private String selfSignature;

    private Integer friendAllowType;

}
