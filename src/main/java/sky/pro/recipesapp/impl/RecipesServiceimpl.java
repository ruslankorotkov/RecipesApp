package sky.pro.recipesapp.impl;

import org.springframework.stereotype.Service;
import sky.pro.recipesapp.model.Recipes;
import sky.pro.recipesapp.services.RecipesService;

import java.util.HashMap;
import java.util.Map;


@Service
public class RecipesServiceimpl implements RecipesService {


    private Map<Long, Recipes> recipesMap = new HashMap<>();
    private Long generatedId = 1L;

    public Recipes createRecipes(Recipes recipes) {
        recipesMap.put(generatedId, recipes);
        generatedId++;
        return recipes;
    }

    public Recipes getById(Long id) {
        return recipesMap.get(id);
    }

    public Recipes updateRecipes(Long id, Recipes recipes) {
        recipesMap.put(id, recipes);
        return recipes;
    }


    public Recipes deleteRecipes(Long id) {
        return recipesMap.remove(id);
    }

}

