package com.rookie.im.user.service.adapter;

import cn.hutool.core.bean.BeanUtil;
import com.rookie.im.common.enums.YesOrNoEnum;
import com.rookie.im.user.domain.dto.ModifyUserDto;
import com.rookie.im.user.domain.dto.UserDto;
import com.rookie.im.user.domain.entity.User;

import java.util.UUID;

public class UserAdapter {

    public static User importUserSave(Long appId, ModifyUserDto userDto){

        User user = new User();
        BeanUtil.copyProperties(userDto, user);

        user.setAppId(appId);
        user.setUserId(UUID.randomUUID().toString());
        user.setForbiddenFlag(YesOrNoEnum.NO.getStatus());

        return user;
    }

    public static UserDto buildUserInfo(User user) {
        UserDto userDto = new UserDto();
        BeanUtil.copyProperties(user, userDto);
        return userDto;
    }
}
