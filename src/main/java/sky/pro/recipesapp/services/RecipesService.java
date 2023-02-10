package sky.pro.recipesapp.services;

import sky.pro.recipesapp.model.Recipe;

import java.util.Map;
import java.util.Optional;


public interface RecipesService {

    Recipe createRecipe(Recipe recipe);

    Optional<Recipe> getId(Long id);

    Recipe updateRecipe(Long id, Recipe recipe);

    Recipe deleteRecipe(Long id);

    Map<Long, Recipe> allRecipes();
}

