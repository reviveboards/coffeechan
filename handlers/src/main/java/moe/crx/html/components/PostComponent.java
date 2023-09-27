package moe.crx.html.components;

import moe.crx.dto.Post;

import static moe.crx.core.util.ReflectionUtil.getAllFields;

public final class PostComponent extends AbstractComponent<PostComponent> {

    public PostComponent() {
        super("/frontend/components/post.html");
    }

    public PostComponent consumePost(Post post) {
        consumeFields(post);

        return this;
    }
}
