package com.crudSimple.MyCrud.service;

import com.crudSimple.MyCrud.entity.User;
import com.crudSimple.MyCrud.entity.dto.UserDto;
import com.crudSimple.MyCrud.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository usersRepository;
    private final UserConverter usersConverter;



    @Override
    public UserDto saveUser(UserDto usersDto) throws ValidationException {
        validateUserDto(usersDto);
        User savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(usersDto));
        return usersConverter.fromUserToUserDto(savedUser);
    }

    private void validateUserDto(UserDto usersDto) throws ValidationException {
        if (isNull(usersDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(usersDto.getName()) || usersDto.getName().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
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
    public List<UserDto> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(usersConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }
}
