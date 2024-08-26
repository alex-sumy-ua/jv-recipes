package org.example.db;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "images")
public class Image {

    // id, filename, file data, associated recipe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String filename;

    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Image() {
    }

    public Image(String filename, Date date, Recipe recipe) {
        this.filename = filename;
        this.date = date;
        this.recipe = recipe;
    }

}
