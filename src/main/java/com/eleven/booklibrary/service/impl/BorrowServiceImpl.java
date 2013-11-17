package com.eleven.booklibrary.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleven.booklibrary.dao.BookMapper;
import com.eleven.booklibrary.dao.BooktypeMapper;
import com.eleven.booklibrary.dao.BorrowMapper;
import com.eleven.booklibrary.dao.BorrowerMapper;
import com.eleven.booklibrary.dao.BorrowertypeMapper;
import com.eleven.booklibrary.exception.BookException;
import com.eleven.booklibrary.model.Book;
import com.eleven.booklibrary.model.Booktype;
import com.eleven.booklibrary.model.Borrow;
import com.eleven.booklibrary.model.BorrowExample;
import com.eleven.booklibrary.model.BorrowKey;
import com.eleven.booklibrary.model.Borrower;
import com.eleven.booklibrary.model.Borrowertype;
import com.eleven.booklibrary.model.vo.BorrowVo;
import com.eleven.booklibrary.model.vo.Pagination;
import com.eleven.booklibrary.service.BorrowService;

@Service
public class BorrowServiceImpl implements BorrowService{
  
  @Autowired
  private BorrowMapper mapper;
  
  @Autowired
  private BookMapper bookMapper;
  
  @Autowired 
  private BorrowerMapper borrowerMapper;
  
  @Autowired
  private BorrowertypeMapper borrowertypeMapper;
  
  @Autowired
  private BooktypeMapper booktypeMapper;

  public void borrowBook(BorrowVo borrow) throws BookException {
    // 判断书能不能借
    Book book = bookMapper.selectByPrimaryKey(borrow.getBookNumber());
    if (book.getNumber() == book.getBorrowedNumber())
      throw new BookException("不能借已经借完的图书");
    // 判断借阅者已经借的数数目
    Borrower borrower = borrowerMapper.selectByPrimaryKey(borrow.getBorrowerNumber());
    Borrowertype borrowertype = borrowertypeMapper.selectByPrimaryKey(borrower.getType());
    if (borrower.getBorrowed() == borrowertype.getBorrowNumber())
      throw new BookException("用户借阅数已经到达上限");
   
    
    // 添加借书记录
    borrower.setBorrowed(borrower.getBorrowed()+1);
    borrowerMapper.updateByPrimaryKey(borrower);
    book.setBorrowedNumber(book.getBorrowedNumber()+1);
    bookMapper.updateByPrimaryKey(book);
    mapper.insert(borrow);
    
  }

  public Borrow returnBook(BorrowKey key) {
    Borrow borrow = mapper.selectByPrimaryKey(key);
    if (borrow == null) {
      return null;
    }
    Book book = bookMapper.selectByPrimaryKey(key.getBookNumber());
    Borrower borrower = borrowerMapper.selectByPrimaryKey(key.getBorrowerNumber());
    book.setBorrowedNumber(book.getBorrowedNumber()-1);
    borrower.setBorrowed(borrower.getBorrowed()-1);
    bookMapper.updateByPrimaryKey(book);
    borrowerMapper.updateByPrimaryKey(borrower);
    
    // 添加归还时间
    
    Date returnDate = Calendar.getInstance().getTime();
    borrow.setReturnDate(returnDate);
    Booktype booktype = booktypeMapper.selectByPrimaryKey(book.getBookType());
    int canBorrowDay = booktype.getBorrowDay();     // 可以借的天数
    Date borrowDate = borrow.getBorrowedDate();
    // 计算借出和归还相隔天数
    long day = (returnDate.getTime() - borrowDate.getTime()) / 1000 / 3600 / 24;
    // 判断是否需要罚款
    if (day > canBorrowDay)
      borrow.setFine(booktype.getDayFine() *(day-canBorrowDay));
    else 
      borrow.setFine(0L);
    mapper.updateByPrimaryKey(borrow);
    return borrow;
  }

  public void deletBorrowRecord(BorrowKey key) {
    mapper.deleteByPrimaryKey(key);
    
  }

  public List<Borrow> selectBorrowRecord(Pagination pagination) {
    long offset = (pagination.getCurPage()-1) * pagination.getPageSize();
    long length = pagination.getPageSize();
    return mapper.selectByPage(offset, length);
  }

  public List<Borrow> selectBorrowRecordByKey(BorrowKey key, Pagination pagination) {
    List<Borrow> result = new ArrayList<Borrow>();
    if (key.getBookNumber() != null && key.getBorrowerNumber() != null) {
      Borrow record = mapper.selectByPrimaryKey(key);
      result.add(record);
    } else if(key.getBookNumber() != null){
      result = selectBorrowByBookNumber(key.getBookNumber(), pagination);
    } else if(key.getBorrowerNumber() != null) {
      result = selectBorrowByCardNumber(key.getBorrowerNumber(), pagination);
    } else {
      result = selectBorrowRecord(pagination);
    }
    return result;
  }

  public List<Borrow> selectBorrowByCardNumber(Long cardNumber, Pagination pagination) {
    BorrowExample example = new BorrowExample();
    example.or().andBorrowerNumberEqualTo(cardNumber);
    example.setOffset((pagination.getCurPage()-1) * pagination.getPageSize());
    example.setLength(pagination.getPageSize());
    return mapper.selectByExample(example);
  }

  public List<Borrow> selectBorrowByBookNumber(Long bookNumber, Pagination pagination) {
    BorrowExample example = new BorrowExample();
    example.or().andBookNumberEqualTo(bookNumber);
    example.setOffset((pagination.getCurPage()-1) * pagination.getPageSize());
    example.setLength(pagination.getPageSize());

    return mapper.selectByExample(example);
  }

  public Pagination countByKey(BorrowKey key, Pagination pagination) {
    BorrowExample example = new BorrowExample();
    if (key.getBookNumber() != null)
      example.or().andBookNumberEqualTo(key.getBookNumber());
    if (key.getBorrowerNumber() != null)
      example.or().andBorrowerNumberEqualTo(key.getBorrowerNumber());
    int nums =  mapper.countByExample(example);
    Pagination page = new Pagination();
    page.setCurPage(pagination.getCurPage());
    page.setPageSize(pagination.getPageSize());
    page.setItems(nums);
    if (nums % page.getPageSize() == 0) {
      page.setPageNumber(nums / page.getPageSize());
    } else {
      page.setPageNumber(nums / page.getPageSize()+1);
    }
    return page;
  }
  

}
