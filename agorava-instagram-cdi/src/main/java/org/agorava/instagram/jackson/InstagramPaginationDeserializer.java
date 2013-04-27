package org.agorava.instagram.jackson;

import org.agorava.instagram.model.Pagination;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;

/**
 * User: Dje
 * Date: 27/04/13
 * Time: 10:40
 */
public class InstagramPaginationDeserializer extends JsonDeserializer<Pagination> {

    @Override
    public Pagination deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode pag = jp.readValueAsTree();
        Pagination pagination = null;
        if (pag.has("next_url")) {
            pagination = new Pagination(pag.get("next_url").asText(),
                    pag.get("next_cursor").asText());
        }
        return pagination;
    }
}
