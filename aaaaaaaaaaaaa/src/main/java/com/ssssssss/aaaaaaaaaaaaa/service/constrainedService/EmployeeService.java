package com.ssssssss.aaaaaaaaaaaaa.service.constrainedService;



 import com.ssssssss.aaaaaaaaaaaaa.common.dto.EmployeeDto;
 import com.ssssssss.aaaaaaaaaaaaa.exception.NotFoundException;
 import com.ssssssss.aaaaaaaaaaaaa.response.ResponseAction;
 import com.ssssssss.aaaaaaaaaaaaa.response.ResponseEmployee;

 import java.util.List;

public interface EmployeeService {

 public ResponseEmployee addEmployee(EmployeeDto employeeDto);
 public ResponseEmployee getEmpByID(int id) throws NotFoundException;
 public List<ResponseEmployee> getAllEmp() throws NotFoundException;

 ResponseEmployee updateEmployee(EmployeeDto employeeDto) throws NotFoundException;

 public ResponseAction moveEmployeeInDepartment(int employeeId  , int targetDepartmentId );


 }