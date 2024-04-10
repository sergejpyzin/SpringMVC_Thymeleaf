package ru.sergeypyzin.taskthree.controller;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sergeypyzin.taskthree.domain.User;
import ru.sergeypyzin.taskthree.repository.UserRepository;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public String getUser(Model model) {

        model.addAttribute("users", userRepository.getUsers());

        return "users";
    }

    @PostMapping("/users")
    public String addUser(User user, Model model) {

        userRepository.addUser(user);

        model.addAttribute("users", userRepository.getUsers());

        return "users";
    }
}
