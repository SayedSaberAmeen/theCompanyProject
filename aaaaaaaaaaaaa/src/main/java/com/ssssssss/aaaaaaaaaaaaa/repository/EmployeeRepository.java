package com.ssssssss.aaaaaaaaaaaaa.repository;

import com.ssssssss.aaaaaaaaaaaaa.common.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    boolean existsByEmployeeNameAndPhoneNumber(String employeeName, String phoneNumber);


}
