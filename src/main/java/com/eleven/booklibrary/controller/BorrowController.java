package com.eleven.booklibrary.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eleven.booklibrary.exception.BookException;
import com.eleven.booklibrary.model.Book;
import com.eleven.booklibrary.model.Booktype;
import com.eleven.booklibrary.model.Borrow;
import com.eleven.booklibrary.model.BorrowKey;
import com.eleven.booklibrary.model.Borrower;
import com.eleven.booklibrary.model.Borrowertype;
import com.eleven.booklibrary.model.vo.BorrowVo;
import com.eleven.booklibrary.model.vo.Pagination;
import com.eleven.booklibrary.service.BookService;
import com.eleven.booklibrary.service.BooktypeService;
import com.eleven.booklibrary.service.BorrowService;
import com.eleven.booklibrary.service.BorrowerService;
import com.eleven.booklibrary.service.BorrowertypeService;

@Controller
@RequestMapping(value="/borrow")
public class BorrowController {
  
  @Autowired
  private BorrowService borrowService;
  
  @Autowired
  private BorrowerService borrowerService;
  
  @Autowired
  private BookService bookService;
  
  @Autowired
  private BorrowertypeService borrowertypeService;
  
  @Autowired
  private BooktypeService booktypeService;
  
  @RequestMapping(value="/borrow.do", method = RequestMethod.GET)
  public String borrow(){
    return "borrow/borrow";
  }
  
  /**
   * 获取借阅者信息
   * @param borrowerNumber
   * @return
   */
  @RequestMapping(value = "/getBorrowerInfo", method=RequestMethod.POST)
  @ResponseBody
  public Object getBorrowerInfo(long borrowerNumber) {
    Borrower borrower = borrowerService.selectBorrowerByCardNumber(borrowerNumber);    
    Map<String, Object> result = new HashMap<String, Object>();
    if (borrower != null) {
      Borrowertype borrowerType = borrowertypeService.selectBorrowertype(borrower.getType());
      result.put("name", borrower.getName());
      result.put("type", borrower.getType());
      result.put("canBorrowNumber", borrowerType.getBorrowNumber());
      result.put("borrowedNumber", borrower.getBorrowed());
      result.put("status", "200");
    } else {
      result.put("status", "300");
      result.put("msg", "没有该借阅者");
    }
    return result;
  }
  
  @RequestMapping(value="/getBookInfo", method=RequestMethod.POST)
  @ResponseBody
  public Object getBookInfo(long bookNumber) {
    Book book = bookService.selectBookByBookNumber(bookNumber);
    Map<String, Object> result = new HashMap<String, Object>();
    if (book != null) {
      Booktype bookType = booktypeService.selectBooktypeByName(book.getBookType());
      result.put("name", book.getBookName());
      result.put("author", book.getAuthor());
      result.put("type", book.getBookType());
      result.put("day", bookType.getBorrowDay());
      result.put("number",book.getNumber());
      result.put("canBorrow", book.getNumber() - book.getBorrowedNumber());
      result.put("status", "200");
    } else {
      result.put("status", "300");
      result.put("msg", "没有该本书");
    }
    return result;
  }
  
  @RequestMapping(value="/borrowBook")
  public String borrowBook(Long borrowerNumber, Long bookNumber, ModelMap modelMap) {
    Book book = bookService.selectBookByBookNumber(bookNumber);
    Borrower borrower = borrowerService.selectBorrowerByCardNumber(borrowerNumber);
    BorrowVo vo = new BorrowVo();
    vo.setBookNumber(bookNumber);
    vo.setBorrowerNumber(borrowerNumber);
    vo.setBookName(book.getBookName());
    vo.setBorrowerName(borrower.getName());
    vo.setBorrowedDate(Calendar.getInstance().getTime());
    try {
      borrowService.borrowBook(vo);
      modelMap.addAttribute("borrow_result", true);
      modelMap.addAttribute("success", "借书成功");
    } catch (BookException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return "borrow/borrow";
  }
 
  
  @RequestMapping(value="/searchBorrow")
  public String searchBorrow(String borrowerNumber, String bookNumber, String page ,ModelMap map) {
    Long cardNum = null;
    Long bookNum = null;
    Pagination pagination = new Pagination();
    if (!StringUtils.isEmpty(borrowerNumber))
      cardNum = Long.parseLong(borrowerNumber);
    else if (!StringUtils.isEmpty(bookNumber))
      bookNum = Long.parseLong(bookNumber);
    if (StringUtils.isEmpty(page)) {
      pagination.setCurPage(1);
    } else {
      pagination.setCurPage(Long.parseLong(page));
    }
    pagination.setPageSize(8);
    
    BorrowKey key = new BorrowKey();
    key.setBookNumber(bookNum);
    key.setBorrowerNumber(cardNum);
    List<Borrow> records = borrowService.selectBorrowRecordByKey(key, pagination);
    pagination = borrowService.countByKey(key, pagination);
    
    if (records != null) {
      map.addAttribute("records", records);
    } else {
      map.addAttribute("error", "没有找到相关记录");
    }
    map.addAttribute("borrowResult", true);
    map.addAttribute("pagination", pagination);
    map.addAttribute("borrowerNumber", borrowerNumber);
    map.addAttribute("bookNumber", bookNumber);
    return "borrow/borrow";
    
  }
  
  @RequestMapping(value="/returnBook", method=RequestMethod.POST)
  @ResponseBody
  public Object returnBook(BorrowKey key) {
    Borrow borrow = borrowService.returnBook(key);
    Map<String, Object> result = new HashMap<String, Object>();
    if (borrow != null) {
      result.put("status", "200");
      result.put("borrow", borrow);
    } else {
      result.put("status", "300");
      result.put("msg", "该记录不存在");
    }
    return result;
  }
  
  @RequestMapping(value="/deleteBook", method=RequestMethod.POST)
  @ResponseBody
  public Object deleteBook(BorrowKey key) {
    borrowService.deletBorrowRecord(key);
    Map<String, Object> result = new HashMap<String, Object>();
    result.put("status", "200");
    return result;
  }
}
