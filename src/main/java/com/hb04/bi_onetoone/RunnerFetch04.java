package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).
                addAnnotatedClass(Diary04.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();


        //get Student and Diary By Id using getmethod

//        Student04 student1 = session.get(Student04.class, 1001);
//
//        Diary04 diary1 = session.get(Diary04.class, 101);
//
//        System.out.println("******** Student04 Object *********");
//        System.out.println(student1);
//
//        System.out.println("******** Diary04 Object *********");
//        System.out.println(diary1);
//
//        System.out.println("******** Fetch Student04 over Diary04 Object *********");
//        System.out.println(diary1.getStudent());
//
//        System.out.println("******** Fetch Diary04 over Student Object *********");
//        System.out.println(student1.getDiary());

//        System.out.println("******** Using HQL fetch classes using inner join *********");

        String hqlQuery1 = "SELECT s.name, d.name FROM Student04 s INNER JOIN FETCH Diary04 d  ON s.id = d.student.id";
        //Sql version: Select s.std_name, d.name FROM t_student04 s INNER JOIN t_diary04 d ON s.id = d.student_id
        List<Object[]> resultList1 = session.createQuery(hqlQuery1).getResultList();
//        for(Object[] obj: resultList1){
//            System.out.println(Arrays.toString(obj));
//        }
   //     resultList1.forEach(obj-> System.out.println(Arrays.toString(obj)));


        //Using Left Join
        //Fetch all Students and students with diary

        System.out.println("******** Using HQL fetch classes using Left join *********");

        String hqQuery2 = "SELECT s.name, d.name FROM Student04 s LEFT JOIN FETCH Diary04 d ON s.id = d.student.id";
        List<Object[]> resultList2 = session.createQuery(hqQuery2).getResultList();

        resultList2.forEach(oa-> System.out.println(Arrays.toString(oa)));


        //Using Right Join
        //Fetch all Diary and diary owners

        System.out.println("******** Using HQL fetch classes using Right join *********");

        String hqQuery3 = "SELECT s.name, d.name FROM Student04 s RIGHT JOIN FETCH Diary04 d ON s.id = d.student.id";
        List<Object[]> resultList3 = session.createQuery(hqQuery3).getResultList();

        resultList3.forEach(oa-> System.out.println(Arrays.toString(oa)));


        //Using FUll Join
        //Fetch all Diary and diary owners

        System.out.println("******** Using HQL fetch classes using FUll join *********");

        String hqQuery4 = "SELECT s.name, d.name FROM Student04 s FULL JOIN FETCH Diary04 d ON s.id = d.student.id";
        List<Object[]> resultList4 = session.createQuery(hqQuery4).getResultList();

        resultList4.forEach(oa-> System.out.println(Arrays.toString(oa)));

        tx.commit();
        session.close();
        sf.close();
    }
}
