package com.amap.api.maps.model.animation;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class ScaleAnimation extends com.amap.api.maps.model.animation.Animation {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float mFromX;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float mFromY;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float mPivotX;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float mPivotY;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float mToX;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float mToY;

    public ScaleAnimation(float f, float f2, float f3, float f4) {
        this.glAnimation = new com.autonavi.amap.mapcore.animation.GLScaleAnimation(f, f2, f3, f4);
        this.mFromX = f;
        this.mToX = f2;
        this.mFromY = f3;
        this.mToY = f4;
        this.mPivotX = 0.0f;
        this.mPivotY = 0.0f;
        setFillMode(1);
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public java.lang.String getAnimationType() {
        return "ScaleAnimation";
    }
}
