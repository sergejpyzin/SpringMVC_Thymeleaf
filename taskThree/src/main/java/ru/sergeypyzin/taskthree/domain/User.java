package ru.sergeypyzin.taskthree.domain;

import lombok.Data;

/**
 * Класс, представляющий пользователя.
 */
@Data
public class User {

    /** Имя пользователя. */
    private String firstName;

    /** Фамилия пользователя. */
    private String lastName;

    /** Возраст пользователя. */
    private int age;
}

