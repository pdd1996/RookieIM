package com.rookie.im.user.service.adapter;

import cn.hutool.core.bean.BeanUtil;
import com.rookie.im.common.enums.YesOrNoEnum;
import com.rookie.im.user.domain.dto.UserDto;
import com.rookie.im.user.domain.entity.User;

import java.util.UUID;

public class UserAdapter {

    public static User importUserSave(UserDto userDto){

        User user = new User();
        BeanUtil.copyProperties(userDto, user);

        user.setUserId(UUID.randomUUID().toString());
        user.setForbiddenFlag(YesOrNoEnum.NO.getStatus());

        return user;
    }

}
