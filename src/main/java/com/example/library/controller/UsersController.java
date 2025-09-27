package com.example.library.controller;

import com.example.library.dto.user.request.UpdateUserRequest;
import com.example.library.dto.user.response.DeletedUserResponse;
import com.example.library.dto.user.response.UpdatedUserResponse;
import com.example.library.dto.user.response.UserListResponse;
import com.example.library.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<UserListResponse> getList(){
        return userService.getList();
    }

    @PutMapping("/{id}")
    public UpdatedUserResponse update(@Valid @RequestBody UpdateUserRequest request){
        return userService.update(request);
    }

    @DeleteMapping("/{id}")
    public DeletedUserResponse delete(@PathVariable int id){
        return userService.delete(id);
    }

}
