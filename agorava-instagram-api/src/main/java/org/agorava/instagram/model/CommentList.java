package org.agorava.instagram.model;

import java.util.List;

/**
 * User: Dje
 * Date: 28/04/13
 * Time: 18:44
 */
public class CommentList {

    private final List<Comment> comments;

    public CommentList(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
