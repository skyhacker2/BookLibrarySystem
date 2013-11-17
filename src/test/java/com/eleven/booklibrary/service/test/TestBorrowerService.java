package com.eleven.booklibrary.service.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eleven.booklibrary.model.Borrower;
import com.eleven.booklibrary.model.vo.BorrowerVo;
import com.eleven.booklibrary.model.vo.Pagination;
import com.eleven.booklibrary.service.BorrowerService;
import com.eleven.booklibrary.util.ModelPrinter;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml"})
public class TestBorrowerService {

  @Autowired
  private BorrowerService borrowerService;
  
  @Test
  public void testInsertBorrower() {
    BorrowerVo vo = new BorrowerVo();
    vo.setCardNumber(borrowerService.getNewCardNumber());
    vo.setName("陈洪晶");
    vo.setAddress("五邑大学");
    vo.setBorrowed(0);
    vo.setCreateTime(new Date(113, 9, 20));
    vo.setIdCardNumber("440782199109133911");
    vo.setIsLost(0);
    vo.setPhone("13750376797");
    vo.setSex("男");
    vo.setType("超级会员");
    vo.setWorkPlace("五邑大学");
    borrowerService.insertBorrower(vo);
  }
  
  @Test
  public void testSelectBorrower() {
    Borrower borrower = borrowerService.selectBorrowerByCardNumber(100L,"");
    ModelPrinter.print(borrower);
  }
  
  @Test
  public void testSelectBorrowers() {
    Pagination pagination = new Pagination();
    pagination.setCurPage(1L);
    pagination.setPageSize(20);
    List<Borrower> list = borrowerService.selectBorrowers(pagination);
    for (Borrower b : list){
      ModelPrinter.print(b, new String[]{"name"});
    }
  }
  
  @Test
  public void testUpdateBorrower() {
    BorrowerVo vo = new BorrowerVo();
    vo.setCardNumber(101L);
    vo.setName("谭苑霞");
    vo.setAddress("五邑大学");
    vo.setBorrowed(0);
    vo.setCreateTime(new Date(113, 9, 20));
    vo.setIdCardNumber("440782199109133911");
    vo.setIsLost(0);
    vo.setPhone("13750376797");
    vo.setSex("女");
    vo.setType("超级管理员");
    vo.setWorkPlace("五邑大学");
    borrowerService.updateBorrower(vo);
    Borrower borrower = borrowerService.selectBorrowerByCardNumber(101L,"");
    ModelPrinter.print(borrower);
  }
  
  @Test
  public void testDeleteBorrower() {
    BorrowerVo vo = new BorrowerVo();
    vo.setCardNumber(101L);
    vo.setName("谭苑霞");
    vo.setAddress("五邑大学");
    vo.setBorrowed(0);
    vo.setCreateTime(new Date(113, 9, 20));
    vo.setIdCardNumber("440782199109133911");
    vo.setIsLost(0);
    vo.setPhone("13750376797");
    vo.setSex("女");
    vo.setType("超级会员");
    vo.setWorkPlace("五邑大学");
    borrowerService.deleteBorrower(101L);
    testSelectBorrowers();
  }
  
  @Test
  public void testGetLastCardNumber() {
    long newCardNum = borrowerService.getNewCardNumber();
    System.out.println(newCardNum);
  }
}
