package com.crudSimple.MyCrud.entity.dto;


import com.crudSimple.MyCrud.entity.User;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private int id;

    private String name;

    private int age;

    private Date createDate;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public UserDto fromUserToUserDto(User users) {
        return UserDto.builder()
                .id(users.getId())
                .age(users.getAge())
                .createDate(users.getCreateDate())
                .name(users.getName())
                .build();
    }
}
