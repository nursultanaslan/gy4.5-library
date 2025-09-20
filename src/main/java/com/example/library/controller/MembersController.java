package com.example.library.controller;

import com.example.library.dto.member.request.CreateMemberRequest;
import com.example.library.dto.member.response.GetByIdMemberResponse;
import com.example.library.dto.member.response.MemberResponse;
import com.example.library.entity.enums.MemberStatus;
import com.example.library.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/members")
public class MembersController {

    private final MemberService memberService;

    public MembersController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping()
    public MemberResponse create(@RequestBody CreateMemberRequest request){
        return memberService.create(request);
    }

    @GetMapping("/{id}")
    public GetByIdMemberResponse getById(@PathVariable Integer id){
        return memberService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        memberService.delete(id);
    }

    @GetMapping()
    public MemberResponse getByMemberStatusAndEmail(@RequestParam MemberStatus memberStatus,
                                                    @RequestParam String email){
        return memberService.getByMemberStatusAndEmail(memberStatus, email);
    }

    @PutMapping("{id}")
    public MemberResponse updateStatus(@PathVariable Integer id,
                                       @RequestParam MemberStatus memberStatus){
        return memberService.updateStatus(id, memberStatus);
    }
}
