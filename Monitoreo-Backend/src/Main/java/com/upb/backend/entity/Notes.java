package com.upb.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="Notas")
public class Notes implements Serializable {

    @Id
    @Column(name = "id_nota")
    private int id;

    @Column(name = "id_estudiante")
    private int student_id;

    @Column(name = "materia")
    private String materia;

    @Column(name = "p1")
    private int p1;

    @Column(name = "p2")
    private int p2;

    @Column(name = "p3")
    private int p3;

    @Column(name = "final")
    private int final_note;


    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public int getP2() {
        return p2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }

    public int getP3() {
        return p3;
    }

    public void setP3(int p3) {
        this.p3 = p3;
    }

    public int getFinal_note() {
        return final_note;
    }

    public void setFinal_note() {
        this.final_note = (int) ((p1*0.3)+(p2*0.3)+(p3*0.4));
    }
}
