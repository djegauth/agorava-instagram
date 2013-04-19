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
    private final Counts counts;


    protected InstagramProfile(String id, String userName, String fullName, String profileImageUrl, String bio, String website, Counts counts) {
        super(id);
        this.userName = userName;
        this.fullName = fullName;
        this.profileImageUrl = profileImageUrl;
        this.bio = bio;
        this.website = website;
        this.counts = counts;
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

    public Counts getCounts() {
        return counts;
    }

    public String getWebsite() {
        return website;
    }
}
