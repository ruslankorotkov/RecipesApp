package sky.pro.recipesapp.services;
import sky.pro.recipesapp.model.Recipe;


public interface RecipesService {

    Recipe createRecipe(Recipe recipe);

    Recipe getById(Long id);

    Recipe updateRecipe(long id, Recipe recipe);

    Recipe deleteRecipe(Long id);

    Recipe allRecipes();
}

