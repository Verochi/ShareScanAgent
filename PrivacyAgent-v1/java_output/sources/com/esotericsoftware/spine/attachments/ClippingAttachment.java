package com.esotericsoftware.spine.attachments;

/* loaded from: classes22.dex */
public class ClippingAttachment extends com.esotericsoftware.spine.attachments.VertexAttachment {
    public com.esotericsoftware.spine.SlotData g;
    public final com.badlogic.gdx.graphics.Color h;

    public ClippingAttachment(java.lang.String str) {
        super(str);
        this.h = new com.badlogic.gdx.graphics.Color(0.2275f, 0.2275f, 0.8078f, 1.0f);
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        return this.h;
    }

    public com.esotericsoftware.spine.SlotData getEndSlot() {
        return this.g;
    }

    public void setEndSlot(com.esotericsoftware.spine.SlotData slotData) {
        this.g = slotData;
    }
}
