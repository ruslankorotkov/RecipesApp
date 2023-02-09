package sky.pro.recipesapp.services;

import sky.pro.recipesapp.model.Ingredient;

import java.util.Map;

public interface IngredientService {
    Ingredient createIngredient(Ingredient ingredient);

    Ingredient getId(Long id);

    Ingredient updateIngredient(Long id, Ingredient ingredient);

    Ingredient deleteIngredient(Long id);

    Map<Long, Ingredient> allIngredients();
}
