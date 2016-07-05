package com.example.andrearodriguez.facebookrecipes.recipelist;

import com.example.andrearodriguez.facebookrecipes.entities.Recipe;

/**
 * Created by andrearodriguez on 7/4/16.
 */
public interface RecipeListRepository {
    void getSavedRecipes();
    void updateRecipe(Recipe recipe);
    void removeRecipe(Recipe recipe);
    void getFavoritesRecipes();
}
