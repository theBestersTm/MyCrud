package com.crudSimple.MyCrud.controller;

import com.crudSimple.MyCrud.entity.dto.UserDto;
import com.crudSimple.MyCrud.exception.UserNotFindException;
import com.crudSimple.MyCrud.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@Log
@AllArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto usersDto)  {
        return userService.saveUser(usersDto);
    }

    @PostMapping("/update/{id}")
    public UserDto updateUser(@RequestBody UserDto usersDto) throws UserNotFindException {
        return userService.updateUser(usersDto);
    }

    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable Integer id) throws UserNotFindException {
        return userService.findById(id);
    }

    @GetMapping("/findByLogin")
    public UserDto findByLogin(@RequestParam String login) {
        return userService.findByLogin(login);
    }

    @GetMapping("/findAll")
    public List<UserDto> findAll(){
        return userService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}

