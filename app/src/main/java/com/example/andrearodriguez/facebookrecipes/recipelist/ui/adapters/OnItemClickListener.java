package com.example.andrearodriguez.facebookrecipes.recipelist.ui.adapters;

import com.example.andrearodriguez.facebookrecipes.entities.Recipe;

/**
 * Created by andrearodriguez on 7/4/16.
 */
public interface OnItemClickListener {
    void onFavClick(Recipe recipe);
    void onItemClick(Recipe recipe);
    void onDeleteClick (Recipe recipe);
}
