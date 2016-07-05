package com.example.andrearodriguez.facebookrecipes.recipesmain;

import com.example.andrearodriguez.facebookrecipes.entities.Recipe;
import com.example.andrearodriguez.facebookrecipes.recipesmain.events.RecipeMainEvent;
import com.example.andrearodriguez.facebookrecipes.recipesmain.ui.RecipeMainView;

/**
 * Created by andrearodriguez on 7/3/16.
 */
public interface RecipeMainPresenter {
    void onCreate();
    void onDestroy();

    void dismissRecipe();
    void getNextRecipe();
    void saveRecipe(Recipe recipe);
    void onEventMainThread(RecipeMainEvent event);

    RecipeMainView getView();

    void imageReady();
    void imageError(String error);
}
