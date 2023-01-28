package com.hb09.fetchtypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_student09")
public class Student09 {
    @Id
    private int id;
    @Column(name="std_name", nullable = false)
    private String name;
    private int grade;

    /*
            1. If next side is Many,  then the default fetch type is Lazy
                a.OneToMany
                b.ManyToMany

            2. If next side is One, then the default fetch type is Eager
                a. ManyToOne
                b. OneToOne
     */

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Book09> bookList = new ArrayList<>();

    //getter- setter


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

    public List<Book09> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book09> bookList) {
        this.bookList = bookList;
    }

    //toString

    @Override
    public String toString() {
        return "Student09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
