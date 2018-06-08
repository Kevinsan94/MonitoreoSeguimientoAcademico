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
    @Column(name = "id_estudiante", unique = true)
    private int id;

    @Column(name = "p1")
    private int p1;

    @Column(name = "p2")
    private int p2;

    @Column(name = "p3")
    private int p3;

    @Column(name = "final")
    private int final_note;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
