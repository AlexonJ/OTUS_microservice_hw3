package ru.otus.microarch.homeworks.crudusers.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.microarch.homeworks.crudusers.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
//    Optional<User> findById(Long id);
//    Optional<User> save(User user);
}
