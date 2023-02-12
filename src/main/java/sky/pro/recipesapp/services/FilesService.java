package sky.pro.recipesapp.services;

public interface FilesService {
    boolean saveToFile(String json);

    String readFromFile();

    boolean saveToIngredientFile(String json);

    String readFromIngredientFile();
}
