package com.neuron.library_api.repository;

import com.neuron.library_api.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, String> {

    @Modifying
    @Query(value = "INSERT INTO t_borrower VALUES(" +
            "?1, NULL, ?4, ?5, ?2, ?3 )", nativeQuery = true)
    Integer create(String id, String memberId, String bookId, Date loanDate, String status);

    @Query(value = "SELECT * FROM t_borrower", nativeQuery = true)
    List<Borrower> getALl();

    @Query(value = "SELECT * FROM t_borrower", nativeQuery = true)
    Borrower getOneById(String id);


    @Modifying
    @Query(value = "UPDATE t_borrower " +
            "SET date_of_return = ?2, " +
            "status = ?3 " +
            "WHERE id = ?1", nativeQuery = true)
    Integer updateBorrowerStatus(String id, Date dateOfReturn, String status);
}
