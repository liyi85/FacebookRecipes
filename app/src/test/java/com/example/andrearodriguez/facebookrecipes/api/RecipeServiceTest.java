package com.example.andrearodriguez.facebookrecipes.api;




import com.example.andrearodriguez.facebookrecipes.BaseTest;
import com.example.andrearodriguez.facebookrecipes.BuildConfig;
import com.example.andrearodriguez.facebookrecipes.entities.Recipe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import retrofit2.Call;
import retrofit2.Response;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by andrearodriguez on 7/20/16.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RecipeServiceTest extends BaseTest {
    private RecipeService service;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        RecipeClient client = new RecipeClient();
        service = client.getRecipeService();
    }

    @Test
    public void doSearch_getRecipeFromBackend() throws Exception {
        String sort = "r";
        int count = 1;
        int page = 1;
        Call<RecipeSearchResponse> call = service.search(BuildConfig.FOOD_API_KEY, sort, count, page);

        Response<RecipeSearchResponse> response = call.execute();
        assertTrue(response.isSuccess());

        RecipeSearchResponse recipeSearchResponse = response.body();
        assertEquals(1, recipeSearchResponse.getCount());

        Recipe recipe = recipeSearchResponse.getFirstRecipe();
        assertNotNull(recipe);
    }
}
