package com.ssssssss.aaaaaaaaaaaaa.service.constrainedService;


import com.ssssssss.aaaaaaaaaaaaa.common.dto.RoleDto;
import com.ssssssss.aaaaaaaaaaaaa.exception.NotFoundException;
import com.ssssssss.aaaaaaaaaaaaa.response.ResponseRole;

import java.util.List;

public interface RolesService {
    public ResponseRole addRole(RoleDto roleDto);
    public ResponseRole getRoleByID(int id) throws NotFoundException;

        public List<RoleDto> getAllRole() throws NotFoundException;
    public RoleDto updateRole(RoleDto roleDto) throws NotFoundException;

}
