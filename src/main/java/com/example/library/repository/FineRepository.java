package com.example.library.repository;

import com.example.library.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FineRepository extends JpaRepository<Fine, Integer> {

//    boolean existsByMemberIdAndIsPaidIsFalse(int memberId);

}
