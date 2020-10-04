package com.crudSimple.MyCrud.controller;





import com.crudSimple.MyCrud.entity.dto.UserDto;
import com.crudSimple.MyCrud.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;


@RestController
@RequestMapping("/user")
@Log
@AllArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
    @GetMapping
    public String GetUser() {
        return "index";
    }


    @PostMapping("/save")
    public UserDto saveUsers(@RequestBody UserDto usersDto) throws ValidationException {
        log.info("Handling save users: " + usersDto);
        return userService.saveUser(usersDto);
    }

    @GetMapping("/findAll")
    public List<UserDto> findAllUsers() {
        log.info("Handling find all users request");
        return userService.findAll();
    }

    @GetMapping("/findByLogin")
    public UserDto findByLogin(@RequestParam String login) {
        log.info("Handling find by login request: " + login);
        return userService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        log.info("Handling delete user request: " + id);
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}

