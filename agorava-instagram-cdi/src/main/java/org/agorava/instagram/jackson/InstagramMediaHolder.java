package org.agorava.instagram.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.agorava.instagram.model.Media;

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
