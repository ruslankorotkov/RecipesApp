package sky.pro.recipesapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sky.pro.recipesapp.model.Ingredient;
import sky.pro.recipesapp.services.IngredientService;

@RestController
@RequestMapping("ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/ingredien")
    public ResponseEntity createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient createIngredient = ingredientService.createIngredient(ingredient);
        return ResponseEntity.ok(createIngredient);
    }

    @GetMapping("/ingredien/{Id}")
    public ResponseEntity getIngredient(@PathVariable Long id) {
        Ingredient ingredient = ingredientService.getById(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @PutMapping("/ingredien")
    public ResponseEntity updateIngredient(@RequestBody Ingredient ingredient) {
        Ingredient updateIngredient = ingredientService.updateIngredient(ingredient.getId(), ingredient);
        return ResponseEntity.ok(updateIngredient);
    }

    @DeleteMapping("/ingredien")
    public ResponseEntity deleteIngredient(@RequestBody Ingredient ingredient) {
        Ingredient deleteIngredient = ingredientService.deleteIngredient(ingredient.getId());
        return ResponseEntity.ok(deleteIngredient);
    }

    @GetMapping("/ingredien")
    public ResponseEntity allIngredients() {
        Ingredient allIngredients = ingredientService.allIngredients();
        return ResponseEntity.ok(allIngredients());
    }
}

