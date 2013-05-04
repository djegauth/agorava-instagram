package org.agorava.instagram.jackson;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

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
