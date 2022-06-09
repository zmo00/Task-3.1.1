package ru.zmo00.javaCourse.Task311.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zmo00.javaCourse.Task311.models.User;
import ru.zmo00.javaCourse.Task311.repositories.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService implements UserServiceInterface{

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public User read(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

}
