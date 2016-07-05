package com.example.andrearodriguez.facebookrecipes.recipesmain;

import java.util.Random;

/**
 * Created by andrearodriguez on 7/3/16.
 */
public class GetNextInteractorImp implements GetNextRecipeInteractor {

    RecipeMainRepository repository;

    public GetNextInteractorImp(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        int recipePage = new Random().nextInt(RecipeMainRepository.RECIPE_RANGE);
        repository.setRecipePage(recipePage);
        repository.getNextRecipe();
    }
}
