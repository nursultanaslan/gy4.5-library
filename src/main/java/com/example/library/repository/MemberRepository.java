package com.example.library.repository;

import com.example.library.entity.Fine;
import com.example.library.entity.Member;
import com.example.library.entity.enums.MemberStatus;
import com.example.library.entity.enums.MembershipLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findByMemberStatusAndEmail(MemberStatus memberStatus, String email);

    Member findByMembershipLevel(MembershipLevel level);

    Member findByEmail(String email);



}
