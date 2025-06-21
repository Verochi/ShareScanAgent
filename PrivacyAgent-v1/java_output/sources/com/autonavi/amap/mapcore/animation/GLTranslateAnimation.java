package com.autonavi.amap.mapcore.animation;

/* loaded from: classes12.dex */
public class GLTranslateAnimation extends com.autonavi.amap.mapcore.animation.GLAnimation {
    public double mToXDelta;
    public double mToYDelta;
    public double mFromXDelta = 0.0d;
    public double mFromYDelta = 0.0d;
    public double mCurXDelta = 0.0d;
    public double mCurYDelta = 0.0d;

    public GLTranslateAnimation(com.amap.api.maps.model.LatLng latLng) {
        this.mToXDelta = 0.0d;
        this.mToYDelta = 0.0d;
        this.mToXDelta = latLng.longitude;
        this.mToYDelta = latLng.latitude;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f, com.autonavi.amap.mapcore.animation.GLTransformation gLTransformation) {
        double d = this.mFromXDelta;
        this.mCurXDelta = d;
        double d2 = this.mFromYDelta;
        this.mCurYDelta = d2;
        double d3 = this.mToXDelta;
        if (d != d3) {
            this.mCurXDelta = d + ((d3 - d) * f);
        }
        double d4 = this.mToYDelta;
        if (d2 != d4) {
            this.mCurYDelta = d2 + ((d4 - d2) * f);
        }
        gLTransformation.x = this.mCurXDelta;
        gLTransformation.y = this.mCurYDelta;
    }

    public void setFromPoint(com.amap.api.maps.model.LatLng latLng) {
        this.mFromXDelta = latLng.longitude;
        this.mFromYDelta = latLng.latitude;
    }
}
