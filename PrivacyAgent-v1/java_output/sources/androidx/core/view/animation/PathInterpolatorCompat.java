package androidx.core.view.animation;

/* loaded from: classes.dex */
public final class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
    }

    public static android.view.animation.Interpolator create(float f, float f2) {
        return new android.view.animation.PathInterpolator(f, f2);
    }

    public static android.view.animation.Interpolator create(float f, float f2, float f3, float f4) {
        return new android.view.animation.PathInterpolator(f, f2, f3, f4);
    }

    public static android.view.animation.Interpolator create(android.graphics.Path path) {
        return new android.view.animation.PathInterpolator(path);
    }
}
