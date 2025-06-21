package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public abstract class MotionInterpolator implements android.view.animation.Interpolator {
    @Override // android.animation.TimeInterpolator
    public abstract float getInterpolation(float f);

    public abstract float getVelocity();
}
