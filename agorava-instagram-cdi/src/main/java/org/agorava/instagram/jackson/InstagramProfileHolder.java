package org.agorava.instagram.jackson;

import org.agorava.instagram.model.InstagramProfile;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 17:20
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramProfileHolder {

    private final InstagramProfile profile;

    @JsonCreator
    public InstagramProfileHolder(@JsonProperty("data") @JsonDeserialize(using = InstagramProfileDeserializer.class) InstagramProfile profile){
        this.profile = profile;
    }

    public InstagramProfile getProfile() {
        return profile;
    }
}
