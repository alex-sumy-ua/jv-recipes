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
    Long id;

    @Column(nullable = false)
    String title;

    String description;
    String instructions;
    int preparationTime;
    int cookingTime;
    int servings;

    @Enumerated(EnumType.STRING)
    Level difficultyLevel;

    int rating;

    @ElementCollection
    List<Integer> listOfIngredients;

    @ElementCollection
    List<Integer> listOfCategories;

    int creator; // Assume this is a foreign key to a User entity

    Date dateCreated;

    Date lastModified;

    public Recipe() {
    }

    public Recipe(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Recipe(Long id, String title, String description, String instructions, int preparationTime, int cookingTime, int servings, Level difficultyLevel, int rating, List<Integer> listOfIngredients, List<Integer> listOfCategories, int creator, Date dateCreated, Date lastModified) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.instructions = instructions;
        this.preparationTime = preparationTime;
        this.cookingTime = cookingTime;
        this.servings = servings;
        this.difficultyLevel = difficultyLevel;
        this.rating = rating;
        this.listOfIngredients = listOfIngredients;
        this.listOfCategories = listOfCategories;
        this.creator = creator;
        this.dateCreated = dateCreated;
        this.lastModified = lastModified;
    }

}