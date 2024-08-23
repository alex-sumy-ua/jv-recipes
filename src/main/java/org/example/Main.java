package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory  = HibernateUtil.buildSessionFactory()) {

            Session session = sessionFactory.openSession();
        }
    }
}