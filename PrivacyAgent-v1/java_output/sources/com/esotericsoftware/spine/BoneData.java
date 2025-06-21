package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class BoneData {
    public final int a;
    public final java.lang.String b;
    public final com.esotericsoftware.spine.BoneData c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public com.esotericsoftware.spine.BoneData.TransformMode l;
    public final com.badlogic.gdx.graphics.Color m;

    public enum TransformMode {
        normal,
        onlyTranslation,
        noRotationOrReflection,
        noScale,
        noScaleOrReflection;

        public static final com.esotericsoftware.spine.BoneData.TransformMode[] values = values();
    }

    public BoneData(int i, java.lang.String str, com.esotericsoftware.spine.BoneData boneData) {
        this.h = 1.0f;
        this.i = 1.0f;
        this.l = com.esotericsoftware.spine.BoneData.TransformMode.normal;
        this.m = new com.badlogic.gdx.graphics.Color(0.61f, 0.61f, 0.61f, 1.0f);
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("index must be >= 0.");
        }
        if (str == null) {
            throw new java.lang.IllegalArgumentException("name cannot be null.");
        }
        this.a = i;
        this.b = str;
        this.c = boneData;
    }

    public BoneData(com.esotericsoftware.spine.BoneData boneData, com.esotericsoftware.spine.BoneData boneData2) {
        this.h = 1.0f;
        this.i = 1.0f;
        this.l = com.esotericsoftware.spine.BoneData.TransformMode.normal;
        this.m = new com.badlogic.gdx.graphics.Color(0.61f, 0.61f, 0.61f, 1.0f);
        if (boneData == null) {
            throw new java.lang.IllegalArgumentException("bone cannot be null.");
        }
        this.a = boneData.a;
        this.b = boneData.b;
        this.c = boneData2;
        this.d = boneData.d;
        this.e = boneData.e;
        this.f = boneData.f;
        this.g = boneData.g;
        this.h = boneData.h;
        this.i = boneData.i;
        this.j = boneData.j;
        this.k = boneData.k;
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        return this.m;
    }

    public int getIndex() {
        return this.a;
    }

    public float getLength() {
        return this.d;
    }

    public java.lang.String getName() {
        return this.b;
    }

    public com.esotericsoftware.spine.BoneData getParent() {
        return this.c;
    }

    public float getRotation() {
        return this.g;
    }

    public float getScaleX() {
        return this.h;
    }

    public float getScaleY() {
        return this.i;
    }

    public float getShearX() {
        return this.j;
    }

    public float getShearY() {
        return this.k;
    }

    public com.esotericsoftware.spine.BoneData.TransformMode getTransformMode() {
        return this.l;
    }

    public float getX() {
        return this.e;
    }

    public float getY() {
        return this.f;
    }

    public void setLength(float f) {
        this.d = f;
    }

    public void setPosition(float f, float f2) {
        this.e = f;
        this.f = f2;
    }

    public void setRotation(float f) {
        this.g = f;
    }

    public void setScale(float f, float f2) {
        this.h = f;
        this.i = f2;
    }

    public void setScaleX(float f) {
        this.h = f;
    }

    public void setScaleY(float f) {
        this.i = f;
    }

    public void setShearX(float f) {
        this.j = f;
    }

    public void setShearY(float f) {
        this.k = f;
    }

    public void setTransformMode(com.esotericsoftware.spine.BoneData.TransformMode transformMode) {
        this.l = transformMode;
    }

    public void setX(float f) {
        this.e = f;
    }

    public void setY(float f) {
        this.f = f;
    }

    public java.lang.String toString() {
        return this.b;
    }
}
