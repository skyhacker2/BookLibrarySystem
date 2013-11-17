package com.eleven.booklibrary.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eleven.booklibrary.util.BookUtil;


public class TestBookUtil {

   @Test
   public void testGetBookInfo() {
     String content = BookUtil.getBookInfo("1139336");
     content = content.replaceAll("\\\\n", "<br>");
     System.out.println(content);
   }
}
