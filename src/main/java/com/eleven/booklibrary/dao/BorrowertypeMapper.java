package com.eleven.booklibrary.dao;

import com.eleven.booklibrary.model.Borrowertype;
import com.eleven.booklibrary.model.BorrowertypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowertypeMapper {
    int countByExample(BorrowertypeExample example);

    int deleteByExample(BorrowertypeExample example);

    int deleteByPrimaryKey(String type);

    int insert(Borrowertype record);

    int insertSelective(Borrowertype record);

    List<Borrowertype> selectByExample(BorrowertypeExample example);

    Borrowertype selectByPrimaryKey(String type);

    int updateByExampleSelective(@Param("record") Borrowertype record, @Param("example") BorrowertypeExample example);

    int updateByExample(@Param("record") Borrowertype record, @Param("example") BorrowertypeExample example);

    int updateByPrimaryKeySelective(Borrowertype record);

    int updateByPrimaryKey(Borrowertype record);
    
    List<Borrowertype> selectByPage(@Param("offset")Long offset, @Param("length")Long lenght);
}