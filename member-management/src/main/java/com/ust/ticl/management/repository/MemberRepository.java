package com.ust.ticl.management.repository;

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
    @Query("UPDATE Member m SET m.isActive= :status,m.lastModifiedDate = CURRENT_TIMESTAMP WHERE m.id in(:idList)")
    int updateMemberAsActiveOrInactive(@Param("status")Boolean status, @Param("idList")List<Integer> idList);
    
    @Modifying
    @Query("UPDATE Member m SET m.isDeleted= :status,m.lastModifiedDate = CURRENT_TIMESTAMP WHERE m.id in(:idList)")
    int removeOrRestoreMember(@Param("status")Boolean status, @Param("idList")List<Integer> idList);
    
    @Modifying
    @Query(value="INSERT INTO Member(name,email_id,password,mob_num,created_date) VALUES(:name,:email,:password,:mob,CURRENT_TIMESTAMP)",nativeQuery = true)
    void insertMember(@Param("name")String name, @Param("email")String email, @Param("password")String password, @Param("mob")Integer mob);
    
    @Query("SELECT count(*) FROM Member m WHERE m.emailId = :email and m.password = :password")
    int findMember( @Param("email")String email, @Param("password")String password);
    
    @Modifying
    @Query("UPDATE Member m SET m.gender= :gender,m.address=:address,m.city=:city,m.state=:state,m.country=:country,m.pinNum=:pinNum,m.lastModifiedDate = CURRENT_TIMESTAMP WHERE m.id in(:id)")
    int updateMember(@Param("gender")String gender,@Param("address")String address,@Param("city")String city,@Param("state")String state,@Param("country")String country,@Param("pinNum")Integer pinNum, @Param("id")Integer id);
    
    @Query(value="SELECT * FROM Member m WHERE m.city = :city",nativeQuery = true)
    List<Member> findAllMembersInCity( @Param("city")String city);
    
   
    
    

    
    
    
    



}
