package ru.sergeypyzin.firstcrudproject.configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties (prefix = "database")
public class DatabaseProperties {

    private String findAllUsersQuery;
    private String saveUserQuery;
    private String deleteUserByIdQuery;
    private String updateUserQuery;
    private String findUserByIdQuery;

}
