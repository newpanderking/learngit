/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package spring.aop.practice1;

import org.springframework.aop.framework.ProxyFactory;

/**
 *
 * @author <a href="mailto:jason.wzr@alipay.com">玄翰</a>
 * @version $Id: Client.java, v 0.1 2018年05月22日 下午9:16 jason.wzr Exp $
 */

public class Client {

  public static void main(String[] args) {
    ProxyFactory proxyFactory = new ProxyFactory();
    proxyFactory.setTarget(new Student());
    proxyFactory.addAdvice(new MarkAdvice());

    Student student = (Student) proxyFactory.getProxy();
    student.eat();
    student.sleep();
  }
}
