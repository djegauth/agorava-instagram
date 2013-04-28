package org.agorava.instagram.jackson;

import org.agorava.instagram.model.Relationship;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

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
