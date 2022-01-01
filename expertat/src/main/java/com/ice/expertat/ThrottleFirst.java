package com.ice.expertat;


import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类描述：在一段间隔内只允许调用一次  throttleFirst
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface ThrottleFirst {

    long DEFAULT_INTERVAL_MILLIS = 1000;

    /**
     * @return 再次调用的间隔（ms），默认是1000ms
     */
    long value() default DEFAULT_INTERVAL_MILLIS;
}
