package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class SkeletonData {
    public java.lang.String a;
    public com.esotericsoftware.spine.Skin e;
    public float k;
    public float l;
    public java.lang.String m;
    public java.lang.String n;
    public java.lang.String p;
    public java.lang.String q;
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.BoneData> b = new com.badlogic.gdx.utils.Array<>();
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.SlotData> c = new com.badlogic.gdx.utils.Array<>();
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Skin> d = new com.badlogic.gdx.utils.Array<>();
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.EventData> f = new com.badlogic.gdx.utils.Array<>();
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Animation> g = new com.badlogic.gdx.utils.Array<>();
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.IkConstraintData> h = new com.badlogic.gdx.utils.Array<>();
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.TransformConstraintData> i = new com.badlogic.gdx.utils.Array<>();
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.PathConstraintData> j = new com.badlogic.gdx.utils.Array<>();
    public float o = 30.0f;

    public com.esotericsoftware.spine.Animation findAnimation(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("animationName cannot be null.");
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Animation> array = this.g;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.Animation animation = array.get(i2);
            if (animation.a.equals(str)) {
                return animation;
            }
        }
        return null;
    }

    public com.esotericsoftware.spine.BoneData findBone(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("boneName cannot be null.");
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.BoneData> array = this.b;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.BoneData boneData = array.get(i2);
            if (boneData.b.equals(str)) {
                return boneData;
            }
        }
        return null;
    }

    public com.esotericsoftware.spine.EventData findEvent(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("eventDataName cannot be null.");
        }
        java.util.Iterator<com.esotericsoftware.spine.EventData> it = this.f.iterator();
        while (it.hasNext()) {
            com.esotericsoftware.spine.EventData next = it.next();
            if (next.a.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public com.esotericsoftware.spine.IkConstraintData findIkConstraint(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("constraintName cannot be null.");
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.IkConstraintData> array = this.h;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.IkConstraintData ikConstraintData = array.get(i2);
            if (ikConstraintData.a.equals(str)) {
                return ikConstraintData;
            }
        }
        return null;
    }

    public com.esotericsoftware.spine.PathConstraintData findPathConstraint(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("constraintName cannot be null.");
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.PathConstraintData> array = this.j;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.PathConstraintData pathConstraintData = array.get(i2);
            if (pathConstraintData.a.equals(str)) {
                return pathConstraintData;
            }
        }
        return null;
    }

    public com.esotericsoftware.spine.Skin findSkin(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("skinName cannot be null.");
        }
        java.util.Iterator<com.esotericsoftware.spine.Skin> it = this.d.iterator();
        while (it.hasNext()) {
            com.esotericsoftware.spine.Skin next = it.next();
            if (next.a.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public com.esotericsoftware.spine.SlotData findSlot(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("slotName cannot be null.");
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.SlotData> array = this.c;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.SlotData slotData = array.get(i2);
            if (slotData.b.equals(str)) {
                return slotData;
            }
        }
        return null;
    }

    public com.esotericsoftware.spine.TransformConstraintData findTransformConstraint(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("constraintName cannot be null.");
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.TransformConstraintData> array = this.i;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.TransformConstraintData transformConstraintData = array.get(i2);
            if (transformConstraintData.a.equals(str)) {
                return transformConstraintData;
            }
        }
        return null;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Animation> getAnimations() {
        return this.g;
    }

    public java.lang.String getAudioPath() {
        return this.q;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.BoneData> getBones() {
        return this.b;
    }

    public com.esotericsoftware.spine.Skin getDefaultSkin() {
        return this.e;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.EventData> getEvents() {
        return this.f;
    }

    public float getFps() {
        return this.o;
    }

    public java.lang.String getHash() {
        return this.n;
    }

    public float getHeight() {
        return this.l;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.IkConstraintData> getIkConstraints() {
        return this.h;
    }

    public java.lang.String getImagesPath() {
        return this.p;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.PathConstraintData> getPathConstraints() {
        return this.j;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Skin> getSkins() {
        return this.d;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.SlotData> getSlots() {
        return this.c;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.TransformConstraintData> getTransformConstraints() {
        return this.i;
    }

    public java.lang.String getVersion() {
        return this.m;
    }

    public float getWidth() {
        return this.k;
    }

    public void setAudioPath(java.lang.String str) {
        this.q = str;
    }

    public void setDefaultSkin(com.esotericsoftware.spine.Skin skin) {
        this.e = skin;
    }

    public void setFps(float f) {
        this.o = f;
    }

    public void setHash(java.lang.String str) {
        this.n = str;
    }

    public void setHeight(float f) {
        this.l = f;
    }

    public void setImagesPath(java.lang.String str) {
        this.p = str;
    }

    public void setName(java.lang.String str) {
        this.a = str;
    }

    public void setVersion(java.lang.String str) {
        this.m = str;
    }

    public void setWidth(float f) {
        this.k = f;
    }

    public java.lang.String toString() {
        java.lang.String str = this.a;
        return str != null ? str : super.toString();
    }
}
