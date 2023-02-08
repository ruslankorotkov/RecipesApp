package sky.pro.recipesapp.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sky.pro.recipesapp.model.Recipe;
import sky.pro.recipesapp.services.RecipesService;

import java.util.Map;
@Tag(name = "Рецепты",description = "CRUD операции и другие эгдпоинты для работы с рецептами")
@RestController
@RequestMapping("recipe")
public class RecipesController {
    private final RecipesService recipesService;

    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @PostMapping("/createRecipe")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe createRecipe = recipesService.createRecipe(recipe);
        return ResponseEntity.ok(createRecipe);
    }

    @GetMapping("/getRecipe/{Id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id) {
        Recipe recipe = recipesService.getId(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @PutMapping("/updateRecipe")
    public ResponseEntity<Recipe> updateRecipe(@RequestParam Long id, @RequestBody Recipe recipe) {
        Recipe updateRecipe = recipesService.updateRecipe(id, recipe);
        return ResponseEntity.ok(updateRecipe);
    }

    @DeleteMapping("/deleteRecipe/{Id}")
    public ResponseEntity<Recipe> deleteRecipe(@RequestParam Long id) {
        Recipe deleteRecipe = recipesService.deleteRecipe(id);
        return ResponseEntity.ok(deleteRecipe);
    }

    @GetMapping("/allRecipes")
    public ResponseEntity getAllRecipes() {
        Map<Long, Recipe> getAllRecipes = recipesService.allRecipes();
        return ResponseEntity.ok(getAllRecipes);
    }
}
