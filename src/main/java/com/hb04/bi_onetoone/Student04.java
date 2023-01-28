package com.hb04.bi_onetoone;

import javax.persistence.*;

@Entity
@Table(name="t_student04")
public class Student04 {
    @Id
    private int id;

    @Column(name = "std_name", length = 100, nullable = false)
    private String name;
    private int grade;

    @OneToOne(mappedBy = "student") //mappedBy attribute will not create any column in Diary class, instead it
                                    // will use the column from Diary class which is named as "student"
    private Diary04 diary;

    //Getter - Setter

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

    public Diary04 getDiary() {
        return diary;
    }

    public void setDiary(Diary04 diary) {
        this.diary = diary;
    }

    //toString

    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
//                ", diary=" + diary + //delete comment this to avoid stack overflow
                '}';
    }
}
