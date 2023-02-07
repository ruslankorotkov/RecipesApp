package sky.pro.recipesapp.model;

import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class Recipes {
    private String title;
    private int cooking_Time;
    private List<Ingredient> ingredients;
    private List<String> cooking_Instructions_Steps;
}
