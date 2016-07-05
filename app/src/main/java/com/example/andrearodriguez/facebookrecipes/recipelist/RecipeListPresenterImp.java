package com.example.andrearodriguez.facebookrecipes.recipelist;

import com.example.andrearodriguez.facebookrecipes.entities.Recipe;
import com.example.andrearodriguez.facebookrecipes.libs.base.EventBus;
import com.example.andrearodriguez.facebookrecipes.recipelist.events.RecipeListEvent;
import com.example.andrearodriguez.facebookrecipes.recipelist.ui.RecipeListView;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by andrearodriguez on 7/4/16.
 */
public class RecipeListPresenterImp implements RecipeListPresenter{
    private EventBus eventBus;
    private RecipeListView view;
    private RecipeListInteractor listInteractor;
    private StoredRecipeInteractor storedRecipeInteractor;

    public RecipeListPresenterImp(EventBus eventBus, RecipeListView view, RecipeListInteractor listInteractor, StoredRecipeInteractor storedRecipeInteractor) {
        this.eventBus = eventBus;
        this.view = view;
        this.listInteractor = listInteractor;
        this.storedRecipeInteractor = storedRecipeInteractor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        view = null;
    }

    @Override
    public void getRecipes() {
        listInteractor.excecute();
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        storedRecipeInteractor.excecuteDelete(recipe);
    }

    @Override
    public void toggleFavorite(Recipe recipe) {
        boolean fav = recipe.getFavorite();
        recipe.setFavorite(!fav);
        storedRecipeInteractor.excecuteUpdate(recipe);
    }

    @Subscribe
    @Override
    public void onEventMainThread(RecipeListEvent event) {
        if(this.view != null){
            switch (event.getType()){
                case RecipeListEvent.READ_EVENT:
                    view.setRecipes(event.getRecipeList());
                    break;
                case RecipeListEvent.UPDATE_EVENT:
                    view.recipeUpdated();
                    break;
                case RecipeListEvent.DELETE_EVENT:
                    Recipe recipe = event.getRecipeList().get(0);
                    view.recipeDeleted(recipe);
                    break;
            }
        }

    }

    @Override
    public void showAll() {
        listInteractor.excecute();
    }

    @Override
    public void showFavs() {
        listInteractor.searchFavs();
    }

    @Override
    public RecipeListView getView() {
        return this.view;
    }
}
