package com.eleven.booklibrary.service.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eleven.booklibrary.exception.BookException;
import com.eleven.booklibrary.model.Borrow;
import com.eleven.booklibrary.model.BorrowKey;
import com.eleven.booklibrary.model.vo.BorrowVo;
import com.eleven.booklibrary.model.vo.Pagination;
import com.eleven.booklibrary.service.BorrowService;
import com.eleven.booklibrary.util.ModelPrinter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml"})
public class TestBorrowService {

  @Autowired
  private BorrowService borrowService;
  
  @Test
  public void testBorrowBook() {
    BorrowVo vo = new BorrowVo();
    vo.setBookNumber(101L);
    vo.setBookName("设计模式");
    vo.setBorrowerName("谭苑霞");
    vo.setBorrowerNumber(101L);
    vo.setBorrowedDate(new Date(113, 8, 19));
    try {
      borrowService.borrowBook(vo);
    } catch (BookException e) {
      System.out.println(e.getMessage());
    }
  }
  
  @Test
  public void testSelectBorrow() {
    Pagination pagination = new Pagination();
    pagination.setCurPage(1L);
    pagination.setPageSize(2L);
    BorrowKey key = new BorrowKey();
    List<Borrow> list = borrowService.selectBorrowRecordByKey(key, pagination);
    for (Borrow b : list) {
      ModelPrinter.print(b);
    }
  }
  
  @Test
  public void testReturnBook() {
    BorrowKey key = new BorrowKey();
    key.setBookNumber(101L);
    key.setBorrowerNumber(101L);
    borrowService.returnBook(key);
  }
  
  @Test
  public void testDeleteBorrow() {
    BorrowKey key = new BorrowKey();
    key.setBookNumber(101L);
    key.setBorrowerNumber(101L);
    borrowService.deletBorrowRecord(key);
  }
}
