package sky.pro.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import sky.pro.recipesapp.model.Ingredient;
import sky.pro.recipesapp.services.IngredientService;

import java.util.Map;
import java.util.TreeMap;

@Service
public class IngredientServiceimpl implements IngredientService {

    private final Map<Long, Ingredient> ingredientMap = new TreeMap<>();
    private long generatedId = 1L;

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
        ingredientMap.getOrDefault(id, null);
        return ingredientMap.put(id, ingredient);
    }

    @Override
    public Ingredient deleteIngredient(Long id) {
        ingredientMap.getOrDefault(id, null);
        return ingredientMap.remove(id);
    }


    @Override
    public Map<Long, Ingredient> allIngredients() {
        return ingredientMap;
    }

}
