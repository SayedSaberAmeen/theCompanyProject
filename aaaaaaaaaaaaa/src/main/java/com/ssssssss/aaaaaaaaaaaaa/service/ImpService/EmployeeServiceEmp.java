package com.ssssssss.aaaaaaaaaaaaa.service.ImpService;

 import com.ssssssss.aaaaaaaaaaaaa.common.dto.EmployeeDto;
 import com.ssssssss.aaaaaaaaaaaaa.common.entity.Department;
import com.ssssssss.aaaaaaaaaaaaa.common.entity.Employee;
import com.ssssssss.aaaaaaaaaaaaa.common.entity.Role;
 import com.ssssssss.aaaaaaaaaaaaa.exception.NotFoundException;
 import com.ssssssss.aaaaaaaaaaaaa.repository.DepartmentRepository;
import com.ssssssss.aaaaaaaaaaaaa.repository.EmployeeRepository;
import com.ssssssss.aaaaaaaaaaaaa.repository.RolesRepository;
import com.ssssssss.aaaaaaaaaaaaa.response.ResponseAction;
 import com.ssssssss.aaaaaaaaaaaaa.response.ResponseEmployee;
import com.ssssssss.aaaaaaaaaaaaa.service.constrainedService.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Optional;

 import static com.ssssssss.aaaaaaaaaaaaa.util.UtilMessage.endMessage;
import static com.ssssssss.aaaaaaaaaaaaa.util.UtilMessage.startMessage;
import static com.ssssssss.aaaaaaaaaaaaa.util.utilTime.end;
import static com.ssssssss.aaaaaaaaaaaaa.util.utilTime.start;


@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceEmp implements EmployeeService {


    private final ModelMapper mapperEmp;
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final RolesRepository rolesRepository;


    @Override
    public ResponseEmployee addEmployee(EmployeeDto employeeDto) {

        String methodName = "add employee";

        log.info(startMessage, methodName);

        ResponseEmployee responseEmployee = new ResponseEmployee();

        boolean existsEmp = employeeRepository.
                existsByEmployeeNameAndPhoneNumber(employeeDto.getEmployeeName(), employeeDto.getPhoneNumber());
        boolean existsDepart = departmentRepository.existsById(employeeDto.getDepartmentId());
        boolean existsRole = rolesRepository.existsById(employeeDto.getRoleId());

        if (!existsEmp && existsDepart && existsRole) {

            Employee employee = mapperEmp.map(employeeDto, Employee.class);

            if (employee != null) {

                Department department = departmentRepository.findById(employeeDto.getDepartmentId()).get();
                Role role = rolesRepository.findById(employeeDto.getRoleId()).get();

                employee.setRole(role);
                employee.setDepartment(department);

                employeeRepository.save(employee);
                log.info("expired success save employee :: {}", employee);

                EmployeeDto employeeDto1 = mapperEmp.map(employee, EmployeeDto.class);
                responseEmployee.responseEmployee = employeeDto1;
                responseEmployee.departName = department.getDepartName();
                responseEmployee.roleName = role.getRoleName();

            } else {
                responseEmployee.employeeMessage = "should be send data Employee";

            }
        } else {
            if (existsEmp) responseEmployee.employeeMessage = "this the Employer is present already";
            if (!existsDepart) responseEmployee.departName = "not present data by this departmentId";
            if (!existsRole) responseEmployee.roleName = "not present data by this roleId";

        }
        log.info(endMessage, methodName, end - start);
        return responseEmployee;

    }

    @Override
    public ResponseEmployee getEmpByID(int id) throws NotFoundException {

        String methodName = "get emp By ID";
        log.info(startMessage, methodName);

        ResponseEmployee responseEmployee = new ResponseEmployee();

        boolean existsById = employeeRepository.existsById(id);

        if (existsById) {

            Employee employee = employeeRepository.findById(id).get();
            EmployeeDto employeeDto = mapperEmp.map(employee, EmployeeDto.class);

            responseEmployee.employeeMessage = null;
            responseEmployee.responseEmployee = employeeDto;
            responseEmployee.departName = employee.getDepartment().getDepartName();
            responseEmployee.roleName = employee.getRole().getRoleName();

            log.info(endMessage, methodName, end - start);

            return responseEmployee;

        } else {

            log.info(endMessage, methodName, end - start);

            throw new NotFoundException("employee not Fount with id ::" + id);

        }
    }

    @Override
    public List<ResponseEmployee> getAllEmp() throws NotFoundException  {

        String methodName = "get All employees";
        log.info(startMessage, methodName);

        List<Employee> employees = employeeRepository.findAll();
        List<ResponseEmployee> responseEmployees =new ArrayList<>();

        if (employees.isEmpty()) {
            log.info(endMessage, methodName, end - start);
            throw new NotFoundException("not present employees");

        } else {
            List<EmployeeDto> employeeDtos = employees.stream().map(employee ->
                    mapperEmp.map(employee, EmployeeDto.class)).toList();
            List<String> departNames = employees.stream().map(employee -> employee.getDepartment().getDepartName()).toList();
            List<String> roleNames = employees.stream().map(employee -> employee.getRole().getRoleName()).toList();
            int count = employees.size();
            for(int x=0 ; x<count; x++) {

                ResponseEmployee responseEmployee = new ResponseEmployee();
                responseEmployee.responseEmployee=employeeDtos.get(x);
                responseEmployee.departName=departNames.get(x);
                responseEmployee.roleName=roleNames.get(x);

                responseEmployees.add(responseEmployee);

            }

        }
            log.info(endMessage, methodName, end - start);
            return responseEmployees;
        }



    @Override
    public ResponseEmployee updateEmployee(EmployeeDto employeeDto) throws NotFoundException{

        String methodName = "update employee";
        log.info(startMessage, methodName);

        ResponseEmployee responseEmployee = new ResponseEmployee();

        boolean existsByEmployeeNameAndPhoneNumber = employeeRepository.existsByEmployeeNameAndPhoneNumber(employeeDto.getEmployeeName(),
                employeeDto.getPhoneNumber());
        boolean existsEmpId = employeeRepository.existsById(employeeDto.getIdEmp());

        Employee employee = employeeRepository.findById(employeeDto.getIdEmp()).get();
        boolean existsDepartmentId = employee.getDepartment().getDepartmentId() == employeeDto.getDepartmentId() ;
        boolean existsRoeId = employee.getRole().getRoleId() == employeeDto.getRoleId() ;

        if (!existsByEmployeeNameAndPhoneNumber|| !(existsRoeId && existsDepartmentId)) {
            if (existsEmpId) {

                Employee employee1 = mapperEmp.map(employeeDto, Employee.class);
                employee1.setEmpId(employeeDto.getIdEmp());

                employeeRepository.save(employee1);

                responseEmployee.responseEmployee=employeeDto;
                responseEmployee.roleName = employee.getRole().getRoleName();
                responseEmployee.departName = employee.getDepartment().getDepartName();

            } else {

                log.info(endMessage, methodName, end - start);

                throw new NotFoundException("the employeeId is not present");
            }
        }
        else {

            log.info(endMessage, methodName, end - start);

            throw new NotFoundException("this employee is present");

        }
        log.info(endMessage, methodName, end - start);
        return responseEmployee ;
    }


    @Override
    public ResponseAction moveEmployeeInDepartment(int employeeId, int targetDepartmentId) {
        return null;
    }
}






























