package com.ssssssss.aaaaaaaaaaaaa.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssssssss.aaaaaaaaaaaaa.common.dto.EmployeeDto;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResponseEmployee {

    public EmployeeDto responseEmployee ;

    public String departName ;

    public String roleName ;

    public List<String> departNames ;

    public List<String> roleNames ;

    public List<EmployeeDto> responseEmployees ;

    public String employeeMessage  ;

}
