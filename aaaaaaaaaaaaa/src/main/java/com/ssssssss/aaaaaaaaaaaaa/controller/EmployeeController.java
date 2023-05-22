package com.ssssssss.aaaaaaaaaaaaa.controller;

 import com.ssssssss.aaaaaaaaaaaaa.common.dto.EmployeeDto;
import com.ssssssss.aaaaaaaaaaaaa.exception.NotFoundException;
 import com.ssssssss.aaaaaaaaaaaaa.response.ResponseEmployee;
 import com.ssssssss.aaaaaaaaaaaaa.service.ImpService.EmployeeServiceEmp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
@RequiredArgsConstructor
public class EmployeeController {


    private final EmployeeServiceEmp employeeServiceEmp;

    @PostMapping("/addEmployee")
    public ResponseEntity<ResponseEmployee> addEmployee(@RequestBody @Valid EmployeeDto employeeDto) {

        return ResponseEntity.ok(employeeServiceEmp.
                addEmployee(employeeDto));

    }

    @GetMapping("/getEmpByID/{empId}")
    public ResponseEntity<ResponseEmployee> getEmpByID(@PathVariable(name = "empId") int id) throws NotFoundException {

        return ResponseEntity.ok(employeeServiceEmp.getEmpByID(id));

    }

    @GetMapping("/getAllEmp")
    public ResponseEntity<List<ResponseEmployee>> getAllEmp() throws NotFoundException {

        return ResponseEntity.ok(employeeServiceEmp.getAllEmp());

    }

    @PostMapping("/updateEmp")
    public ResponseEntity<ResponseEmployee> updateEmployee(@RequestBody @Valid EmployeeDto employeeDto) throws NotFoundException {

        return ResponseEntity.ok(employeeServiceEmp.updateEmployee(employeeDto));

    }


}