package com.example.learning.service;

import com.example.learning.model.BookModel;
import com.example.learning.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImp implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public BookModel createBook(BookModel bookModel) {
        return bookRepository.save(bookModel);
    }

    @Override
    public BookModel getById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public BookModel getBookByName(String name) {
        return bookRepository.findByName(name).orElse(null);
    }

    @Override
    public BookModel getBookByAuthor(String author) {
        return bookRepository.findByAuthor(author).orElse(null);
    }

    @Override
    public void deleteBook(long id) {
            bookRepository.deleteById(id);
    }

    @Override
    public void deleteBookByName(String name) {
            bookRepository.deleteByName(name);
    }
}
