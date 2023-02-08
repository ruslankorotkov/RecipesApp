package sky.pro.recipesapp.model;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Recipe {
    private String title;
    private int cookingTime;
    private List<Ingredient> ingredients;
    private List<String> cookingInstructionsSteps;
}
