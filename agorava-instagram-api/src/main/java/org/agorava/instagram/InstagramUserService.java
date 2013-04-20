package org.agorava.instagram;

import org.agorava.instagram.model.InstagramProfile;

import java.util.List;

/**
 * User: Dje
 * Date: 19/04/13
 * Time: 23:46
 */
public interface InstagramUserService {

    InstagramProfile getUserProfile();

    InstagramProfile getUserProfile(String userId);

    /**
     * Search a user matching the String passed in args.
     * @param query : String to search
     * @return List of {@link InstagramProfile}
     */
    List<InstagramProfile> search(String query);

    /**
     * the API has an issue. No matter how much we put for the count, it always return 16 results
     * @param query : string to search
     * @param count : number of result
     * @return List of {@link InstagramProfile}
     */
    List<InstagramProfile> search(String query, int count);
}
