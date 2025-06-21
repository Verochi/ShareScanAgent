package com.esotericsoftware.spine.utils;

/* loaded from: classes22.dex */
public class SkeletonActorPool extends com.badlogic.gdx.utils.Pool<com.esotericsoftware.spine.utils.SkeletonActor> {
    public com.esotericsoftware.spine.SkeletonRenderer b;
    public com.esotericsoftware.spine.SkeletonData c;
    public com.esotericsoftware.spine.AnimationStateData d;
    public final com.badlogic.gdx.utils.Pool<com.esotericsoftware.spine.Skeleton> e;
    public final com.badlogic.gdx.utils.Pool<com.esotericsoftware.spine.AnimationState> f;
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.utils.SkeletonActor> g;

    /* renamed from: com.esotericsoftware.spine.utils.SkeletonActorPool$1, reason: invalid class name */
    public class AnonymousClass1 extends com.badlogic.gdx.utils.Pool<com.esotericsoftware.spine.Skeleton> {
        public AnonymousClass1(int i, int i2) {
            super(i, i2);
        }

        @Override // com.badlogic.gdx.utils.Pool
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void reset(com.esotericsoftware.spine.Skeleton skeleton) {
            skeleton.setColor(com.badlogic.gdx.graphics.Color.WHITE);
            skeleton.setFlip(false, false);
            skeleton.setSkin((com.esotericsoftware.spine.Skin) null);
            skeleton.setSkin(com.esotericsoftware.spine.utils.SkeletonActorPool.this.c.getDefaultSkin());
            skeleton.setToSetupPose();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.badlogic.gdx.utils.Pool
        public com.esotericsoftware.spine.Skeleton newObject() {
            return new com.esotericsoftware.spine.Skeleton(com.esotericsoftware.spine.utils.SkeletonActorPool.this.c);
        }
    }

    /* renamed from: com.esotericsoftware.spine.utils.SkeletonActorPool$2, reason: invalid class name */
    public class AnonymousClass2 extends com.badlogic.gdx.utils.Pool<com.esotericsoftware.spine.AnimationState> {
        public AnonymousClass2(int i, int i2) {
            super(i, i2);
        }

        @Override // com.badlogic.gdx.utils.Pool
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.esotericsoftware.spine.AnimationState newObject() {
            return new com.esotericsoftware.spine.AnimationState(com.esotericsoftware.spine.utils.SkeletonActorPool.this.d);
        }

        @Override // com.badlogic.gdx.utils.Pool
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void reset(com.esotericsoftware.spine.AnimationState animationState) {
            animationState.clearTracks();
            animationState.clearListeners();
        }
    }

    public SkeletonActorPool(com.esotericsoftware.spine.SkeletonRenderer skeletonRenderer, com.esotericsoftware.spine.SkeletonData skeletonData, com.esotericsoftware.spine.AnimationStateData animationStateData) {
        this(skeletonRenderer, skeletonData, animationStateData, 16, Integer.MAX_VALUE);
    }

    public SkeletonActorPool(com.esotericsoftware.spine.SkeletonRenderer skeletonRenderer, com.esotericsoftware.spine.SkeletonData skeletonData, com.esotericsoftware.spine.AnimationStateData animationStateData, int i, int i2) {
        super(i, i2);
        this.b = skeletonRenderer;
        this.c = skeletonData;
        this.d = animationStateData;
        this.g = new com.badlogic.gdx.utils.Array<>(false, i);
        this.e = new com.esotericsoftware.spine.utils.SkeletonActorPool.AnonymousClass1(i, i2);
        this.f = new com.esotericsoftware.spine.utils.SkeletonActorPool.AnonymousClass2(i, i2);
    }

    public void freeComplete() {
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.utils.SkeletonActor> array = this.g;
        for (int i = array.size - 1; i >= 0; i--) {
            com.esotericsoftware.spine.utils.SkeletonActor skeletonActor = array.get(i);
            com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.AnimationState.TrackEntry> tracks = skeletonActor.v.getTracks();
            int i2 = tracks.size;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    free(skeletonActor);
                    break;
                } else if (tracks.get(i3) != null) {
                    break;
                } else {
                    i3++;
                }
            }
        }
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.utils.SkeletonActor> getObtained() {
        return this.g;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.utils.Pool
    public com.esotericsoftware.spine.utils.SkeletonActor newObject() {
        com.esotericsoftware.spine.utils.SkeletonActor skeletonActor = new com.esotericsoftware.spine.utils.SkeletonActor();
        skeletonActor.setRenderer(this.b);
        return skeletonActor;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.utils.Pool
    public com.esotericsoftware.spine.utils.SkeletonActor obtain() {
        com.esotericsoftware.spine.utils.SkeletonActor skeletonActor = (com.esotericsoftware.spine.utils.SkeletonActor) super.obtain();
        skeletonActor.setSkeleton(this.e.obtain());
        skeletonActor.setAnimationState(this.f.obtain());
        this.g.add(skeletonActor);
        return skeletonActor;
    }

    @Override // com.badlogic.gdx.utils.Pool
    public void reset(com.esotericsoftware.spine.utils.SkeletonActor skeletonActor) {
        skeletonActor.remove();
        this.g.removeValue(skeletonActor, true);
        this.e.free(skeletonActor.getSkeleton());
        this.f.free(skeletonActor.getAnimationState());
    }
}
