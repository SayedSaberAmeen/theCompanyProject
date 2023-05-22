package com.ssssssss.aaaaaaaaaaaaa.controller;

 import com.ssssssss.aaaaaaaaaaaaa.common.dto.RoleDto;
import com.ssssssss.aaaaaaaaaaaaa.exception.NotFoundException;
import com.ssssssss.aaaaaaaaaaaaa.response.ResponseRole;
 import com.ssssssss.aaaaaaaaaaaaa.service.ImpService.RolesServiceEmp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Roles")
@RequiredArgsConstructor
public class RolesController {

    private final RolesServiceEmp rolesServiceEmp;


    @PostMapping("/addRole")
    public ResponseEntity<ResponseRole> addRole(@RequestBody @Valid RoleDto roleDto) {

        return ResponseEntity.ok(rolesServiceEmp.
                addRole(roleDto));
    }

    @GetMapping("/getRoleByID/{roleId}")
    public ResponseEntity<ResponseRole> getRoleByID(@PathVariable(name = "roleId") int id) throws NotFoundException {
        return ResponseEntity.ok(rolesServiceEmp.getRoleByID(id));
    }

    @GetMapping("/getAllRole")
    public ResponseEntity<List<RoleDto>> getAllRole() throws NotFoundException {
        return ResponseEntity.ok(rolesServiceEmp.getAllRole());
    }

    @PostMapping("/updateRole")
    public ResponseEntity<RoleDto> updateRole(@RequestBody @Valid RoleDto roleDto) throws NotFoundException {

        return ResponseEntity.ok(rolesServiceEmp.updateRole(roleDto));

    }


}














