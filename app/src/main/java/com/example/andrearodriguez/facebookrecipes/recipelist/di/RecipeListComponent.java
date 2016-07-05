package com.example.andrearodriguez.facebookrecipes.recipelist.di;

import com.example.andrearodriguez.facebookrecipes.libs.base.di.LibsModule;
import com.example.andrearodriguez.facebookrecipes.recipelist.RecipeListPresenter;
import com.example.andrearodriguez.facebookrecipes.recipelist.ui.adapters.RecipesAdapter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by andrearodriguez on 7/3/16.
 */
@Singleton
@Component (modules = {RecipiListModule.class, LibsModule.class})
public interface RecipeListComponent {
    RecipesAdapter getAdapter();
    RecipeListPresenter getPresenter();
}
