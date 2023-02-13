package sky.pro.recipesapp.services;

import sky.pro.recipesapp.model.Ingredient;
import sky.pro.recipesapp.model.Recipe;

public interface ValidateService {
    public boolean validate(Recipe recipe);

    public boolean validate(Ingredient ingredient);
}
