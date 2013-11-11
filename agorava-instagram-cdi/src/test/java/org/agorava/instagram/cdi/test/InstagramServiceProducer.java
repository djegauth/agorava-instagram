package org.agorava.instagram.cdi.test;

import org.agorava.api.oauth.application.OAuthAppSettings;
import org.agorava.api.oauth.application.OAuthApplication;
import org.agorava.instagram.Instagram;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 09:49
 */
public class InstagramServiceProducer {


    @ApplicationScoped
    @Produces
    @Instagram
    @OAuthApplication
    public OAuthAppSettings produceSettings;

}
