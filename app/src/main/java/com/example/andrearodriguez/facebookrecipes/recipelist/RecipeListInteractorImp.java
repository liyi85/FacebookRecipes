package com.example.andrearodriguez.facebookrecipes.recipelist;

/**
 * Created by andrearodriguez on 7/4/16.
 */
public class RecipeListInteractorImp implements RecipeListInteractor{
    private RecipeListRepository repository;

    public RecipeListInteractorImp(RecipeListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void excecute() {
        repository.getSavedRecipes();
    }

    @Override
    public void searchFavs() {
        repository.getFavoritesRecipes();
    }
}
