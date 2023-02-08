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

    @PostMapping("/createIngredient")
    public ResponseEntity createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient createIngredient = ingredientService.createIngredient(ingredient);
        return ResponseEntity.ok(createIngredient);
    }

    @GetMapping("/getIngredient/{Id}")
    public ResponseEntity getIngredient(@PathVariable Long id) {
        Ingredient ingredient = ingredientService.getById(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @PutMapping("/updateIngredient")
    public ResponseEntity updateIngredient(@RequestBody Long id,@RequestBody Ingredient ingredient) {
        Ingredient updateIngredient = ingredientService.updateIngredient(id, ingredient);
        return ResponseEntity.ok(updateIngredient);
    }

    @DeleteMapping("/deleteIngredient")
    public ResponseEntity deleteIngredient(@PathVariable Long id) {
        Ingredient deleteIngredient = ingredientService.deleteIngredient(id);
        return ResponseEntity.ok(deleteIngredient);
    }

    @GetMapping("/allIngredients")
    public ResponseEntity allIngredients() {
        Ingredient allIngredients = ingredientService.allIngredients();
        return ResponseEntity.ok(allIngredients());
    }
}

