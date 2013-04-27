package org.agorava.instagram.model;

/**
 * User: Dje
 * Date: 27/04/13
 * Time: 10:36
 */
public class Pagination {

    private final String nextUrl;
    private final String nextCursor;

    public Pagination(String nextUrl, String nextCursor) {
        this.nextCursor = nextCursor;
        this.nextUrl = nextUrl;
    }

    public String getNextCursor() {
        return nextCursor;
    }

    public String getNextUrl() {
        return nextUrl;
    }

}
