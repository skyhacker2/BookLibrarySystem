package com.eleven.booklibrary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleven.booklibrary.dao.BorrowertypeMapper;
import com.eleven.booklibrary.model.Borrowertype;
import com.eleven.booklibrary.model.vo.BorrowerVo;
import com.eleven.booklibrary.model.vo.BorrowertypeVo;
import com.eleven.booklibrary.model.vo.Pagination;
import com.eleven.booklibrary.service.BorrowertypeService;

@Service
public class BorrowertypeServiceImpl implements BorrowertypeService{
  
  @Autowired
  private BorrowertypeMapper mapper;

  public void insertBorrowertype(BorrowertypeVo vo) {
    mapper.insert(vo);
  }

  public void updateBorrowertype(BorrowertypeVo vo) {
    mapper.updateByPrimaryKey(vo);
  }

  public Borrowertype selectBorrowertype(String name) {
    return mapper.selectByPrimaryKey(name);
  }

  public List<Borrowertype> selectBorrowertype(Pagination pagination) {
    long offset = (pagination.getCurPage()-1) * pagination.getPageSize();
    long length = pagination.getPageSize();
    
    return mapper.selectByPage(offset, length);
  }


  public void deleteBorrowertype(String type) {
    mapper.deleteByPrimaryKey(type);
    
  }

  public List<Borrowertype> selectBorrowertype() {
    return mapper.selectByExample(null);
  }

}
