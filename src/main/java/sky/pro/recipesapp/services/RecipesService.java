package sky.pro.recipesapp.services;

import sky.pro.recipesapp.model.Recipe;

import java.util.Map;


public interface RecipesService {

    Recipe createRecipe(Recipe recipe);

    Recipe getId(Long id);

    Recipe updateRecipe(long id, Recipe recipe);

    Recipe deleteRecipe(Long id);

    Map<Long, Recipe> allRecipes();
}

