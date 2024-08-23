package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import static java.lang.Boolean.TRUE;
import static org.hibernate.cfg.JdbcSettings.*;

public class Database {
    public static SessionFactory getSessionFactory() {
        // use H2 in-memory database
        // default username / password
        // options to display SQL in console

        return new Configuration()
                // use H2 in-memory database
                .setProperty(URL, "jdbc:h2:mem:db1")
                // default username / password
                .setProperty(USER, "sa")
                .setProperty(PASS, "")
                .setProperty("hibernate.agroal.maxSize", "20")
                // options to display SQL in console
                .setProperty(SHOW_SQL, TRUE.toString())
                .setProperty(FORMAT_SQL, TRUE.toString())
                .setProperty(HIGHLIGHT_SQL, TRUE.toString())
                .buildSessionFactory();
    }
}
