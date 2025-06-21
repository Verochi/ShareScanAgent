package androidx.transition;

/* loaded from: classes.dex */
class PropertyValuesHolderUtils {
    private PropertyValuesHolderUtils() {
    }

    public static android.animation.PropertyValuesHolder ofPointF(android.util.Property<?, android.graphics.PointF> property, android.graphics.Path path) {
        return android.animation.PropertyValuesHolder.ofObject(property, (android.animation.TypeConverter) null, path);
    }
}
