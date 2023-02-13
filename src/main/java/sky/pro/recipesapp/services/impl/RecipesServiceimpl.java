package sky.pro.recipesapp.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;
import sky.pro.recipesapp.exception.ValidationException;
import sky.pro.recipesapp.model.Recipe;
import sky.pro.recipesapp.services.RecipesService;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;


@Service
public class RecipesServiceimpl implements RecipesService {


    private static Map<Long, Recipe> recipesMap = new TreeMap<>();
    private long generatedId = 1L;
    private final ValidateServiceImpl validateService;

    public RecipesServiceimpl(ValidateServiceImpl validateService) {
        this.validateService = validateService;
    }


    @Override
    public Recipe createRecipe(Recipe recipe) {
//        if (!validateService.validate(recipe)) {
//            throw new ValidationException(recipe.toString());
//        }
        return recipesMap.put(generatedId++, recipe);
    }

    @Override
    public Optional<Recipe> getId(Long id) {
        return Optional.ofNullable(recipesMap.get(id));
    }

    @Override
    public Optional<Recipe> updateRecipe(Long id, Recipe recipe) {
//        if (!validateService.validate(recipe)) {
//            throw new ValidationException(recipe.toString());
//        }
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


