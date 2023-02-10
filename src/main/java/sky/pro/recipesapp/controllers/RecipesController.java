package sky.pro.recipesapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sky.pro.recipesapp.model.Recipe;
import sky.pro.recipesapp.services.RecipesService;

import java.util.Map;

@Tag(name = "Рецепты", description = "CRUD операции и другие эгдпоинты для работы с рецептами")
@RestController
@RequestMapping("recipe")
public class RecipesController {
    private final RecipesService recipesService;

    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Добавление рецепта.", summary = "Добавление рецепта.", description = "Можно ввести информацию")
    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe createRecipe = recipesService.createRecipe(recipe);
        return ResponseEntity.ok(createRecipe);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Получение рецепта по id.", summary = "Получение рецепта по id.", description = "Можно получить информацию")
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable long id) {
        Recipe recipe = recipesService.getId(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Редактирование рецепта по id.", summary = "Редактирование рецепта по id.", description = "Можно изменить информацию")
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable long id, @RequestBody Recipe recipe) {
        Recipe updateRecipe = recipesService.updateRecipe(id, recipe);
        return ResponseEntity.ok(updateRecipe);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Удаление рецепта по id.", summary = "Удаление рецепта по id.", description = "Можно удалить информацию")
    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable long id) {
        Recipe deleteRecipe = recipesService.deleteRecipe(id);
        return ResponseEntity.ok(deleteRecipe);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Получение списка всех рецептов.", summary = "Получение списка всех рецептов.", description = "Можно получить информацию")
    @GetMapping
    public ResponseEntity<Map<Long, Recipe>> getAllRecipes() {
        Map<Long, Recipe> getAllRecipes = recipesService.allRecipes();
        return ResponseEntity.ok(getAllRecipes);

    }
}
