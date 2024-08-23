package org.example;

import org.example.db.Recipe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = Database.getSessionFactory()) {

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            session.persist(new Recipe(null, "Apple pie"));

            transaction.commit();  // Commit the transaction

            session.close();
        }
    }
}