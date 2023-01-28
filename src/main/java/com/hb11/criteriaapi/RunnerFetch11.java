package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Random;

public class RunnerFetch11 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();

        /*
            CRUD (Create, Read, Update, Delete)
                C-->session.save()
                R-->session.get(), HQL, SQL
                U-->session.update(), updateQuery
                D-->session.delete(), HQL, SQL
         */

        //1. update using update() method
       Student11 student = session.get(Student11.class, 1L);
       System.out.println("Student before update: " +student);
       student.setName("Updated Student 1");
       student.setGrade(100);
       session.update(student);
       System.out.println("Student after update: " +student);


        //2. update records using query
        //set grades that are less than 75 to 80

        int sGrade = 80;
        int lGrade = 75;

       String hqlQuery = "UPDATE Student11 s SET s.grade =:sMath WHERE s.grade<:lMath";

       Query query = session.createQuery(hqlQuery); // returns Query object from hibernate
       query.setParameter("sMath", sGrade); // setting the parameters of query
       query.setParameter("lMath", lGrade);

       int numberOfUpdatedRows = query.executeUpdate(); //returns number of updated row
       System.out.println("numberOfUpdatedRows: "+ numberOfUpdatedRows);


        //Criteria API

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student11> criteriaQuery = cb.createQuery(Student11.class);
        Root<Student11> root= criteriaQuery.from(Student11.class);

        Example 1  Fetch All students
       criteriaQuery.select(root); //SELECT * FROM student11
       Query<Student11> query1 = session.createQuery(criteriaQuery);
       List<Student11> resultList11 = query1.getResultList();
       resultList11.forEach(std-> System.out.println(std));

        Example 2 --> get student whose name is "Student Name 8"

       criteriaQuery.select(root). //SELECT * FROM
               where(cb.equal(root.get("name"), "Student Name 8")); //adding Where condition

       Query<Student11> query2 = session.createQuery(criteriaQuery);
       List<Student11> resultList12 = query2.getResultList();
       resultList12.forEach(std-> System.out.println(std));


        //Example 3 -->Fetch students whose grade is greater than 80;

       criteriaQuery.select(root).
               where(cb.greaterThan(root.get("grade"), 80));

       Query<Student11> query3 = session.createQuery(criteriaQuery);
       List<Student11> resultList13 = query3.getResultList();
       resultList13.forEach(std-> System.out.println(std));

        //Example 4 -->Fetch students whose grade is less than 95;


        criteriaQuery.select(root).where(cb.lessThan(root.get("grade"), 95));
        Query<Student11>query4 = session.createQuery(criteriaQuery);
        List<Student11> resultList4 =query4.getResultList();
        resultList4.forEach(std-> System.out.println(std));




        tx.commit();
        session.close();
        sf.close();
    }
}
