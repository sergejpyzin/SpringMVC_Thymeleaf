package ru.sergeypyzin.taskthree.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import ru.sergeypyzin.taskthree.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий для управления пользователями.
 */
@Repository
@Getter
public class UserRepository {

    /** Список пользователей. */
    private List<User> users = new ArrayList<>();

    /**
     * Метод для добавления пользователя в репозиторий.
     *
     * @param user пользователь для добавления
     */
    public void addUser(User user) {
        users.add(user);
    }
}