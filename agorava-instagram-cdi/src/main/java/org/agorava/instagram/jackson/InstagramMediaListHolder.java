package org.agorava.instagram.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.agorava.instagram.model.Media;

import java.util.List;

/**
 * User: Dje
 * Date: 04/05/13
 * Time: 17:53
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramMediaListHolder {

    private final List<Media> list;

    public InstagramMediaListHolder(@JsonProperty("data") List<Media> list) {
        this.list = list;
    }

    public List<Media> getList() {
        return list;
    }
}
