package com.hb05.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_student05")
public class Student05 {
    @Id
    private int id;
    @Column(name="std_name", length = 100, nullable = false)
    private String name;
    private int grade;
    private LocalDateTime createdDate;


    @ManyToOne
    @JoinColumn(name ="univ_id")
    private University university;

    @PrePersist // This annotation makes this method run when we save data to DB
    public void prePersist(){
        createdDate  = LocalDateTime.now();
    }

    //Getter-Setter


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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    // since we used @PrePersist annotation, we do not need to set method
//    public void setCreatedDate(LocalDateTime createdDate) {
//        this.createdDate = createdDate;
//    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    //toString()

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createdDate=" + createdDate +
                ", university=" + university +
                '}';
    }
}
