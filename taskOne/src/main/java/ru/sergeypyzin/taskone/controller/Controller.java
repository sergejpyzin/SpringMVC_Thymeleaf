package ru.sergeypyzin.taskone.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/index")
    public String helloWord (){
        return "index.html";
    }
}
