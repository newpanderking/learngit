
package spring.aop.practice2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @version $Id: AnnotationLog.java, v 0.1 2018年05月29日 下午4:09 jason.wzr Exp $
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationLog {

    String message() default "";
}
