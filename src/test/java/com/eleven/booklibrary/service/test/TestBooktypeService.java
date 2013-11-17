package com.eleven.booklibrary.service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eleven.booklibrary.model.Booktype;
import com.eleven.booklibrary.model.vo.BooktypeVo;
import com.eleven.booklibrary.service.BooktypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml"})
public class TestBooktypeService {
  @Autowired
  private BooktypeService booktypeService;
  
  @Test
  public void testInsertBooktype() {
    BooktypeVo vo = new BooktypeVo();
    vo.setType("经管");
    vo.setBorrowDay(30);
    vo.setDayFine(1L);
    booktypeService.insertBooktype(vo);
  }
  
  @Test
  public void testSelectBooktype() {
    List<Booktype> booktypes = booktypeService.selectBooktype();
    for (Booktype b : booktypes)
      System.out.println(b.getType());
  }
  
  @Test
  public void testUpdateBooktype() {
    BooktypeVo vo = new BooktypeVo();
    vo.setType("经管");
    vo.setBorrowDay(30);
    vo.setDayFine(1L);
    
    BooktypeVo newVo = new BooktypeVo();
    newVo.setType("人文");
    newVo.setBorrowDay(10);
    newVo.setDayFine(2L);
    
    booktypeService.updateBooktype(newVo, vo);
  }
  
  
  @Test
  public void testDeleteBooktype() {
    booktypeService.deleteBooktype("人文");
  }
}
