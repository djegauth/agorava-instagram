package org.agorava;

import org.agorava.core.api.oauth.OAuthService;
import org.agorava.core.spi.TierService;
import org.agorava.instagram.Instagram;

import javax.inject.Inject;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 00:20
 */
public abstract class InstagramBaseService extends TierService {

    public static final String API_ROOT = "https://api.instagram.com/v1/";

    @Inject
    @Instagram
    private OAuthService service;

    @Override
    protected String buildAbsoluteUri(String uri) {
        return API_ROOT + uri;
    }

    @Override
    public OAuthService getService() {
        return service;
    }


}
