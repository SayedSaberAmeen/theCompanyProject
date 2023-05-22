package com.ssssssss.aaaaaaaaaaaaa.repository;


import com.ssssssss.aaaaaaaaaaaaa.common.entity.Department;
import com.ssssssss.aaaaaaaaaaaaa.common.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RolesRepository extends JpaRepository<Role, Integer> {

    Optional<Department> findByRoleName(String name);


    boolean existsByRoleName(String departmentName);


}
