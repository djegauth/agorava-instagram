package org.agorava.instagram.model;

import com.google.common.base.Objects;

import java.util.List;

/**
 * User: Dje
 * Date: 04/05/13
 * Time: 13:55
 */
public class Media {

    private final String id;
    private final InstagramProfile user;
    private final String type;
    private final String filter;
    private final Integer commentsCount;
    private final List<Comment> comments;
    private final Comment caption;

    public Media(String id, InstagramProfile user, String type, String filter, Integer commentsCount, List<Comment> comments, Comment caption) {
        this.id = id;
        this.user = user;
        this.type = type;
        this.filter = filter;
        this.commentsCount = commentsCount;
        this.comments = comments;
        this.caption = caption;
    }

    public String getId() {
        return id;
    }

    public InstagramProfile getUser() {
        return user;
    }

    public String getType() {
        return type;
    }

    public String getFilter() {
        return filter;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Comment getCaption() {
        return caption;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("filter", filter)
                .add("id", id)
                .add("user", user)
                .add("type", type)
                .toString();
    }
}
