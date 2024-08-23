package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.example.db.*;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory  = Database.getSessionFactory()) {

            Session session = sessionFactory.openSession();

            session.persist(new Recipe(1L, "Apple pie"));

            session.close();
        }
    }
}