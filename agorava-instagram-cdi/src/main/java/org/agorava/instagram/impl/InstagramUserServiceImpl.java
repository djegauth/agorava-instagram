package org.agorava.instagram.impl;

import org.agorava.InstagramBaseService;
import org.agorava.instagram.InstagramUserService;
import org.agorava.instagram.model.InstagramProfile;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 00:27
 */
public class InstagramUserServiceImpl extends InstagramBaseService implements InstagramUserService {

    static final String GET_USER_PROFILE_URL = "users/show.json";

    @Override
    public InstagramProfile getUserProfile() {
        return getService().get(buildUri("/users/self"), InstagramProfile.class);
    }


    @Override
    public InstagramProfile getUserProfile(long userId) {
        return getService().get(buildUri("users/" + userId), InstagramProfile.class);
    }

}
