package com.eleven.booklibrary.service;

import java.util.List;

import com.alibaba.druid.sql.dialect.postgresql.ast.stmt.PGInsertStatement;
import com.eleven.booklibrary.exception.BookException;
import com.eleven.booklibrary.model.Borrow;
import com.eleven.booklibrary.model.BorrowKey;
import com.eleven.booklibrary.model.vo.BorrowVo;
import com.eleven.booklibrary.model.vo.Pagination;

public interface BorrowService {
  void borrowBook(BorrowVo borrow) throws BookException;
  
  Borrow returnBook(BorrowKey key);
  
  void deletBorrowRecord(BorrowKey key);
  
  List<Borrow> selectBorrowRecord(Pagination pagination);
  
  List<Borrow> selectBorrowByCardNumber(Long cardNumber, Pagination pagination);
  
  List<Borrow> selectBorrowByBookNumber(Long bookNumber, Pagination pagination);
  
  List<Borrow> selectBorrowRecordByKey(BorrowKey key, Pagination pagination);
  
  Pagination countByKey(BorrowKey key, Pagination pagination);
}
