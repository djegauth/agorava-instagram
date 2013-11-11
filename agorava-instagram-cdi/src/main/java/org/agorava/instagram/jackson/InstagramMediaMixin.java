package org.agorava.instagram.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * User: Dje
 * Date: 04/05/13
 * Time: 17:59
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = InstagramMediaDeserializer.class)
public class InstagramMediaMixin {
}
