package com.hb03.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).
                addAnnotatedClass(Diray.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        System.out.println("******** using get() fetch student ********");
        Student03 student1 = session.get(Student03.class, 1001);
        System.out.println(student1);

        System.out.println("******** using get() fetch diary ********");
        Diray diary = session.get(Diray.class, 101);
        System.out.println(diary);

        System.out.println("******** using get() fetch student from diary ********");
        System.out.println(diary.getStudent());


        tx.commit();
        sf.close();
        session.close();
    }
}
