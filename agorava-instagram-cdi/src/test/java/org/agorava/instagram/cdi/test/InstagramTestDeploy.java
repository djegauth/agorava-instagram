package org.agorava.instagram.cdi.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.*;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: Dje
 * Date: 10/11/13
 * Time: 12:27
 */
public class InstagramTestDeploy {

    @Deployment
    public static Archive<?> createTestArchive() throws FileNotFoundException {
        JavaArchive testJar = ShrinkWrap.create(JavaArchive.class, "all-agorava.jar")
                .addPackages(true, new Filter<ArchivePath>() {
                    @Override
                    public boolean include(ArchivePath path) {
                        return !((path.get().contains("test") || path.get().contains("servlet") || path.get().contains
                                ("jsf")));
                    }
                }, "org.agorava")
                .addAsResource("META-INF/services/javax.enterprise.inject.spi.Extension")
                .addAsResource("META-INF/services/org.apache.deltaspike.core.spi.config.ConfigSourceProvider")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        GenericArchive[] libs = Maven.resolver()
                .loadPomFromFile("pom.xml")
                .resolve("org.apache.deltaspike.core:deltaspike-core-impl:0.5")
                .withTransitivity().as(GenericArchive.class);

        return ShrinkWrap
                .create(WebArchive.class, "test.war")
                .addPackages(true, "org.agorava")
                .addClass(InstagramServiceProducer.class)
                .addAsLibraries(libs)
                .addAsLibraries(testJar)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("agorava.properties");
    }
}
