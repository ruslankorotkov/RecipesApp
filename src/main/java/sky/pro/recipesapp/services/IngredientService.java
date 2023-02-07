package sky.pro.recipesapp.services;

import sky.pro.recipesapp.model.Ingredient;

public interface IngredientService {
    Ingredient createIngredient(Ingredient ingredient);

    Ingredient getById(Long id);


    Ingredient updateIngredient(Long id, Ingredient ingredient);

    Ingredient deleteIngredient(Long id);

    Ingredient allIngredients();
}
