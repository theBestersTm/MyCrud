package com.crudSimple.MyCrud.repository;

import com.crudSimple.MyCrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer>{
    User findByName(String name);

}
