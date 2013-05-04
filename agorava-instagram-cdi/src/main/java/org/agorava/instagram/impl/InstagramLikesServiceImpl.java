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
        List<InstagramProfile> list = getService().get(buildUri("/media/" + mediaId + "/likes"), InstagramProfileListHolder.class).getList();
        return list;
    }

    @Override
    public void postLike(String mediaId) {
        getService().post(buildUri("/media/" + mediaId + "/likes"), new HashMap<String, String>(), InstagramDataDeserializer.class);
    }

    @Override
    public void deleteLike(String mediaId) {
        getService().delete(buildUri("/media/" + mediaId + "/likes"));
    }
}
