package com.example.library.service;

import com.example.library.dto.member.request.CreateMemberRequest;
import com.example.library.dto.member.response.DeletedMemberResponse;
import com.example.library.dto.member.response.GetByIdMemberResponse;
import com.example.library.dto.member.response.MemberResponse;
import com.example.library.entity.Fine;
import com.example.library.entity.Member;
import com.example.library.entity.enums.MemberStatus;
import com.example.library.entity.enums.MembershipLevel;
import com.example.library.mapper.MemberMapper;
import com.example.library.repository.MemberRepository;
import com.example.library.rules.MemberBusinessRules;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Service
@Validated
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberBusinessRules memberBusinessRules;
    private final MemberMapper memberMapper;

    public MemberService(MemberRepository memberRepository,MemberBusinessRules memberBusinessRules, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberBusinessRules = memberBusinessRules;
        this.memberMapper = MemberMapper.INSTANCE;
    }

    public MemberResponse create(@Valid CreateMemberRequest request){

        Member member = memberMapper.createMemberRequestToMember(request);
        memberRepository.save(member);

        return memberMapper.memberToCreateMemberRequest(member);

    }

    public GetByIdMemberResponse getById(Integer id){
        Member member = memberBusinessRules.memberShouldExistWithGivenId(id);
        return memberMapper.memberToGetByIdResponse(member);
    }

    public MemberResponse getByMemberStatusAndEmail(MemberStatus memberStatus, String email){
        Member member = memberRepository.findByMemberStatusAndEmail(memberStatus, email);
        return memberMapper.memberToMemberResponse(member);
    }

    public MemberResponse updateStatus(Integer id,MemberStatus memberStatus){

        Member member = memberBusinessRules.memberShouldExistWithGivenId(id);
        member.setMemberStatus(memberStatus);
        memberRepository.save(member);

        return memberMapper.memberToMemberResponse(member);
    }

    public DeletedMemberResponse delete(int id){
        Member member = memberBusinessRules.memberShouldExistWithGivenId(id);
        memberRepository.delete(member);
        return memberMapper.toDeletedMemberResponse(member);
    }

    // GET /api/members/{id}/fines?isPaid=false
    //cezası odenmemiş kullanıcıları getir

}
