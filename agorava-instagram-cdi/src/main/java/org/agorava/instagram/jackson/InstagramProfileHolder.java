package org.agorava.instagram.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.agorava.instagram.model.InstagramProfile;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 17:20
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramProfileHolder {

    private final InstagramProfile profile;

    @JsonCreator
    public InstagramProfileHolder(@JsonProperty("data") InstagramProfile profile){
        this.profile = profile;
    }

    public InstagramProfile getProfile() {
        return profile;
    }
}
