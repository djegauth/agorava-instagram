package org.agorava.instagram;

import org.agorava.instagram.model.Comment;

import java.util.List;

/**
 * User: Dje
 * Date: 28/04/13
 * Time: 18:45
 */
public interface InstagramCommentsService {

    /**
     * Get the comments from the media
     *
     * @param mediaId :  id of the media
     * @return list of {@link Comment}
     */
    List<Comment> getComments(String mediaId);
}
