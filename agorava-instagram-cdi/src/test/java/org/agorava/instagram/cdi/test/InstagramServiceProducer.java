package org.agorava.instagram.cdi.test;

import org.agorava.core.api.atinject.Current;
import org.agorava.core.api.atinject.GenericBean;
import org.agorava.core.api.oauth.OAuthAppSettings;
import org.agorava.core.api.oauth.OAuthSession;
import org.agorava.core.oauth.PropertyOAuthAppSettingsBuilder;
import org.agorava.instagram.Instagram;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
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
    public OAuthAppSettings produceFirstSetting() {
        PropertyOAuthAppSettingsBuilder builder = new PropertyOAuthAppSettingsBuilder();
        return builder.build();
    }

    @SessionScoped
    @Produces
    @Instagram
    @Current
    public org.agorava.core.api.oauth.OAuthSession produceOauthSession(@Instagram @GenericBean OAuthSession session) {
        return session;

    }
}
