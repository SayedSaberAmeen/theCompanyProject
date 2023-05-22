package com.ssssssss.aaaaaaaaaaaaa.repository;


import com.ssssssss.aaaaaaaaaaaaa.common.entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer> {


    boolean existsByNameActionAndCodeAction(String nameAction, String codeAction);


}
