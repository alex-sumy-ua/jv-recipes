package org.example.db;

import jakarta.persistence.*;
import org.example.Level;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;
    private String instructions;
    private int preparationTime;
    private int cookingTime;
    private int servings;

    @Enumerated(EnumType.STRING)
    private Level difficultyLevel;

    private int rating;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Ingredient> listOfIngredients;

    @ElementCollection
    private List<Integer> listOfCategories;

    private int creator;

    private Date dateCreated;
    private Date lastModified;

    public Recipe() {
    }

    public Recipe(String title, List<Ingredient> listOfIngredients) {
        this.title = title;
        this.listOfIngredients = listOfIngredients;
        for (Ingredient ingredient : listOfIngredients) {
            ingredient.setRecipe(this);
        }
    }

}