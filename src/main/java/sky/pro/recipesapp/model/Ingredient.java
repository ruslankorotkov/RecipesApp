package sky.pro.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Ingredient {
    private String name;
    private int weight;
    private List<String> measure;
}
