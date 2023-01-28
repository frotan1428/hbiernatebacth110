package com.hb09.fetchtypes;

import com.hb08.manytomany.Book08;
import com.hb08.manytomany.Student08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {
    public static void main(String[] args) {
        Student09 student1  = new Student09();
        student1.setId(1001);
        student1.setName("AAA");
        student1.setGrade(90);

        Student09 student2  = new Student09();
        student2.setId(1002);
        student2.setName("BBB");
        student2.setGrade(90);

        Student09 student3  = new Student09();
        student3.setId(1003);
        student3.setName("CCC");
        student3.setGrade(90);

        //create 3 book object
        Book09 book1 = new Book09();
        book1.setId(101);
        book1.setName("Java Book");

        Book09 book2 = new Book09();
        book2.setId(102);
        book2.setName("Math Book");

        Book09 book3 = new Book09();
        book3.setId(103);
        book3.setName("Hibernate Book");

        Book09 book4 = new Book09();
        book4.setId(104);
        book4.setName("Phys Book");

        Book09 book5 = new Book09();
        book5.setId(105);
        book5.setName("FetchType Book");

        //normally (if we are not using Cascade), we have to do the setting from relation owner side.
        //since we have used CascadeType.ALL to set set OneToMany relationship we have to do setting from both side

        //set books to students
        student1.getBookList().add(book1);
        student1.getBookList().add(book2);

        student2.getBookList().add(book3);
        student2.getBookList().add(book4);

        student3.getBookList().add(book5);

        //set students to book
        //if you do not do the setting from both related column will be null
        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student2);
        book5.setStudent(student3);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).
                addAnnotatedClass(Book09.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        // if you use CascadeType.All or CascadeType.persist no need to save child table
//        session.save(book1);
//        session.save(book2);
//        session.save(book3);
//        session.save(book4);
//        session.save(book5);


        tx.commit();
        session.close();
        sf.close();

    }
}
