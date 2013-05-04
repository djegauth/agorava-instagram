package org.agorava.instagram.jackson;

import org.agorava.Instagram;
import org.agorava.instagram.model.Comment;
import org.agorava.instagram.model.Image;
import org.agorava.instagram.model.InstagramProfile;
import org.agorava.instagram.model.Media;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 09:35
 */
@Instagram
public class InstragramModule extends SimpleModule {

    public InstragramModule() {
        super("InstagramModule", new Version(1, 0, 0, null));
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(InstagramProfile.class, InstagramProfileMixin.class);
        context.setMixInAnnotations(Comment.class, InstagramCommentMixin.class);
        context.setMixInAnnotations(Image.class, InstagramImageMixin.class);
        context.setMixInAnnotations(Media.class, InstagramMediaMixin.class);
    }
}
