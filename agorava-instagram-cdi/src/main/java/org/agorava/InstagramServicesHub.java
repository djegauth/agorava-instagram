package org.agorava;

import org.agorava.core.api.event.OAuthComplete;
import org.agorava.core.api.event.SocialEvent;
import org.agorava.core.api.oauth.OAuthService;
import org.agorava.core.cdi.AbstractSocialMediaApiHub;
import org.agorava.instagram.impl.InstagramUserServiceImpl;
import org.jboss.logging.Logger;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 00:25
 */
public class InstagramServicesHub extends AbstractSocialMediaApiHub {

    private static final String MEDIA_NAME = "Instagram";

    @Inject
    Logger log;

    @Inject
    Instance<InstagramBaseService> services;

    @Inject
    @Instagram
    private OAuthService service;

    public void initMyProfile(@Observes @Instagram OAuthComplete oauthComplete) {
        log.info("**** Initializing Instagram profile ****");
        if (oauthComplete.getStatus() == SocialEvent.Status.SUCCESS)
            oauthComplete.getEventData().setUserProfile(services.select(InstagramUserServiceImpl.class).get().getUserProfile());
    }

    @Override
    public String getSocialMediaName() {
        return MEDIA_NAME;
    }
}
