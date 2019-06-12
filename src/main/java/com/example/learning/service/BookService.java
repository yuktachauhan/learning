package com.example.learning.service;

import java.util.List;
import com.example.learning.model.BookModel;

public interface BookService {
    List<BookModel> getAllBooks();

    BookModel createBook(BookModel bookModel);

    BookModel getById(long id);

    BookModel getBookByName(String name);

    BookModel getBookByAuthor(String author);

    void deleteBook(long id);

    void deleteBookByName(String name);

    //for updating the books using PUT request
    BookModel updateBook(BookModel bookModel,long id);
}
