package ru.otus.microarch.homeworks.crudusers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository<User, Long> extends CrudRepository<User, Long> {
    @Override
    Optional<User> findById(Long id);
    @Override
    void (User user);
}
