package org.agorava.instagram.model;

import org.agorava.core.api.UserProfile;

/**
 * User: Dje
 * Date: 19/04/13
 * Time: 23:48
 */
public class InstagramProfile extends UserProfile {

    private final String userName;
    private final String fullName;
    private final String profileImageUrl;
    private final String bio;
    private final String website;

    public InstagramProfile(String id, String userName, String fullName, String profileImageUrl, String bio, String website ) {
        super(id);
        this.userName = userName;
        this.fullName = fullName;
        this.profileImageUrl = profileImageUrl;
        this.bio = bio;
        this.website = website;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public String getBio() {
        return bio;
    }

    public String getUserName() {
        return userName;
    }

    public String getWebsite() {
        return website;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("InstagramProfile{");
        sb.append("bio='").append(bio).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", profileImageUrl='").append(profileImageUrl).append('\'');
        sb.append(", website='").append(website).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
