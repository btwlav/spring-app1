package com.spring.first.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String fio;

    private Date bdate;

    public Student() {}

    public Student(String fio) {
        this.fio = fio;
        this.bdate = new Date(new Date().getTime());
    }

    public Integer getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getBdate() {
        return bdate;
    }

    public String getStringBdate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(bdate);
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }
}
