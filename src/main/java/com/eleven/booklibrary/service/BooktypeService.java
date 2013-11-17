package com.eleven.booklibrary.service;

import java.util.List;

import com.eleven.booklibrary.model.Booktype;
import com.eleven.booklibrary.model.vo.BooktypeVo;
import com.eleven.booklibrary.model.vo.Pagination;

public interface BooktypeService {
  void insertBooktype(BooktypeVo vo);
  
  void updateBooktype(BooktypeVo newBooktypeVo, BooktypeVo oldBooktypeVo);
  
  Booktype selectBooktypeByName(String name);
  
  List<Booktype> selectBooktype(Pagination pagination);
  
  List<Booktype> selectBooktype();
    
  void deleteBooktype(String name);
}
