package com.ssssssss.aaaaaaaaaaaaa.controller;

import com.ssssssss.aaaaaaaaaaaaa.common.dto.DepartmentDto;
import com.ssssssss.aaaaaaaaaaaaa.exception.NotFoundException;
import com.ssssssss.aaaaaaaaaaaaa.response.ResponseDeportment;
import com.ssssssss.aaaaaaaaaaaaa.service.ImpService.DepartmentServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentServiceImp departmentServiceEmp;

    @PostMapping("/addDepartment")
    public ResponseEntity<ResponseDeportment> addDepartment(@RequestBody @Valid DepartmentDto departmentDto) {

        return ResponseEntity.ok(departmentServiceEmp.
                addDepartment(departmentDto));

    }

    @GetMapping("/getDepartByID/{deportmentId}")
    public ResponseEntity<ResponseDeportment> getDepartByID(@PathVariable(name = "deportmentId") int deportmentId) throws NotFoundException {

        return ResponseEntity.ok(departmentServiceEmp.getDepartByID(deportmentId));

    }

    @GetMapping("/getAllDepart")
    public ResponseEntity<List<DepartmentDto>> getAllDepart() throws NotFoundException {

        return ResponseEntity.ok(departmentServiceEmp.getAllDepart());

    }

    @PostMapping("/updateDepart")
    public ResponseEntity<DepartmentDto> updateDepart(@RequestBody @Valid DepartmentDto departmentDto) throws NotFoundException {

        return ResponseEntity.ok(departmentServiceEmp.updateDepart(departmentDto));

    }


}
