package sky.pro.recipesapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {


    @GetMapping
    public String applicationLaunched() {
        return " Приложение запущено ";
    }

    @GetMapping("/info")
    public String info() {
        return " info: имя ученика: Руслан ,\n" +
                "название вашего проекта: RecipesApp ,\n" +
                "дату создания проекта: 02/02/2023 ,\n" +
                "описание проекта: приложение для сайта рецептов";
    }

    @GetMapping("/info")
    public String info(@RequestParam String info) {
        return " info:" + info;
    }

}
