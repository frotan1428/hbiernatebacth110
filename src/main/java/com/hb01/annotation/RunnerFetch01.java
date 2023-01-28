package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // There are 3 ways of fetching data from DB
                //1. get()
                //2. SQL
                //3. HQL

        // ************ 1st way using get() ************

//        Student01 student01 = session.get(Student01.class, 1001);
//        Student01 student02 = session.get(Student01.class, 1002);
//        Student01 student03 = session.get(Student01.class, 1003);
//
//        System.out.println(student01);
//        System.out.println(student02);
//        System.out.println(student03);
//
//        tx.commit();
//        sf.close();
//        session.close();

        // ************ 2nd way using SQL ************

//        String sqlQuery1 = "SELECT * FROM t_student01";
//        List<Object[]>  resultLit1 = session.createSQLQuery(sqlQuery1).getResultList();
//
//        for (Object[] o:resultLit1){
//            System.out.println(Arrays.toString(o));
//        }

        // ************ 3rd way using HQL ************

//        String hqlQuery1 = "FROM Student01";
//        List<Student01> resultListHqlq = session.createQuery(hqlQuery1, Student01.class).getResultList();
//
//        for(Student01 std : resultListHqlq){
//            System.out.println(std);
//        }

        // ************ fetching unique data using SQL ************

//        String sqlQuery2 = "SELECT * FROM t_student01 WHERE std_name='Ali Armagan'";
//        Object[] student2 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
//        System.out.println(Arrays.toString(student2));

        // ************ fetching unique data using HQL ************
//        String hqlQuery3 = "FROM Student01 WHERE name = 'Ali Armagan'";
//        Student01 std = session.createQuery(hqlQuery3, Student01.class).uniqueResult();
//        System.out.println(std);

        // ************ fetching  data using alias HQL ************

        String hqlQuery4 = "SELECT s.id, s.name FROM Student01 s WHERE s.id <= 1002"; ///Student01 ==> s
        List<Object[]>  resultList = session.createQuery(hqlQuery4).getResultList();
        for(Object[] std : resultList){
            System.out.println(Arrays.toString(std));
        }
    }
}
