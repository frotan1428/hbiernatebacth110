package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {
        Student01 student01  = new Student01();
        student01.setId(1001);
        student01.setName("Ali Armagan");
        student01.setGrade(90);

        Student01 student02  = new Student01();
        student02.setId(1002);
        student02.setName("Mustafa K");
        student02.setGrade(95);

        Student01 student03  = new Student01();
        student03.setId(1003);
        student03.setName("Vusani");
        student03.setGrade(98);

        //Let Hibernate know that our configuration file and Entity class
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();

        //session.save(student01);
        //session.save(student02);
        session.save(student03);


        tx.commit(); //info will be sent to DB
        session.close();
        sf.close();
    }
}
