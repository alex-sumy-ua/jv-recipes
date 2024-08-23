package org.example.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.example.Level;
//import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.util.ArrayList;

@Entity
@Table
public class Recipe {

    @Id
    @GeneratedValue
    Long id;

//    @NotNull
    String title;

    String description;

    String instructions;

    int preparationTime;

    int cookingTime;

    int servings;

    Level difficultyLevel;

    int rating;

    ArrayList<Integer> listOfIngredients;

    ArrayList<Integer> listOfCategories;

    int creator;// User

    Date dateCreated;

    Date lastModified;

    public Recipe(Long id, /*@NotNull*/ String title) {
        this.id = id;
        this.title = title;
    }

    public Recipe(Long id, /*@NotNull*/ String title, String description, String instructions, int preparationTime, int cookingTime, int servings, Level difficultyLevel, int rating, ArrayList<Integer> listOfIngredients, ArrayList<Integer> listOfCategories, int creator, Date dateCreated, Date lastModified) {
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
