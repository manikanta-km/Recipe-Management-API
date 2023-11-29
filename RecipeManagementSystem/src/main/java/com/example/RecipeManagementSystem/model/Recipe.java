package com.example.RecipeManagementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipeId;
    private String recipeName;
    private List<String> recipeIngredients;
    private String preparationTime;
    private String instructions;
    private Integer servings;
    private Categories recipeCategory;
    private Cuisine cuisine;
    private RecipeFormat recipeFormat;
    private Seasoning seasoning;
    private String NutritionalInformation;
    private String tags;
    private LocalDateTime timeStamp;

    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "fk_owner_user_id")
    private User recipeOwner;

    @OneToMany
    @JoinColumn(name = "no_of_likes")
    private List<Likes> likes;

    @OneToMany
    @JoinColumn(name = "no_of_comments")
    private List<Comment> comments;
}
