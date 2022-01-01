package com.ice.expertat;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类描述：检查
 *
 */

@Target({TYPE, METHOD, CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface Tracking{

}
