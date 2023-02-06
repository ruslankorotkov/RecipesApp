package sky.pro.recipesapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientController {
    @GetMapping("/addIngredient")
    public String addIngredient(@RequestParam String name,
                                @RequestParam int weight,
                                @RequestParam String measure) {
        return "addIngredient" + name + weight + measure;
    }

}
