package ru.matevitsky.crud.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.sql.Timestamp;


/**
 * Created by Sergey on 13.04.16.
 */

@Entity
//@Table(name = "USERS")
public class User {

    @Id
   // @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "name")
    @Size(min = 4, message = "Имя должно быть больше 3-ч символов")
    private String name;

    @Column(name = "age")
    @Min(18)
    @Max(85)
    private int age;

    @Column(name = "isAdmin")
    private boolean isAdmin;

    @Column(name = "createdDate",nullable = true)
    private Timestamp createdDate;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
