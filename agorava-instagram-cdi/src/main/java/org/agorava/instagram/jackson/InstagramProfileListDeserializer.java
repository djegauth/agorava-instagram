package org.agorava.instagram.jackson;

import org.agorava.instagram.model.InstagramProfile;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 18:12
 */
public class InstagramProfileListDeserializer extends JsonDeserializer<List<InstagramProfile>> {

    @Override
    public List<InstagramProfile> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDeserializationConfig(ctxt.getConfig());
        jp.setCodec(mapper);

        JsonNode dataNode = jp.readValueAsTree();
        return mapper.readValue(dataNode, new TypeReference<List<InstagramProfile>>() {
        });
    }
}
