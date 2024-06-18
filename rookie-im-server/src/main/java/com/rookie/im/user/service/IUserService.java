package com.rookie.im.user.service;

import com.rookie.im.user.domain.entity.User;

/**
 * <p>
 * 菜鸟 IM 用户表 服务类
 * </p>
 *
 * @author paddy
 * @since 2024-06-18
 */
public interface IUserService {
    User getUserById(Integer id);
}
