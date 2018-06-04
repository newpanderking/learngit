/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package spring.aop.practice2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author <a href="mailto:jason.wzr@alipay.com">玄翰</a>
 * @version $Id: AnnotationLog.java, v 0.1 2018年05月29日 下午4:09 jason.wzr Exp $
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationLog {

    String message() default "";
}
