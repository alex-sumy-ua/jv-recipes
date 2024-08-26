package org.example;

import org.example.db.Category;
import org.example.db.Ingredient;
import org.example.db.Recipe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = Database.getSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Ingredient sugar = new Ingredient("Sugar");
            Ingredient apple = new Ingredient("Apple");
            session.persist(sugar);
            session.persist(apple);

            Category sweets = new Category("Sweets");
            Category savoury = new Category("Savoury");

            Recipe applePie = new Recipe("Apple Pie", Arrays.asList(sugar, apple), List.of(sweets));
            session.persist(applePie);

            transaction.commit();
            session.close();
        }
    }
}