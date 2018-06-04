
package spring.aop.practice3;

import org.apache.log4j.Logger;

/**
 *
 * @version $Id: Student.java, v 0.1 2018年05月22日 下午8:51 jason.wzr Exp $
 */

public class Student implements Person {

    /**
     * logger
     */
    private Logger logger = Logger.getLogger(Student.class);

    public void eat() {
        logger.info("student eat!");
    }

    public void sleep() {
        logger.info("student sleep!");
    }
}
