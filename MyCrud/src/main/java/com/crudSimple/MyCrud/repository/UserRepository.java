package com.crudSimple.MyCrud.repository;


import com.crudSimple.MyCrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Integer>{
    User findByName(String name);

}
