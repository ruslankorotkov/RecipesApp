package sky.pro.recipesapp.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sky.pro.recipesapp.services.FilesService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FilesServiceImpl implements FilesService {
    @Value("${path.to.recipes.files}")
    private String recipesFilePath;
    @Value("${name.of.recipes.files}")
    private String recipesFileName;
    @Override
    public boolean saveToFile(String json){
        try {
            deleteRecipeFile();
            Files.writeString(Path.of(recipesFilePath,recipesFileName),json);
        } catch (IOException e) {
            e.getStackTrace();
        }
        return false;
    }
    @Override
    public String readFromFile(){
        try {
            return Files.readString(Path.of(recipesFilePath,recipesFileName));
        } catch (IOException e) {
            e.getStackTrace();
            throw new RuntimeException(e);
        }
    }
    private boolean deleteRecipeFile(){
        try {
            Path path = Path.of(recipesFilePath,recipesFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.getStackTrace();
            return false;
        }
    }
}
