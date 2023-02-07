package sky.pro.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import sky.pro.recipesapp.model.Ingredient;
import sky.pro.recipesapp.services.IngredientService;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceimpl implements IngredientService {

    private Map<Long, Ingredient> ingredientMap = new HashMap<>();
    private Long generatedId = 1L;

    public Ingredient createIngredient(Ingredient ingredient) {
        ingredientMap.put(generatedId, ingredient);
        generatedId++;
        return ingredient;
    }

    public Ingredient getById(Long id) {
        return ingredientMap.get(id);
    }

    public Ingredient updateIngredient(Long id, Ingredient ingredient) {
        ingredientMap.put(id, ingredient);
        return ingredient;
    }


    public Ingredient deleteIngredient(Long id) {
        return ingredientMap.remove(id);
    }
}
