package sky.pro.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import sky.pro.recipesapp.model.Recipe;
import sky.pro.recipesapp.services.RecipesService;

import java.util.Map;
import java.util.TreeMap;


@Service
public class RecipesServiceimpl implements RecipesService {


    private final Map<Long, Recipe> recipesMap = new TreeMap<>();
    private long generatedId = 1L;

    @Override
    public Recipe createRecipe(Recipe recipe) {
        recipesMap.put(generatedId, recipe);
        generatedId++;
        return recipe;
    }

    @Override
    public Recipe getId(long id) {
        return recipesMap.get(id);
    }

    @Override
    public Recipe updateRecipe(long id, Recipe recipe) {

        recipesMap.put(id, recipe);
        return recipe;
    }

    @Override
    public Recipe deleteRecipe(long id) {

        return recipesMap.remove(id);
    }

    @Override
    public Map<Long, Recipe> allRecipes() {
        return recipesMap;
    }
}


