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
    public Ingredient getId(long id) {
        return ingredientMap.get(id);
    }


    @Override
    public Ingredient updateIngredient(long id, Ingredient ingredient) {
        
        ingredientMap.put(id, ingredient);
        return ingredient;
    }

    @Override
    public Ingredient deleteIngredient(long id) {

        return ingredientMap.remove(id);
    }


    @Override
    public Map<Long, Ingredient> allIngredients() {
        return ingredientMap;
    }

}
