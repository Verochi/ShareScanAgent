package androidx.core.graphics;

/* loaded from: classes.dex */
public final class BitmapCompat {
    private BitmapCompat() {
    }

    public static int getAllocationByteCount(@androidx.annotation.NonNull android.graphics.Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    public static boolean hasMipMap(@androidx.annotation.NonNull android.graphics.Bitmap bitmap) {
        return bitmap.hasMipMap();
    }

    public static void setHasMipMap(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, boolean z) {
        bitmap.setHasMipMap(z);
    }
}
