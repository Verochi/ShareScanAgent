package androidx.transition;

/* loaded from: classes.dex */
class ViewUtils {
    static final android.util.Property<android.view.View, android.graphics.Rect> CLIP_BOUNDS;
    private static final androidx.transition.ViewUtilsBase IMPL;
    private static final java.lang.String TAG = "ViewUtils";
    static final android.util.Property<android.view.View, java.lang.Float> TRANSITION_ALPHA;

    /* renamed from: androidx.transition.ViewUtils$1, reason: invalid class name */
    public static class AnonymousClass1 extends android.util.Property<android.view.View, java.lang.Float> {
        public AnonymousClass1(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public java.lang.Float get(android.view.View view) {
            return java.lang.Float.valueOf(androidx.transition.ViewUtils.getTransitionAlpha(view));
        }

        @Override // android.util.Property
        public void set(android.view.View view, java.lang.Float f) {
            androidx.transition.ViewUtils.setTransitionAlpha(view, f.floatValue());
        }
    }

    /* renamed from: androidx.transition.ViewUtils$2, reason: invalid class name */
    public static class AnonymousClass2 extends android.util.Property<android.view.View, android.graphics.Rect> {
        public AnonymousClass2(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public android.graphics.Rect get(android.view.View view) {
            return androidx.core.view.ViewCompat.getClipBounds(view);
        }

        @Override // android.util.Property
        public void set(android.view.View view, android.graphics.Rect rect) {
            androidx.core.view.ViewCompat.setClipBounds(view, rect);
        }
    }

    static {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 29) {
            IMPL = new androidx.transition.ViewUtilsApi29();
        } else if (i >= 23) {
            IMPL = new androidx.transition.ViewUtilsApi23();
        } else if (i >= 22) {
            IMPL = new androidx.transition.ViewUtilsApi22();
        } else {
            IMPL = new androidx.transition.ViewUtilsApi21();
        }
        TRANSITION_ALPHA = new androidx.transition.ViewUtils.AnonymousClass1(java.lang.Float.class, "translationAlpha");
        CLIP_BOUNDS = new androidx.transition.ViewUtils.AnonymousClass2(android.graphics.Rect.class, "clipBounds");
    }

    private ViewUtils() {
    }

    public static void clearNonTransitionAlpha(@androidx.annotation.NonNull android.view.View view) {
        IMPL.clearNonTransitionAlpha(view);
    }

    public static androidx.transition.ViewOverlayImpl getOverlay(@androidx.annotation.NonNull android.view.View view) {
        return new androidx.transition.ViewOverlayApi18(view);
    }

    public static float getTransitionAlpha(@androidx.annotation.NonNull android.view.View view) {
        return IMPL.getTransitionAlpha(view);
    }

    public static androidx.transition.WindowIdImpl getWindowId(@androidx.annotation.NonNull android.view.View view) {
        return new androidx.transition.WindowIdApi18(view);
    }

    public static void saveNonTransitionAlpha(@androidx.annotation.NonNull android.view.View view) {
        IMPL.saveNonTransitionAlpha(view);
    }

    public static void setAnimationMatrix(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.graphics.Matrix matrix) {
        IMPL.setAnimationMatrix(view, matrix);
    }

    public static void setLeftTopRightBottom(@androidx.annotation.NonNull android.view.View view, int i, int i2, int i3, int i4) {
        IMPL.setLeftTopRightBottom(view, i, i2, i3, i4);
    }

    public static void setTransitionAlpha(@androidx.annotation.NonNull android.view.View view, float f) {
        IMPL.setTransitionAlpha(view, f);
    }

    public static void setTransitionVisibility(@androidx.annotation.NonNull android.view.View view, int i) {
        IMPL.setTransitionVisibility(view, i);
    }

    public static void transformMatrixToGlobal(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.graphics.Matrix matrix) {
        IMPL.transformMatrixToGlobal(view, matrix);
    }

    public static void transformMatrixToLocal(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.graphics.Matrix matrix) {
        IMPL.transformMatrixToLocal(view, matrix);
    }
}
