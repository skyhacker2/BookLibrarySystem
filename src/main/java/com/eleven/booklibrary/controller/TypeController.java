package com.eleven.booklibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eleven.booklibrary.model.Booktype;
import com.eleven.booklibrary.model.Borrowertype;
import com.eleven.booklibrary.model.vo.BooktypeVo;
import com.eleven.booklibrary.model.vo.BorrowertypeVo;
import com.eleven.booklibrary.service.BooktypeService;
import com.eleven.booklibrary.service.BorrowertypeService;

@Controller
@RequestMapping(value="/type")
public class TypeController {
  
  @Autowired
  private BorrowertypeService borrowerTypeService;
  
  @Autowired
  private BooktypeService bookTypeService;
  
  @RequestMapping(value="/borrowerType")
  public String borrowerType(ModelMap map) {
    List<Borrowertype> list = borrowerTypeService.selectBorrowertype();
    map.put("typeList", list);
    return "type/borrower_type";
  }

  @RequestMapping(value="addBorrowerType", method=RequestMethod.POST)
  public String addBorrowerType(BorrowertypeVo vo, ModelMap map) {
    borrowerTypeService.insertBorrowertype(vo);
    List<Borrowertype> list = borrowerTypeService.selectBorrowertype();
    map.put("typeList", list);
    return "type/borrower_type";
  }
  
  @RequestMapping(value="deleteBorrowerType", method=RequestMethod.GET)
  public String deleteBorrowerType(String type, ModelMap map) {
    borrowerTypeService.deleteBorrowertype(type);
    List<Borrowertype> list = borrowerTypeService.selectBorrowertype();
    map.put("typeList", list);
    return "type/borrower_type";
  }
  
  @RequestMapping(value="bookType")
  public String bookType(ModelMap map){
    List<Booktype> list = bookTypeService.selectBooktype();
    map.put("typeList", list);
    return "type/book_type";
  }
  
  @RequestMapping(value="addBookType", method=RequestMethod.POST)
  public String addBookType(BooktypeVo vo, ModelMap map) {
    bookTypeService.insertBooktype(vo);
    List<Booktype> list = bookTypeService.selectBooktype();
    map.put("typeList", list);
    return "type/book_type";
  }
  
  @RequestMapping(value="deleteBookType", method=RequestMethod.POST)
  @ResponseBody
  public String deleteBookType(String type, ModelMap map) {
    bookTypeService.deleteBooktype(type);
    return "200";
  }
}
