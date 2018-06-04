package spring.aop.practice1;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 *
 * @author <a href="mailto:jason.wzr@alipay.com">玄翰</a>
 * @version $Id: MarkAdvice.java, v 0.1 2018年05月22日 下午9:13 jason.wzr Exp $
 */

public class MarkAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    /**
     * logger
     */
    private Logger logger = Logger.getLogger(MarkAdvice.class);

    public void afterReturning(Object o, Method method, Object[] objects, Object o1)
                                                                                    throws Throwable {
        logger.info("after:" + method.getName());
    }

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        logger.info("before:" + method.getName());
    }
}
