package sky.pro.recipesapp.services;

import sky.pro.recipesapp.model.Recipe;

import java.util.Map;


public interface RecipesService {

    Recipe createRecipe(Recipe recipe);

    Recipe getId(long id);

    Recipe updateRecipe(long id, Recipe recipe);

    Recipe deleteRecipe(long id);

    Map<Long, Recipe> allRecipes();
}

