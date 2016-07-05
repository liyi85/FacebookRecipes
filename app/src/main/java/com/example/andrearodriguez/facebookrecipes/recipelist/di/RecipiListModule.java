package com.example.andrearodriguez.facebookrecipes.recipelist.di;

import com.example.andrearodriguez.facebookrecipes.entities.Recipe;
import com.example.andrearodriguez.facebookrecipes.libs.base.EventBus;
import com.example.andrearodriguez.facebookrecipes.libs.base.ImageLoader;
import com.example.andrearodriguez.facebookrecipes.recipelist.RecipeListInteractor;
import com.example.andrearodriguez.facebookrecipes.recipelist.RecipeListInteractorImp;
import com.example.andrearodriguez.facebookrecipes.recipelist.RecipeListPresenter;
import com.example.andrearodriguez.facebookrecipes.recipelist.RecipeListPresenterImp;
import com.example.andrearodriguez.facebookrecipes.recipelist.RecipeListRepository;
import com.example.andrearodriguez.facebookrecipes.recipelist.RecipeListRepositoryImp;
import com.example.andrearodriguez.facebookrecipes.recipelist.StoredRecipeInteractor;
import com.example.andrearodriguez.facebookrecipes.recipelist.StoredRecipeInteractorImp;
import com.example.andrearodriguez.facebookrecipes.recipelist.ui.RecipeListView;
import com.example.andrearodriguez.facebookrecipes.recipelist.ui.adapters.OnItemClickListener;
import com.example.andrearodriguez.facebookrecipes.recipelist.ui.adapters.RecipesAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andrearodriguez on 7/3/16.
 */
@Module
public class RecipiListModule {
    RecipeListView view;
    OnItemClickListener clickListener;

    public RecipiListModule(RecipeListView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    public RecipiListModule(RecipeListView view) {
        this.view = view;
    }

    //Deb proveer los elementos que el componente requiere
    @Provides
    @Singleton
    RecipeListView providesRecipeListView() {
        return this.view;
    }

    //=====================================RecipeMainPresenter=========================================================================================================================
    @Provides
    @Singleton
    RecipeListPresenter providesRecipeListPresenter(EventBus eventBus, RecipeListView view, RecipeListInteractor listInteractor, StoredRecipeInteractor storedRecipeInteractor) {
        return new RecipeListPresenterImp(eventBus, view, listInteractor, storedRecipeInteractor);
    }

    // ===============================interactors ======================================================================================================================================
    @Provides
    @Singleton
    StoredRecipeInteractor providesStoredRecipeInteractor(RecipeListRepository repository) {
        return new StoredRecipeInteractorImp(repository);
    }

    @Provides
    @Singleton
    RecipeListInteractor providesRecipeListInteractor(RecipeListRepository repository) {
        return new RecipeListInteractorImp(repository);
    }

    // ==========================================RecipeMainRepository===================================================================================================================

    @Provides
    @Singleton
    RecipeListRepository providesRecipeListRepository(EventBus eventBus) {
        return new RecipeListRepositoryImp(eventBus);
    }
    @Provides
    @Singleton
    RecipesAdapter providesRecipesAdapter(List<Recipe> recipeList, ImageLoader imageLoader, OnItemClickListener onItemClickListener) {
        return new RecipesAdapter(recipeList, imageLoader, onItemClickListener);
    }
    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener() {
        return this.clickListener;
    }
    @Provides
    @Singleton
    List<Recipe> providesEmptyList() {
        return new ArrayList<Recipe>();
    }
}
