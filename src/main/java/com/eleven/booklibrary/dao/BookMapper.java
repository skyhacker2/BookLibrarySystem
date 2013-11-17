package com.eleven.booklibrary.dao;

import com.eleven.booklibrary.model.Book;
import com.eleven.booklibrary.model.BookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {
    int countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(Long bookNumber);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(Long bookNumber);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
    
    List<Book> selectByName(@Param("bookName") String bookName, @Param("offset") Long offset, @Param("length")Long length, @Param("orderBy")String orderBy);
    
    int count(@Param("bookName")String bookName);
}