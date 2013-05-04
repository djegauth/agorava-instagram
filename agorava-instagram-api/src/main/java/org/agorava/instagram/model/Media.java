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
    private final Long createdTime;
    private final String link;
    private final Integer likesCount;
    private final List<InstagramProfile> likes;
    private final Image lowResolution;
    private final Image thumbnail;
    private final Image standardResolution;
    private final boolean userHasLiked;


    public Media(String id, InstagramProfile user, String type, String filter,
                 Integer commentsCount, List<Comment> comments, Comment caption,
                 Long createdTime, String link, Integer likesCount, List<InstagramProfile> likes,
                 Image lowResolution, Image thumbnail, Image standardResolution, boolean userHasLiked) {
        this.id = id;
        this.user = user;
        this.type = type;
        this.filter = filter;
        this.commentsCount = commentsCount;
        this.comments = comments;
        this.caption = caption;
        this.createdTime = createdTime;
        this.link = link;
        this.likesCount = likesCount;
        this.likes = likes;
        this.lowResolution = lowResolution;
        this.thumbnail = thumbnail;
        this.standardResolution = standardResolution;
        this.userHasLiked = userHasLiked;
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

    public Long getCreatedTime() {
        return createdTime;
    }

    public String getLink() {
        return link;
    }

    public List<InstagramProfile> getLikes() {
        return likes;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public Image getLowResolution() {
        return lowResolution;
    }

    public Image getStandardResolution() {
        return standardResolution;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public boolean isUserHasLiked() {
        return userHasLiked;
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
