package com.example.learning.repository;

import com.example.learning.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookModel,Long> {

    Optional<BookModel> findByName(String name);

    Optional<BookModel> findByAuthor(String author);

    Optional<Void> deleteBookByName(String name);
}
