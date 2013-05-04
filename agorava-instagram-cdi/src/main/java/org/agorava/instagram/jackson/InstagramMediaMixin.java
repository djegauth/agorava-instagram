package org.agorava.instagram.jackson;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * User: Dje
 * Date: 04/05/13
 * Time: 17:59
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = InstagramMediaDeserializer.class)
public class InstagramMediaMixin {
}
