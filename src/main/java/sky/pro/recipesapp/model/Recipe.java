package sky.pro.recipesapp.model;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class Recipe {
    private String title;
    private int cooking_Time;
    private List<Ingredient> ingredients;
    private List<String> cooking_Instructions_Steps;
    private long id =1;

    public long getId() {
        return id;
    }
}
