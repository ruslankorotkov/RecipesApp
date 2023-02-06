package sky.pro.recipesapp.impl;

import org.springframework.stereotype.Service;
import sky.pro.recipesapp.model.Ingredient;
import sky.pro.recipesapp.model.Recipes;
import sky.pro.recipesapp.services.IngredientService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class IngredientServiceimpl implements IngredientService {
    private Map<Integer, Ingredient> ingredientMap = new TreeMap<>();
    private static int id = 0;


    public Ingredient getIngredientMap(Integer id) {
        return ingredientMap.get(id);
    }


    public void addIngredient(Ingredient ingredient) {
        ingredientMap.put(id++, ingredient);
    }
}
