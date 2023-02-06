package sky.pro.recipesapp.impl;

import org.springframework.stereotype.Service;
import sky.pro.recipesapp.model.Recipes;
import sky.pro.recipesapp.services.RecipesService;

import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipesServiceimpl implements RecipesService {
    private Map<Integer,Recipes> recipesMap = new TreeMap<>();
}
