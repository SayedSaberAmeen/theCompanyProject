package com.ssssssss.aaaaaaaaaaaaa.repository;

import com.ssssssss.aaaaaaaaaaaaa.common.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Optional<Department> findByDepartName(String name);


    boolean existsByDepartNameAndDescription(String departmentName, String description);


}
