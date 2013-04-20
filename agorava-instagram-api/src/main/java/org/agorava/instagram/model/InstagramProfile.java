package org.agorava.instagram.model;

import org.agorava.core.api.UserProfile;

/**
 * User: Dje
 * Date: 19/04/13
 * Time: 23:48
 */
public class InstagramProfile extends UserProfile {


    public InstagramProfile(String id ) {
        super(id);
    }

    @Override
    public String getFullName() {
        return "";
    }

    @Override
    public String getProfileImageUrl() {
        return "";
    }
}
