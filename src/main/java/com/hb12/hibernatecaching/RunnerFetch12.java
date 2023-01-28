package com.hb12.hibernatecaching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student12.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        /*
                1st level caching is enabled by default, and it works in the same session
         */

        //let's check 1st level caching
        System.out.println("First get method for student whose id is 1");
        Student12 student1 = session.get(Student12.class, 1L);

        //session.clear(); //clears the cache memory

        System.out.println("Second get method for student whose id is 1");
        Student12 student2 = session.get(Student12.class, 1L);


        tx.commit();
        session.close(); //first session closed

        Session session2 = sf.openSession(); //opening new session
        Transaction tx2 = session2.beginTransaction();

        System.out.println("Third get method for student whose id is 1 from second session");
        Student12 student3 = session2.get(Student12.class, 1L);
       // System.out.println(student3);

        tx2.commit();
        session2.close();
        sf.close();
    }
}
