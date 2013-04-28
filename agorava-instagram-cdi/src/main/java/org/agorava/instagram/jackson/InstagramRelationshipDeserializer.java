package org.agorava.instagram.jackson;

import org.agorava.instagram.model.Relationship;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;

/**
 * User: Dje
 * Date: 27/04/13
 * Time: 15:38
 */
public class InstagramRelationshipDeserializer extends JsonDeserializer<Relationship> {

    @Override
    public Relationship deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode data = jp.readValueAsTree();
        Relationship relationship = new Relationship(data.get("outgoing_status").asText(),
                data.get("target_user_is_private").asBoolean());
        if (data.has("incoming_status")) {
            relationship.setIncomingStatus(data.get("incoming_status").asText());
        }
        return relationship;
    }
}
