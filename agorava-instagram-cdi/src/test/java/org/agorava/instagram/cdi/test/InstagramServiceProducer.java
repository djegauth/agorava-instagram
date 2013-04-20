package org.agorava.instagram.cdi.test;

import org.agorava.Instagram;
import org.agorava.InstagramServicesHub;
import org.agorava.core.api.SocialMediaApiHub;
import org.agorava.core.api.oauth.Param;
import org.agorava.core.cdi.OAuthApplication;
import org.agorava.core.oauth.SimpleOAuthAppSettingsBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import static org.agorava.core.api.oauth.OAuthAppSettingsBuilder.API_KEY;
import static org.agorava.core.api.oauth.OAuthAppSettingsBuilder.API_SECRET;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 09:49
 */
public class InstagramServiceProducer {

    @Instagram
    @ApplicationScoped
    @OAuthApplication(builder = SimpleOAuthAppSettingsBuilder.class, params = {@Param(name = API_KEY, value = "63cfee50521b4b579b238be876f06ffc"),
            @Param(name = API_SECRET, value = "a5fa2fddcc6e4eceac1d10cbf7c183cc")})
    @Produces
    public SocialMediaApiHub OAuthSettingsProducer(InstagramServicesHub service) {
        return service;
    }
}
