package com.eleven.booklibrary.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eleven.booklibrary.model.Book;
import com.eleven.booklibrary.model.Booktype;
import com.eleven.booklibrary.service.BookService;
import com.eleven.booklibrary.service.BooktypeService;

@Controller
public class IndexController {
  @Autowired
  private BookService bookService;
  
  @Autowired 
  private BooktypeService bookTypeService;
  
  @RequestMapping("/index.do")
  public String index(HttpServletRequest request, ModelMap map) {
    request.getSession().setAttribute("title", "首页");
    List<Book> book = bookService.selectNewBooks(8);
    List<Booktype> bookTypes = bookTypeService.selectBooktype();
    map.addAttribute("bookTypes", bookTypes);
    map.addAttribute("books", book);
    return "index";
  }
}
