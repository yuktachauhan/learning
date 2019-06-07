package com.example.learning.controller;

import com.example.learning.model.BookModel;
import com.example.learning.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

//for creating api
@RestController
@RequestMapping(value="/api/books")
public class BookRestController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = {"/",""},method = RequestMethod.GET)
    public List<BookModel> getAllBooks(){
        return bookService.getAllBooks();
    }

    @RequestMapping(value = {"/",""}, method = RequestMethod.POST)
    public BookModel createBook(@Valid @RequestBody BookModel bookModel){
        System.out.println(bookModel.toString());
        return bookService.createBook(bookModel);
    }

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public BookModel getById(@PathVariable long id){
        return bookService.getById(id);
    }

    @RequestMapping(value="/name/{name}",method=RequestMethod.GET)
    public BookModel getBookByName(@PathVariable String name){
        return bookService.getBookByName(name);
    }

    @RequestMapping(value="/author/{author}",method=RequestMethod.GET)
    public BookModel getBookByAuthor(@PathVariable String author){
        return bookService.getBookByAuthor(author);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable long id){
         bookService.deleteBook(id);
    }

    @RequestMapping(value = "/delete/name/{name}",method = RequestMethod.DELETE)
    public void deleteBookByName(@PathVariable String name){
        bookService.deleteBookByName(name);
    }
}
