package ru.otus.microarch.homeworks.crudusers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.otus.microarch.homeworks.crudusers.entity.User;
import ru.otus.microarch.homeworks.crudusers.model.ErrorResponse;
import ru.otus.microarch.homeworks.crudusers.service.UserService;

@Controller
public class UsersController {

    UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> createUser(@Value("${service.teststring}") String testString){
        return new ResponseEntity<>(testString, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user),HttpStatus.CREATED);
    }

    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.get(userId), HttpStatus.OK);
    }

    @RequestMapping(path = "/user/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/user/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        userService.update(userId, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
