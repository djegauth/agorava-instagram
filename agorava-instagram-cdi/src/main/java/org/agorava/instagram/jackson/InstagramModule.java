package org.agorava.instagram.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.agorava.instagram.Instagram;
import org.agorava.instagram.model.Comment;
import org.agorava.instagram.model.Image;
import org.agorava.instagram.model.InstagramProfile;
import org.agorava.instagram.model.Media;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 09:35
 */
@Instagram
public class InstagramModule extends SimpleModule {

    public InstagramModule() {
        super("InstagramModule");
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(InstagramProfile.class, InstagramProfileMixin.class);
        context.setMixInAnnotations(Comment.class, InstagramCommentMixin.class);
        context.setMixInAnnotations(Image.class, InstagramImageMixin.class);
        context.setMixInAnnotations(Media.class, InstagramMediaMixin.class);
    }
}
