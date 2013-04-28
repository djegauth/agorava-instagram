package org.agorava.instagram.model;

/**
 * User: Dje
 * Date: 19/04/13
 * Time: 23:51
 */
public class Count {

    private final Integer media;
    private final Integer follows;
    private final Integer followedBy;

    public Count(Integer followedBy, Integer media, Integer follows) {
        this.followedBy = followedBy;
        this.media = media;
        this.follows = follows;
    }

    public Integer getFollowedBy() {
        return followedBy;
    }

    public Integer getFollows() {
        return follows;
    }

    public Integer getMedia() {
        return media;
    }
}
