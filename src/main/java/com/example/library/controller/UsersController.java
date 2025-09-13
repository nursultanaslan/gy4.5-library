package com.example.library.controller;

import com.example.library.dto.user.request.SignupRequest;
import com.example.library.dto.user.response.UserResponse;
import com.example.library.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public UserResponse create(@RequestBody SignupRequest request){
        return userService.create(request);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
