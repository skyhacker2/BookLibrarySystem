package com.eleven.booklibrary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleven.booklibrary.dao.UserMapper;
import com.eleven.booklibrary.model.User;
import com.eleven.booklibrary.model.UserExample;
import com.eleven.booklibrary.model.vo.Pagination;
import com.eleven.booklibrary.model.vo.UserVo;
import com.eleven.booklibrary.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;
  
  public void insertUser(UserVo user) {
    userMapper.insert(user);
  }

  public User selectUser(String username) {
    UserExample userExample = new UserExample();
    userExample.or().andUsernameEqualTo(username);
    List<User> users = userMapper.selectByExample(userExample);
    if (users != null)
      return users.get(0);
    else
      return null;
  }

  public void deleteUser(String name) {
    UserExample userExample = new UserExample();
    userExample.or().andUsernameEqualTo(name);
    userMapper.deleteByExample(userExample);
  }

  public List<User> selectUsers(Pagination pagination) {
    return userMapper.selectByExample(null);
    
  }

  public User login(UserVo user) {
    UserExample example = new UserExample();
    example.or().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
    List<User> records = userMapper.selectByExample(example);
    if (records.size() > 0 )
      return records.get(0);
    else
      return null;
  }

}
