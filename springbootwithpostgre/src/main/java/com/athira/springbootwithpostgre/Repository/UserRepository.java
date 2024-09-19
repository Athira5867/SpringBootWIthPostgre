package com.athira.springbootwithpostgre.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athira.springbootwithpostgre.Model.UserEntity;

public interface  UserRepository extends JpaRepository<UserEntity, Integer>{

}
