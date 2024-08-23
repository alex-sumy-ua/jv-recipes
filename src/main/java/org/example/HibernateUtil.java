package org.example;

import org.example.db.Recipe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.example.Database;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory buildSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySetting("hibernate.connection.url", "jdbc:postgresql://localhost:5432/users")
                .applySetting("hibernate.connection.username", "dimadeloseros1")
                .applySetting("hibernate.connection.password", "fgmkiller12")
                .applySetting("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                .applySetting("hibernate.show_sql", "true")
                .applySetting("hibernate.format_sql", "true")
                .applySetting("hibernate.highlight_sql", "true")
                .applySetting("hibernate.hikari.maximumPoolSize", "20")
                .build();

        try {
            sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(Recipe.class)
                    .buildMetadata()
                    .buildSessionFactory();
            sessionFactory.getSchemaManager();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError("Initialization of SessionFactory failed");
        }

        return sessionFactory;
    }
}
