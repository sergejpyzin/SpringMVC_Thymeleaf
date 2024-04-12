package ru.sergeypyzin.firstcrudproject.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Класс для хранения настроек базы данных.
 */
@Data
@Component
@ConfigurationProperties(prefix = "database")
public class DatabaseProperties {

    /** SQL-запрос для получения всех пользователей. */
    private String findAllUsersQuery;

    /** SQL-запрос для сохранения пользователя. */
    private String saveUserQuery;

    /** SQL-запрос для удаления пользователя по идентификатору. */
    private String deleteUserByIdQuery;

    /** SQL-запрос для обновления информации о пользователе. */
    private String updateUserQuery;

    /** SQL-запрос для поиска пользователя по идентификатору. */
    private String findUserByIdQuery;
}