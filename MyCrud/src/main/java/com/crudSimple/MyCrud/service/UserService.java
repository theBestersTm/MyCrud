package com.crudSimple.MyCrud.service;

import com.crudSimple.MyCrud.entity.dto.UserDto;
import com.crudSimple.MyCrud.exception.UserNotFindException;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface UserService {
    UserDto saveUser(UserDto usersDto);

    void deleteUser(Integer userId);

    UserDto findByLogin(String login);
    UserDto findById(Integer id) throws UserNotFindException;
    //UserDto findById(Integer id);
    List<UserDto> findAll();
}
