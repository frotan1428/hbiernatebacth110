package com.hb03.uni_onetoone;

import com.hb02.embeddable.Student02;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {

        Student03 student01 = new Student03();
        student01.setId(1001);
        student01.setName("AAA");
        student01.setGrade(87);

        Student03 student02 = new Student03();
        student02.setId(1002);
        student02.setName("BBB");
        student02.setGrade(89);

        Student03 student03 = new Student03();
        student03.setId(1003);
        student03.setName("CCC");
        student03.setGrade(76);

        Diray diray1 = new Diray();
        diray1.setId(101);
        diray1.setName("AAA's diary");
        diray1.setStudent(student01);

        Diray diray2 = new Diray();
        diray2.setId(102);
        diray2.setName("BBB's diary");
        diray2.setStudent(student02);


        Diray diray3 = new Diray();
        diray3.setId(103);
        diray3.setName("CCC's diary");
        diray3.setStudent(student03);


        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).
                addAnnotatedClass(Diray.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student01);
        session.save(student02);
        session.save(student03);

        session.save(diray1);
        session.save(diray2);
        session.save(diray3);

        tx.commit();
        session.close();
        sf.close();

    }
}
