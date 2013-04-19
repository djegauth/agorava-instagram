package org.agorava;

import org.agorava.core.api.event.SocialEvent;
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

    public void initMyProfile(@Observes @Instagram org.agorava.core.api.event.OAuthComplete oauthComplete) {
        log.debug("**** Initializing Twitter profile ****");
        if (oauthComplete.getStatus() == SocialEvent.Status.SUCCESS)
            oauthComplete.getEventData().setUserProfile(services.select(InstagramUserServiceImpl.class).get().getUserProfile());
    }

    @Override
    public String getSocialMediaName() {
        return MEDIA_NAME;
    }
}
