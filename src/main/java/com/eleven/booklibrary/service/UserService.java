package com.eleven.booklibrary.service;

import java.util.List;

import com.eleven.booklibrary.model.User;
import com.eleven.booklibrary.model.vo.Pagination;
import com.eleven.booklibrary.model.vo.UserVo;

public interface UserService {
  /**
   * 添加用户
   * @param user
   */
  public void insertUser(UserVo user);
  
  /**
   * 选择用户
   * @param username
   * @return
   */
  public User selectUser(String username);
  
  public List<User> selectUsers(Pagination pagination);
  
  
  public void deleteUser(String username);
  
  public User login(UserVo user);
}
