package androidx.core.graphics;

/* loaded from: classes.dex */
public final class PathUtils {
    private PathUtils() {
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(26)
    public static java.util.Collection<androidx.core.graphics.PathSegment> flatten(@androidx.annotation.NonNull android.graphics.Path path) {
        return flatten(path, 0.5f);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(26)
    public static java.util.Collection<androidx.core.graphics.PathSegment> flatten(@androidx.annotation.NonNull android.graphics.Path path, @androidx.annotation.FloatRange(from = 0.0d) float f) {
        float[] approximate;
        approximate = path.approximate(f);
        int length = approximate.length / 3;
        java.util.ArrayList arrayList = new java.util.ArrayList(length);
        for (int i = 1; i < length; i++) {
            int i2 = i * 3;
            int i3 = (i - 1) * 3;
            float f2 = approximate[i2];
            float f3 = approximate[i2 + 1];
            float f4 = approximate[i2 + 2];
            float f5 = approximate[i3];
            float f6 = approximate[i3 + 1];
            float f7 = approximate[i3 + 2];
            if (f2 != f5 && (f3 != f6 || f4 != f7)) {
                arrayList.add(new androidx.core.graphics.PathSegment(new android.graphics.PointF(f6, f7), f5, new android.graphics.PointF(f3, f4), f2));
            }
        }
        return arrayList;
    }
}
