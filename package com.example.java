package com.example.hibernatecrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CRUDExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // CREATE
            session.beginTransaction();
            Student s1 = new Student("John Doe", "john@example.com");
            session.save(s1);
            session.getTransaction().commit();

            // READ
            session = factory.getCurrentSession();
            session.beginTransaction();
            Student retrieved = session.get(Student.class, s1.getId());
            System.out.println("Fetched: " + retrieved);
            session.getTransaction().commit();

            // UPDATE
            session = factory.getCurrentSession();
            session.beginTransaction();
            retrieved = session.get(Student.class, s1.getId());
            retrieved.setName("John Updated");
            session.getTransaction().commit();

            // DELETE
            session = factory.getCurrentSession();
            session.beginTransaction();
            Student toDelete = session.get(Student.class, s1.getId());
            if (toDelete != null) session.delete(toDelete);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
