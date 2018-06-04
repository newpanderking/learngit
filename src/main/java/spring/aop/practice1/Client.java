package spring.aop.practice1;

import org.springframework.aop.framework.ProxyFactory;

/**
 *
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
