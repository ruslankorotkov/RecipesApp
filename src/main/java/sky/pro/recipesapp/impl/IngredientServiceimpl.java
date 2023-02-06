package sky.pro.recipesapp.impl;

import sky.pro.recipesapp.model.Ingredient;
import sky.pro.recipesapp.services.IngredientService;

import java.util.Map;
import java.util.TreeMap;

public class IngredientServiceimpl implements IngredientService {
    private Map<Integer, Ingredient> ingredientMap = new TreeMap<>();

}
