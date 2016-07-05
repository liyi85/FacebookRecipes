package com.example.andrearodriguez.facebookrecipes.recipelist;

import com.example.andrearodriguez.facebookrecipes.entities.Recipe;
import com.example.andrearodriguez.facebookrecipes.entities.Recipe_Table;
import com.example.andrearodriguez.facebookrecipes.libs.base.EventBus;
import com.example.andrearodriguez.facebookrecipes.recipelist.events.RecipeListEvent;
import com.raizlabs.android.dbflow.list.FlowCursorList;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.Arrays;
import java.util.List;

/**
 * Created by andrearodriguez on 7/4/16.
 */
public class RecipeListRepositoryImp implements RecipeListRepository{
    private EventBus eventBus;

    public RecipeListRepositoryImp(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void getSavedRecipes() {
        FlowCursorList<Recipe> storedRecipes = new FlowCursorList<Recipe>(false, Recipe.class);
        post(RecipeListEvent.READ_EVENT, storedRecipes.getAll());
        storedRecipes.close();
    }

    @Override
    public void updateRecipe(Recipe recipe) {
        recipe.update();
        post();
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        recipe.delete();
        post(RecipeListEvent.DELETE_EVENT, Arrays.asList(recipe));
    }

    @Override
    public void getFavoritesRecipes() {
        List<Recipe> recipes = new Select().from(Recipe.class).where(Recipe_Table.favorite.is(true)).queryList();
        post(RecipeListEvent.READ_EVENT, recipes);
    }

    private void post(int type, List<Recipe> recipeList){
        RecipeListEvent event = new RecipeListEvent();
        event.setType(type);
        event.setRecipeList(recipeList);
        eventBus.post(event);
    }
    private void post(){
        post(RecipeListEvent.UPDATE_EVENT, null);
    }
}
