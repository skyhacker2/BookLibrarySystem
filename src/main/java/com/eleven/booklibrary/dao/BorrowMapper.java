package com.eleven.booklibrary.dao;

import com.eleven.booklibrary.model.Borrow;
import com.eleven.booklibrary.model.BorrowExample;
import com.eleven.booklibrary.model.BorrowKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowMapper {
    int countByExample(BorrowExample example);

    int deleteByExample(BorrowExample example);

    int deleteByPrimaryKey(BorrowKey key);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    List<Borrow> selectByExample(BorrowExample example);

    Borrow selectByPrimaryKey(BorrowKey key);

    int updateByExampleSelective(@Param("record") Borrow record, @Param("example") BorrowExample example);

    int updateByExample(@Param("record") Borrow record, @Param("example") BorrowExample example);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);
    
    List<Borrow> selectByPage(@Param("offset") Long offset, @Param("length")Long length);
    
    List<Borrow> selectByCardNumber(@Param("cardNumber") Long cardNumber, @Param("offset") Long offset, @Param("length")Long length);
    
    List<Borrow> selectByBookNumber(@Param("bookNumber") Long bookNumber, @Param("offset") Long offset, @Param("length")Long length);
}