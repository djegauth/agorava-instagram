package org.agorava.instagram;

import org.agorava.instagram.model.InstagramProfile;

import java.util.List;

/**
 * User: Dje
 * Date: 04/05/13
 * Time: 12:46
 */
public interface InstagramLikesService {

    /**
     * Get a list of users who have liked this media.
     *
     * @param mediaId :  id of the media
     * @return list of InstagramProfile
     */
    List<InstagramProfile> getLikes(String mediaId);

    /**
     * Set a like on this media by the currently authenticated user.
     *
     * @param mediaId : id of the media
     */
    void postLike(String mediaId);

    /**
     * Remove a like on this media by the currently authenticated user.
     *
     * @param mediaId : id of the media
     */
    void deleteLike(String mediaId);
}
