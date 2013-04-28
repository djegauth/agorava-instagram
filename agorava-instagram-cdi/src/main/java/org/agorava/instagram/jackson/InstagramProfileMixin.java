package org.agorava.instagram.jackson;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 16:16
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = InstagramProfileDeserializer.class)
public class InstagramProfileMixin {

}
