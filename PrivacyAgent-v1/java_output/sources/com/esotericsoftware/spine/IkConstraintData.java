package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class IkConstraintData {
    public final java.lang.String a;
    public int b;
    public com.esotericsoftware.spine.BoneData d;
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.BoneData> c = new com.badlogic.gdx.utils.Array<>();
    public int e = 1;
    public float f = 1.0f;

    public IkConstraintData(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("name cannot be null.");
        }
        this.a = str;
    }

    public int getBendDirection() {
        return this.e;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.BoneData> getBones() {
        return this.c;
    }

    public float getMix() {
        return this.f;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public int getOrder() {
        return this.b;
    }

    public com.esotericsoftware.spine.BoneData getTarget() {
        return this.d;
    }

    public void setBendDirection(int i) {
        this.e = i;
    }

    public void setMix(float f) {
        this.f = f;
    }

    public void setOrder(int i) {
        this.b = i;
    }

    public void setTarget(com.esotericsoftware.spine.BoneData boneData) {
        if (boneData == null) {
            throw new java.lang.IllegalArgumentException("target cannot be null.");
        }
        this.d = boneData;
    }

    public java.lang.String toString() {
        return this.a;
    }
}
