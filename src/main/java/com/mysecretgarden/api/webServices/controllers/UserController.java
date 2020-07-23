package com.mysecretgarden.api.webServices.controllers;

import com.mysecretgarden.api.webServices.entities.Guardian;
import com.mysecretgarden.api.webServices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public Guardian getMe() {
        Guardian guardian = userService.getMe();
        guardian.setCards(new ArrayList<>());
        return guardian;
    }

    @GetMapping
    public List<Guardian> getUsers(){
        return userService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Guardian getUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping(value = "/sign-up")
    public Guardian postUser(@RequestBody Guardian guardian){
        return userService.saveUser(guardian);
    }

    @PutMapping(value = "/{id}")
    public Guardian putUser(@RequestBody Guardian guardian, @PathVariable Long id){
        return userService.updateUser(guardian, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
