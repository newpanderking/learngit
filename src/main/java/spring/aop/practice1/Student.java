/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package spring.aop.practice1;

import org.apache.log4j.Logger;

/**
 *
 * @author <a href="mailto:jason.wzr@alipay.com">玄翰</a>
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
