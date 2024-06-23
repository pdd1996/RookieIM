package com.rookie.im.user.controller;


import com.rookie.im.common.domain.resp.ApiResult;
import com.rookie.im.user.domain.req.ImportUserReq;
import com.rookie.im.user.domain.resp.ImportUserResp;
import com.rookie.im.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 菜鸟 IM 用户表 前端控制器
 * </p>
 *
 * @author paddy
 * @since 2024-06-18
 */
@RestController
@RequestMapping("/capi/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/test")
    public String getUser(){
        return userService.getUserById(1).getUserName();
    }
    @PutMapping("/import")
    public ApiResult<ImportUserResp> importUser(@RequestBody ImportUserReq req){
        ImportUserResp resp = userService.importUsers(req);
        return ApiResult.success(resp);
    }
}

