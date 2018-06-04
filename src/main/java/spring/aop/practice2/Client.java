/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package spring.aop.practice2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author <a href="mailto:jason.wzr@alipay.com">玄翰</a>
 * @version $Id: Client.java, v 0.1 2018年05月22日 下午9:16 jason.wzr Exp $
 */

public class Client {

  public static void main(String[] args)  {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.aop.xml");
    final Person person = (Person)ctx.getBean("student");
    ExecutorService executorService = Executors.newFixedThreadPool(10);


        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    //try {
                    //    Thread.sleep(1000);
                    //} catch (InterruptedException e) {
                    //    e.printStackTrace();
                    //}
                    person.eat("fish");
                }
            });

        }
    person.sleep();
  }
}
