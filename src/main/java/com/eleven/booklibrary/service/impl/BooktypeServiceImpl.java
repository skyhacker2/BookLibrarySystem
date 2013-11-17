package com.eleven.booklibrary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleven.booklibrary.dao.BooktypeMapper;
import com.eleven.booklibrary.model.Booktype;
import com.eleven.booklibrary.model.BooktypeExample;
import com.eleven.booklibrary.model.vo.BooktypeVo;
import com.eleven.booklibrary.model.vo.Pagination;
import com.eleven.booklibrary.service.BooktypeService;

@Service
public class BooktypeServiceImpl implements BooktypeService{

  @Autowired
  private BooktypeMapper booktypeMapper;
  
  public void insertBooktype(BooktypeVo vo) {
    booktypeMapper.insert(vo);
    
  }

  public void updateBooktype(BooktypeVo newBooktypeVo, BooktypeVo oldBooktypeVo) {
    BooktypeExample example = new BooktypeExample();
    example.or().andTypeEqualTo(oldBooktypeVo.getType());
    booktypeMapper.updateByExample(newBooktypeVo, example);
    
  }

  public Booktype selectBooktypeByName(String name) {
    return booktypeMapper.selectByPrimaryKey(name);
  }

  public List<Booktype> selectBooktype(Pagination pagination) {
    long offset = (pagination.getCurPage()-1) * pagination.getPageSize();
    long length = pagination.getPageSize();
    return booktypeMapper.selectByPage(offset, length);
  }

  public List<Booktype> selectBooktype() {
    return booktypeMapper.selectByExample(null);
  }

  public void deleteBooktype(String name) {
    booktypeMapper.deleteByPrimaryKey(name);
  }

}
