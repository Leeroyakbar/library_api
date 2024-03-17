package com.neuron.library_api.repository;

import com.neuron.library_api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    @Query(value = "SELECT * FROM m_book mb " +
            "WHERE (?1 IS NULL OR LOWER(mb.title) LIKE LOWER(CONCAT('%', ?1, '%'))) " +
            "AND (?2 IS NULL OR LOWER(mb.author) LIKE LOWER(CONCAT('%', ?2, '%'))) " +
            "AND (?3 IS NULL OR mb.year_published = ?3)", nativeQuery = true)
    List<Book> getAllByFilter(String title, String author, String yearPublished);

    @Query(value = "SELECT * FROM m_book WHERE id = ?", nativeQuery = true)
    Book getOneById(String id);

    @Modifying
    @Query(value = "UPDATE m_book " +
            "SET title = ?2, " +
            "author = ?3, " +
            "year_published = ?4 " +
            "WHERE id = ?1", nativeQuery = true)
    Integer updateBook(String id, String title, String author, String yearPublished);

    @Modifying
    @Query(value = "DELETE FROM m_book WHERE id=?1", nativeQuery = true)
    Integer deleteBookById(String id);
}
