package com.crudSimple.MyCrud.service;

import com.crudSimple.MyCrud.entity.User;
import com.crudSimple.MyCrud.entity.dto.UserDto;
import com.crudSimple.MyCrud.exception.UserNotFindException;
import com.crudSimple.MyCrud.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


//Рефакторинг age, crud postman, optional class java, data, delete logs, delete status code noContent
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository usersRepository;
    private final UserConverter usersConverter;


    @Override
    public UserDto saveUser(UserDto usersDto) {

        User savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(usersDto));
        return usersConverter.fromUserToUserDto(savedUser);
    }

    public UserDto updateUser(UserDto usersDto) throws UserNotFindException {
        //Optional<User> userFromDb = usersRepository.findById(usersDto.getId());

       // User user = userFromDb.orElseThrow(() -> new IllegalArgumentException("USER WITH ID : " + usersDto.getId() + " not found"));

       // user.setCreateDate(usersDto.getCreateDate());
//        user.setAge(usersDto.getAge());
//        user.setName(usersDto.getName());
//
//        User savedUser = usersRepository.save(user);
//
//        return usersConverter.fromUserToUserDto(savedUser);


        Optional<User> userFromDb = usersRepository.findById(usersDto.getId());
        User user = usersRepository.findById(usersDto.getId()).orElseThrow(() -> new UserNotFindException("User doesnt exist"));

        user.setCreateDate(usersDto.getCreateDate());
        user.setAge(usersDto.getAge());
        user.setName(usersDto.getName());
        return usersConverter.fromUserToUserDto(user);

    }


    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UserDto findByLogin(String name) {
        User users = usersRepository.findByName(name);
        if (users != null) {

            return usersConverter.fromUserToUserDto(users);


        }
        return null;
    }

    @Override
    public UserDto findById(Integer id) throws UserNotFindException{
        return usersRepository.findById(id).map(usersConverter::fromUserToUserDto).orElseThrow(() -> new UserNotFindException("User doesnt exist"));
    }

    @Override
    public List<UserDto> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(usersConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }
}
