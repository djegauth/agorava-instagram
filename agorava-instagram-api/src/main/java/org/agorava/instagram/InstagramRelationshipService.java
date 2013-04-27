package org.agorava.instagram;

import org.agorava.instagram.model.InstagramProfile;
import org.agorava.instagram.model.InstagramProfileList;
import org.agorava.instagram.model.Relationship;

import java.util.List;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 23:59
 */
public interface InstagramRelationshipService {

    /**
     * Get the list of users this user follows.
     *
     * @param userId : user id
     * @return list of {@link InstagramProfile}
     */
    InstagramProfileList getFollows(String userId);

    /**
     * Get the list of users this user follows.
     *
     * @param userId     : user id
     * @param nextCursor : pagination next cursor
     * @return list of {@link InstagramProfile}
     */
    InstagramProfileList getFollows(String userId, String nextCursor);

    /**
     * Get the list of users this user is followed by.
     *
     * @param userId : user id
     * @return list of {@link InstagramProfile}
     */
    InstagramProfileList getFollowedBy(String userId);

    /**
     * Get the list of users this user is followed by.
     *
     * @param userId     : user id
     * @param nextCursor : pagination next cursor
     * @return list of {@link InstagramProfile}
     */
    InstagramProfileList getFollowedBy(String userId, String nextCursor);

    /**
     * List the users who have requested this user's permission to follow.
     *
     * @return list of {@link InstagramProfile}
     */
    List<InstagramProfile> getRequestBy();

    /**
     * Get information about a relationship to another user.
     *
     * @return {@link Relationship}
     */
    Relationship getRelationship();

    /**
     * Modify the relationship between the current user and the target user.
     *
     * @return
     */
    Relationship postRelationship();
}
