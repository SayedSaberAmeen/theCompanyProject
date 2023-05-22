package com.ssssssss.aaaaaaaaaaaaa.response;

import com.fasterxml.jackson.annotation.JsonInclude;
 import com.ssssssss.aaaaaaaaaaaaa.common.dto.RoleDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseRole {
    public RoleDto roleDto;


    public String roleMessage;


}
