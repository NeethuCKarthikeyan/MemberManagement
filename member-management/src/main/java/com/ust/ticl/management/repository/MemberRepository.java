package com.ust.ticl.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.ticl.management.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

}
