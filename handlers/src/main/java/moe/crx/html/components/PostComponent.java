package moe.crx.html.components;

import moe.crx.dto.Post;

public final class PostComponent extends AbstractComponent<PostComponent> {

    public PostComponent() {
        super("/frontend/components/post.html");
    }

    public PostComponent consumePost(Post post) {
        return this;
    }
}
