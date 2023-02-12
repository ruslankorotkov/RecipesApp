package sky.pro.recipesapp.services;

public interface FilesService {
    boolean saveToFile(String json);

    String readFromFile();
}
