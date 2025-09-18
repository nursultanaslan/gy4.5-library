package com.example.library.controller;

import com.example.library.dto.member.request.MemberCreateRequest;
import com.example.library.dto.member.request.SignupRequest;
import com.example.library.dto.member.response.MemberResponse;
import com.example.library.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class MembersController {

    private final MemberService userService;

    public MembersController(MemberService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public MemberResponse create(@RequestBody MemberCreateRequest request){
        return userService.create(request);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteMember(id);
    }
}
