package androidx.core.view;

/* loaded from: classes.dex */
public final class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    private GravityCompat() {
    }

    public static void apply(int i, int i2, int i3, android.graphics.Rect rect, int i4, int i5, android.graphics.Rect rect2, int i6) {
        android.view.Gravity.apply(i, i2, i3, rect, i4, i5, rect2, i6);
    }

    public static void apply(int i, int i2, int i3, android.graphics.Rect rect, android.graphics.Rect rect2, int i4) {
        android.view.Gravity.apply(i, i2, i3, rect, rect2, i4);
    }

    public static void applyDisplay(int i, android.graphics.Rect rect, android.graphics.Rect rect2, int i2) {
        android.view.Gravity.applyDisplay(i, rect, rect2, i2);
    }

    public static int getAbsoluteGravity(int i, int i2) {
        return android.view.Gravity.getAbsoluteGravity(i, i2);
    }
}
