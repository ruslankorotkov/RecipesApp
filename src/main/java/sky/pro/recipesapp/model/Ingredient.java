package sky.pro.recipesapp.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Ingredient {
    private String name;
    private int weight;
    private String measure;
    private long id = 1;

    public long getId() {
        return id;
    }
}
