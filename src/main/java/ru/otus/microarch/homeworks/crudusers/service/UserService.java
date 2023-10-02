package ru.otus.microarch.homeworks.crudusers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.microarch.homeworks.crudusers.entity.User;
import ru.otus.microarch.homeworks.crudusers.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User get(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow();
    }

    public User update(Long id, User user){
        Optional<User> findedUserOptional = userRepository.findById(id);
        User fundedUser = findedUserOptional.orElseThrow();
        user.setId(id);
        return userRepository.save(user);
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
