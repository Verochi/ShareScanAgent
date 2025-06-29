package androidx.core.view;

/* loaded from: classes.dex */
public final class PointerIconCompat {
    public static final int TYPE_ALIAS = 1010;
    public static final int TYPE_ALL_SCROLL = 1013;
    public static final int TYPE_ARROW = 1000;
    public static final int TYPE_CELL = 1006;
    public static final int TYPE_CONTEXT_MENU = 1001;
    public static final int TYPE_COPY = 1011;
    public static final int TYPE_CROSSHAIR = 1007;
    public static final int TYPE_DEFAULT = 1000;
    public static final int TYPE_GRAB = 1020;
    public static final int TYPE_GRABBING = 1021;
    public static final int TYPE_HAND = 1002;
    public static final int TYPE_HELP = 1003;
    public static final int TYPE_HORIZONTAL_DOUBLE_ARROW = 1014;
    public static final int TYPE_NO_DROP = 1012;
    public static final int TYPE_NULL = 0;
    public static final int TYPE_TEXT = 1008;
    public static final int TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW = 1017;
    public static final int TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW = 1016;
    public static final int TYPE_VERTICAL_DOUBLE_ARROW = 1015;
    public static final int TYPE_VERTICAL_TEXT = 1009;
    public static final int TYPE_WAIT = 1004;
    public static final int TYPE_ZOOM_IN = 1018;
    public static final int TYPE_ZOOM_OUT = 1019;
    private java.lang.Object mPointerIcon;

    private PointerIconCompat(java.lang.Object obj) {
        this.mPointerIcon = obj;
    }

    public static androidx.core.view.PointerIconCompat create(android.graphics.Bitmap bitmap, float f, float f2) {
        android.view.PointerIcon create;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return new androidx.core.view.PointerIconCompat(null);
        }
        create = android.view.PointerIcon.create(bitmap, f, f2);
        return new androidx.core.view.PointerIconCompat(create);
    }

    public static androidx.core.view.PointerIconCompat getSystemIcon(android.content.Context context, int i) {
        android.view.PointerIcon systemIcon;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return new androidx.core.view.PointerIconCompat(null);
        }
        systemIcon = android.view.PointerIcon.getSystemIcon(context, i);
        return new androidx.core.view.PointerIconCompat(systemIcon);
    }

    public static androidx.core.view.PointerIconCompat load(android.content.res.Resources resources, int i) {
        android.view.PointerIcon load;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return new androidx.core.view.PointerIconCompat(null);
        }
        load = android.view.PointerIcon.load(resources, i);
        return new androidx.core.view.PointerIconCompat(load);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public java.lang.Object getPointerIcon() {
        return this.mPointerIcon;
    }
}
