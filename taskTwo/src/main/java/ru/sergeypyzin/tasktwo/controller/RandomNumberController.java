package ru.sergeypyzin.tasktwo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

/**
 * Контроллер для генерации случайных чисел.
 */
@Controller
public class RandomNumberController {
    // Инициализация объекта Random для генерации случайных чисел
    Random random = new Random();

    /**
     * Обрабатывает GET-запрос на получение случайного числа.
     *
     * @param model объект модели
     * @return имя представления для отображения случайного числа
     */
    @GetMapping("/random")
    public String getRandomNumber(Model model) {
        // Генерация случайного числа
        int number = random.nextInt();
        // Добавление сгенерированного числа в модель
        model.addAttribute("number", number);
        // Возврат имени представления для отображения случайного числа
        return "random";
    }

    /**
     * Обрабатывает запрос на получение случайного числа в заданном диапазоне.
     *
     * @param model объект модели
     * @param min   минимальное значение диапазона
     * @param max   максимальное значение диапазона
     * @return имя представления для отображения случайного числа в заданном диапазоне
     */
    @RequestMapping("/random/{min}/{max}")
    public String getMinMaxRandomNumber(Model model, @PathVariable(name = "min") int min, @PathVariable(name = "max") int max) {
        // Генерация случайного числа в заданном диапазоне
        int number = random.nextInt(max - min + 1) + min;
        // Добавление сгенерированного числа и границ диапазона в модель
        model.addAttribute("number", number);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        // Возврат имени представления для отображения случайного числа в заданном диапазоне
        return "randomMinMax";
    }

    /**
     * Обрабатывает GET-запрос на получение случайного числа в заданном диапазоне через параметры пути.
     *
     * @param model объект модели
     * @param min   минимальное значение диапазона
     * @param max   максимальное значение диапазона
     * @return имя представления для отображения случайного числа в заданном диапазоне
     */
    @GetMapping("/random/path")
    public String getRandomNumberWithMinMax(Model model, @RequestParam(name = "min", required = false, defaultValue = "0") int min,
                                            @RequestParam(name = "max", required = false, defaultValue = "100") int max) {
        // Генерация случайного числа в заданном диапазоне
        int number = random.nextInt(max - min + 1) + min;
        // Добавление сгенерированного числа и границ диапазона в модель
        model.addAttribute("number", number);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        // Возврат имени представления для отображения случайного числа в заданном диапазоне
        return "randomNumber";
    }
}
