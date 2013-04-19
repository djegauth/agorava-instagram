package org.agorava;

import org.agorava.core.api.ServiceRelated;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@ServiceRelated
@Target({TYPE, METHOD, PARAMETER, FIELD})
@Retention(RUNTIME)
@Documented
/**
 * User: Dje
 * Date: 20/04/13
 * Time: 00:18
 */
public @interface Instagram {
}
