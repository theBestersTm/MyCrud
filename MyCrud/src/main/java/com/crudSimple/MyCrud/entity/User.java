package com.crudSimple.MyCrud.entity;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user_table")
@Data
public class User {
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;
    @Column
    private int age;
    @Column
    private Date createDate;

}

