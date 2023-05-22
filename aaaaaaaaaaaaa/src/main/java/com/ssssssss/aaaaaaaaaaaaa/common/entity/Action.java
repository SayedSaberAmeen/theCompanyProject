package com.ssssssss.aaaaaaaaaaaaa.common.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "action")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Action {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "action_id")
    private int acId;
    @Column(name = "name_action")
    private String nameAction;

    @Column(name = "date_action")
    private String dataAction;
    @Column(name = "cod_action")
    private String codeAction;




    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;












}
