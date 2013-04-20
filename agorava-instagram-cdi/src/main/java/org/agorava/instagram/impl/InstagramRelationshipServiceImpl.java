package org.agorava.instagram.impl;

import org.agorava.InstagramBaseService;
import org.agorava.instagram.InstagramRelationshipService;
import org.agorava.instagram.jackson.InstagramProfileListHolder;
import org.agorava.instagram.model.InstagramProfile;
import org.agorava.instagram.model.Relationship;

import java.util.List;

/**
 * User: Dje
 * Date: 21/04/13
 * Time: 00:13
 */
public class InstagramRelationshipServiceImpl extends InstagramBaseService implements InstagramRelationshipService {


    @Override
    public List<InstagramProfile> getFollows(String userId) {
        return getService().get(buildUri("/users/" + userId + "/follows"), InstagramProfileListHolder.class).getList();
    }

    @Override
    public List<InstagramProfile> getFollowedBy(String userId) {
        return getService().get(buildUri("/users/" + userId + "/followed-by"), InstagramProfileListHolder.class).getList();
    }

    @Override
    public List<InstagramProfile> getRequestBy() {
        return getService().get(buildUri("/users/self/requested-by"), InstagramProfileListHolder.class).getList();
    }

    @Override
    public Relationship getRelationship() {
        return null;
    }

    @Override
    public Relationship postRelationship() {
        return null;
    }
}
