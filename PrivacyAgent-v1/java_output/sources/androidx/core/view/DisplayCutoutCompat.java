package androidx.core.view;

/* loaded from: classes.dex */
public final class DisplayCutoutCompat {
    private final java.lang.Object mDisplayCutout;

    public DisplayCutoutCompat(android.graphics.Rect rect, java.util.List<android.graphics.Rect> list) {
        this(android.os.Build.VERSION.SDK_INT >= 28 ? new android.view.DisplayCutout(rect, list) : null);
    }

    public DisplayCutoutCompat(@androidx.annotation.NonNull androidx.core.graphics.Insets insets, @androidx.annotation.Nullable android.graphics.Rect rect, @androidx.annotation.Nullable android.graphics.Rect rect2, @androidx.annotation.Nullable android.graphics.Rect rect3, @androidx.annotation.Nullable android.graphics.Rect rect4, @androidx.annotation.NonNull androidx.core.graphics.Insets insets2) {
        this(constructDisplayCutout(insets, rect, rect2, rect3, rect4, insets2));
    }

    private DisplayCutoutCompat(java.lang.Object obj) {
        this.mDisplayCutout = obj;
    }

    private static android.view.DisplayCutout constructDisplayCutout(@androidx.annotation.NonNull androidx.core.graphics.Insets insets, @androidx.annotation.Nullable android.graphics.Rect rect, @androidx.annotation.Nullable android.graphics.Rect rect2, @androidx.annotation.Nullable android.graphics.Rect rect3, @androidx.annotation.Nullable android.graphics.Rect rect4, @androidx.annotation.NonNull androidx.core.graphics.Insets insets2) {
        if (androidx.core.os.BuildCompat.isAtLeastR()) {
            return new android.view.DisplayCutout(insets.toPlatformInsets(), rect, rect2, rect3, rect4, insets2.toPlatformInsets());
        }
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 29) {
            return new android.view.DisplayCutout(insets.toPlatformInsets(), rect, rect2, rect3, rect4);
        }
        if (i < 28) {
            return null;
        }
        android.graphics.Rect rect5 = new android.graphics.Rect(insets.left, insets.top, insets.right, insets.bottom);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (rect != null) {
            arrayList.add(rect);
        }
        if (rect2 != null) {
            arrayList.add(rect2);
        }
        if (rect3 != null) {
            arrayList.add(rect3);
        }
        if (rect4 != null) {
            arrayList.add(rect4);
        }
        return new android.view.DisplayCutout(rect5, arrayList);
    }

    public static androidx.core.view.DisplayCutoutCompat wrap(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        return new androidx.core.view.DisplayCutoutCompat(obj);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || androidx.core.view.DisplayCutoutCompat.class != obj.getClass()) {
            return false;
        }
        return androidx.core.util.ObjectsCompat.equals(this.mDisplayCutout, ((androidx.core.view.DisplayCutoutCompat) obj).mDisplayCutout);
    }

    @androidx.annotation.NonNull
    public java.util.List<android.graphics.Rect> getBoundingRects() {
        java.util.List<android.graphics.Rect> boundingRects;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return java.util.Collections.emptyList();
        }
        boundingRects = ((android.view.DisplayCutout) this.mDisplayCutout).getBoundingRects();
        return boundingRects;
    }

    public int getSafeInsetBottom() {
        int safeInsetBottom;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return 0;
        }
        safeInsetBottom = ((android.view.DisplayCutout) this.mDisplayCutout).getSafeInsetBottom();
        return safeInsetBottom;
    }

    public int getSafeInsetLeft() {
        int safeInsetLeft;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return 0;
        }
        safeInsetLeft = ((android.view.DisplayCutout) this.mDisplayCutout).getSafeInsetLeft();
        return safeInsetLeft;
    }

    public int getSafeInsetRight() {
        int safeInsetRight;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return 0;
        }
        safeInsetRight = ((android.view.DisplayCutout) this.mDisplayCutout).getSafeInsetRight();
        return safeInsetRight;
    }

    public int getSafeInsetTop() {
        int safeInsetTop;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return 0;
        }
        safeInsetTop = ((android.view.DisplayCutout) this.mDisplayCutout).getSafeInsetTop();
        return safeInsetTop;
    }

    @androidx.annotation.NonNull
    public androidx.core.graphics.Insets getWaterfallInsets() {
        android.graphics.Insets waterfallInsets;
        if (!androidx.core.os.BuildCompat.isAtLeastR()) {
            return androidx.core.graphics.Insets.NONE;
        }
        waterfallInsets = ((android.view.DisplayCutout) this.mDisplayCutout).getWaterfallInsets();
        return androidx.core.graphics.Insets.toCompatInsets(waterfallInsets);
    }

    public int hashCode() {
        java.lang.Object obj = this.mDisplayCutout;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public java.lang.String toString() {
        return "DisplayCutoutCompat{" + this.mDisplayCutout + com.alipay.sdk.m.u.i.d;
    }

    @androidx.annotation.RequiresApi(api = 28)
    public android.view.DisplayCutout unwrap() {
        return (android.view.DisplayCutout) this.mDisplayCutout;
    }
}
