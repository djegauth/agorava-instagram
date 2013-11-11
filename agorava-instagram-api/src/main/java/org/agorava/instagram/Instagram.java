package org.agorava.instagram;

import org.agorava.api.atinject.ProviderRelated;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created with IntelliJ IDEA.
 * User: Dje
 * Date: 17/09/13
 * Time: 22:20
 */
@Qualifier
@ProviderRelated("Instagram")
@Target({TYPE, METHOD, PARAMETER, FIELD})
@Retention(RUNTIME)
@Documented
public @interface Instagram {
}
