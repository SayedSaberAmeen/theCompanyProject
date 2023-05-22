package com.ssssssss.aaaaaaaaaaaaa.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {

    @NotNull(message = "employee name shouldn't be null")
    private String employeeName;
    @Pattern(regexp = "^\\d{10}$",message = "invalid phone number entered")
    private String phoneNumber;
    @NotNull(message = " should be entering card number")
    private String cardNumber;
    @NotNull(message = "employee name shouldn't be null")
    private String address;
    @Email(message = "invalid email address")
    private String mail;
    @Min(20)
    @Max(60)
    private int  age;


    private int idEmp ;
    private int departmentId ;
    private int roleId ;







/*
    private String departmentName;
    private String roleName;

*/

}



