package org.agorava.instagram;

import org.agorava.api.oauth.application.OAuthAppSettings;
import org.agorava.api.service.OAuthEncoder;
import org.agorava.api.service.Preconditions;
import org.agorava.spi.ProviderConfigOauth20Final;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 11:35
 */
@Instagram
public class InstagramApi extends ProviderConfigOauth20Final {

    private static final String MEDIA_NAME = "Instagram";
    private static final String AUTHORIZE_URL = "https://instagram.com/oauth/authorize/?client_id=%s&redirect_uri=%s&response_type=token";
    private static final String SCOPED_AUTHORIZE_URL = AUTHORIZE_URL + "&scope=%s";

    @Override
    public String getAccessTokenEndpoint() {
        return "https://api.instagram.com/oauth/access_token";
    }

    @Override
    public String getAuthorizationUrl(OAuthAppSettings oAuthAppSettings) {
        Preconditions.checkValidUrl(oAuthAppSettings.getCallback(), "Must provide a valid url as callback. Instagram does not support OOB");

        // Append scope if present
        if (oAuthAppSettings.hasScope()) {
            return String.format(SCOPED_AUTHORIZE_URL, oAuthAppSettings.getApiKey(), OAuthEncoder.encode(oAuthAppSettings.getCallback()), OAuthEncoder.encode(oAuthAppSettings.getScope()));
        } else {
            return String.format(AUTHORIZE_URL, oAuthAppSettings.getApiKey(), OAuthEncoder.encode(oAuthAppSettings.getCallback()));
        }
    }

    @Override
    public String getProviderName() {
        return MEDIA_NAME;
    }
}
