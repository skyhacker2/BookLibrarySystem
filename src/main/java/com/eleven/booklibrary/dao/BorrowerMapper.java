package com.eleven.booklibrary.dao;

import com.eleven.booklibrary.model.Borrower;
import com.eleven.booklibrary.model.BorrowerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowerMapper {
    int countByExample(BorrowerExample example);

    int deleteByExample(BorrowerExample example);

    int deleteByPrimaryKey(Long cardNumber);

    int insert(Borrower record);

    int insertSelective(Borrower record);

    List<Borrower> selectByExample(BorrowerExample example);

    Borrower selectByPrimaryKey(Long cardNumber);

    int updateByExampleSelective(@Param("record") Borrower record, @Param("example") BorrowerExample example);

    int updateByExample(@Param("record") Borrower record, @Param("example") BorrowerExample example);

    int updateByPrimaryKeySelective(Borrower record);

    int updateByPrimaryKey(Borrower record);
    
    List<Borrower> selectByName(@Param("name")String name, @Param("offset")Long offset, @Param("length")Long length);
    
    Long getLastCardNumber();
}