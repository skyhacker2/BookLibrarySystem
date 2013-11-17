package com.eleven.booklibrary.service;

import java.util.List;

import com.eleven.booklibrary.model.Borrowertype;
import com.eleven.booklibrary.model.vo.BorrowerVo;
import com.eleven.booklibrary.model.vo.BorrowertypeVo;
import com.eleven.booklibrary.model.vo.Pagination;

public interface BorrowertypeService {
  void insertBorrowertype(BorrowertypeVo vo);
  
  void updateBorrowertype(BorrowertypeVo vo);
  
  Borrowertype selectBorrowertype(String name);
  
  List<Borrowertype> selectBorrowertype(Pagination pagination);
  
  List<Borrowertype> selectBorrowertype();
  
  void deleteBorrowertype(String type);
}
