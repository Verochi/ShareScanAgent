package com.airbnb.lottie.value;

/* loaded from: classes.dex */
public class Keyframe<T> {

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.LottieComposition a;
    public float b;
    public float c;
    public int d;
    public int e;

    @androidx.annotation.Nullable
    public java.lang.Float endFrame;

    @androidx.annotation.Nullable
    public T endValue;
    public float f;
    public float g;

    @androidx.annotation.Nullable
    public final android.view.animation.Interpolator interpolator;
    public android.graphics.PointF pathCp1;
    public android.graphics.PointF pathCp2;
    public final float startFrame;

    @androidx.annotation.Nullable
    public final T startValue;

    @androidx.annotation.Nullable
    public final android.view.animation.Interpolator xInterpolator;

    @androidx.annotation.Nullable
    public final android.view.animation.Interpolator yInterpolator;

    public Keyframe(com.airbnb.lottie.LottieComposition lottieComposition, @androidx.annotation.Nullable T t, @androidx.annotation.Nullable T t2, @androidx.annotation.Nullable android.view.animation.Interpolator interpolator, float f, @androidx.annotation.Nullable java.lang.Float f2) {
        this.b = -3987645.8f;
        this.c = -3987645.8f;
        this.d = 784923401;
        this.e = 784923401;
        this.f = Float.MIN_VALUE;
        this.g = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.a = lottieComposition;
        this.startValue = t;
        this.endValue = t2;
        this.interpolator = interpolator;
        this.xInterpolator = null;
        this.yInterpolator = null;
        this.startFrame = f;
        this.endFrame = f2;
    }

    public Keyframe(com.airbnb.lottie.LottieComposition lottieComposition, @androidx.annotation.Nullable T t, @androidx.annotation.Nullable T t2, @androidx.annotation.Nullable android.view.animation.Interpolator interpolator, @androidx.annotation.Nullable android.view.animation.Interpolator interpolator2, float f, @androidx.annotation.Nullable java.lang.Float f2) {
        this.b = -3987645.8f;
        this.c = -3987645.8f;
        this.d = 784923401;
        this.e = 784923401;
        this.f = Float.MIN_VALUE;
        this.g = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.a = lottieComposition;
        this.startValue = t;
        this.endValue = t2;
        this.interpolator = null;
        this.xInterpolator = interpolator;
        this.yInterpolator = interpolator2;
        this.startFrame = f;
        this.endFrame = f2;
    }

    public Keyframe(com.airbnb.lottie.LottieComposition lottieComposition, @androidx.annotation.Nullable T t, @androidx.annotation.Nullable T t2, @androidx.annotation.Nullable android.view.animation.Interpolator interpolator, @androidx.annotation.Nullable android.view.animation.Interpolator interpolator2, @androidx.annotation.Nullable android.view.animation.Interpolator interpolator3, float f, @androidx.annotation.Nullable java.lang.Float f2) {
        this.b = -3987645.8f;
        this.c = -3987645.8f;
        this.d = 784923401;
        this.e = 784923401;
        this.f = Float.MIN_VALUE;
        this.g = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.a = lottieComposition;
        this.startValue = t;
        this.endValue = t2;
        this.interpolator = interpolator;
        this.xInterpolator = interpolator2;
        this.yInterpolator = interpolator3;
        this.startFrame = f;
        this.endFrame = f2;
    }

    public Keyframe(T t) {
        this.b = -3987645.8f;
        this.c = -3987645.8f;
        this.d = 784923401;
        this.e = 784923401;
        this.f = Float.MIN_VALUE;
        this.g = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.a = null;
        this.startValue = t;
        this.endValue = t;
        this.interpolator = null;
        this.xInterpolator = null;
        this.yInterpolator = null;
        this.startFrame = Float.MIN_VALUE;
        this.endFrame = java.lang.Float.valueOf(Float.MAX_VALUE);
    }

    public boolean containsProgress(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= getStartProgress() && f < getEndProgress();
    }

    public float getEndProgress() {
        if (this.a == null) {
            return 1.0f;
        }
        if (this.g == Float.MIN_VALUE) {
            if (this.endFrame == null) {
                this.g = 1.0f;
            } else {
                this.g = getStartProgress() + ((this.endFrame.floatValue() - this.startFrame) / this.a.getDurationFrames());
            }
        }
        return this.g;
    }

    public float getEndValueFloat() {
        if (this.c == -3987645.8f) {
            this.c = ((java.lang.Float) this.endValue).floatValue();
        }
        return this.c;
    }

    public int getEndValueInt() {
        if (this.e == 784923401) {
            this.e = ((java.lang.Integer) this.endValue).intValue();
        }
        return this.e;
    }

    public float getStartProgress() {
        com.airbnb.lottie.LottieComposition lottieComposition = this.a;
        if (lottieComposition == null) {
            return 0.0f;
        }
        if (this.f == Float.MIN_VALUE) {
            this.f = (this.startFrame - lottieComposition.getStartFrame()) / this.a.getDurationFrames();
        }
        return this.f;
    }

    public float getStartValueFloat() {
        if (this.b == -3987645.8f) {
            this.b = ((java.lang.Float) this.startValue).floatValue();
        }
        return this.b;
    }

    public int getStartValueInt() {
        if (this.d == 784923401) {
            this.d = ((java.lang.Integer) this.startValue).intValue();
        }
        return this.d;
    }

    public boolean isStatic() {
        return this.interpolator == null && this.xInterpolator == null && this.yInterpolator == null;
    }

    public java.lang.String toString() {
        return "Keyframe{startValue=" + this.startValue + ", endValue=" + this.endValue + ", startFrame=" + this.startFrame + ", endFrame=" + this.endFrame + ", interpolator=" + this.interpolator + '}';
    }
}
