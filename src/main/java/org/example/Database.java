package org.example;

import org.example.db.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
                .addAnnotatedClass(Ingredient.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(Image.class)
                .addAnnotatedClass(Tag.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Rating.class)
                .buildSessionFactory();
    }
}