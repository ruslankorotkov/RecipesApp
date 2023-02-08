package sky.pro.recipesapp.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sky.pro.recipesapp.model.Ingredient;
import sky.pro.recipesapp.services.IngredientService;

import java.util.Map;
@Tag(name = "Ингредиенты",description = "CRUD операции и другие эгдпоинты для работы с ингредиентами")
@RestController
@RequestMapping("ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/createIngredient")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient createIngredient = ingredientService.createIngredient(ingredient);
        return ResponseEntity.ok(createIngredient);
    }

    @GetMapping("/getIngredient/{Id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable Long id) {
        Ingredient ingredient = ingredientService.getById(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @PutMapping("/updateIngredient")
    public ResponseEntity<Ingredient> updateIngredient(@RequestParam Long id, @RequestParam Ingredient ingredient) {
        Ingredient updateIngredient = ingredientService.updateIngredient(id, ingredient);
        return ResponseEntity.ok(updateIngredient);
    }

    @DeleteMapping("/deleteIngredient")
    public ResponseEntity<Ingredient> deleteIngredient(@RequestParam Long id) {
        Ingredient deleteIngredient = ingredientService.deleteIngredient(id);
        return ResponseEntity.ok(deleteIngredient);
    }

    @GetMapping("/allIngredients")
    public ResponseEntity getAllIngredients() {
        Map<Long, Ingredient> getAllIngredients = ingredientService.allIngredients();
        return ResponseEntity.ok(getAllIngredients);
    }
}

