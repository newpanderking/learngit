
package spring.aop.practice3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * @version $Id: Client.java, v 0.1 2018年05月22日 下午9:16 jason.wzr Exp $
 */
@Configuration
@EnableAspectJAutoProxy
public class Client {

  public static void main(String[] args) {
    Person person = getStudent();
    person.eat();
    person.sleep();
  }

  @Bean
  public static Student getStudent(){
    return  new Student();
  }
}
