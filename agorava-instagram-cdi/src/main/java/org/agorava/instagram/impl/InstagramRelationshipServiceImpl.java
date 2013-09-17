package org.agorava.instagram.impl;

import org.agorava.InstagramBaseService;
import org.agorava.instagram.InstagramRelationshipService;
import org.agorava.instagram.jackson.InstagramProfileListHolder;
import org.agorava.instagram.jackson.InstagramRelationshipHolder;
import org.agorava.instagram.model.InstagramProfile;
import org.agorava.instagram.model.InstagramProfileList;
import org.agorava.instagram.model.Relationship;
import org.agorava.instagram.model.RelationshipAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Dje
 * Date: 21/04/13
 * Time: 00:13
 */
public class InstagramRelationshipServiceImpl extends InstagramBaseService implements InstagramRelationshipService {


    @Override
    public InstagramProfileList getFollows(String userId) {
        InstagramProfileListHolder holder = getService().get(buildAbsoluteUri("/users/" + userId + "/follows"), InstagramProfileListHolder.class);
        return new InstagramProfileList(holder.getPagination(), holder.getList());
    }

    @Override
    public InstagramProfileList getFollows(String userId, String nextCursor) {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("cursor", nextCursor);
        InstagramProfileListHolder holder = getService().get(buildUri("/users/" + userId + "/follows", parameters), InstagramProfileListHolder.class);
        return new InstagramProfileList(holder.getPagination(), holder.getList());
    }

    @Override
    public InstagramProfileList getFollowedBy(String userId) {
        InstagramProfileListHolder holder = getService().get(buildAbsoluteUri("/users/" + userId + "/followed-by"), InstagramProfileListHolder.class);
        return new InstagramProfileList(holder.getPagination(), holder.getList());
    }

    @Override
    public InstagramProfileList getFollowedBy(String userId, String nextCursor) {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("cursor", nextCursor);
        InstagramProfileListHolder holder = getService().get(buildUri("/users/" + userId + "/followed-by", parameters), InstagramProfileListHolder.class);
        return new InstagramProfileList(holder.getPagination(), holder.getList());
    }

    @Override
    public List<InstagramProfile> getRequestBy() {
        return getService().get(buildAbsoluteUri("/users/self/requested-by"), InstagramProfileListHolder.class).getList();
    }

    @Override
    public Relationship getRelationship(String userId) {
        return getService().get(buildAbsoluteUri("/users/" + userId + "/relationship"), InstagramRelationshipHolder.class).getRelationship();
    }

    @Override
    public Relationship updateRelationship(String userId, RelationshipAction action) {
        Map<String, String> body = new HashMap<String, String>();
        body.put("action", action.getAction());
        return getService().post(buildAbsoluteUri("/users/" + userId + "/relationship"), body, InstagramRelationshipHolder.class).getRelationship();
    }
}
