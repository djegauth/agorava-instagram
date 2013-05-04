package org.agorava.instagram.jackson;

import org.agorava.instagram.model.Media;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

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
