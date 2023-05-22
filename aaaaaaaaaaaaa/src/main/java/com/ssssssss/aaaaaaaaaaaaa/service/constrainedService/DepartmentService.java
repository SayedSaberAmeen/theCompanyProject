package com.ssssssss.aaaaaaaaaaaaa.service.constrainedService;



import com.ssssssss.aaaaaaaaaaaaa.common.dto.DepartmentDto;
import com.ssssssss.aaaaaaaaaaaaa.exception.NotFoundException;
import com.ssssssss.aaaaaaaaaaaaa.response.ResponseDeportment;

import java.util.List;

public interface DepartmentService {
    public ResponseDeportment addDepartment(DepartmentDto departmentDto) ;
    public ResponseDeportment getDepartByID(int deportmentId)throws NotFoundException;
    public List<DepartmentDto> getAllDepart()throws NotFoundException;
    public DepartmentDto updateDepart(DepartmentDto departmentDto ) throws NotFoundException;

}
