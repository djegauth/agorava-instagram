package org.agorava.instagram.jackson;

import org.agorava.instagram.model.InstagramProfile;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;

import java.io.IOException;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 12:31
 */
public class InstagramProfileDeserializer extends JsonDeserializer<InstagramProfile> {

    @Override
    public InstagramProfile deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode data = jsonParser.readValueAsTree();
        InstagramProfile profile = new InstagramProfile(data.get("id").asText(),
                data.get("username").asText(),
                data.get("full_name").asText(),
                data.get("profile_picture").asText(),
                data.get("bio").asText(),
                data.get("website").asText());
        return profile;
    }

}
