package sky.pro.recipesapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sky.pro.recipesapp.model.Ingredient;
import sky.pro.recipesapp.services.IngredientService;

import java.util.Map;

@Tag(name = "Ингредиенты", description = "CRUD операции и другие эгдпоинты для работы с ингредиентами")
@RestController
@RequestMapping("ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Метод c/reateIngredient", summary = "Можете ввести информацию об новом ингредиент", description = "Можно ввести информацию")
    @PostMapping("/createIngredient")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient createIngredient = ingredientService.createIngredient(ingredient);
        return ResponseEntity.ok(createIngredient);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Метод /getIngredient/{Id}", summary = "Можете получить информацию об ингредиенте по id", description = "Можно получить информацию")
    @GetMapping("/getIngredient/{Id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable Long id) {
        Ingredient ingredient = ingredientService.getById(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Метод /updateIngredient", summary = "Можете изменить информацию об ингредиенте по параметрам", description = "Можно изменить информацию")
    @PutMapping("/updateIngredient")
    public ResponseEntity<Ingredient> updateIngredient(@RequestParam Long id, @RequestParam Ingredient ingredient) {
        Ingredient updateIngredient = ingredientService.updateIngredient(id, ingredient);
        return ResponseEntity.ok(updateIngredient);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Метод /deleteIngredient/{Id}", summary = "Можете удалить информацию об ингредиенте по id", description = "Можно удалить информацию")
    @DeleteMapping("/deleteIngredient/{Id}")
    public ResponseEntity<Ingredient> deleteIngredient(@RequestParam Long id) {
        Ingredient deleteIngredient = ingredientService.deleteIngredient(id);
        return ResponseEntity.ok(deleteIngredient);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Метод /getAllIngredients", summary = "Можете получить информацию о всех ингредиентах", description = "Можно получить информацию")
    @GetMapping("/allIngredients")
    public ResponseEntity getAllIngredients() {
        Map<Long, Ingredient> getAllIngredients = ingredientService.allIngredients();
        return ResponseEntity.ok(getAllIngredients);
    }
}

