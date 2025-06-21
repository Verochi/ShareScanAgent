package com.esotericsoftware.spine.utils;

/* loaded from: classes22.dex */
public class SkeletonPool extends com.badlogic.gdx.utils.Pool<com.esotericsoftware.spine.Skeleton> {
    public com.esotericsoftware.spine.SkeletonData b;

    public SkeletonPool(com.esotericsoftware.spine.SkeletonData skeletonData) {
        this.b = skeletonData;
    }

    public SkeletonPool(com.esotericsoftware.spine.SkeletonData skeletonData, int i) {
        super(i);
        this.b = skeletonData;
    }

    public SkeletonPool(com.esotericsoftware.spine.SkeletonData skeletonData, int i, int i2) {
        super(i, i2);
        this.b = skeletonData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.utils.Pool
    public com.esotericsoftware.spine.Skeleton newObject() {
        return new com.esotericsoftware.spine.Skeleton(this.b);
    }
}
