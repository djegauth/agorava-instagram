package org.agorava.instagram.jackson;

import org.agorava.instagram.model.Comment;
import org.agorava.instagram.model.Image;
import org.agorava.instagram.model.InstagramProfile;
import org.agorava.instagram.model.Media;
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
 * Date: 04/05/13
 * Time: 14:11
 */
public class InstagramMediaDeserializer extends JsonDeserializer<Media> {

    @Override
    public Media deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDeserializationConfig(ctxt.getConfig());
        jp.setCodec(mapper);

        JsonNode data = jp.readValueAsTree();
        JsonNode jsonProfile = data.get("user");
        InstagramProfile user = mapper.readValue(jsonProfile, InstagramProfile.class);

        JsonNode captionNode = data.get("caption");
        Comment caption = mapper.readValue(captionNode, Comment.class);

        JsonNode commentsNode = data.get("comments");
        JsonNode commentListNode = commentsNode.get("data");
        List<Comment> comments = mapper.readValue(commentListNode, new TypeReference<List<Comment>>() {
        });

        JsonNode likesNode = data.get("likes");
        JsonNode likesListNode = likesNode.get("data");
        List<InstagramProfile> likes = mapper.readValue(likesListNode, new TypeReference<List<InstagramProfile>>() {
        });

        JsonNode imagesNode = data.get("images");
        Image lowResolution = mapper.readValue(imagesNode.get("low_resolution"), Image.class);
        Image thumbnail = mapper.readValue(imagesNode.get("thumbnail"), Image.class);
        Image standardResolution = mapper.readValue(imagesNode.get("standard_resolution"), Image.class);

        return new Media(data.get("id").asText(),
                user,
                data.get("type").asText(),
                data.get("filter").asText(),
                commentsNode.get("count").asInt(),
                comments,
                caption,
                data.get("created_time").asLong(),
                data.get("link").asText(),
                likesNode.get("count").asInt(),
                likes,
                lowResolution,
                thumbnail,
                standardResolution,
                data.get("user_has_liked").asBoolean());
    }
}
