package sky.pro.recipesapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.awt.Color.red;

@RestController
public class FirstController {


    @GetMapping
    public String applicationLaunched() {
        return "<h1 style=\"text-align: center\">Приложение запущено</h1>";
    }

    @GetMapping("/info")
    public String info() {
        return "<h2><center>info:</center></h2>,"+
                "<h3><center>имя ученика: Руслан </center></h3>," +
                "<h3><center>название проекта: RecipesApp</center></h3>," +
                "<h3><center>дата создания проекта: 02/02/2023 </center></h3>," +
                "<h3><center>описание проекта: приложение для сайта рецептов</center></h3>.";
    }

    @GetMapping("/info1")
    public String info1(@RequestParam String info) {
        return "<h3><center>info1:</center></h3>" + info;
    }

}
