package com.ssssssss.aaaaaaaaaaaaa.common.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int empId;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "card_number")
    private String cardNumber;
    private String address;
    private String mail;
    private int age;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


}
