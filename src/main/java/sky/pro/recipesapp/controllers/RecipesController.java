package sky.pro.recipesapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.recipesapp.model.Ingredient;

import java.util.List;

@RestController
public class RecipesController {
    @GetMapping("/addRecipes")
    public String addRecipes(@RequestParam String title,
     @RequestParam int cooking_Time,
     @RequestParam List<Ingredient> ingredients,
     @RequestParam List<String> cooking_Instructions_Steps){
        return "addRecipes" + title + cooking_Time + ingredients + cooking_Instructions_Steps;
    }
}
