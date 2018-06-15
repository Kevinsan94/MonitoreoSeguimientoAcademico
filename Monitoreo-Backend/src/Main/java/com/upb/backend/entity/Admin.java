package com.upb.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="Administrador")
public class Admin implements Serializable {

    @Column(name = "id_administrador", unique = true)
    private String id_admin;

    @Column(name = "password")
    private String password;


    public String getId_admin() {
        return id_admin;
    }

    public void setId_admin(String id_admin) {
        this.id_admin = id_admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
