package com.eleven.booklibrary.dao;

import com.eleven.booklibrary.model.Booktype;
import com.eleven.booklibrary.model.BooktypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BooktypeMapper {
    int countByExample(BooktypeExample example);

    int deleteByExample(BooktypeExample example);

    int deleteByPrimaryKey(String type);

    int insert(Booktype record);

    int insertSelective(Booktype record);

    List<Booktype> selectByExample(BooktypeExample example);

    Booktype selectByPrimaryKey(String type);

    int updateByExampleSelective(@Param("record") Booktype record, @Param("example") BooktypeExample example);

    int updateByExample(@Param("record") Booktype record, @Param("example") BooktypeExample example);

    int updateByPrimaryKeySelective(Booktype record);

    int updateByPrimaryKey(Booktype record);
    
    List<Booktype> selectByPage(@Param("offset") Long offset, @Param("length")Long length);
}