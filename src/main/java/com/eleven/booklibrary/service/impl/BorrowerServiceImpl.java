package com.eleven.booklibrary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleven.booklibrary.dao.BorrowerMapper;
import com.eleven.booklibrary.model.Borrower;
import com.eleven.booklibrary.model.BorrowerExample;
import com.eleven.booklibrary.model.vo.BorrowerVo;
import com.eleven.booklibrary.model.vo.Pagination;
import com.eleven.booklibrary.service.BorrowerService;

@Service
public class BorrowerServiceImpl implements BorrowerService {

  @Autowired
  private BorrowerMapper borrowerMapper;
  
  public void insertBorrower(BorrowerVo vo) {
    borrowerMapper.insert(vo);

  }

  public void updateBorrower(BorrowerVo vo) {
    borrowerMapper.updateByPrimaryKey(vo);

  }

  public void deleteBorrower(Long cardNumber) {
    borrowerMapper.deleteByPrimaryKey(cardNumber);

  }

  public Borrower selectBorrowerByCardNumber(Long cardNumber, String type) {
    BorrowerExample example = new BorrowerExample();
    example.or().andCardNumberEqualTo(cardNumber).andTypeEqualTo(type);
    List<Borrower> borrowers = borrowerMapper.selectByExample(example);
    if (borrowers.size() > 0)
      return borrowers.get(0);
    else
      return null;
  }

  public List<Borrower> selectBorrowerByName(String name, Pagination pagination) {
    long offset = (pagination.getCurPage()-1) * pagination.getPageSize();
    long length = pagination.getPageSize();
    
    return borrowerMapper.selectByName(name, offset, length);
  }

  public List<Borrower> selectBorrowers(Pagination pagination) {
    return borrowerMapper.selectByExample(null);
  }

  public Long getNewCardNumber() {    
    Long lastCardNumber =  borrowerMapper.getLastCardNumber();
    if (lastCardNumber == null)
      return 1L;
    else
      return lastCardNumber+1;
  }

  public Borrower selectBorrowerByCardNumber(long borrowerNumber) {
    return borrowerMapper.selectByPrimaryKey(borrowerNumber);
  }

}
