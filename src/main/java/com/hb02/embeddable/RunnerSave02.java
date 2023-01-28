package com.hb02.embeddable;

import com.hb01.annotation.Student01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {
        Student02 student01 = new Student02();
        student01.setName("Ali Armagan");
        student01.setId(1001);
        student01.setGrade(90);

        Address address1 = new Address();
        address1.setStreet("Apple Street");
        address1.setCity("Orange");
        address1.setCountry("Banana");
        address1.setZipcode("1234");

        student01.setAddress(address1);


        Student02 student02 = new Student02();
        student02.setName("Vusani");
        student02.setId(1002);
        student02.setGrade(95);

        Address address2 = new Address();
        address2.setStreet("Hello Street");
        address2.setCity("Welcome");
        address2.setCountry("HowAreyou");
        address2.setZipcode("353");
        student02.setAddress(address2);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student02.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student01);
        session.save(student02);

        tx.commit();
        session.close();
        sf.close();
    }
}
