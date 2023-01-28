package com.hb03.uni_onetoone;

import javax.persistence.*;

@Entity
@Table(name = "t_diary")
public class Diray {
    @Id
    private int id;

    private String name;

    @OneToOne //in my diary table new column will be added with default name "student_id"
    @JoinColumn(name="std_id") // this will change name from "student_id" to "std_id"
    private Student03 student;

    // Getter-- Setter

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    //toString ()

    @Override
    public String toString() {
        return "Diray{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
