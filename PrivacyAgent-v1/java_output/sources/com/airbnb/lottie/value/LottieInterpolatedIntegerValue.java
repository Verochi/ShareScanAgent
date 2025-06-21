package com.airbnb.lottie.value;

/* loaded from: classes.dex */
public class LottieInterpolatedIntegerValue extends com.airbnb.lottie.value.LottieInterpolatedValue<java.lang.Integer> {
    public LottieInterpolatedIntegerValue(java.lang.Integer num, java.lang.Integer num2) {
        super(num, num2);
    }

    public LottieInterpolatedIntegerValue(java.lang.Integer num, java.lang.Integer num2, android.view.animation.Interpolator interpolator) {
        super(num, num2, interpolator);
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public java.lang.Integer a(java.lang.Integer num, java.lang.Integer num2, float f) {
        return java.lang.Integer.valueOf(com.airbnb.lottie.utils.MiscUtils.lerp(num.intValue(), num2.intValue(), f));
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue, com.airbnb.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ java.lang.Object getValue(com.airbnb.lottie.value.LottieFrameInfo lottieFrameInfo) {
        return super.getValue(lottieFrameInfo);
    }
}
