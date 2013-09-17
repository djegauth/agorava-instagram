package org.agorava;

import org.agorava.instagram.Instagram;

import javax.enterprise.util.AnnotationLiteral;

/**
 * Created with IntelliJ IDEA.
 * User: Dje
 * Date: 17/09/13
 * Time: 22:44
 */
public class InstagramLiteral extends AnnotationLiteral<Instagram> implements Instagram{

    public static Instagram INSTANCE = new InstagramLiteral();
}
