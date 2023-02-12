package sky.pro.recipesapp.services.impl;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import sky.pro.recipesapp.model.Recipe;
//import sky.pro.recipesapp.services.FilesService;
import sky.pro.recipesapp.services.RecipesService;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;


@Service
public class RecipesServiceimpl implements RecipesService {


    private static TreeMap<Long, Recipe> recipesMap = new TreeMap<>();
    private long generatedId = 1L;
//    final private FilesService filesService;
//
//    public RecipesServiceimpl(FilesService filesService) {
//        this.filesService = filesService;
//    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
//        saveToFile();
        return recipesMap.put(generatedId++, recipe);
    }

    @Override
    public Optional<Recipe> getId(Long id) {
//        readFromFile();
        return Optional.ofNullable(recipesMap.get(id));
    }

    @Override
    public Optional<Recipe> updateRecipe(Long id, Recipe recipe) {
//        saveToFile();
        return Optional.ofNullable(recipesMap.replace(id, recipe));
    }

    @Override
    public Optional<Recipe> deleteRecipe(Long id) {
        return Optional.ofNullable(recipesMap.remove(id));
    }

    @Override
    public Map<Long, Recipe> allRecipes() {
//        readFromFile();
        return recipesMap;
    }

//    private void saveToFile() {
//        try {
//            String json = new ObjectMapper().writeValueAsString(recipesMap);
//            filesService.saveToFile(json);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private void readFromFile() {
//        try {
//            String json = filesService.readFromFile();
//            recipesMap = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Long, Recipe>>() {
//            });
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException();
//        }
//    }
}


