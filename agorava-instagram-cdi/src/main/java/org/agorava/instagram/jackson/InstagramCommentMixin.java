package org.agorava.instagram.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.agorava.instagram.model.InstagramProfile;

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
