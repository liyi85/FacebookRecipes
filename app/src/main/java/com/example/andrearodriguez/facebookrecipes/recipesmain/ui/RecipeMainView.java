package com.example.andrearodriguez.facebookrecipes.recipesmain.ui;

import com.example.andrearodriguez.facebookrecipes.entities.Recipe;

/**
 * Created by andrearodriguez on 7/3/16.
 */
public interface RecipeMainView {

    void showProgress();
    void hideProgress();

    void showUIElements();
    void hideUIElements();

    void saveAnimation();
    void dismissAnimation();

    void onRecipeSaved();

    void setRecipe(Recipe recipe);
    void onGetRecipeError(String error);


}
