package org.agorava.instagram.jackson;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * User: Dje
 * Date: 28/04/13
 * Time: 19:25
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = InstagramCommentDeserializer.class)
public class InstagramCommentMixin {
}
