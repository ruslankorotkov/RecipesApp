package sky.pro.recipesapp.services;

import sky.pro.recipesapp.model.Recipes;

public interface RecipesService {
    Recipes getRecipesMap(Integer id);

    void addRecipes(Recipes recipes);
}
