package com.example.andrearodriguez.facebookrecipes.recipesmain.di;

import com.example.andrearodriguez.facebookrecipes.api.RecipeClient;
import com.example.andrearodriguez.facebookrecipes.api.RecipeService;
import com.example.andrearodriguez.facebookrecipes.libs.base.EventBus;
import com.example.andrearodriguez.facebookrecipes.recipesmain.GetNextInteractorImp;
import com.example.andrearodriguez.facebookrecipes.recipesmain.GetNextRecipeInteractor;
import com.example.andrearodriguez.facebookrecipes.recipesmain.RecipeMainPresenter;
import com.example.andrearodriguez.facebookrecipes.recipesmain.RecipeMainPresenterImp;
import com.example.andrearodriguez.facebookrecipes.recipesmain.RecipeMainRepository;
import com.example.andrearodriguez.facebookrecipes.recipesmain.RecipeMainRepositoryImp;
import com.example.andrearodriguez.facebookrecipes.recipesmain.SaveRecipeInteractor;
import com.example.andrearodriguez.facebookrecipes.recipesmain.SaveRecipeInteractorImp;
import com.example.andrearodriguez.facebookrecipes.recipesmain.ui.RecipeMainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andrearodriguez on 7/3/16.
 */
@Module
public class RecipiMainModule {
    RecipeMainView view;

    public RecipiMainModule(RecipeMainView view) {
        this.view = view;
    }

    //Deb proveer los elementos que el componente requiere
    @Provides @Singleton
    RecipeMainView providesRecipeMainView(){
        return  this.view;
    }

    //=====================================RecipeMainPresenter=========================================================================================================================
    @Provides @Singleton
    RecipeMainPresenter providesRecipeMainPresenter(EventBus eventBus, RecipeMainView view, SaveRecipeInteractor saveRecipeInteractor, GetNextRecipeInteractor getNextRecipeInteractor){
        return  new RecipeMainPresenterImp(eventBus, view , saveRecipeInteractor, getNextRecipeInteractor);
    }

    // ===============================interactors ======================================================================================================================================
    @Provides @Singleton
    SaveRecipeInteractor providesSaveRecipeInteractor(RecipeMainRepository repository){
        return  new SaveRecipeInteractorImp(repository);
    }

    @Provides @Singleton
    GetNextRecipeInteractor providesGetNextRecipeInteractor(RecipeMainRepository repository){
        return  new GetNextInteractorImp(repository);
    }

    // ==========================================RecipeMainRepository===================================================================================================================

    @Provides @Singleton
    RecipeMainRepository providesRecipeMainRepository( EventBus eventBus, RecipeService service){
        return  new RecipeMainRepositoryImp( eventBus , service);
    }

//    ================================================Retrofit============================================================================================================================

    @Provides @Singleton
    RecipeService providesRecipeService(){
        return  new RecipeClient().getRecipeService();
    }

}
