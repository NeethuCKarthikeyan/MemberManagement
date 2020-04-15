package com.ust.ticl.management.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.ticl.management.entity.Member;

@Repository
@Transactional
public interface MemberRepository extends JpaRepository<Member, Integer> {
	
    @Modifying
    @Query("UPDATE Member m SET m.is_active = :status,m.last_mod_date = :lastModDate WHERE m.id in(:idList)")
    int updateMemberAsActive(@Param("status")Boolean status,@Param("lastModDate")Timestamp lastModDate, @Param("idList")List<Integer> idList);


}
