package com.ssssssss.aaaaaaaaaaaaa.common.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int roleId  ;
    @Column(name = "role_name")
    private String roleName ;


    @OneToMany(mappedBy="role",cascade = CascadeType.ALL)
    private Set<Action> actions;

    @OneToMany(mappedBy="role",cascade = CascadeType.ALL)
    private Set<Employee> employees;





}







