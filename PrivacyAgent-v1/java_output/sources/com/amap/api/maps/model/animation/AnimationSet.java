package com.amap.api.maps.model.animation;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class AnimationSet extends com.amap.api.maps.model.animation.Animation {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private java.util.List<com.amap.api.maps.model.animation.Animation> mAnimations = new java.util.ArrayList();

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private boolean shareInterpolator;

    public AnimationSet(boolean z) {
        this.shareInterpolator = false;
        this.glAnimation = new com.autonavi.amap.mapcore.animation.GLAnimationSet(z);
        this.shareInterpolator = z;
    }

    public void addAnimation(com.amap.api.maps.model.animation.Animation animation) {
        ((com.autonavi.amap.mapcore.animation.GLAnimationSet) this.glAnimation).addAnimation(animation);
        this.mAnimations.add(animation);
    }

    public void cleanAnimation() {
        ((com.autonavi.amap.mapcore.animation.GLAnimationSet) this.glAnimation).cleanAnimation();
        this.mAnimations.clear();
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public java.lang.String getAnimationType() {
        return "AnimationSet";
    }
}
