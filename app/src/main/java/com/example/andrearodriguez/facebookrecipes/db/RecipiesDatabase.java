package com.example.andrearodriguez.facebookrecipes.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by andrearodriguez on 7/3/16.
 */
@Database(name = RecipiesDatabase.NAME, version = RecipiesDatabase.VERSION)
public class RecipiesDatabase {
    public static final int VERSION = 1;
    public static final String NAME = "Recipes";
}
