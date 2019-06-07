package com.example.learning.controller;

import com.example.learning.model.BookModel;
import com.example.learning.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

//for web
@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    //constructor dependency injection
    @Autowired
    public BookController(BookService bookService){
           this.bookService=bookService;
    }

    @RequestMapping(value={"/",""},method= RequestMethod.GET)
    public ModelAndView getAllBooks(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("books");
        modelAndView.addObject("books",bookService.getAllBooks());
        return modelAndView;
    }

    @RequestMapping(value="/create",method = RequestMethod.GET)
    public ModelAndView createBookGet(String msg){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("book_form");
        modelAndView.addObject("book",new BookModel());
        modelAndView.addObject("msg",msg);
        return modelAndView;
    }

    @RequestMapping(value="/create",method = RequestMethod.POST)
    public ModelAndView createBookPost(@Valid BookModel bookModel, BindingResult bindingResult){
          ModelAndView modelAndView =new ModelAndView();
          if(bindingResult.hasErrors()){
              modelAndView.setViewName("book_form");
              modelAndView.addObject("msg","Failed to create book");
              modelAndView.addObject("book",bookModel);
          }else{
              bookService.createBook(bookModel);
              modelAndView = createBookGet("Book Created");
          }
          return modelAndView;
    }
}
