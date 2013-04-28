package org.agorava.instagram;

import org.agorava.instagram.model.Comment;
import org.agorava.instagram.model.CommentList;

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
     * @return CommentList
     */
    List<Comment> getComments(String mediaId);
}
