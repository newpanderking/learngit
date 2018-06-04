
package spring.aop.practice3;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *
 * @version $Id: LoggerAspect.java, v 0.1 2018年05月28日 下午8:16 jason.wzr Exp $
 */

@Aspect
@Component
public class LoggerAspect {

  /**
   * logger
   */
  private Logger logger = Logger.getLogger(LoggerAspect.class);

  @Pointcut("execution(* spring.aop.practice2.Student.*())")
  public void proceed(){}

  @Before("proceed()")
  public void before(){
    logger.info("before executed!");
  }

  @After("proceed()")
  public void after(){
    logger.info("after executed!");
  }

}
