package com.ssssssss.aaaaaaaaaaaaa.common.mapper;


/*
@Mapper(componentModel = "spring")
*/
public interface EmployeeMapper {

/*
    @Mapping( source="department.departName",target="departmentName")
    @Mapping(target="roleName", source="role.roleName")
    EmployeeDto employeeToEmployeeDTO(Employee entity);

   @Mapping(target="id", source="dto.employeeId")
    @Mapping(target="name", source="dto.employeeName")
    Employee employeeDTOtoEmployee(EmployeeDto dto);

*/

/*
    @AfterMapping
    default void setEmployNestedObjects( Employee employee , @MappingTarget EmployeeDto employeeDto){

        employeeDto.setDepartmentName(employee.getDepartment().getDepartName());
        employeeDto.setRoleName(employee.getRole().getRoleName());


    }
*/
}