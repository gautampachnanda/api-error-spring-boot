package org.pachnanda.apierrorspringboot.controller;


import org.pachnanda.apierrorspringboot.entities.User;
import org.pachnanda.apierrorspringboot.model.EntityNotFoundException;
import org.pachnanda.apierrorspringboot.service.UserCollection;
import org.pachnanda.apierrorspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping(value = "/{userId}")
    public User getUser(@PathVariable("userId") Long userId) throws EntityNotFoundException {
        return userService.getUser(userId);
    }

    @GetMapping(value = "/collection")
    public List<User> getUserValid(@RequestBody UserCollection userCollection) throws EntityNotFoundException {
        return userService.getUserCollection(userCollection);
    }

    @GetMapping(value = "/all")
    public List<User> list() throws EntityNotFoundException {
        return userService.list();
    }

    @GetMapping(value = "/params")
    public User getUserRequestParam(@RequestParam("userId") Long userId) throws EntityNotFoundException {
        return userService.getUser(userId);
    }

    @GetMapping(value = "/noexception/{userId}")
    public User getUserNoException(@PathVariable("userId") Long userId) throws EntityNotFoundException {
        return userService.getUserNoException(userId).orElse(null);
    }


    @PostMapping
    public User createUser(@RequestBody @Valid User user) {
        return userService.createUser(user);
    }

}
