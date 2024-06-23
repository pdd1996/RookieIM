package com.rookie.im.user.domain.req;

import com.rookie.im.common.domain.req.BaseRequest;
import com.rookie.im.user.domain.dto.UserDto;
import lombok.Data;

import java.util.List;

@Data
public class ImportUserReq extends BaseRequest {

    private List<UserDto> userList;

}
