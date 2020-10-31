package com.crudSimple.MyCrud.service;

import com.crudSimple.MyCrud.entity.dto.UserDto;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface UserService {
    UserDto saveUser(UserDto usersDto);

    void deleteUser(Integer userId);

    UserDto findByLogin(String login);
    UserDto findById(Integer id);
    //UserDto findById(Integer id);
    List<UserDto> findAll();
}
