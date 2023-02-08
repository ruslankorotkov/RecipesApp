package sky.pro.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Recipe {
    private String title;
    private int cookingTime;
    private Map<Long, Ingredient> ingredientMap;
    private Map<Long, String> cookingInstructionsSteps;
}
