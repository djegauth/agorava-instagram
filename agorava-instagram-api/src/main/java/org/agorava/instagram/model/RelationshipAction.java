package org.agorava.instagram.model;

/**
 * User: Dje
 * Date: 28/04/13
 * Time: 10:36
 */
public enum RelationshipAction {
    FOLLOW("follow"),
    UNFOLLOW("unfollow"),
    BLOCK("block"),
    UNBLOCK("unblock"),
    APPROVE("approve"),
    DENY("deny");
    private String action;

    private RelationshipAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
