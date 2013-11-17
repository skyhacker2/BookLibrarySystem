package com.eleven.booklibrary.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eleven.booklibrary.model.Borrowertype;
import com.eleven.booklibrary.model.User;
import com.eleven.booklibrary.model.vo.UserVo;
import com.eleven.booklibrary.service.BorrowertypeService;
import com.eleven.booklibrary.service.UserService;
import com.eleven.booklibrary.util.ModelPrinter;

@Controller
@RequestMapping(value="/user")
public class UserController {
  
  @Autowired
  private UserService userService;
  
  
  /**
   * 验证用户登录
   * @param user
   * @param request
   * @param redirectAttr
   * @return
   */
  @RequestMapping(value="/login.do", method = RequestMethod.POST)
  public String login(UserVo userVo, HttpServletRequest request, RedirectAttributes redirectAttr) {
    request.getSession().setAttribute("title", "登入");
    User user = userService.login(userVo);
    if (user != null) {
      request.getSession().setAttribute("user", user);
      redirectAttr.addFlashAttribute("success", "登录成功");
      return "redirect:/index.do";
    }
    else {
      redirectAttr.addFlashAttribute("error", "账号或密码错误");
      return "redirect:/user/login.do";
    }
  }
  
  /**
   * 用户登录页面
   * @param request
   * @return
   */
  @RequestMapping(value="/login.do", method = RequestMethod.GET)
  public String login(HttpServletRequest request) {
    request.getSession().setAttribute("title", "登入");
    return "user/login";
  }
  
  /**
   * 退出登录
   * @param request
   * @param redirectAttr
   * @return
   */
  @RequestMapping(value="/logout.do", method=RequestMethod.GET)
  public String logout(HttpServletRequest request, RedirectAttributes redirectAttr) {
    request.getSession().setAttribute("user", null);
    redirectAttr.addFlashAttribute("success", "登出成功");
    return "redirect:/index.do";
  }
  
  /**
   * 用户中心
   * @return
   */
  @RequestMapping(value="/user_center", method = RequestMethod.GET)
  public String userCenter(HttpServletRequest request) {
    request.getSession().setAttribute("title", "用户中心");
    User user = (User)request.getSession().getAttribute("user");
    if (user.getIsAdmin() == 1)
      return "user/admin_center";
    else
      return "user/user_center";
  }
  
  @RequestMapping(value="manageUser")
  public String manageUser(ModelMap map) {
    List<User> list = userService.selectUsers(null);
    map.addAttribute("userList", list);
    return "user/manage_user";
  }
  
  @RequestMapping(value="addUser", method=RequestMethod.POST)
  public String addUser(UserVo vo, ModelMap map) {
    userService.insertUser(vo);
    List<User> list = userService.selectUsers(null);
    map.addAttribute("userList", list);
    map.addAttribute("success", "添加用户\'" + vo.getUsername() + "\'成功");
    return "user/manage_user";
  }
  
  @RequestMapping(value="deleteUser", method=RequestMethod.POST)
  @ResponseBody
  public String deleteUser(String name) {
    userService.deleteUser(name);
    return "200";
  }
}
