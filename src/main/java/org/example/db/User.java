package org.example.db;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "users")
public class User {

    // id, username, email, password, roles (admin, regular user), date registered
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    private String email;

    private String password;

    private String role;

    private Date registered;

    public User(String username) {
        this.username = username;
    }

    public User(Long id, String username, String email, String password, String role, Date registered) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.registered = registered;
    }

}
