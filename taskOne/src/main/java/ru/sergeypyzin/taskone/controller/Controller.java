package ru.sergeypyzin.taskone.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Контроллер для обработки запросов на страницу index.html.
 */
@org.springframework.stereotype.Controller
public class Controller {

    /**
     * Обрабатывает запрос на отображение страницы index.html.
     *
     * @return имя представления index.html
     */
    @RequestMapping("/index")
    public String helloWord (){
        return "index.html";
    }
}
