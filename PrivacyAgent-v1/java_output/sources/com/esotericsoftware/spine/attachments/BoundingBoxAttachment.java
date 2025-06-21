package com.esotericsoftware.spine.attachments;

/* loaded from: classes22.dex */
public class BoundingBoxAttachment extends com.esotericsoftware.spine.attachments.VertexAttachment {
    public final com.badlogic.gdx.graphics.Color g;

    public BoundingBoxAttachment(java.lang.String str) {
        super(str);
        this.g = new com.badlogic.gdx.graphics.Color(0.38f, 0.94f, 0.0f, 1.0f);
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        return this.g;
    }
}
