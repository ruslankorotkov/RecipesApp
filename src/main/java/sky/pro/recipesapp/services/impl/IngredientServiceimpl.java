package sky.pro.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import sky.pro.recipesapp.exception.ValidationException;
import sky.pro.recipesapp.model.Ingredient;
import sky.pro.recipesapp.services.IngredientService;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Service
public class IngredientServiceimpl implements IngredientService {

    private final Map<Long, Ingredient> ingredientMap = new TreeMap<>();
    private long generatedId = 1L;
    private final ValidateServiceImpl validateService;

    public IngredientServiceimpl(ValidateServiceImpl validateService) {
        this.validateService = validateService;
    }

    @Override
    public Ingredient createIngredient(Ingredient ingredient) {
        if (!validateService.validate(ingredient)) {
            throw new ValidationException(ingredient.toString());
        }
        return ingredientMap.put(generatedId++, ingredient);
    }

    @Override
    public Optional<Ingredient> getId(Long id) {

        return Optional.ofNullable(ingredientMap.get(id));
    }

    @Override
    public Ingredient updateIngredient(Long id, Ingredient ingredient) {
        if (!validateService.validate(ingredient)) {
            throw new ValidationException(ingredient.toString());
        }
        return ingredientMap.replace(id, ingredient);
    }

    @Override
    public Ingredient deleteIngredient(Long id) {
        return ingredientMap.remove(id);
    }

    @Override
    public Map<Long, Ingredient> allIngredients() {
        return ingredientMap;
    }
}
