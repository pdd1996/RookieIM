package com.rookie.im.user.service;

import com.rookie.im.common.domain.resp.PageResponse;
import com.rookie.im.user.domain.dto.UserDto;
import com.rookie.im.user.domain.entity.User;
import com.rookie.im.user.domain.req.ImportUserReq;
import com.rookie.im.user.domain.req.ModifyUserInfoReq;
import com.rookie.im.user.domain.resp.ImportUserResp;

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

    ImportUserResp importUsers(ImportUserReq req);

    void modifyUserInfo(ModifyUserInfoReq req);

    PageResponse<UserDto> getAllUser(Long appId, Integer page, Integer pageSize);
}
