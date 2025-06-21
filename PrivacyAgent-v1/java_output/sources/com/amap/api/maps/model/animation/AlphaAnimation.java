package com.amap.api.maps.model.animation;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class AlphaAnimation extends com.amap.api.maps.model.animation.Animation {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float mFromAlpha;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float mToAlpha;

    public AlphaAnimation(float f, float f2) {
        this.mFromAlpha = 0.0f;
        this.mToAlpha = 1.0f;
        this.glAnimation = new com.autonavi.amap.mapcore.animation.GLAlphaAnimation(f, f2);
        this.mFromAlpha = f;
        this.mToAlpha = f2;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public java.lang.String getAnimationType() {
        return "AlphaAnimation";
    }
}
