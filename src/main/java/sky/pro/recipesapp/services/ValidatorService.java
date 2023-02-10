package sky.pro.recipesapp.services;

import sky.pro.recipesapp.model.Ingredient;
import sky.pro.recipesapp.model.Recipe;

public interface ValidatorService {
    public boolean validate(Recipe recipe);

    public boolean validate(Ingredient ingredient);
}
