package com.ssssssss.aaaaaaaaaaaaa.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DepartmentDto {

    @NotNull(message = "department name shouldn't be null")
    @NotBlank
    private String departName;
    @NotBlank
    private String description;

    private int idDepart;

}