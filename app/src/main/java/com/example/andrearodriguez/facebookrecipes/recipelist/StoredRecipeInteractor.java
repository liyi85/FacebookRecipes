package com.example.andrearodriguez.facebookrecipes.recipelist;

import com.example.andrearodriguez.facebookrecipes.entities.Recipe;

/**
 * Created by andrearodriguez on 7/4/16.
 */
public interface StoredRecipeInteractor {
    void excecuteUpdate (Recipe recipe);
    void excecuteDelete (Recipe recipe);
}
