package org.agorava.instagram.impl;

import org.agorava.InstagramBaseService;
import org.agorava.instagram.InstagramLikesService;
import org.agorava.instagram.jackson.InstagramDataDeserializer;
import org.agorava.instagram.jackson.InstagramProfileListHolder;
import org.agorava.instagram.model.InstagramProfile;

import java.util.HashMap;
import java.util.List;

/**
 * User: Dje
 * Date: 04/05/13
 * Time: 12:47
 */
public class InstagramLikesServiceImpl extends InstagramBaseService implements InstagramLikesService {

    @Override
    public List<InstagramProfile> getLikes(String mediaId) {
        return getService().get(buildAbsoluteUri("/media/" + mediaId + "/likes"), InstagramProfileListHolder.class).getList();
    }

    @Override
    public void postLike(String mediaId) {
        getService().post(buildAbsoluteUri("/media/" + mediaId + "/likes"), new HashMap<String, String>(), InstagramDataDeserializer.class);
    }

    @Override
    public void deleteLike(String mediaId) {
        getService().delete(buildAbsoluteUri("/media/" + mediaId + "/likes"));
    }
}
