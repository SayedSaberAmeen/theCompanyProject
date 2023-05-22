package com.ssssssss.aaaaaaaaaaaaa.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssssssss.aaaaaaaaaaaaa.common.dto.DepartmentDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDeportment {

    public DepartmentDto responseDepartment;

    public String departmentMessage;


}
