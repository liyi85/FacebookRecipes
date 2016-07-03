package com.example.andrearodriguez.facebookrecipes.api;

import com.example.andrearodriguez.facebookrecipes.entities.Recipe;

import java.util.List;

/**
 * Created by andrearodriguez on 7/3/16.
 */
public class RecipeSearchResponse {
    private int count;
    private List<Recipe> recipes;

    public List<Recipe> getRecipes(){
        return recipes;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    public Recipe getFirstRecipe(){
        Recipe first = null;
        if(!recipes.isEmpty()){
            first = recipes.get(0);
        }
        return first;
    }
}
