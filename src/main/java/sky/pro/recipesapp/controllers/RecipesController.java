package sky.pro.recipesapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sky.pro.recipesapp.services.RecipesService;

import java.util.Map;

@RestController
@RequestMapping
public class RecipesController {
    @GetMapping("/api")
    @ResponseBody
    public String getMapVariable(@PathVariable Map recipesMap) {
        Integer id = (Integer) recipesMap.get("id");
        String title = (String) recipesMap.get("title");
        if(id != null && title  != null) {
            return "ID: " + id + ", title: " + title;
        } else {
            return "Missing Parameters";
        }
    }
}
