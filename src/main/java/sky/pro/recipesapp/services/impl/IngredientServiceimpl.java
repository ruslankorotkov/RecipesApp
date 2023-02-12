package sky.pro.recipesapp.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import sky.pro.recipesapp.model.Ingredient;
import sky.pro.recipesapp.model.Recipe;
import sky.pro.recipesapp.services.FilesService;
import sky.pro.recipesapp.services.IngredientService;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Service
public class IngredientServiceimpl implements IngredientService {

    private Map<Long, Ingredient> ingredientMap = new TreeMap<>();
    private long generatedId = 1L;
    public final FilesService filesService;

    public IngredientServiceimpl(FilesService filesService) {
        this.filesService = filesService;
    }

    @Override
    public Ingredient createIngredient(Ingredient ingredient) {
        saveToFile();
        return ingredientMap.put(generatedId++, ingredient);
    }

    @Override
    public Optional<Ingredient> getId(Long id) {
        readFromFile();
        return Optional.ofNullable(ingredientMap.get(id));
    }

    @Override
    public Optional<Ingredient> updateIngredient(Long id, Ingredient ingredient) {
        saveToFile();
        return Optional.ofNullable(ingredientMap.replace(id, ingredient));
    }

    @Override
    public Optional<Ingredient> deleteIngredient(Long id) {
        return Optional.ofNullable(ingredientMap.remove(id));
    }

    @Override
    public Map<Long, Ingredient> allIngredients() {
        readFromFile();
        return ingredientMap;
    }

    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredientMap);
            filesService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile() {
        try {
            String json = filesService.readFromFile();
            ingredientMap = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Long, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
    }
}
