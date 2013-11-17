package com.eleven.booklibrary.service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eleven.booklibrary.model.Borrowertype;
import com.eleven.booklibrary.model.vo.BorrowertypeVo;
import com.eleven.booklibrary.model.vo.Pagination;
import com.eleven.booklibrary.service.BorrowertypeService;
import com.eleven.booklibrary.util.ModelPrinter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml"})
public class TestBorrowertypeService {

  @Autowired
  private BorrowertypeService service;
  
  @Test
  public void testInsertBorrowertype() {
    BorrowertypeVo vo = new BorrowertypeVo();
    vo.setBorrowNumber(10);
    vo.setType("超级会员");
    service.insertBorrowertype(vo);
  }
  
  @Test
  public void testSelectBorrowertype() {
    Pagination pagination = new Pagination();
    pagination.setCurPage(1L);
    pagination.setPageSize(10);
    
    List<Borrowertype> list = service.selectBorrowertype(pagination);
    
    for (Borrowertype b : list)
      ModelPrinter.print(b);
    
    Borrowertype type = service.selectBorrowertype("普通会员");
    ModelPrinter.print(type);
  }
  
  @Test
  public void testDeleteBorrowertype() {
    service.deleteBorrowertype("普通会员");
  }
  
}
