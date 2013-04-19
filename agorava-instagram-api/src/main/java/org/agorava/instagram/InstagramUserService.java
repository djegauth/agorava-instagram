package org.agorava.instagram;

import org.agorava.instagram.model.InstagramProfile;

/**
 * User: Dje
 * Date: 19/04/13
 * Time: 23:46
 */
public interface InstagramUserService {

    InstagramProfile getUserProfile();

    InstagramProfile getUserProfile(long userId);
}
