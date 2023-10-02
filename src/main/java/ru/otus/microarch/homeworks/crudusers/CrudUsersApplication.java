package ru.otus.microarch.homeworks.crudusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.otus.microarch.homeworks.crudusers.repository.UserRepository;

@SpringBootApplication
public class CrudUsersApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrudUsersApplication.class, args);
    }

}
