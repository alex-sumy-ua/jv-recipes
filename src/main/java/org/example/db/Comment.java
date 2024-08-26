package org.example.db;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "comments")
public class Comment {

    // id, text, date posted, author (User), associated recipe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    private Date datePosted;

    private int creator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Comment() {
    }

    public Comment(String text) {
        this.text = text;
    }

    public Comment(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Comment(String text, Date datePosted, int creator, Recipe recipe) {
        this.text = text;
        this.datePosted = datePosted;
        this.creator = creator;
        this.recipe = recipe;
    }

}
