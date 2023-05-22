package com.ssssssss.aaaaaaaaaaaaa.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
public class RoleDto {


    @NotNull(message = "role name shouldn't be null")
    private String roleName;

    private int idRole;


}