package org.agorava.instagram.cdi.test;

import org.agorava.api.atinject.Current;
import org.agorava.api.oauth.OAuthService;
import org.agorava.api.oauth.OAuthSession;
import org.agorava.api.oauth.Token;
import org.agorava.instagram.*;
import org.agorava.instagram.model.*;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.List;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 09:52
 */
@RunWith(Arquillian.class)
public class InstagramTest extends InstagramTestDeploy {

    @Inject
    @Instagram
    OAuthService service;

    @Inject
    @Instagram
    @Current
    OAuthSession sessionTest;

    @Inject
    org.agorava.api.service.OAuthLifeCycleService OAuthLifeCycleService;

    @Inject
    @Instagram
    InstagramUserService userService;
    @Inject
    InstagramRelationshipService relationshipService;
    @Inject
    InstagramCommentsService commentService;
    @Inject
    InstagramLikesService likesService;
    @Inject
    InstagramMediaService mediaService;

    @Before
    public void init() {
        Token token = new Token("30659961.1fb234f.8c1bb3f7eaac4ec0aae831e3c3e8acc8", "");
        sessionTest.setAccessToken(token);
        OAuthLifeCycleService.endDance();
    }

    @Test
    public void loginTest() {
        InstagramProfile profile = userService.getUserProfile();
        Assert.assertEquals("djegauth", profile.getUserName());
        Assert.assertEquals("It's an old story with me. I was born out of time.", profile.getBio());
        Assert.assertNotNull(profile.getCount());
    }

    @Test
    public void getUserProfileWithId() {
        InstagramProfile profile = userService.getUserProfile("1574083");
        Assert.assertEquals("snoopdogg", profile.getUserName());
    }

    @Test
    public void searchUser() {
        InstagramProfileList profileList = userService.search("marie");
        Assert.assertTrue(profileList.getProfiles().size() > 0);
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

    @Test
    public void getRelationship() {
        // Get
        Relationship relationship = relationshipService.getRelationship("4368630");
        Assert.assertNotNull(relationship);
        Assert.assertEquals("followed_by", relationship.getIncomingStatus());
        Assert.assertEquals("follows", relationship.getOutgoingStatus());

        // Update unfollow
        Relationship relationUpdate = relationshipService.updateRelationship("4368630", RelationshipAction.UNFOLLOW);
        Assert.assertNotNull(relationUpdate);
        Assert.assertEquals("none", relationUpdate.getOutgoingStatus());

        // Update follow
        relationUpdate = relationshipService.updateRelationship("4368630", RelationshipAction.FOLLOW);
        Assert.assertNotNull(relationUpdate);
        Assert.assertEquals("follows", relationUpdate.getOutgoingStatus());
    }

    @Test
    public void getComments() {
        List<Comment> list = commentService.getComments("424654008017062099_30659961");
        Assert.assertEquals(1, list.size());
        Comment comment = list.get(0);
        Assert.assertEquals("Et l'Expo était vraiment top", comment.getText());
        Assert.assertEquals("djegauth", comment.getFrom().getUserName());
    }

    @Test
    public void testLikes() {
        List<InstagramProfile> list = likesService.getLikes("424654008017062099_30659961");
        Assert.assertEquals(2, list.size());

        likesService.postLike("424654008017062099_30659961");
        list = likesService.getLikes("424654008017062099_30659961");
        Assert.assertEquals(3, list.size());

        likesService.deleteLike("424654008017062099_30659961");
        list = likesService.getLikes("424654008017062099_30659961");
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void getMedia() {
        Media media = mediaService.getMedia("447049573353439230_4368630");
        Assert.assertEquals("447049573353439230_4368630", media.getId());
        Assert.assertEquals("Valencia", media.getFilter());
        Assert.assertEquals("image", media.getType());
        Assert.assertEquals(Integer.valueOf(17), media.getCommentsCount());
        Assert.assertEquals(8, media.getComments().size());
        Assert.assertEquals("2eme édition en préparation #boxdescreatrices", media.getCaption().getText());
        Assert.assertEquals(Long.valueOf(1367512483), media.getCreatedTime());
        Assert.assertEquals("http://instagram.com/p/Y0PTfouL_-/", media.getLink());
        Assert.assertEquals(Integer.valueOf(87), media.getLikesCount());
        Assert.assertEquals(4, media.getLikes().size());
        Assert.assertEquals(Integer.valueOf(306), media.getLowResolution().getWidth());
        Assert.assertEquals(Integer.valueOf(150), media.getThumbnail().getWidth());
        Assert.assertEquals(Integer.valueOf(612), media.getStandardResolution().getWidth());
        Assert.assertFalse(media.isUserHasLiked());
    }

    @Test
    public void getPopular() {
        List<Media> listMedia = mediaService.getPopular();
        Assert.assertNotNull(listMedia);
        Assert.assertTrue(listMedia.size() > 0);
    }

}
