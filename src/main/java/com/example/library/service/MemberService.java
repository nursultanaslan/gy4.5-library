package com.example.library.service;

import com.example.library.dto.member.request.MemberCreateRequest;
import com.example.library.dto.member.request.SignupRequest;
import com.example.library.dto.member.response.MemberResponse;
import com.example.library.entity.Member;
import com.example.library.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository userRepository;

    public MemberService(MemberRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MemberResponse create(MemberCreateRequest request){
        Member user = new Member();

        userRepository.save(user);

        return new MemberResponse(
        );
    }

    public void deleteMember(int id){
        userRepository.deleteById(id);
    }

}
