package org.agorava.instagram;

import org.agorava.instagram.model.Media;

import java.util.List;

/**
 * User: Dje
 * Date: 04/05/13
 * Time: 13:58
 */
public interface InstagramMediaService {

    /**
     * Get information about a {@link Media} object
     *
     * @param mediaId : media's Id
     * @return {@link Media}
     */
    Media getMedia(String mediaId);

    /**
     * Get a list of what media is most popular at the moment.
     *
     * @return a list of {@link Media}
     */
    List<Media> getPopular();
}
