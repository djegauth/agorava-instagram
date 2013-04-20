package org.agorava.instagram.jackson;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 16:16
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = InstagramProfileDeserializer.class)
public class InstagramProfileMixin {

    @JsonCreator
    InstagramProfileMixin(@JsonProperty("id") String id,
                          @JsonProperty("username") String userName,
                          @JsonProperty("full_name") String fullName,
                          @JsonProperty("profile_picture") String profileImageUrl,
                          @JsonProperty("bio") String bio,
                          @JsonProperty("website")String website) {
    }
}
