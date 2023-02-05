package sky.pro.recipesapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {


    @GetMapping
    public String applicationLaunched() {
        return "<h1 style=\"text-align: center\">Приложение запущено</h1>";
    }

    @GetMapping("/info")
    public String info() {
        return " info: имя ученика: Руслан <br/>," +
                "название проекта: RecipesApp <br/>," +
                "дата создания проекта: 02/02/2023 <br/>," +
                "описание проекта: приложение для сайта рецептов";
    }

    @GetMapping("/info1")
    public String info1(@RequestParam String info) {
        return " info1:" + info;
    }

}
