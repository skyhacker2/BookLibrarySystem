package com.eleven.booklibrary.service;

import java.util.List;

import com.eleven.booklibrary.model.Borrower;
import com.eleven.booklibrary.model.vo.BorrowerVo;
import com.eleven.booklibrary.model.vo.Pagination;

public interface BorrowerService {
  /**
   * 添加借阅者
   */
  public void insertBorrower(BorrowerVo vo);
  
  /**
   * 更新借阅者
   * @param vo
   */
  public void updateBorrower(BorrowerVo vo);
  
  /**
   * 删除借阅者
   * @param vo
   */
  public void deleteBorrower(Long cardNumber);
  
  /**
   * 使用借阅卡号查找借阅者
   * @param cardNumber
   * @return
   */
  public Borrower selectBorrowerByCardNumber(Long cardNumber, String type);
  
  /**
   * 使用姓名查找借阅者
   * @param name
   * @param pagination
   * @return
   */
  public List<Borrower> selectBorrowerByName(String name, Pagination pagination);
  
  /**
   * 查找全部借阅者
   * @param pagination
   * @return
   */
  public List<Borrower> selectBorrowers(Pagination pagination);
  
  public Long getNewCardNumber();
  
  public Borrower selectBorrowerByCardNumber(long borrowerNumber);
    

}
