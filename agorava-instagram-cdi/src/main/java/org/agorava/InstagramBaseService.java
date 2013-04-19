package org.agorava;

import org.agorava.core.api.oauth.OAuthService;
import org.agorava.core.cdi.AbstractSocialMediaApi;

import javax.inject.Inject;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 00:20
 */
public abstract class InstagramBaseService extends AbstractSocialMediaApi{

    public static final String API_ROOT = "https://api.instagram.com/v1/";

    @Inject
    @Instagram
    private OAuthService service;

    @Override
    public String buildUri(String uri) {
        return API_ROOT + uri;
    }

    @Override
    public OAuthService getService() {
        return service;
    }
}
