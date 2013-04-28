package org.agorava.instagram.jackson;

import org.agorava.instagram.model.Comment;
import org.agorava.instagram.model.InstagramProfile;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * User: Dje
 * Date: 28/04/13
 * Time: 18:50
 */
public class InstagramCommentDeserializer extends JsonDeserializer<Comment> {

    @Override
    public Comment deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDeserializationConfig(ctxt.getConfig());
        jp.setCodec(mapper);

        JsonNode data = jp.readValueAsTree();
        JsonNode jsonProfile = data.get("from");
        InstagramProfile profile = mapper.readValue(jsonProfile, InstagramProfile.class);
        System.out.println(profile.toString());
        Comment comment = new Comment(data.get("created_time").asLong(),
                data.get("id").asText(),
                data.get("text").asText(),
                profile
        );
        System.out.println(comment.toString());
        return comment;
    }
}
