package com.hb08.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student08")
public class Student08 {
    @Id
    private int id;
    @Column(name="std_name", nullable = false)
    private String name;
    private int grade;

    @ManyToMany
    @JoinTable(name = "student08_book08", //name for the join table
            joinColumns = {@JoinColumn(name="std_id")},  //name of column for owner .
            inverseJoinColumns = {@JoinColumn(name="book_id")} // name of column where id of other table will be stored

    )
    private List<Book08> bookList = new ArrayList<>();


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

    public List<Book08> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book08> bookList) {
        this.bookList = bookList;
    }

    //toString


    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
