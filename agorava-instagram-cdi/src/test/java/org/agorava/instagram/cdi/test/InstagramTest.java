package org.agorava.instagram.cdi.test;

import org.agorava.Instagram;
import org.agorava.core.api.SocialMediaApiHub;
import org.agorava.core.api.oauth.OAuthToken;
import org.agorava.core.oauth.scribe.OAuthTokenScribe;
import org.agorava.instagram.InstagramUserService;
import org.agorava.instagram.model.InstagramProfile;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.io.File;
import java.io.FileNotFoundException;

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

    @Deployment
    public static Archive<?> createTestArchive() throws FileNotFoundException {

        String path = "F:\\Dev\\Agorava\\agorava-instagram\\agorava-instagram-api\\target\\agorava-instagram-api.jar";

        WebArchive ret = ShrinkWrap
                .create(WebArchive.class, "test.war")
                .addPackages(true, "org.agorava")
                .addClass(InstagramServiceProducer.class)
                .addAsLibraries(new File(path));
        System.out.println(System.getProperty("arquillian"));
        if (("weld-ee-embedded-1.1".equals(System.getProperty("arquillian")) || System.getProperty("arquillian") == null)) {
            // Don't embed dependencies that are already in the CL in the embedded container from surefire
            /*ret.addAsLibraries(DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml")
                    .artifact("org.jboss.solder:solder-impl").resolveAs(GenericArchive.class));
       */
        } else {
            ret.addAsLibraries(DependencyResolvers.use(MavenDependencyResolver.class)
                    .loadMetadataFromPom("pom.xml")
                    .artifact("org.jboss.solder:solder-impl")
                    .artifact("org.scribe:scribe")
                    .artifact("org.apache.commons:commons-lang3")
                    .artifact("org.codehaus.jackson:jackson-mapper-asl")
                    .artifact("com.google.guava:guava").resolveAsFiles());
        }
        return ret;
    }

    @Before
    public void init() {
        System.out.println("init");
        OAuthToken token = new OAuthTokenScribe("30659961.1fb234f.8c1bb3f7eaac4ec0aae831e3c3e8acc8", "");
        System.out.println("servicehub : " + serviceHub.getSocialMediaName());
        serviceHub.getSession().setAccessToken(token);
        serviceHub.getService().initAccessToken();
    }

    @Test
    public void loginTest() {
        InstagramProfile profile = userService.getUserProfile();
        System.out.println(profile.toString());
        Assert.assertEquals("30659961", profile.getId());
    }

}