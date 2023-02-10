package sky.pro.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import sky.pro.recipesapp.exception.ValidationException;
import sky.pro.recipesapp.model.Recipe;
import sky.pro.recipesapp.services.RecipesService;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;


@Service
public class RecipesServiceimpl implements RecipesService {


    private final Map<Long, Recipe> recipesMap = new TreeMap<>();
    private long generatedId = 1L;
    private final ValidateServiceImpl validateService;

    public RecipesServiceimpl(ValidateServiceImpl validateService) {
        this.validateService = validateService;
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        if (!validateService.validate(recipe)) {
            throw new ValidationException(recipe.toString());
        }
        return recipesMap.put(generatedId++, recipe);
    }

    @Override
    public Optional<Recipe> getId(Long id) {
        return Optional.ofNullable(recipesMap.get(id));
    }

    @Override
    public Recipe updateRecipe(Long id, Recipe recipe) {
        if (!validateService.validate(recipe)) {
            throw new ValidationException(recipe.toString());
        }
        return recipesMap.replace(id, recipe);
    }

    @Override
    public Recipe deleteRecipe(Long id) {
        return recipesMap.remove(id);
    }

    @Override
    public Map<Long, Recipe> allRecipes() {
        return recipesMap;
    }
}


