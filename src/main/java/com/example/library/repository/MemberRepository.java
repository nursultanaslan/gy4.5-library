package com.example.library.repository;

import com.example.library.entity.Member;
import com.example.library.entity.enums.MemberStatus;
import com.example.library.entity.enums.MembershipLevel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findByMemberStatusAndEmail(MemberStatus memberStatus, String email);

    Member findByIdAndMemberStatus(Integer id, MemberStatus memberStatus);

    Member findByMembershipLevel(MembershipLevel level);
}
