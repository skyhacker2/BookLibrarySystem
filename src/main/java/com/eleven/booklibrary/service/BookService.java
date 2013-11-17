package com.eleven.booklibrary.service;

import java.util.List;

import com.eleven.booklibrary.model.Book;
import com.eleven.booklibrary.model.vo.BookVo;
import com.eleven.booklibrary.model.vo.Pagination;

public interface BookService {
  
  public void insertBook(BookVo vo);
  
  public List<Book> selectBookByName(String name, String type, Pagination pagination);
  
  public void updateBook(BookVo vo, Long bookNum);
  
  public void deleteBookByBookNumber(long num);
  
  public Book selectBookByBookNumber(long num);
  
  public int countByName(String bookName);
  
  public Pagination count(String name, String type, Pagination pagination);
  
  /**
   * 根据书号和类别查找图书
   * @param num
   * @param type
   * @return
   */
  public Book selectBook(long num, String type);
  
  public List<Book> selectNewBooks(int num);
}
