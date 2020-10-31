package com.crudSimple.MyCrud.controller;

import com.crudSimple.MyCrud.entity.dto.UserDto;
import com.crudSimple.MyCrud.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@Log
@AllArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping
    public String GetUser() {
        return "index";
    }


    @PostMapping
    public UserDto createUser(@RequestBody UserDto usersDto)  {
        return userService.saveUser(usersDto);
    }

    @PostMapping("/update/{id}")
    public UserDto updateUser(@RequestBody UserDto usersDto)  {
        return userService.updateUser(usersDto);
    }

    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/findByLogin")
    public UserDto findByLogin(@RequestParam String login) {
        return userService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}

