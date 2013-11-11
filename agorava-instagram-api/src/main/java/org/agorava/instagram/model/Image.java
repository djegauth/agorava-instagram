package org.agorava.instagram.model;

/**
 * User: Dje
 * Date: 04/05/13
 * Time: 15:50
 */
public class Image {
    private final String url;
    private final Integer width;
    private final Integer height;

    public Image(String url, Integer height, Integer width) {
        this.height = height;
        this.url = url;
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public String getUrl() {
        return url;
    }

    public Integer getWidth() {
        return width;
    }
}
