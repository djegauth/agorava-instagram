package org.agorava.instagram.model;

import java.util.List;

/**
 * User: Dje
 * Date: 27/04/13
 * Time: 12:19
 */
public class InstagramProfileList {

    private final List<InstagramProfile> profiles;
    private final Pagination pagination;

    public InstagramProfileList(Pagination pagination, List<InstagramProfile> profiles) {
        this.pagination = pagination;
        this.profiles = profiles;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public List<InstagramProfile> getProfiles() {
        return profiles;
    }
}
