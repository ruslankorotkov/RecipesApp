package sky.pro.recipesapp.services;

import sky.pro.recipesapp.model.Ingredient;

import java.util.Map;

public interface IngredientService {
    Ingredient createIngredient(Ingredient ingredient);

    Ingredient getById(long id);

    Ingredient updateIngredient(long id, Ingredient ingredient);

    Ingredient deleteIngredient(long id);

    Map<Long, Ingredient> allIngredients();
}
