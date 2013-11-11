package org.agorava.instagram.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 16:16
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = InstagramProfileDeserializer.class)
public class InstagramProfileMixin {

}
