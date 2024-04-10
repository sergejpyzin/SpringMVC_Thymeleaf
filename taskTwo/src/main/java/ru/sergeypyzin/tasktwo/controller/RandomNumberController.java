package ru.sergeypyzin.tasktwo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RandomNumberController {
    Random random = new Random();

    @GetMapping("/random")
    public String getRandomNumber(Model model) {
        int number = random.nextInt();
        model.addAttribute("number", number);
        return "random";
    }

    @RequestMapping("/random/{min}/{max}")
    public String getMinMaxRandomNumber(Model model, @PathVariable(name = "min") int min, @PathVariable(name = "max") int max){
        int number = random.nextInt(min, max);
        model.addAttribute("number", number);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        return "randomMinMax";
    }

    @GetMapping("/random/path")
    public String getRandomNumberWithMinMax(Model model, @RequestParam(name = "min", required = false, defaultValue = "0") int min,
                                            @RequestParam(name = "max", required = false, defaultValue = "100") int max){
        int number = random.nextInt(min, max);
        model.addAttribute("number", number);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        return "randomNumber";
    }
}
