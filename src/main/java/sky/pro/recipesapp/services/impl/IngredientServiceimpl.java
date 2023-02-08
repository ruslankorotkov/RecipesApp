package sky.pro.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import sky.pro.recipesapp.model.Ingredient;
import sky.pro.recipesapp.services.IngredientService;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class IngredientServiceimpl implements IngredientService {

    private Map<Long, Ingredient> ingredientMap = new LinkedHashMap<>();
    private Long generatedId = 1L;

    @Override
    public Ingredient createIngredient(Ingredient ingredient) {
        ingredientMap.put(generatedId, ingredient);
        generatedId++;
        return ingredient;
    }

    @Override
    public Ingredient getById(Long id) {
        return ingredientMap.get(id);
    }

    @Override
    public Ingredient updateIngredient(Long id, Ingredient ingredient) {
        ingredientMap.put(id, ingredient);
        return ingredient;
    }

    @Override
    public Ingredient deleteIngredient(Long id) {
        return ingredientMap.remove(id);
    }


    @Override
    public Map<Long, Ingredient> allIngredients() {
        Map<Long, Ingredient> ingredientMap = new LinkedHashMap<>();
        return ingredientMap;
    }
}
