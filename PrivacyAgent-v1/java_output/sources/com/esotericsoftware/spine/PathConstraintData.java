package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class PathConstraintData {
    public final java.lang.String a;
    public int b;
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.BoneData> c = new com.badlogic.gdx.utils.Array<>();
    public com.esotericsoftware.spine.SlotData d;
    public com.esotericsoftware.spine.PathConstraintData.PositionMode e;
    public com.esotericsoftware.spine.PathConstraintData.SpacingMode f;
    public com.esotericsoftware.spine.PathConstraintData.RotateMode g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;

    public enum PositionMode {
        fixed,
        percent;

        public static final com.esotericsoftware.spine.PathConstraintData.PositionMode[] values = values();
    }

    public enum RotateMode {
        tangent,
        chain,
        chainScale;

        public static final com.esotericsoftware.spine.PathConstraintData.RotateMode[] values = values();
    }

    public enum SpacingMode {
        length,
        fixed,
        percent;

        public static final com.esotericsoftware.spine.PathConstraintData.SpacingMode[] values = values();
    }

    public PathConstraintData(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("name cannot be null.");
        }
        this.a = str;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.BoneData> getBones() {
        return this.c;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public float getOffsetRotation() {
        return this.h;
    }

    public int getOrder() {
        return this.b;
    }

    public float getPosition() {
        return this.i;
    }

    public com.esotericsoftware.spine.PathConstraintData.PositionMode getPositionMode() {
        return this.e;
    }

    public float getRotateMix() {
        return this.k;
    }

    public com.esotericsoftware.spine.PathConstraintData.RotateMode getRotateMode() {
        return this.g;
    }

    public float getSpacing() {
        return this.j;
    }

    public com.esotericsoftware.spine.PathConstraintData.SpacingMode getSpacingMode() {
        return this.f;
    }

    public com.esotericsoftware.spine.SlotData getTarget() {
        return this.d;
    }

    public float getTranslateMix() {
        return this.l;
    }

    public void setOffsetRotation(float f) {
        this.h = f;
    }

    public void setOrder(int i) {
        this.b = i;
    }

    public void setPosition(float f) {
        this.i = f;
    }

    public void setPositionMode(com.esotericsoftware.spine.PathConstraintData.PositionMode positionMode) {
        this.e = positionMode;
    }

    public void setRotateMix(float f) {
        this.k = f;
    }

    public void setRotateMode(com.esotericsoftware.spine.PathConstraintData.RotateMode rotateMode) {
        this.g = rotateMode;
    }

    public void setSpacing(float f) {
        this.j = f;
    }

    public void setSpacingMode(com.esotericsoftware.spine.PathConstraintData.SpacingMode spacingMode) {
        this.f = spacingMode;
    }

    public void setTarget(com.esotericsoftware.spine.SlotData slotData) {
        this.d = slotData;
    }

    public void setTranslateMix(float f) {
        this.l = f;
    }

    public java.lang.String toString() {
        return this.a;
    }
}
