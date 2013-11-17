package com.eleven.booklibrary.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eleven.booklibrary.model.Borrower;
import com.eleven.booklibrary.model.Borrowertype;
import com.eleven.booklibrary.model.vo.BorrowerVo;
import com.eleven.booklibrary.service.BorrowerService;
import com.eleven.booklibrary.service.BorrowertypeService;
import com.eleven.booklibrary.util.BookUtil;
import com.eleven.booklibrary.util.ModelPrinter;

@Controller
@RequestMapping(value="/borrower")
public class BorrowerController {
  
  @Autowired
  private BorrowerService borrowerService;
  
  @Autowired
  private BorrowertypeService borrowertypeService;
  
  @RequestMapping(value="/searchBorrower", method = RequestMethod.POST)
  @ResponseBody
  public Object searchBorrower(String cardNumber, String borrowerType) {
    Borrower borrower = borrowerService.selectBorrowerByCardNumber(Long.parseLong(cardNumber), borrowerType);
    Map<String,Object> map = new HashMap<String, Object>();
    if (borrower == null)
      map.put("status", "300");
    else {
      map.put("status", "200");
      map.put("borrower", borrower);
    }
    return map;
  }
  
  @RequestMapping(value="/getBorrowerType", method = RequestMethod.POST)
  @ResponseBody
  public Object getBorrowerType() {
    List<Borrowertype> list = borrowertypeService.selectBorrowertype();
    return list;
  }
  
  @RequestMapping(value = "/getNewCardNumber", method = RequestMethod.POST)
  @ResponseBody
  public Object getNewCardNumber() {
    Long newCardNumber = borrowerService.getNewCardNumber();
    return newCardNumber;
  }
  
  @RequestMapping(value="/addBorrower", method = RequestMethod.POST)
  @ResponseBody
  public Object addBorrower(BorrowerVo vo) {
    ModelPrinter.print(vo);
    vo.setCardNumber(borrowerService.getNewCardNumber());
    vo.setCreateTime(Calendar.getInstance().getTime());
    vo.setBorrowed(0);
    vo.setIsLost(0);
    borrowerService.insertBorrower(vo);
    Map<String, Object> result = new HashMap<String, Object>();
    result.put("status", 200);
    result.put("cardNumber", vo.getCardNumber());
    result.put("type", vo.getType());
    return result;
  }
  
  @RequestMapping(value="/updateBorrower", method=RequestMethod.POST)
  @ResponseBody
  public Object updateBorrower(BorrowerVo vo) {
    ModelPrinter.print(vo);
    borrowerService.updateBorrower(vo);
    Map<String,Object> result = new HashMap<String, Object>();
    result.put("status", 200);
    result.put("cardNumber", vo.getCardNumber());
    result.put("type", vo.getType());
    
    return result;
  }
  
  @RequestMapping(value="/deleteBorrower", method=RequestMethod.POST)
  @ResponseBody
  public Object deleteBorrower(long cardNumber) {
    borrowerService.deleteBorrower(cardNumber);
    Map<String,Object> result = new HashMap<String, Object>();
    result.put("status", 200);
    return result;
  }
  

}
