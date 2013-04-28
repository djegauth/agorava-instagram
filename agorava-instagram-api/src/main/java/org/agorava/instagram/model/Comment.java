package org.agorava.instagram.model;

import com.google.common.base.Objects;

/**
 * User: Dje
 * Date: 28/04/13
 * Time: 18:40
 */
public class Comment {

    private final String id;
    private final Long createdTime;
    private final String text;
    private final InstagramProfile from;

    public Comment(Long createdTime, String id, String text, InstagramProfile from) {
        this.createdTime = createdTime;
        this.id = id;
        this.text = text;
        this.from = from;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public InstagramProfile getFrom() {
        return from;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("createdTime", createdTime)
                .add("id", id)
                .add("text", text)
                .add("from", from)
                .toString();
    }
}
