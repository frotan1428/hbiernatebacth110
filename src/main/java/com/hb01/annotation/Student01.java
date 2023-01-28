package com.hb01.annotation;

import javax.persistence.*;

@Entity //converts class to DB table named "student01"
@Table(name="t_student01") // changing table name in DB to "t_student01"
public class Student01 {

    @Id //specifies the primary key of entity
    //@Column(name="std_id") //@Column annotation s not compalsory, it is to give some directions to column
    private int id;
    @Column(name="std_name", length = 100, nullable = false, unique = false)
    private String name;

    //@Transient //this column will not be created in DB
    private int grade;
//    @Lob //Large object
//    private byte[] image;

    //Getter--Setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    //toString method

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
