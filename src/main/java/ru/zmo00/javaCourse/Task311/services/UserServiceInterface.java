package ru.zmo00.javaCourse.Task311.services;

import ru.zmo00.javaCourse.Task311.models.User;

import java.util.List;

public interface UserServiceInterface {

    void create(User user);

    User read(long id);

    void update(User user);

    void delete(User user);

    List<User> readAll();

}
