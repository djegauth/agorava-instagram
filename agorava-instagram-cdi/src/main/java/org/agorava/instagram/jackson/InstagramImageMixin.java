package org.agorava.instagram.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: Dje
 * Date: 04/05/13
 * Time: 15:51
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramImageMixin {

    @JsonCreator
    public InstagramImageMixin(@JsonProperty("url") String url,
                               @JsonProperty("height") Integer height,
                               @JsonProperty("width") Integer width) {
    }
}
