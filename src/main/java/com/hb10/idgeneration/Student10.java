package com.hb10.idgeneration;

import javax.persistence.*;

/*
   Oracle DB - PostgreSQL ---> Sequence ( kontrolü developera bırakır, Id üretilirken başlangıç değeri veya kaç tane id cachelenecek bu gibi bilgileri developer setliyebilir)
   MySQL - Microsoft SQL   ---> IDENTITY ( kontrol DB de , kendi yapısına göre ıd oluşturur, içlerindeki en basitidir)

   GenerationType.AUTO ---> Hibernate otomatik olarak stratejiyi belirler
   GenerationType.TABLE ---> En yavaşı , oyüzden çok kullanılmıyor, çünkü id
    üretmek için ekstra tablo oluşturuyor
 */

@Entity
@Table(name = "t_student10")
public class Student10 {


    @Id
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="sequence", //should be matching  @GeneratedValue's attribute "generator"
            sequenceName = "std_seq", //sequence that will be stored in DB
            initialValue = 1001, //initial staring id
            allocationSize = 10 // reserved id

    )
    private int id;
    @Column(name="std_name", nullable = false)
    private String name;
    private int grade;

    //getter- setter

    public int getId() {
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

    //toString()

    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
