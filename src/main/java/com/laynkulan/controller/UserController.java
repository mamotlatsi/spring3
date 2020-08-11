package com.laynkulan.controller;


import com.company.User;
import com.company.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @PostMapping(path = "user")
    public boolean addUser(@RequestBody @Valid User user){
        return userService.addUser(user);
    }

    @DeleteMapping(path = "user")
    public boolean deleteUser(@RequestBody @Valid User user){
        return userService.removeUser(user.getId());
    }

    @GetMapping(path = "user")
    public User getUser(@RequestBody @Valid long id){
        return userService.getUser(id);
    }


}