package org.agorava.instagram.impl;

import org.agorava.InstagramBaseService;
import org.agorava.instagram.InstagramMediaService;
import org.agorava.instagram.jackson.InstagramMediaHolder;
import org.agorava.instagram.jackson.InstagramMediaListHolder;
import org.agorava.instagram.model.Media;

import java.util.List;

/**
 * User: Dje
 * Date: 04/05/13
 * Time: 14:08
 */
public class InstagramMediaServiceImpl extends InstagramBaseService implements InstagramMediaService {

    @Override
    public Media getMedia(String mediaId) {
        return getService().get(buildAbsoluteUri("/media/" + mediaId), InstagramMediaHolder.class).getMedia();
    }

    @Override
    public List<Media> getPopular() {
        return getService().get(buildAbsoluteUri("/media/popular"), InstagramMediaListHolder.class).getList();
    }
}
