package org.agorava.instagram.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.agorava.instagram.model.Relationship;

/**
 * User: Dje
 * Date: 27/04/13
 * Time: 15:37
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramRelationshipHolder {

    private final Relationship relationship;

    @JsonCreator
    public InstagramRelationshipHolder(@JsonProperty("data") @JsonDeserialize(using = InstagramRelationshipDeserializer.class) Relationship relationship) {
        this.relationship = relationship;
    }

    public Relationship getRelationship() {
        return relationship;
    }
}
