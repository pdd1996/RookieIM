package com.rookie.im.user.controller;


import com.rookie.im.common.domain.resp.ApiResult;
import com.rookie.im.common.domain.resp.PageResponse;
import com.rookie.im.user.domain.dto.UserDto;
import com.rookie.im.user.domain.req.ImportUserReq;
import com.rookie.im.user.domain.req.ModifyUserInfoReq;
import com.rookie.im.user.domain.resp.ImportUserResp;
import com.rookie.im.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
@Api(tags = "用户资料相关接口")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/test")
    public String getUser(){
        return userService.getUserById(1).getUserName();
    }
    @PutMapping("/import")
    @ApiOperation(value = "用户资料导入")
    public ApiResult<ImportUserResp> importUser(@RequestBody @Valid ImportUserReq req){
        ImportUserResp resp = userService.importUsers(req);
        return ApiResult.success(resp);
    }

    @PostMapping("/modify")
    @ApiOperation(value = "修改用户信息")
    public ApiResult<Void> ModifyUserInfo(@RequestBody @Valid ModifyUserInfoReq req){
        userService.modifyUserInfo(req);
        return ApiResult.success();
    }

    @GetMapping("/getAllUserInfo")
    @ApiOperation(value = "获取所有用户信息")
    public ApiResult<PageResponse<UserDto>> GetAllUserInfo(Long appId, Integer page, Integer pageSize){
        PageResponse<UserDto> allUser = userService.getAllUser(appId, page, pageSize);
        return ApiResult.success(allUser);
    }
}

