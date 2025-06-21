package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class Slot {
    public final com.esotericsoftware.spine.SlotData a;
    public final com.esotericsoftware.spine.Bone b;
    public final com.badlogic.gdx.graphics.Color c;
    public final com.badlogic.gdx.graphics.Color d;
    public com.esotericsoftware.spine.attachments.Attachment e;
    public float f;
    public com.badlogic.gdx.utils.FloatArray g;

    public Slot(com.esotericsoftware.spine.Slot slot, com.esotericsoftware.spine.Bone bone) {
        com.badlogic.gdx.graphics.Color color = new com.badlogic.gdx.graphics.Color();
        this.c = color;
        this.g = new com.badlogic.gdx.utils.FloatArray();
        if (slot == null) {
            throw new java.lang.IllegalArgumentException("slot cannot be null.");
        }
        if (bone == null) {
            throw new java.lang.IllegalArgumentException("bone cannot be null.");
        }
        this.a = slot.a;
        this.b = bone;
        color.set(slot.c);
        this.d = slot.d == null ? null : new com.badlogic.gdx.graphics.Color(slot.d);
        this.e = slot.e;
        this.f = slot.f;
    }

    public Slot(com.esotericsoftware.spine.SlotData slotData, com.esotericsoftware.spine.Bone bone) {
        this.c = new com.badlogic.gdx.graphics.Color();
        this.g = new com.badlogic.gdx.utils.FloatArray();
        if (slotData == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null.");
        }
        if (bone == null) {
            throw new java.lang.IllegalArgumentException("bone cannot be null.");
        }
        this.a = slotData;
        this.b = bone;
        this.d = slotData.e == null ? null : new com.badlogic.gdx.graphics.Color();
        setToSetupPose();
    }

    public com.esotericsoftware.spine.attachments.Attachment getAttachment() {
        return this.e;
    }

    public float getAttachmentTime() {
        return this.b.b.l - this.f;
    }

    public com.badlogic.gdx.utils.FloatArray getAttachmentVertices() {
        return this.g;
    }

    public com.esotericsoftware.spine.Bone getBone() {
        return this.b;
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        return this.c;
    }

    public com.badlogic.gdx.graphics.Color getDarkColor() {
        return this.d;
    }

    public com.esotericsoftware.spine.SlotData getData() {
        return this.a;
    }

    public com.esotericsoftware.spine.Skeleton getSkeleton() {
        return this.b.b;
    }

    public void setAttachment(com.esotericsoftware.spine.attachments.Attachment attachment) {
        if (this.e == attachment) {
            return;
        }
        this.e = attachment;
        this.f = this.b.b.l;
        this.g.clear();
    }

    public void setAttachmentTime(float f) {
        this.f = this.b.b.l - f;
    }

    public void setAttachmentVertices(com.badlogic.gdx.utils.FloatArray floatArray) {
        if (floatArray == null) {
            throw new java.lang.IllegalArgumentException("attachmentVertices cannot be null.");
        }
        this.g = floatArray;
    }

    public void setToSetupPose() {
        this.c.set(this.a.d);
        com.badlogic.gdx.graphics.Color color = this.d;
        if (color != null) {
            color.set(this.a.e);
        }
        com.esotericsoftware.spine.SlotData slotData = this.a;
        java.lang.String str = slotData.f;
        if (str == null) {
            setAttachment(null);
        } else {
            this.e = null;
            setAttachment(this.b.b.getAttachment(slotData.a, str));
        }
    }

    public java.lang.String toString() {
        return this.a.b;
    }
}
