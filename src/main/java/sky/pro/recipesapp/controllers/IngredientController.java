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
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Добавление ингредиента.", summary = "Можете ввести информацию об новом ингредиент", description = "Можно ввести информацию")
    @PostMapping("/")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient createIngredient = ingredientService.createIngredient(ingredient);
        return ResponseEntity.ok(createIngredient);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Получение информации об ингредиенте по id.", summary = "Можете получить информацию об ингредиенте по id", description = "Можно получить информацию")
    @GetMapping("/{Id}")
    public ResponseEntity<Ingredient> getIngredient(@RequestParam Long id) {
        Ingredient ingredient = ingredientService.getId(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Редактирование ингредиента по id.", summary = "Редактирование ингредиента по id.", description = "Можно изменить информацию")
    @PutMapping("/{Id}")
    public ResponseEntity<Ingredient> updateIngredient(@RequestParam Long id, @RequestBody Ingredient ingredient) {
        Ingredient updateIngredient = ingredientService.updateIngredient(id, ingredient);
        return ResponseEntity.ok(updateIngredient);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Удаление ингредиента.", summary = "Удаление ингредиента.", description = "Можно удалить информацию")
    @DeleteMapping("/{Id}")
    public ResponseEntity<Ingredient> deleteIngredient(@RequestParam Long id) {
        Ingredient deleteIngredient = ingredientService.deleteIngredient(id);
        return ResponseEntity.ok(deleteIngredient);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Получение полного списка ингредиентов.", summary = "Получение полного списка ингредиентов.", description = "Можно получить информацию")
    @GetMapping("/")
    public ResponseEntity<Map<Long, Ingredient>> getAllIngredients(@PathVariable Map<Long, Ingredient> ingredientMap) {
        Map<Long, Ingredient> getAllIngredients = ingredientService.allIngredients();
        return ResponseEntity.ok(getAllIngredients);

    }
}

