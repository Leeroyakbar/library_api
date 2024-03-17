package com.neuron.library_api.repository;

import com.neuron.library_api.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    @Modifying
    @Query(value = "INSERT INTO m_member VALUES(" +
            "?1, ?3, ?4, ?2)", nativeQuery = true)
    Integer save(String id, String name, String address, String mobilePhone);


    @Query(value = "SELECT * FROM m_member WHERE id = ?", nativeQuery = true)
    Member getOneById(String id);

    @Query(value = "SELECT * FROM m_member mm " +
            "WHERE (?1 IS NULL OR LOWER(mm.name) LIKE LOWER(CONCAT('%', ?1, '%')))" +
            "AND (?2 IS NULL OR LOWER(mm.address) LIKE LOWER(CONCAT('%', ?2, '%')))", nativeQuery = true)
    List<Member> getAllByFilter(String name, String address);


    @Modifying
    @Query(value = "UPDATE m_member " +
            "SET address = ?3," +
            "mobile_phone = ?4," +
            "name = ?2 " +
            "WHERE id = ?1", nativeQuery = true)
    Integer updateMember(String id, String name, String address, String mobilePhone);

    @Modifying
    @Query(value = "DELETE FROM m_member WHERE id = ?", nativeQuery = true)
    Integer deleteMemberById(String id);
}
