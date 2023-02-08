package sky.pro.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import sky.pro.recipesapp.model.Recipe;
import sky.pro.recipesapp.services.RecipesService;

import java.util.HashMap;
import java.util.Map;


@Service
public class RecipesServiceimpl implements RecipesService {


    private Map<Long, Recipe> recipesMap = new HashMap<>();
    private Long generatedId = 1L;

    @Override
    public Recipe createRecipe(Recipe recipe) {
        recipesMap.put(generatedId, recipe);
        generatedId++;
        return recipe;
    }

    @Override
    public Recipe getId(Long id) {
        return recipesMap.get(id);
    }

    @Override
    public Recipe updateRecipe(long id, Recipe recipe) {
        recipesMap.put(id, recipe);
        return recipe;
    }

    @Override
    public Recipe deleteRecipe(Long id) {
        return recipesMap.remove(id);
    }

    @Override
    public Recipe allRecipes() {
        Map<Long, Recipe> recipesMap = new HashMap<>();
        return (Recipe) recipesMap;
    }
}

