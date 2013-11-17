package com.eleven.booklibrary.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eleven.booklibrary.model.User;

public class LoginFilter implements Filter {

  public void destroy() {
    // TODO Auto-generated method stub

  }

  public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest)arg0;
    HttpServletResponse response = (HttpServletResponse)arg1;
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("user");
    String url = request.getRequestURI();
    System.out.println(url);
    if (user == null) {
       // response.sendRedirect(request.getContextPath() + "/login.do");
      arg2.doFilter(arg0, arg1);
    } else {
      arg2.doFilter(arg0, arg1);
    }

  }

  public void init(FilterConfig arg0) throws ServletException {
    // TODO Auto-generated method stub

  }

}
