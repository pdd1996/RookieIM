package com.rookie.im.user.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rookie.im.common.enums.YesOrNoEnum;
import com.rookie.im.user.domain.entity.User;
import com.rookie.im.user.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜鸟 IM 用户表 服务实现类
 * </p>
 *
 * @author paddy
 * @since 2024-06-18
 */
@Service
public class UserDao extends ServiceImpl<UserMapper, User> {
    @Autowired
    private UserMapper userMapper;
    public User getUserInfoByUserId(Long appId, String userId) {
        return lambdaQuery()
                .eq(User::getAppId, appId)
                .eq(User::getUserId, userId)
                .eq(User::getForbiddenFlag, YesOrNoEnum.NO.getStatus())
                .one();
    }

    public boolean updateUserInfo(User update) {
        return lambdaUpdate()
                .eq(User::getAppId, update.getAppId())
                .eq(User::getUserId, update.getUserId())
                .set(User::getUserName, update.getUserName())
                .set(User::getAvatar, update.getAvatar())
                .set(User::getSex, update.getSex())
                .set(User::getSelfSignature, update.getSelfSignature())
                .set(User::getFriendAllowType, update.getFriendAllowType())
                .update();
    }

    public Page<User> getAllUser(Long appId, Page<User> userPage) {

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getAppId, appId);
        lambdaQueryWrapper.eq(User::getForbiddenFlag, YesOrNoEnum.NO.getStatus());

        return userMapper.selectPage(userPage, lambdaQueryWrapper);
    }
}
