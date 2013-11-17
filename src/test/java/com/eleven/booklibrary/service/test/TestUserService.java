package com.eleven.booklibrary.service.test;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eleven.booklibrary.model.User;
import com.eleven.booklibrary.model.vo.Pagination;
import com.eleven.booklibrary.model.vo.UserVo;
import com.eleven.booklibrary.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring.xml"})
public class TestUserService {

  @Autowired
  private UserService userService;
  
  @Test
  public void testInsertUser() {
    UserVo vo = new UserVo();
    vo.setUsername("hello");
    vo.setPassword("123");
    vo.setIsAdmin(1);
    userService.insertUser(vo);
  }
  
  @Test
  public void testSelectUser() {
    User user = userService.selectUser("nono");
    System.out.println(user.getUsername());
    System.out.println(user.getPassword());
  }
  
  @Test
  public void testSelectUsers() {
    Pagination pagination = new Pagination();
    pagination.setCurPage(1);
    pagination.setPageSize(3);
    List<User> users = userService.selectUsers(pagination);
    for (User u : users) {
      System.out.println(u.getUsername() + " " + u.getPassword());
    }
  }
  @Test
  public void testDeleteUser() {
    userService.deleteUser("skyhacker");
  }
}