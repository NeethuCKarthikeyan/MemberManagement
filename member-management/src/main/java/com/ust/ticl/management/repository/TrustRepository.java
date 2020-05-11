package com.ust.ticl.management.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.ticl.management.model.Member;
import com.ust.ticl.management.model.Trust;


@Repository
@Transactional
public interface TrustRepository extends JpaRepository<Trust,Integer> {
	
}
