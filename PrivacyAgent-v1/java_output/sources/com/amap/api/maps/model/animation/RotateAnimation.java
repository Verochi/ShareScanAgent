package com.amap.api.maps.model.animation;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class RotateAnimation extends com.amap.api.maps.model.animation.Animation {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float mFromDegrees;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float mToDegrees;

    public RotateAnimation(float f, float f2) {
        this.mFromDegrees = 0.0f;
        this.mToDegrees = 1.0f;
        this.glAnimation = new com.autonavi.amap.mapcore.animation.GLRotateAnimation(f, f2, 0.0f, 0.0f, 0.0f);
        this.mFromDegrees = f;
        this.mToDegrees = f2;
    }

    public RotateAnimation(float f, float f2, float f3, float f4, float f5) {
        this.mFromDegrees = 0.0f;
        this.mToDegrees = 1.0f;
        this.glAnimation = new com.autonavi.amap.mapcore.animation.GLRotateAnimation(f, f2, f3, f4, f5);
        this.mFromDegrees = f;
        this.mToDegrees = f2;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public java.lang.String getAnimationType() {
        return "RotateAnimation";
    }
}
