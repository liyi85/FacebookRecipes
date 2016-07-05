package com.example.andrearodriguez.facebookrecipes.recipelist.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.andrearodriguez.facebookrecipes.FacebookRecipiesApp;
import com.example.andrearodriguez.facebookrecipes.R;
import com.example.andrearodriguez.facebookrecipes.entities.Recipe;
import com.example.andrearodriguez.facebookrecipes.recipelist.RecipeListPresenter;
import com.example.andrearodriguez.facebookrecipes.recipelist.di.RecipeListComponent;
import com.example.andrearodriguez.facebookrecipes.recipelist.ui.adapters.OnItemClickListener;
import com.example.andrearodriguez.facebookrecipes.recipelist.ui.adapters.RecipesAdapter;
import com.example.andrearodriguez.facebookrecipes.recipesmain.ui.RecipeMainActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecipeListActivity extends AppCompatActivity implements RecipeListView, OnItemClickListener{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private RecipesAdapter adapter;
    private RecipeListPresenter presenter;
    private RecipeListComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        ButterKnife.bind(this);
        setupToolbar();
        setupInjection();
        setupRecyclerView();
        presenter.onCreate();
        presenter.getRecipes();
        
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recipes_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_main){
            navigateToMainScreen();
        }else if (id == R.id.action_show_all){
            presenter.showAll();
        }else if (id == R.id.action_show_fav){
            presenter.showFavs();
        } else if (id == R.id.action_logout){
            logout();
        }
        return super.onOptionsItemSelected(item);
    }


    private void logout() {
        FacebookRecipiesApp app = (FacebookRecipiesApp)getApplication();
        app.logout();
    }

    private void navigateToMainScreen() {
        startActivity(new Intent(this, RecipeMainActivity.class));

    }

    private void setupInjection() {

        FacebookRecipiesApp app = (FacebookRecipiesApp)getApplication();
        component = app.getRecipeListComponent(this, this, this);
        presenter = getPresenter();
        adapter = getAdapter();

//        ImageLoader loader = new GlideImageLoader(Glide.with(this));
//        Recipe recipe = new Recipe();
//        recipe.setFavorite(false);
//        recipe.setTitle("Prueba");
//        recipe.setSourceURL("http://static.food2fork.com/icedcoffee5766.jpg");
//        recipe.setImageURL("http://static.food2fork.com/icedcoffee5766.jpg");
//        adapter = new RecipesAdapter(Arrays.asList(recipe), loader, this);
//        presenter = new RecipeListPresenter() {
//            @Override
//            public void onCreate() {
//
//            }
//
//            @Override
//            public void onDestroy() {
//
//            }
//
//            @Override
//            public void getRecipes() {
//
//            }
//
//            @Override
//            public void removeRecipe(Recipe recipe) {
//
//            }
//
//            @Override
//            public void toggleFavorite(Recipe recipe) {
//
//            }
//
//            @Override
//            public void onEventMainThread(RecipeListEvent event) {
//
//            }
//
//            @Override
//            public RecipeListView getView() {
//                return null;
//            }
//        };
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

    private void setupToolbar() {
    setSupportActionBar(toolbar);
    }

    @OnClick(R.id.toolbar)
    public void onToolbarClick(){
        recyclerView.smoothScrollToPosition(0);
    }

    @Override
    public void setRecipes(List<Recipe> data) {
        adapter.setRecipe(data);
    }

    @Override
    public void recipeUpdated() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void recipeDeleted(Recipe recipe) {
        adapter.removeRecipe(recipe);
    }

    @Override
    public void onFavClick(Recipe recipe) {
        presenter.toggleFavorite(recipe);
    }

    @Override
    public void onItemClick(Recipe recipe) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(recipe.getSourceURL()));
        startActivity(intent);
    }

    @Override
    public void onDeleteClick(Recipe recipe) {
        presenter.removeRecipe(recipe);
    }

    public RecipeListPresenter getPresenter() {
        return component.getPresenter();
    }

    public RecipesAdapter getAdapter() {
        return component.getAdapter();
    }
}
