package com.example.andrearodriguez.facebookrecipes.recipelist;

import com.example.andrearodriguez.facebookrecipes.entities.Recipe;

/**
 * Created by andrearodriguez on 7/4/16.
 */
public class StoredRecipeInteractorImp implements StoredRecipeInteractor{

    private RecipeListRepository repository;


    public StoredRecipeInteractorImp(RecipeListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void excecuteUpdate(Recipe recipe) {
        repository.updateRecipe(recipe);
    }

    @Override
    public void excecuteDelete(Recipe recipe) {
        repository.removeRecipe(recipe);
    }
}
