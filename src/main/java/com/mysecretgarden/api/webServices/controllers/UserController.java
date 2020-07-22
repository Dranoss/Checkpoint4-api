package com.mysecretgarden.api.webServices.controllers;

import com.mysecretgarden.api.webServices.entities.User;
import com.mysecretgarden.api.webServices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping(value = "/sign-up")
    public User postUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping(value = "/{id}")
    public User putUser(@RequestBody User user, @PathVariable Long id){
        return userService.updateUser(user, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
