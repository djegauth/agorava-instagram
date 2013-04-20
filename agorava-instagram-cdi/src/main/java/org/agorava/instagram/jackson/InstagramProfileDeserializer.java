package org.agorava.instagram.jackson;

import org.agorava.instagram.model.InstagramProfile;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 12:31
 */
public class InstagramProfileDeserializer extends JsonDeserializer<InstagramProfile> {

    @Override
    public InstagramProfile deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode tree = jsonParser.readValueAsTree();
        JsonNode data= tree.get("data");
        String id = data.get("id").asText();
        InstagramProfile profile = new InstagramProfile(id);
        return profile;
    }
}
