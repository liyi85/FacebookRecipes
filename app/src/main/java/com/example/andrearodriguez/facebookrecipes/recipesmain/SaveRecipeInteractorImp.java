package com.example.andrearodriguez.facebookrecipes.recipesmain;

import com.example.andrearodriguez.facebookrecipes.entities.Recipe;

/**
 * Created by andrearodriguez on 7/3/16.
 */
public class SaveRecipeInteractorImp implements SaveRecipeInteractor {

    RecipeMainRepository repository;

    public SaveRecipeInteractorImp(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Recipe recipe) {
        repository.saveRecipe(recipe);
    }
}
