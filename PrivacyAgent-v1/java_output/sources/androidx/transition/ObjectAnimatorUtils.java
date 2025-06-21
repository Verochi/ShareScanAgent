package androidx.transition;

/* loaded from: classes.dex */
class ObjectAnimatorUtils {
    private ObjectAnimatorUtils() {
    }

    public static <T> android.animation.ObjectAnimator ofPointF(T t, android.util.Property<T, android.graphics.PointF> property, android.graphics.Path path) {
        return android.animation.ObjectAnimator.ofObject(t, property, (android.animation.TypeConverter) null, path);
    }
}
