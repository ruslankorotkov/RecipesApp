package sky.pro.recipesapp.services.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import sky.pro.recipesapp.model.Recipe;
import sky.pro.recipesapp.services.RecipesService;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;


@Service
public class RecipesServiceimpl implements RecipesService {


    private final Map<Long, Recipe> recipesMap = new TreeMap<>();
    private long generatedId = 1L;

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipesMap.put(generatedId++, recipe);
    }

    @Override
    public Optional<Recipe> getId(Long id) {
        return Optional.ofNullable(recipesMap.get(id));
    }

    @Override
    public Optional<Recipe> updateRecipe(Long id, Recipe recipe) {
        return Optional.ofNullable(recipesMap.replace(id, recipe));
    }

    @Override
    public Optional<Recipe> deleteRecipe(Long id) {
        return Optional.ofNullable(recipesMap.remove(id));
    }

    @Override
    public Map<Long, Recipe> allRecipes() {
        return recipesMap;
    }
}


