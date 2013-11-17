package com.eleven.booklibrary.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.eleven.booklibrary.dao.BookMapper;
import com.eleven.booklibrary.model.Book;
import com.eleven.booklibrary.model.BookExample;
import com.eleven.booklibrary.model.BookExample.Criteria;
import com.eleven.booklibrary.model.vo.BookVo;
import com.eleven.booklibrary.model.vo.Pagination;
import com.eleven.booklibrary.service.BookService;

@Service
public class BookServiceImpl implements BookService{
  
  @Autowired
  private BookMapper bookMapper;

  public void insertBook(BookVo vo) {
    // 更正价格
    String price = "";
    for (int i = 0; i < vo.getPriceVo().length(); i++) {
      if (vo.getPriceVo().charAt(i) == '.') {
        break;
      } else {
        price += vo.getPriceVo().charAt(i);
      }
    }
    // 出版时间
    String[] time = vo.getPubdate().split("-");
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, Integer.parseInt(time[0]));
    calendar.set(Calendar.MONTH, Integer.parseInt(time[1]));
    vo.setPrice(Long.parseLong(price));
    vo.setStoreDate(Calendar.getInstance().getTime());
    vo.setPublishDate(calendar.getTime());
    vo.setBorrowedNumber(0);
    bookMapper.insert(vo);
    
  }

  public List<Book> selectBookByName(String name, String type, Pagination pagination) {
    long offset = (pagination.getCurPage()-1) * pagination.getPageSize();
    long length = pagination.getPageSize();
    BookExample example = new BookExample();
    Criteria criteria = new BookExample().createCriteria();
    if (!StringUtils.isEmpty(name)) {
      criteria.andBookNameLike("%" + name + "%");
    }
    if (!StringUtils.isEmpty(type))
      criteria.andBookTypeEqualTo(type);
    example.or(criteria);
    example.setOffset(offset);
    example.setLength(length);
    List<Book> books = bookMapper.selectByExample(example);
    
    return books;
  }

  public void updateBook(BookVo vo, Long bookNum) {
 // 更正价格
    String price = "";
    for (int i = 0; i < vo.getPriceVo().length(); i++) {
      if (vo.getPriceVo().charAt(i) == '.') {
        break;
      } else {
        price += vo.getPriceVo().charAt(i);
      }
    }
    // 出版时间
    String[] time = vo.getPubdate().split("-");
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, Integer.parseInt(time[0]));
    calendar.set(Calendar.MONTH, Integer.parseInt(time[1]));
    vo.setPrice(Long.parseLong(price));
    vo.setPublishDate(calendar.getTime());
    BookExample bookExample = new BookExample();
    bookExample.or().andBookNumberEqualTo(bookNum);
    bookMapper.updateByExample(vo, bookExample);
  }

  public void deleteBookByBookNumber(long num) {
    BookExample bookExample = new BookExample();
    bookExample.or().andBookNumberEqualTo(num);
    bookMapper.deleteByExample(bookExample);
    
  }

  public Book selectBookByBookNumber(long num) {
    return bookMapper.selectByPrimaryKey(num);
  }

  public int countByName(String bookName) {
    return bookMapper.count(bookName);
  }

  public Pagination count(String name, String type, Pagination pagination) {
    BookExample example = new BookExample();
    Criteria criteria = example.createCriteria();
    if (!StringUtils.isEmpty(name)) {
      criteria.andBookNameLike("%" + name + "%");
    }
    if (!StringUtils.isEmpty(type))
      criteria.andBookTypeEqualTo(type);
    example.or(criteria);
    int num = bookMapper.countByExample(example);
    pagination.setItems(num);
    long a = pagination.getItems() % pagination.getPageSize();
    long b = pagination.getItems() / pagination.getPageSize();
    if (a == 0) {
      pagination.setPageNumber(b);
    } else {
      pagination.setPageNumber(b+1);
    }
    return pagination;
  }

  public Book selectBook(long num, String type) {
    BookExample example = new BookExample();
    example.or().andBookNumberEqualTo(num);
    if (!StringUtils.isEmpty(type))
      example.or().andBookTypeEqualTo(type);
    List<Book> books = bookMapper.selectByExample(example);
    if (books.size() > 0)
      return books.get(0);
    else
      return null;
  }

  public List<Book> selectNewBooks(int num) {
    BookExample example = new BookExample();
    example.setOffset(0);
    example.setLength(num);
    example.setOrderByClause("store_date DESC");
    List<Book> list = bookMapper.selectByExample(example);
    return list;
  }

}
