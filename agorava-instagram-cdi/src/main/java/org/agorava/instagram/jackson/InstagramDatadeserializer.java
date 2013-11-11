package org.agorava.instagram.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * User: Dje
 * Date: 04/05/13
 * Time: 13:25
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramDataDeserializer {

    public InstagramDataDeserializer() {
    }
}
