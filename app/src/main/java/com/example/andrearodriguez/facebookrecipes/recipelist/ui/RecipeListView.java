package com.example.andrearodriguez.facebookrecipes.recipelist.ui;

import com.example.andrearodriguez.facebookrecipes.entities.Recipe;

import java.util.List;

/**
 * Created by andrearodriguez on 7/4/16.
 */
public interface RecipeListView {
    void setRecipes(List<Recipe> data);
    void recipeUpdated();
    void recipeDeleted(Recipe recipe);
}
