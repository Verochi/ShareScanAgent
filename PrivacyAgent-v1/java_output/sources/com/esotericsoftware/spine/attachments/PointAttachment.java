package com.esotericsoftware.spine.attachments;

/* loaded from: classes22.dex */
public class PointAttachment extends com.esotericsoftware.spine.attachments.Attachment {
    public float b;
    public float c;
    public float d;
    public final com.badlogic.gdx.graphics.Color e;

    public PointAttachment(java.lang.String str) {
        super(str);
        this.e = new com.badlogic.gdx.graphics.Color(0.9451f, 0.9451f, 0.0f, 1.0f);
    }

    public com.badlogic.gdx.math.Vector2 computeWorldPosition(com.esotericsoftware.spine.Bone bone, com.badlogic.gdx.math.Vector2 vector2) {
        vector2.x = (this.b * bone.getA()) + (this.c * bone.getB()) + bone.getWorldX();
        vector2.y = (this.b * bone.getC()) + (this.c * bone.getD()) + bone.getWorldY();
        return vector2;
    }

    public float computeWorldRotation(com.esotericsoftware.spine.Bone bone) {
        float cosDeg = com.badlogic.gdx.math.MathUtils.cosDeg(this.d);
        float sinDeg = com.badlogic.gdx.math.MathUtils.sinDeg(this.d);
        return ((float) java.lang.Math.atan2((cosDeg * bone.getC()) + (sinDeg * bone.getD()), (bone.getA() * cosDeg) + (bone.getB() * sinDeg))) * 57.295776f;
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        return this.e;
    }

    public float getRotation() {
        return this.d;
    }

    public float getX() {
        return this.b;
    }

    public float getY() {
        return this.c;
    }

    public void setRotation(float f) {
        this.d = f;
    }

    public void setX(float f) {
        this.b = f;
    }

    public void setY(float f) {
        this.c = f;
    }
}
