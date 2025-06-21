package com.airbnb.lottie.animation.keyframe;

/* loaded from: classes.dex */
public class PathKeyframe extends com.airbnb.lottie.value.Keyframe<android.graphics.PointF> {

    @androidx.annotation.Nullable
    public android.graphics.Path h;
    public final com.airbnb.lottie.value.Keyframe<android.graphics.PointF> i;

    public PathKeyframe(com.airbnb.lottie.LottieComposition lottieComposition, com.airbnb.lottie.value.Keyframe<android.graphics.PointF> keyframe) {
        super(lottieComposition, keyframe.startValue, keyframe.endValue, keyframe.interpolator, keyframe.xInterpolator, keyframe.yInterpolator, keyframe.startFrame, keyframe.endFrame);
        this.i = keyframe;
        createPath();
    }

    @androidx.annotation.Nullable
    public android.graphics.Path a() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void createPath() {
        T t;
        T t2;
        T t3 = this.endValue;
        boolean z = (t3 == 0 || (t2 = this.startValue) == 0 || !((android.graphics.PointF) t2).equals(((android.graphics.PointF) t3).x, ((android.graphics.PointF) t3).y)) ? false : true;
        T t4 = this.startValue;
        if (t4 == 0 || (t = this.endValue) == 0 || z) {
            return;
        }
        com.airbnb.lottie.value.Keyframe<android.graphics.PointF> keyframe = this.i;
        this.h = com.airbnb.lottie.utils.Utils.createPath((android.graphics.PointF) t4, (android.graphics.PointF) t, keyframe.pathCp1, keyframe.pathCp2);
    }
}
