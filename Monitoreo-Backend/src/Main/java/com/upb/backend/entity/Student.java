package com.upb.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Estudiante")
public class Student implements Serializable {


    @Id
    @Column(name = "id_estudiante", unique = true)
    private int code;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String last_name;

    @Column(name = "telefono")
    private int number;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;



    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return last_name;
    }
    public void setLastname(String lastname) {
        this.last_name = lastname;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
