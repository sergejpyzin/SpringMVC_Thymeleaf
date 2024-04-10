package ru.sergeypyzin.taskthree.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import ru.sergeypyzin.taskthree.domain.User;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class UserRepository {

    List<User> users = new ArrayList<>();

    public void addUser (User user){
        users.add(user);
    }

}
