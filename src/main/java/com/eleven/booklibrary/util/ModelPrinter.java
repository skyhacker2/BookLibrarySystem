package com.eleven.booklibrary.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ModelPrinter {

  /**
   * 输出一个实体类的全部属性
   * @param model
   */
  public static void print(Object model) {
    Class cls = model.getClass();
    Field[] fields = cls.getDeclaredFields();
    System.out.println("###################### " + model.getClass().getName() + " ####################");
    for (Field field : fields) {
        char[] buffer = field.getName().toCharArray();
        buffer[0] = Character.toUpperCase(buffer[0]);
        String mothodName = "get" + new String(buffer);
        try {
          Method method = cls.getDeclaredMethod(mothodName);
          Object resutl = method.invoke(model, null);
          System.out.println(field.getName() + ": " + resutl);
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
    System.out.println("###################### End ####################");
  }
  /**
   * 输出实体类指定的属性
   * @param model
   * @param fields
   */
  public static void print(Object model, String[] fields) {
    Class cls = model.getClass();
    System.out.println("###################### " + model.getClass().getName() + " ####################");
    for (String field : fields) {
        char[] buffer = field.toCharArray();
        buffer[0] = Character.toUpperCase(buffer[0]);
        String mothodName = "get" + new String(buffer);
        try {
          Method method = cls.getDeclaredMethod(mothodName);
          Object resutl = method.invoke(model, null);
          System.out.println(field + ": " + resutl);
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
    System.out.println("###################### End ####################");
  }
}
