package com.airbnb.lottie.value;

/* loaded from: classes.dex */
public class LottieRelativePointValueCallback extends com.airbnb.lottie.value.LottieValueCallback<android.graphics.PointF> {
    public final android.graphics.PointF c;

    public LottieRelativePointValueCallback() {
        this.c = new android.graphics.PointF();
    }

    public LottieRelativePointValueCallback(@androidx.annotation.NonNull android.graphics.PointF pointF) {
        super(pointF);
        this.c = new android.graphics.PointF();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public android.graphics.PointF getOffset(com.airbnb.lottie.value.LottieFrameInfo<android.graphics.PointF> lottieFrameInfo) {
        T t = this.value;
        if (t != 0) {
            return (android.graphics.PointF) t;
        }
        throw new java.lang.IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.value.LottieValueCallback
    public final android.graphics.PointF getValue(com.airbnb.lottie.value.LottieFrameInfo<android.graphics.PointF> lottieFrameInfo) {
        this.c.set(com.airbnb.lottie.utils.MiscUtils.lerp(lottieFrameInfo.getStartValue().x, lottieFrameInfo.getEndValue().x, lottieFrameInfo.getInterpolatedKeyframeProgress()), com.airbnb.lottie.utils.MiscUtils.lerp(lottieFrameInfo.getStartValue().y, lottieFrameInfo.getEndValue().y, lottieFrameInfo.getInterpolatedKeyframeProgress()));
        android.graphics.PointF offset = getOffset(lottieFrameInfo);
        this.c.offset(offset.x, offset.y);
        return this.c;
    }
}
