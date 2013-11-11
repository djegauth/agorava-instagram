package org.agorava.instagram.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.agorava.instagram.model.Comment;
import org.agorava.instagram.model.Image;
import org.agorava.instagram.model.InstagramProfile;
import org.agorava.instagram.model.Media;

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
        mapper.registerModule(new InstagramModule());
        jp.setCodec(mapper);

        JsonNode data = jp.readValueAsTree();
        JsonNode jsonProfile = data.get("user");
        InstagramProfile user = mapper.reader(new TypeReference<InstagramProfile>() {
        }).readValue(jsonProfile.toString());

        JsonNode captionNode = data.get("caption");
        Comment caption = mapper.readValue(captionNode.toString(), new TypeReference<Comment>() {});

        JsonNode commentsNode = data.get("comments");
        JsonNode commentListNode = commentsNode.get("data");
        List<Comment> comments = mapper.reader(new TypeReference<List<Comment>>() {
        }).readValue(commentListNode.toString());

        JsonNode likesNode = data.get("likes");
        JsonNode likesListNode = likesNode.get("data");
        List<InstagramProfile> likes = mapper.reader(new TypeReference<List<InstagramProfile>>() {
        }).readValue(likesListNode.toString());

        JsonNode imagesNode = data.get("images");
        Image lowResolution = mapper.reader(new TypeReference<Image>() {
        }).readValue(imagesNode.get("low_resolution").toString());
        Image thumbnail = mapper.reader(new TypeReference<Image>() {
        }).readValue(imagesNode.get("thumbnail").toString());
        Image standardResolution = mapper.reader(new TypeReference<Image>() {
        }).readValue(imagesNode.get("standard_resolution").toString());

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
