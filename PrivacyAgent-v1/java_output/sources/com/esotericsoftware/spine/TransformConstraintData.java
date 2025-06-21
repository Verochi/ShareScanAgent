package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class TransformConstraintData {
    public final java.lang.String a;
    public int b;
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.BoneData> c = new com.badlogic.gdx.utils.Array<>();
    public com.esotericsoftware.spine.BoneData d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public boolean o;
    public boolean p;

    public TransformConstraintData(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("name cannot be null.");
        }
        this.a = str;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.BoneData> getBones() {
        return this.c;
    }

    public boolean getLocal() {
        return this.p;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public float getOffsetRotation() {
        return this.i;
    }

    public float getOffsetScaleX() {
        return this.l;
    }

    public float getOffsetScaleY() {
        return this.m;
    }

    public float getOffsetShearY() {
        return this.n;
    }

    public float getOffsetX() {
        return this.j;
    }

    public float getOffsetY() {
        return this.k;
    }

    public int getOrder() {
        return this.b;
    }

    public boolean getRelative() {
        return this.o;
    }

    public float getRotateMix() {
        return this.e;
    }

    public float getScaleMix() {
        return this.g;
    }

    public float getShearMix() {
        return this.h;
    }

    public com.esotericsoftware.spine.BoneData getTarget() {
        return this.d;
    }

    public float getTranslateMix() {
        return this.f;
    }

    public void setLocal(boolean z) {
        this.p = z;
    }

    public void setOffsetRotation(float f) {
        this.i = f;
    }

    public void setOffsetScaleX(float f) {
        this.l = f;
    }

    public void setOffsetScaleY(float f) {
        this.m = f;
    }

    public void setOffsetShearY(float f) {
        this.n = f;
    }

    public void setOffsetX(float f) {
        this.j = f;
    }

    public void setOffsetY(float f) {
        this.k = f;
    }

    public void setOrder(int i) {
        this.b = i;
    }

    public void setRelative(boolean z) {
        this.o = z;
    }

    public void setRotateMix(float f) {
        this.e = f;
    }

    public void setScaleMix(float f) {
        this.g = f;
    }

    public void setShearMix(float f) {
        this.h = f;
    }

    public void setTarget(com.esotericsoftware.spine.BoneData boneData) {
        if (boneData == null) {
            throw new java.lang.IllegalArgumentException("target cannot be null.");
        }
        this.d = boneData;
    }

    public void setTranslateMix(float f) {
        this.f = f;
    }

    public java.lang.String toString() {
        return this.a;
    }
}
