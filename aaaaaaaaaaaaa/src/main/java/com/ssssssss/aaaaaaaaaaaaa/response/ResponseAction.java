package com.ssssssss.aaaaaaaaaaaaa.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssssssss.aaaaaaaaaaaaa.common.dto.ActionDto;
 import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseAction {

    public ActionDto responseAction;

    public String roleName;

    public String actionMessage;


}
