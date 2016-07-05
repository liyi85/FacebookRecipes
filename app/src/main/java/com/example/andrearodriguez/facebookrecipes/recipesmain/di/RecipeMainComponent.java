package com.example.andrearodriguez.facebookrecipes.recipesmain.di;

import com.example.andrearodriguez.facebookrecipes.libs.base.ImageLoader;
import com.example.andrearodriguez.facebookrecipes.libs.base.di.LibsModule;
import com.example.andrearodriguez.facebookrecipes.recipesmain.RecipeMainPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by andrearodriguez on 7/3/16.
 */
@Singleton
@Component (modules = {RecipiMainModule.class, LibsModule.class})
public interface RecipeMainComponent {
    //void inject(RecipeMainActivity activity);
    ImageLoader getImageLoader();
    RecipeMainPresenter getPresenter();
}
