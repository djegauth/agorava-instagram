package org.agorava.instagram.cdi.test;

import org.agorava.Instagram;
import org.agorava.core.api.SocialMediaApiHub;
import org.agorava.core.api.oauth.OAuthToken;
import org.agorava.core.oauth.scribe.OAuthTokenScribe;
import org.agorava.instagram.InstagramRelationshipService;
import org.agorava.instagram.InstagramUserService;
import org.agorava.instagram.model.InstagramProfile;
import org.agorava.instagram.model.InstagramProfileList;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 09:52
 */
@RunWith(Arquillian.class)
public class InstagramTest {

    @Inject
    @Instagram
    SocialMediaApiHub serviceHub;

    @Inject
    InstagramUserService userService;

    @Inject
    InstagramRelationshipService relationshipService;

    @Deployment
    public static Archive<?> createTestArchive() throws FileNotFoundException {

        WebArchive ret = ShrinkWrap
                .create(WebArchive.class, "test.war")
                .addPackages(true, "org.agorava")
                .addClass(InstagramServiceProducer.class);

        return ret;
    }

    @Before
    public void init() {
        OAuthToken token = new OAuthTokenScribe("30659961.1fb234f.8c1bb3f7eaac4ec0aae831e3c3e8acc8", "");
        serviceHub.getSession().setAccessToken(token);
        serviceHub.getService().initAccessToken();
    }

    @Test
    public void loginTest() {
        InstagramProfile profile = userService.getUserProfile();
        Assert.assertEquals("djegauth", profile.getUserName());
    }

    @Test
    public void getUserProfileWithId() {
        InstagramProfile profile = userService.getUserProfile("1574083");
        Assert.assertEquals("snoopdogg", profile.getUserName());
    }

    @Test
    public void searchUser() {
        InstagramProfileList profileList = userService.search("marie");
        Assert.assertEquals(16, profileList.getProfiles().size());
    }

    @Test
    public void getFollowsTest() {
        InstagramProfileList followingList = relationshipService.getFollows("30659961");
        Assert.assertTrue(followingList.getProfiles().size() > 0);
        Assert.assertNull(followingList.getPagination());
        System.out.println("djegauth follows " + followingList.getProfiles().size() + " instagrammers");
    }

    @Test
    public void getFollowsPaginationTest() {
        InstagramProfileList followingList = relationshipService.getFollows("1574083");
        Assert.assertTrue(followingList.getProfiles().size() > 0);
        Assert.assertNotNull(followingList.getPagination());
        System.out.println("SnoopDog follows " + followingList.getProfiles().size() + " instagrammers");
        InstagramProfileList followingListPagination = relationshipService.getFollows("1574083", followingList.getPagination().getNextCursor());
        Assert.assertTrue(followingListPagination.getProfiles().size() > 0);
    }

    @Test
    public void getFollowedByTest() {
        InstagramProfileList followerList = relationshipService.getFollowedBy("30659961");
        Assert.assertTrue(followerList.getProfiles().size() > 0);
        Assert.assertNull(followerList.getPagination());
        System.out.println("djegauth has " + followerList.getProfiles().size() + " followers and no pagination");
    }

    @Test
    public void getFollowedByPaginationTest() {
        InstagramProfileList followerList = relationshipService.getFollowedBy("1574083");
        Assert.assertTrue(followerList.getProfiles().size() > 0);
        Assert.assertNotNull(followerList.getPagination());
        System.out.println("SnoopDog has " + followerList.getProfiles().size() + " followers and pagination");
        InstagramProfileList followerListPagination = relationshipService.getFollowedBy("1574083", followerList.getPagination().getNextCursor());
        Assert.assertTrue(followerListPagination.getProfiles().size() > 0);
    }

    @Test
    public void getRequestByTest() {
        List<InstagramProfile> requested = relationshipService.getRequestBy();
        System.out.println(requested.size() + " want to follow SnoopDog");
        Assert.assertNotNull(requested);
    }

}
