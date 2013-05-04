package org.agorava.instagram.jackson;

import org.agorava.instagram.model.Media;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * User: Dje
 * Date: 04/05/13
 * Time: 14:13
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramMediaHolder {

    private final Media media;

    @JsonCreator
    public InstagramMediaHolder(@JsonProperty("data") @JsonDeserialize(using = InstagramMediaDeserializer.class) Media media) {
        this.media = media;
    }

    public Media getMedia() {
        return media;
    }
}
