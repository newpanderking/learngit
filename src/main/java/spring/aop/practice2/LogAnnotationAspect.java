/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package spring.aop.practice2;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

/**
 *
 * @author <a href="mailto:jason.wzr@alipay.com">玄翰</a>
 * @version $Id: LogAnnotationAspect.java, v 0.1 2018年05月29日 下午4:12 jason.wzr Exp $
 */

public class LogAnnotationAspect {

    /**
     * logger
     */
    private Logger            logger = Logger.getLogger(LoggerAspect.class);

    private Long              start;

    private ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    public void before(JoinPoint point) {
        Class c = point.getTarget().getClass();
        Signature signature = point.getSignature();
        Object[] argus = point.getArgs();
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(Thread.currentThread().getId()).append("]");

        sb.append(c.getSimpleName()).append(".").append(signature.getName()).append(":");
        for (Object o : argus) {
            sb.append(o.toString()).append(",");
        }
        sb.append(getAnnotationMark(point)).append(",");
        start = System.currentTimeMillis();
        startTime.set(start);
        sb.append("start[").append(start).append("]startTime[").append(startTime).append("]");
        //logger.info("LoggerAspect.before " + sb.toString() + ", executed!");
    }

    public void after() {
        long end = System.currentTimeMillis();
        long endTime = end;
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(Thread.currentThread().getId()).append("]");
        sb.append("end[").append(end).append("]cost[").append(end - start).append("]endTime[")
            .append(endTime).append("]cost[").append(endTime - startTime.get()).append("]");
        //logger.info("LogAnnotationAspect. after executed!" + sb.toString());

        StringBuilder sb1 = new StringBuilder();
        sb1.append("[").append(Thread.currentThread().getId()).append("]start[").append(start);
        sb1.append("]end[").append(end).append("]cost[").append(end - start)
            .append("]startTime[" + endTime + "]endTime[").append(endTime).append("]cost[")
            .append(endTime - startTime.get()).append("]");

        logger.info(sb1.toString());
    }

    private String getAnnotationMark(JoinPoint joinPoint) {
        String mark = "";
        Class c = joinPoint.getTarget().getClass();
        Signature signature = joinPoint.getSignature();
        for (Method method : c.getMethods()) {
            if (method.getName() == signature.getName()) {
                AnnotationLog annotationLog = method.getAnnotation(AnnotationLog.class);
                mark = annotationLog.message();
            }
        }
        return mark;
    }

}
