package sky.pro.recipesapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sky.pro.recipesapp.model.Recipe;
import sky.pro.recipesapp.services.RecipesService;

@RestController
@RequestMapping("recipe")
public class RecipesController {
    private final RecipesService recipesService;

    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @PostMapping("/createRecipe")
    public ResponseEntity createRecipe(@RequestBody Recipe recipe) {
        Recipe createRecipe = recipesService.createRecipe(recipe);
        return ResponseEntity.ok(createRecipe);
    }

    @GetMapping("/getRecipe/{Id}")
    public ResponseEntity getRecipe(@PathVariable Long id) {
        Recipe recipe = recipesService.getId(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @PutMapping("/updateRecipe")
    public ResponseEntity updateRecipe(@RequestBody Long id,@RequestBody Recipe recipe) {
        Recipe updateRecipe = recipesService.updateRecipe(id, recipe);
        return ResponseEntity.ok(updateRecipe);
    }

    @DeleteMapping("/deleteRecipe/{Id}")
    public ResponseEntity deleteRecipe(@PathVariable Long id) {
        Recipe deleteRecipe = recipesService.deleteRecipe(id);
        return ResponseEntity.ok(deleteRecipe);
    }

    @GetMapping("/allRecipes")
    public ResponseEntity allRecipes() {
        Recipe allRecipes = recipesService.allRecipes();
        return ResponseEntity.ok(allRecipes());
    }
}
