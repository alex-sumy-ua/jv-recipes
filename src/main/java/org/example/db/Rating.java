package org.example.db;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ratings")
public class Rating {

    // id, value (e.g. 1-5 stars), date rated, associated recipe, rater (User)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String stars;

    private Date rated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    private int rater;

    public Rating() {
    }

    public Rating(String stars, int rater, Recipe recipe, Date rated) {
        this.stars = stars;
        this.rater = rater;
        this.recipe = recipe;
        this.rated = rated;
    }

}
