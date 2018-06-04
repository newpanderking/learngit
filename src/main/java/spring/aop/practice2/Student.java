
package spring.aop.practice2;

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

    @AnnotationLog(message = "new student eat")
    public void eat(String food) {
        logger.info("student eat " + food);
    }

    @AnnotationLog(message = "学生睡觉")
    public void sleep() {
        logger.info("student sleep!");
    }
}
