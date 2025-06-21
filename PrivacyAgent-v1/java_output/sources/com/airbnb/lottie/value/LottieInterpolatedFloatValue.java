package com.airbnb.lottie.value;

/* loaded from: classes.dex */
public class LottieInterpolatedFloatValue extends com.airbnb.lottie.value.LottieInterpolatedValue<java.lang.Float> {
    public LottieInterpolatedFloatValue(java.lang.Float f, java.lang.Float f2) {
        super(f, f2);
    }

    public LottieInterpolatedFloatValue(java.lang.Float f, java.lang.Float f2, android.view.animation.Interpolator interpolator) {
        super(f, f2, interpolator);
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public java.lang.Float a(java.lang.Float f, java.lang.Float f2, float f3) {
        return java.lang.Float.valueOf(com.airbnb.lottie.utils.MiscUtils.lerp(f.floatValue(), f2.floatValue(), f3));
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue, com.airbnb.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ java.lang.Object getValue(com.airbnb.lottie.value.LottieFrameInfo lottieFrameInfo) {
        return super.getValue(lottieFrameInfo);
    }
}
