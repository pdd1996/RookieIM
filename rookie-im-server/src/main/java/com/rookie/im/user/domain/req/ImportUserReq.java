package com.rookie.im.user.domain.req;

import com.rookie.im.common.domain.req.BaseRequest;
import com.rookie.im.user.domain.dto.UserEntity;
import lombok.Data;

import java.util.List;

@Data
public class ImportUserReq extends BaseRequest {

    private List<UserEntity> userList;

}
