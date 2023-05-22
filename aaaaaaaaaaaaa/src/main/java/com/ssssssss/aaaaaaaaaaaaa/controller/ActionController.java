package com.ssssssss.aaaaaaaaaaaaa.controller;

import com.ssssssss.aaaaaaaaaaaaa.common.dto.ActionDto;
 import com.ssssssss.aaaaaaaaaaaaa.exception.NotFoundException;
import com.ssssssss.aaaaaaaaaaaaa.response.ResponseAction;
 import com.ssssssss.aaaaaaaaaaaaa.service.ImpService.ActionServiceEmp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/action")
@RequiredArgsConstructor
public class ActionController {

    private final ActionServiceEmp actionServiceEmp;


    @PostMapping("/addAction")
    public ResponseEntity<ResponseAction> addAction(@RequestBody @Valid ActionDto actionDto) {

        return ResponseEntity.ok(actionServiceEmp.
                addAction(actionDto));

    }

    @GetMapping("/getActionByID/{actionId}")
    public ResponseEntity<ResponseAction> getActionByID(@PathVariable(name = "actionId") int id) throws NotFoundException {

        return ResponseEntity.ok(actionServiceEmp.getActionByID(id));

    }
    @GetMapping("/getAllAction")
    public ResponseEntity<List<ResponseAction>> getAllAction() throws NotFoundException {

        return ResponseEntity.ok(actionServiceEmp.getAllAction());

    }
    @PostMapping("/updateAction")
    public ResponseEntity<ResponseAction> updateAction(@RequestBody @Valid ActionDto actionDto) throws NotFoundException {

        return ResponseEntity.ok(actionServiceEmp.updateAction(actionDto));

    }



}
