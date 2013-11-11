package org.agorava.instagram.model;

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
}
