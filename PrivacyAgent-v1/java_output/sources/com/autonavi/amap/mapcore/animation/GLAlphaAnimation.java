package com.autonavi.amap.mapcore.animation;

/* loaded from: classes12.dex */
public class GLAlphaAnimation extends com.autonavi.amap.mapcore.animation.GLAnimation {
    public float mCurAlpha = 0.0f;
    public float mFromAlpha;
    public float mToAlpha;

    public GLAlphaAnimation(float f, float f2) {
        this.mFromAlpha = f;
        this.mToAlpha = f2;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f, com.autonavi.amap.mapcore.animation.GLTransformation gLTransformation) {
        float f2 = this.mFromAlpha;
        float f3 = f2 + ((this.mToAlpha - f2) * f);
        this.mCurAlpha = f3;
        gLTransformation.alpha = f3;
    }
}
