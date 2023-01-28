package com.hb12.hibernatecaching;

import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="t_student12")

@Cacheable//Specifies whether an entity should be cached if
// caching is enabled when the value of the persistence
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Student12")
public class Student12 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name="std_name", nullable = false)
    private String name;
    private int grade;

    //getter Setter

    public Long getId() {
        return id;
    }
//    public void setId(int id) {
//        this.id = id;
//    }

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

    //toString

    @Override
    public String toString() {
        return "Student12{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
