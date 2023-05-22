package com.ssssssss.aaaaaaaaaaaaa.common.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ActionDto {

    @NotNull(message = "name action shouldn't be null")
    private String nameAction;
    @NotNull(message = "data action shouldn't be null")
    private String dataAction;
    @NotNull(message = "cod action shouldn't be null")
    private String codeAction;

    private int idAction;
    private int idRole;


}















