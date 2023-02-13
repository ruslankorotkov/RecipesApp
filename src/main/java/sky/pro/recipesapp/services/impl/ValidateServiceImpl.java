package sky.pro.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import sky.pro.recipesapp.model.Ingredient;
import sky.pro.recipesapp.model.Recipe;
import sky.pro.recipesapp.services.ValidateService;


@Service
public class ValidateServiceImpl implements ValidateService {
    @Override
    public boolean validate(Recipe recipe) {
        return recipe != null
                && recipe.getTitle() != null
                && recipe.getCookingInstructionsSteps() != null
                && recipe.getCookingInstructionsSteps().isEmpty()
                && recipe.getIngredients() != null
                && recipe.getIngredients().isEmpty();
    }

    @Override
    public boolean validate(Ingredient ingredient) {
        return ingredient != null
                && ingredient.getName() != null;

    }
}
