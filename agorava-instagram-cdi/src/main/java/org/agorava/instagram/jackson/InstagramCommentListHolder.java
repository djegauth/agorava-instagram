package org.agorava.instagram.jackson;

import org.agorava.instagram.model.Comment;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * User: Dje
 * Date: 28/04/13
 * Time: 18:50
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramCommentListHolder {

    private final List<Comment> list;

    @JsonCreator
    public InstagramCommentListHolder(@JsonProperty("data") List<Comment> list) {
        this.list = list;
    }

    public List<Comment> getList() {
        return list;
    }
}
