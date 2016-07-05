package com.example.andrearodriguez.facebookrecipes.recipelist;

import com.example.andrearodriguez.facebookrecipes.entities.Recipe;
import com.example.andrearodriguez.facebookrecipes.recipelist.events.RecipeListEvent;
import com.example.andrearodriguez.facebookrecipes.recipelist.ui.RecipeListView;

/**
 * Created by andrearodriguez on 7/4/16.
 */
public interface RecipeListPresenter {
    void onCreate();
    void onDestroy();

    void getRecipes();
    void removeRecipe(Recipe recipe);
    void toggleFavorite(Recipe recipe);

    void onEventMainThread(RecipeListEvent event);

    void showAll();
    void showFavs();

    RecipeListView getView();
}
