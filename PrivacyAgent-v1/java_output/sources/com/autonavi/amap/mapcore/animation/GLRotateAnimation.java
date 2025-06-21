package com.autonavi.amap.mapcore.animation;

/* loaded from: classes12.dex */
public class GLRotateAnimation extends com.autonavi.amap.mapcore.animation.GLAnimation {
    private float mFromDegrees;
    private float mToDegrees;

    public GLRotateAnimation(float f, float f2, float f3, float f4, float f5) {
        this.mFromDegrees = f;
        this.mToDegrees = f2;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f, com.autonavi.amap.mapcore.animation.GLTransformation gLTransformation) {
        float f2 = this.mFromDegrees;
        gLTransformation.rotate = f2 + ((this.mToDegrees - f2) * f);
    }
}
