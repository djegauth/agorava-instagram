package org.agorava.instagram.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.agorava.instagram.model.Count;
import org.agorava.instagram.model.InstagramProfile;

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
                data.get("profile_picture").asText());
        if (data.has("bio")) {
            profile.setBio(data.get("bio").asText());
        }
        if (data.has("website")) {
            profile.setWebsite(data.get("website").asText());
        }
        if (data.has("counts")) {
            JsonNode countsNode = data.get("counts");
            Count counts = new Count(countsNode.get("followed_by").asInt(),
                    countsNode.get("media").asInt(),
                    countsNode.get("follows").asInt());
            profile.setCount(counts);
        }
        return profile;
    }
}
