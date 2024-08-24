package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.example.db.Recipe;
import org.example.db.Ingredient;
import static java.lang.Boolean.TRUE;
import static org.hibernate.cfg.JdbcSettings.*;

public class Database {
    public static SessionFactory getSessionFactory() {
        return new Configuration()
                .setProperty("hibernate.connection.url", "jdbc:h2:mem:db1")
                .setProperty("hibernate.connection.username", "sa")
                .setProperty("hibernate.connection.password", "")
                .setProperty("hibernate.agroal.maxSize", "20")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.format_sql", "true")
                .setProperty(HIGHLIGHT_SQL, TRUE.toString())
                .addAnnotatedClass(Recipe.class)
                .addAnnotatedClass(Ingredient.class)  // Add this if Ingredient is used as an entity
                .buildSessionFactory();
    }
}