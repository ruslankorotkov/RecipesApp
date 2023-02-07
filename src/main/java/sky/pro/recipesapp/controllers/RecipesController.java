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

    @PostMapping("/recipe")
    public ResponseEntity createRecipe(@RequestBody Recipe recipe) {
        Recipe createRecipe = recipesService.createRecipe(recipe);
        return ResponseEntity.ok(createRecipe);
    }

    @GetMapping("/recipe/{Id}")
    public ResponseEntity getRecipe(@PathVariable Long id) {
        Recipe recipe = recipesService.getById(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @PutMapping("/recipe")
    public ResponseEntity updateRecipe(@RequestBody Recipe recipe) {
        Recipe updateRecipe = recipesService.updateRecipe(recipe.getId(), recipe);
        return ResponseEntity.ok(updateRecipe);
    }

    @DeleteMapping("/recipe")
    public ResponseEntity deleteRecipe(@RequestBody Recipe recipe) {
        Recipe deleteRecipe = recipesService.deleteRecipe(recipe.getId());
        return ResponseEntity.ok(deleteRecipe);
    }

    @GetMapping("/recipe")
    public Recipe allRecipe() {
        return allRecipe();
    }

}
