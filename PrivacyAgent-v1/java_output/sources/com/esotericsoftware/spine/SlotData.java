package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class SlotData {
    public final int a;
    public final java.lang.String b;
    public final com.esotericsoftware.spine.BoneData c;
    public final com.badlogic.gdx.graphics.Color d = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
    public com.badlogic.gdx.graphics.Color e;
    public java.lang.String f;
    public com.esotericsoftware.spine.BlendMode g;

    public SlotData(int i, java.lang.String str, com.esotericsoftware.spine.BoneData boneData) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("index must be >= 0.");
        }
        if (str == null) {
            throw new java.lang.IllegalArgumentException("name cannot be null.");
        }
        if (boneData == null) {
            throw new java.lang.IllegalArgumentException("boneData cannot be null.");
        }
        this.a = i;
        this.b = str;
        this.c = boneData;
    }

    public java.lang.String getAttachmentName() {
        return this.f;
    }

    public com.esotericsoftware.spine.BlendMode getBlendMode() {
        return this.g;
    }

    public com.esotericsoftware.spine.BoneData getBoneData() {
        return this.c;
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        return this.d;
    }

    public com.badlogic.gdx.graphics.Color getDarkColor() {
        return this.e;
    }

    public int getIndex() {
        return this.a;
    }

    public java.lang.String getName() {
        return this.b;
    }

    public void setAttachmentName(java.lang.String str) {
        this.f = str;
    }

    public void setBlendMode(com.esotericsoftware.spine.BlendMode blendMode) {
        this.g = blendMode;
    }

    public void setDarkColor(com.badlogic.gdx.graphics.Color color) {
        this.e = color;
    }

    public java.lang.String toString() {
        return this.b;
    }
}
