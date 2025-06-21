package com.airbnb.lottie.value;

/* loaded from: classes.dex */
public class LottieInterpolatedPointValue extends com.airbnb.lottie.value.LottieInterpolatedValue<android.graphics.PointF> {
    public final android.graphics.PointF f;

    public LottieInterpolatedPointValue(android.graphics.PointF pointF, android.graphics.PointF pointF2) {
        super(pointF, pointF2);
        this.f = new android.graphics.PointF();
    }

    public LottieInterpolatedPointValue(android.graphics.PointF pointF, android.graphics.PointF pointF2, android.view.animation.Interpolator interpolator) {
        super(pointF, pointF2, interpolator);
        this.f = new android.graphics.PointF();
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public android.graphics.PointF a(android.graphics.PointF pointF, android.graphics.PointF pointF2, float f) {
        this.f.set(com.airbnb.lottie.utils.MiscUtils.lerp(pointF.x, pointF2.x, f), com.airbnb.lottie.utils.MiscUtils.lerp(pointF.y, pointF2.y, f));
        return this.f;
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue, com.airbnb.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ java.lang.Object getValue(com.airbnb.lottie.value.LottieFrameInfo lottieFrameInfo) {
        return super.getValue(lottieFrameInfo);
    }
}
