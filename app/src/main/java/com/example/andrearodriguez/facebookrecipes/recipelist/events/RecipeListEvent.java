package com.example.andrearodriguez.facebookrecipes.recipelist.events;

import com.example.andrearodriguez.facebookrecipes.entities.Recipe;

import java.util.List;

/**
 * Created by andrearodriguez on 7/4/16.
 */
public class RecipeListEvent {
    private int type;
    private List<Recipe> recipeList;

    public final static int READ_EVENT=0;
    public final static int UPDATE_EVENT=1;
    public final static int DELETE_EVENT=2;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
}
