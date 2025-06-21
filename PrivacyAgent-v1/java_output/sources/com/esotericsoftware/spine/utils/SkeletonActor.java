package com.esotericsoftware.spine.utils;

/* loaded from: classes22.dex */
public class SkeletonActor extends com.badlogic.gdx.scenes.scene2d.Actor {
    public com.esotericsoftware.spine.SkeletonRenderer t;
    public com.esotericsoftware.spine.Skeleton u;
    public com.esotericsoftware.spine.AnimationState v;

    public SkeletonActor() {
    }

    public SkeletonActor(com.esotericsoftware.spine.SkeletonRenderer skeletonRenderer, com.esotericsoftware.spine.Skeleton skeleton, com.esotericsoftware.spine.AnimationState animationState) {
        this.t = skeletonRenderer;
        this.u = skeleton;
        this.v = animationState;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.Actor
    public void act(float f) {
        this.v.update(f);
        this.v.apply(this.u);
        this.u.updateWorldTransform();
        super.act(f);
    }

    @Override // com.badlogic.gdx.scenes.scene2d.Actor
    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f) {
        com.badlogic.gdx.graphics.Color color = this.u.getColor();
        float f2 = color.a;
        this.u.getColor().a *= f;
        this.u.setPosition(getX(), getY());
        this.t.draw(batch, this.u);
        color.a = f2;
    }

    public com.esotericsoftware.spine.AnimationState getAnimationState() {
        return this.v;
    }

    public com.esotericsoftware.spine.SkeletonRenderer getRenderer() {
        return this.t;
    }

    public com.esotericsoftware.spine.Skeleton getSkeleton() {
        return this.u;
    }

    public void setAnimationState(com.esotericsoftware.spine.AnimationState animationState) {
        this.v = animationState;
    }

    public void setRenderer(com.esotericsoftware.spine.SkeletonRenderer skeletonRenderer) {
        this.t = skeletonRenderer;
    }

    public void setSkeleton(com.esotericsoftware.spine.Skeleton skeleton) {
        this.u = skeleton;
    }
}
