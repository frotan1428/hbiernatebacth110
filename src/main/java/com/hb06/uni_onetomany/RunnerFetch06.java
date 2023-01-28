package com.hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).
                addAnnotatedClass(Book06.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("*********** fetch studentd obj using get() **********");
        Student06 student1 =  session.get(Student06.class, 1001);
        System.out.println(student1);

        System.out.println("*********** fetch book obj using get() **********");

        Book06 book1 =  session.get(Book06.class, 101);
        System.out.println(book1);

        System.out.println("*********** fetch books of student whose id is 1001 using HQL **********");
        String hqlQuery1 = "SELECT b.id, b.name FROM Student06 s INNER JOIN s.bookList b WHERE s.id = 1001";

        List<Object[]> resultList1 = session.createQuery(hqlQuery1).getResultList();
        resultList1.forEach(oa -> System.out.println(Arrays.toString(oa)));

        System.out.println("*********** fetch books of student whose id is 1001 using get() **********");
        System.out.println(student1.getBookList());


        tx.commit();
        session.close();
        sf.close();
    }
}
