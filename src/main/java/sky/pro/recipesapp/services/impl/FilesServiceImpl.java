package sky.pro.recipesapp.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sky.pro.recipesapp.services.FilesService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FilesServiceImpl implements FilesService {
    @Value("${path.to.recipes.file}")
    private String recipesFilePath;
    @Value("${name.of.recipes.file}")
    private String recipesFileName;
    @Value("${path.to.ingredient.file}")
    private String ingredientFilePath;
    @Value("${name.of.ingredient.file}")
    private String ingredientFileName;

    @Override
    public boolean saveToFile(String json) {
        try {
            deleteRecipeFile();
            Files.writeString(Path.of(recipesFilePath, recipesFileName), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String readFromFile() {
        try {
            return Files.readString(Path.of(recipesFilePath, recipesFileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private boolean deleteRecipeFile() {
        try {
            Path path = Path.of(recipesFilePath, recipesFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveToIngredientFile(String json) {
        try {
            deleteRecipeFile();
            Files.writeString(Path.of(ingredientFilePath, ingredientFileName), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String readFromIngredientFile() {
        try {
            return Files.readString(Path.of(ingredientFilePath, ingredientFileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private boolean deleteIngredientFile() {
        try {
            Path path = Path.of(ingredientFilePath, ingredientFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
