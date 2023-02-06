package sky.pro.recipesapp.services;

import sky.pro.recipesapp.model.Ingredient;

public interface IngredientService {
    Ingredient getIngredientMap(Integer id);

    void addIngredient(Ingredient ingredient);
}
