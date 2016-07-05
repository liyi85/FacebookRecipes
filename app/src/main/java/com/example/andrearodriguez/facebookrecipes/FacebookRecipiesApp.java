package com.example.andrearodriguez.facebookrecipes;

import android.app.Application;
import android.content.Intent;

import com.example.andrearodriguez.facebookrecipes.libs.base.di.LibsModule;
import com.example.andrearodriguez.facebookrecipes.login.ui.LoginActivity;
import com.example.andrearodriguez.facebookrecipes.recipesmain.di.DaggerRecipeMainComponent;
import com.example.andrearodriguez.facebookrecipes.recipesmain.di.RecipeMainComponent;
import com.example.andrearodriguez.facebookrecipes.recipesmain.di.RecipiMainModule;
import com.example.andrearodriguez.facebookrecipes.recipesmain.ui.RecipeMainActivity;
import com.example.andrearodriguez.facebookrecipes.recipesmain.ui.RecipeMainView;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by andrearodriguez on 7/2/16.
 */
public class FacebookRecipiesApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        initFacebook();
        initDB();
    }

    private void initDB() {
        FlowManager.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        DBTearDown();
    }


    private void DBTearDown() {
        FlowManager.destroy();
    }

    private void initFacebook() {
        FacebookSdk.sdkInitialize(this);
    }

    public void logout() {
        LoginManager.getInstance().logOut();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                |Intent.FLAG_ACTIVITY_NEW_TASK
                |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public RecipeMainComponent getRecipeMainComponent(RecipeMainActivity activity, RecipeMainView view){
        return DaggerRecipeMainComponent
                .builder()
                .libsModule(new LibsModule(activity))
                .recipiMainModule(new RecipiMainModule(view))
                .build();

    }
}
