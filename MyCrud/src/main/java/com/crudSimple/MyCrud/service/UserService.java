package com.crudSimple.MyCrud.service;

import com.crudSimple.MyCrud.entity.dto.UserDto;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;
@Service
public interface UserService {
    UserDto saveUser(UserDto usersDto) throws ValidationException;

    void deleteUser(Integer userId);

    UserDto findByLogin(String login);

    List<UserDto> findAll();
}
