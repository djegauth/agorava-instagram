package org.agorava;

import org.agorava.api.oauth.OAuthService;
import org.agorava.instagram.Instagram;
import org.agorava.spi.ProviderApiService;

import javax.inject.Inject;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 00:20
 */
public abstract class InstagramBaseService extends ProviderApiService {

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
