package com.ssssssss.aaaaaaaaaaaaa.service.ImpService;

import com.ssssssss.aaaaaaaaaaaaa.common.dto.RoleDto;
import com.ssssssss.aaaaaaaaaaaaa.common.entity.Role;
import com.ssssssss.aaaaaaaaaaaaa.exception.NotFoundException;
import com.ssssssss.aaaaaaaaaaaaa.repository.RolesRepository;
import com.ssssssss.aaaaaaaaaaaaa.response.ResponseRole;
import com.ssssssss.aaaaaaaaaaaaa.service.constrainedService.RolesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssssssss.aaaaaaaaaaaaa.util.UtilMessage.endMessage;
import static com.ssssssss.aaaaaaaaaaaaa.util.UtilMessage.startMessage;
import static com.ssssssss.aaaaaaaaaaaaa.util.utilTime.end;
import static com.ssssssss.aaaaaaaaaaaaa.util.utilTime.start;

@Service
@RequiredArgsConstructor
@Slf4j
public class RolesServiceEmp implements RolesService {

    private final ModelMapper mapperDep;

    private final RolesRepository rolesRepository;


    @Override
    public ResponseRole addRole(RoleDto roleDto) {

        String methodName = "add role";
        log.info(startMessage, methodName);

        ResponseRole responseRole = new ResponseRole();

        boolean exists = rolesRepository.existsByRoleName(roleDto.getRoleName());

        if (!exists) {

            Role role = mapperDep.map(roleDto, Role.class);

            responseRole.roleDto = roleDto;
            responseRole.roleMessage = null;

            if (role != null) {

                rolesRepository.save(role);

            } else {
                responseRole.roleDto = null;
                responseRole.roleMessage = "should be send data role";

            }

        } else {
            responseRole.roleDto = null;
            responseRole.roleMessage = "this the role is present already";

        }
        log.info(endMessage, methodName, end - start);
        return responseRole;
    }

    @Override
    public ResponseRole getRoleByID(int id) throws NotFoundException {

        String methodName = "get role By ID";
        log.info(startMessage, methodName);

        ResponseRole responseRole = new ResponseRole();

        boolean existsById = rolesRepository.existsById(id);

        if (existsById) {

            Role role = rolesRepository.findById(id).get();

            RoleDto roleDto = mapperDep.map(role, RoleDto.class);

            responseRole.roleMessage = null;
            responseRole.roleDto = roleDto;

            log.info(endMessage, methodName, end - start);
            return responseRole;

        } else {
            log.info(endMessage, methodName, end - start);
            throw new NotFoundException("role not Fount with id ::" + id);

        }
    }

    @Override
    public List<RoleDto> getAllRole() throws NotFoundException {

        String methodName = "get All roles";
        log.info(startMessage, methodName);

        List<Role> roles = rolesRepository.findAll();

        List<RoleDto> roleDtos = roles.stream().map(role ->
                mapperDep.map(role, RoleDto.class)).toList();

        if (roleDtos.isEmpty()) {

            log.info(endMessage, methodName, end - start);
            throw new NotFoundException("error in role to roleDto");

        } else {
            log.info(endMessage, methodName, end - start);
            return roleDtos;

        }

    }

    @Override
    public RoleDto updateRole(RoleDto roleDto) throws NotFoundException {

        String methodName = "update role";
        log.info(startMessage, methodName);

        boolean exists = rolesRepository.existsByRoleName(roleDto.getRoleName());
        boolean exists1 = rolesRepository.existsById(roleDto.getIdRole());

        if (!exists) {
            if (exists1) {

                Role role = mapperDep.map(roleDto, Role.class);

                role.setRoleId(roleDto.getIdRole());

                rolesRepository.save(role);

                log.info(endMessage, methodName, end - start);
                return roleDto;

            } else {
                log.info(endMessage, methodName, end - start);
                throw new NotFoundException("the roleId is not present");

            }
        } else {
            log.info(endMessage, methodName, end - start);
            throw new NotFoundException("this role is present");

        }

    }

}

