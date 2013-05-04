package org.agorava.instagram.jackson;

import org.agorava.instagram.model.InstagramProfile;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * User: Dje
 * Date: 28/04/13
 * Time: 19:25
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramCommentMixin {

    @JsonCreator
    public InstagramCommentMixin(@JsonProperty("created_time") Long createdTime,
                                 @JsonProperty("id") String id,
                                 @JsonProperty("text") String text,
                                 @JsonProperty("from") InstagramProfile from) {
    }
}
