package com.mnsd.social.controller;

import com.mnsd.social.dto.UserLoginDto;
import com.mnsd.social.model.User;
import com.mnsd.social.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@ApiOperation("controller related to user")
@CrossOrigin
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return this.userService.registerUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody UserLoginDto user){
        return this.userService.loginUser(user);
    }

    @GetMapping("/{userId}/random")
    public List<User> getRandomUsers(@PathVariable("userId") String userId){
        return this.userService.findRandomUsers(userId);
    }

}
