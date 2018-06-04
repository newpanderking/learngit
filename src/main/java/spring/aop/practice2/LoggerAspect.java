
package spring.aop.practice2;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

/**
 *
 * @version $Id: LoggerAspect.java, v 0.1 2018年05月28日 下午8:16 jason.wzr Exp $
 */

public class LoggerAspect {

    /**
     * logger
     */
    private Logger logger = Logger.getLogger(LoggerAspect.class);

    public void before(JoinPoint point) {
        Class c = point.getTarget().getClass();
        Signature signature = point.getSignature();


        logger.info("LoggerAspect.before " + c.getSimpleName() + "." + signature.getName()
                    + ", executed!");
    }

    public void after() {
        logger.info("LoggerAspect. after executed!");
    }

}
