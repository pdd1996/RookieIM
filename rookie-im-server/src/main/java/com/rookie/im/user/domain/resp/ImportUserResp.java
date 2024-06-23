package com.rookie.im.user.domain.resp;

import lombok.Data;

import java.util.List;

@Data
public class ImportUserResp {

    private List<String> errorImportUserNames;

}
