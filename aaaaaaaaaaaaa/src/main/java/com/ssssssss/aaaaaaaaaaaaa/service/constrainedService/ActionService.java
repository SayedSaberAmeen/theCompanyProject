package com.ssssssss.aaaaaaaaaaaaa.service.constrainedService;



import com.ssssssss.aaaaaaaaaaaaa.common.dto.ActionDto;
import com.ssssssss.aaaaaaaaaaaaa.exception.NotFoundException;
import com.ssssssss.aaaaaaaaaaaaa.response.ResponseAction;

import java.util.List;

public interface ActionService {
    public ResponseAction addAction(ActionDto actionDto);
    public ResponseAction getActionByID(int id) throws NotFoundException;
    public List<ResponseAction> getAllAction() throws NotFoundException;
    public ResponseAction updateAction(ActionDto actionDto) throws NotFoundException;



}
