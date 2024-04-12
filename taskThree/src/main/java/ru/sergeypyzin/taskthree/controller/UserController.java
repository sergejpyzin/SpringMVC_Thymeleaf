package ru.sergeypyzin.taskthree.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sergeypyzin.taskthree.domain.User;
import ru.sergeypyzin.taskthree.repository.UserRepository;

/**
 * Контроллер для управления пользователями.
 */
@Controller
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    /**
     * Метод для отображения списка пользователей.
     *
     * @param model объект модели
     * @return имя представления для отображения списка пользователей
     */
    @GetMapping("/users")
    public String getUser(Model model) {
        model.addAttribute("users", userRepository.getUsers());
        return "users";
    }

    /**
     * Метод для добавления нового пользователя.
     *
     * @param user  объект пользователя для добавления
     * @param model объект модели
     * @return имя представления для отображения списка пользователей
     */
    @PostMapping("/users")
    public String addUser(User user, Model model) {
        userRepository.addUser(user);
        model.addAttribute("users", userRepository.getUsers());
        return "users";
    }
}