package com.ssssssss.aaaaaaaaaaaaa.service.ImpService;

import com.ssssssss.aaaaaaaaaaaaa.common.dto.DepartmentDto;
import com.ssssssss.aaaaaaaaaaaaa.common.entity.Department;
import com.ssssssss.aaaaaaaaaaaaa.exception.NotFoundException;
import com.ssssssss.aaaaaaaaaaaaa.repository.DepartmentRepository;
 import com.ssssssss.aaaaaaaaaaaaa.response.ResponseDeportment;
import com.ssssssss.aaaaaaaaaaaaa.service.constrainedService.DepartmentService;
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
public class DepartmentServiceImp implements DepartmentService {

    private final ModelMapper modelMapper;

    private final DepartmentRepository departmentRepository;


    @Override
    public ResponseDeportment addDepartment(DepartmentDto departmentDto) {

        String methodName = "add department";

        log.info(startMessage, methodName);

        if (departmentRepository.findByDepartName(departmentDto.getDepartName()).isEmpty()) {

            Department department = modelMapper.map(departmentDto, Department.class);

            ResponseDeportment responseDeportment = new ResponseDeportment();

            responseDeportment.responseDepartment = departmentDto;
            responseDeportment.departmentMessage = null;

            if (department != null) {

                departmentRepository.save(department);

            } else {
                responseDeportment.responseDepartment = null;
                responseDeportment.departmentMessage = "should be send data department";

            }

            log.info(endMessage, methodName, end - start);

            return responseDeportment;

        } else {
            ResponseDeportment responseDeportment = new ResponseDeportment();

            responseDeportment.responseDepartment = null;
            responseDeportment.departmentMessage = "this the department is present already";

            log.info(endMessage, methodName, end - start);

            return responseDeportment;

        }
    }

    @Override
    public ResponseDeportment getDepartByID(int deportmentId) throws NotFoundException {

        String methodName = "get Depart By ID";

        log.info(startMessage, methodName);

        ResponseDeportment responseDeportment = new ResponseDeportment();
        boolean existsById = departmentRepository.existsById(deportmentId);

        if (existsById) {

            Department department = departmentRepository.findById(deportmentId).get();

            DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);

            responseDeportment.departmentMessage = null;
            responseDeportment.responseDepartment = departmentDto;

            log.info(endMessage, methodName, end - start);

            return responseDeportment;

        } else {

            log.info(endMessage, methodName, end - start);

            throw new NotFoundException("department not Fount with id ::" + deportmentId);

        }
    }

    @Override
    public List<DepartmentDto> getAllDepart() throws NotFoundException {

        String methodName = "get All Department";

        log.info(startMessage, methodName);

        List<Department> departments = departmentRepository.findAll();

        List<DepartmentDto> departmentDtos = departments.stream().map(department ->
                modelMapper.map(department, DepartmentDto.class)).toList();
        if (departmentDtos.isEmpty()) {

            log.info(endMessage, methodName, end - start);

            throw new NotFoundException("error in department to departmentDto");
        } else {

            log.info(endMessage, methodName, end - start);

            return departmentDtos;
        }
    }

    @Override
    public DepartmentDto updateDepart(DepartmentDto departmentDto) throws NotFoundException {

        String methodName = "update Department";

        log.info(startMessage, methodName);

        boolean exists = departmentRepository.existsByDepartNameAndDescription(departmentDto.getDepartName(),
                departmentDto.getDescription());
        boolean exists1 = departmentRepository.existsById(departmentDto.getIdDepart());

        if (!exists) {
            if (exists1) {

                    Department department = modelMapper.map(departmentDto, Department.class);

                    department.setDepartmentId(departmentDto.getIdDepart());

                    departmentRepository.save(department);

                    log.info(endMessage, methodName, end - start);

                    return departmentDto;

            } else {

                log.info(endMessage, methodName, end - start);

                throw new NotFoundException("the departmentId is not present");
            }
        }
        else {

            log.info(endMessage, methodName, end - start);

            throw new NotFoundException("this Department is present");


        }


    }

}
