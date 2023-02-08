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
    @Operation(method = "Метод c/reateIngredient", summary = "Можете ввести информацию об новом ингредиент", description = "Можно ввести информацию")
    @PostMapping("/createRecipe")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe createRecipe = recipesService.createRecipe(recipe);
        return ResponseEntity.ok(createRecipe);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Метод /getIngredient/{id}", summary = "Можете получить информацию о рецепте по id", description = "Можно получить информацию")
    @GetMapping("/getRecipe/{Id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id) {
        Recipe recipe = recipesService.getId(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Метод /updateIngredient", summary = "Можете изменить информацию  о рецепте по параметрам", description = "Можно изменить информацию")
    @PutMapping("/updateRecipe")
    public ResponseEntity<Recipe> updateRecipe(@RequestParam Long id, @RequestBody Recipe recipe) {
        Recipe updateRecipe = recipesService.updateRecipe(id, recipe);
        return ResponseEntity.ok(updateRecipe);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Метод /deleteIngredient/{id}", summary = "Можете удалить информацию  о рецепте по id", description = "Можно удалить информацию")
    @DeleteMapping("/deleteRecipe/{Id}")
    public ResponseEntity<Recipe> deleteRecipe(@RequestParam Long id) {
        Recipe deleteRecipe = recipesService.deleteRecipe(id);
        return ResponseEntity.ok(deleteRecipe);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Информация была получена", content = {@Content(mediaType = "application/json")})})
    @Operation(method = "Метод /getAllIngredients", summary = "Можете получить информацию о всех рецептах", description = "Можно получить информацию")
    @GetMapping("/allRecipes")
    public ResponseEntity getAllRecipes(@PathVariable Map<Long, Recipe> recipeMap) {
        Map<Long, Recipe> getAllRecipes = recipesService.allRecipes();
        return ResponseEntity.ok(getAllRecipes);
    }
}
