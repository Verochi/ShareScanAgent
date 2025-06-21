package androidx.core.widget;

/* loaded from: classes.dex */
public final class PopupWindowCompat {
    private static final java.lang.String TAG = "PopupWindowCompatApi21";
    private static java.lang.reflect.Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static java.lang.reflect.Field sOverlapAnchorField;
    private static boolean sOverlapAnchorFieldAttempted;
    private static java.lang.reflect.Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(@androidx.annotation.NonNull android.widget.PopupWindow popupWindow) {
        boolean overlapAnchor;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            overlapAnchor = popupWindow.getOverlapAnchor();
            return overlapAnchor;
        }
        if (!sOverlapAnchorFieldAttempted) {
            try {
                java.lang.reflect.Field declaredField = android.widget.PopupWindow.class.getDeclaredField("mOverlapAnchor");
                sOverlapAnchorField = declaredField;
                declaredField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused) {
            }
            sOverlapAnchorFieldAttempted = true;
        }
        java.lang.reflect.Field field = sOverlapAnchorField;
        if (field == null) {
            return false;
        }
        try {
            return ((java.lang.Boolean) field.get(popupWindow)).booleanValue();
        } catch (java.lang.IllegalAccessException unused2) {
            return false;
        }
    }

    public static int getWindowLayoutType(@androidx.annotation.NonNull android.widget.PopupWindow popupWindow) {
        int windowLayoutType;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            windowLayoutType = popupWindow.getWindowLayoutType();
            return windowLayoutType;
        }
        if (!sGetWindowLayoutTypeMethodAttempted) {
            try {
                java.lang.reflect.Method declaredMethod = android.widget.PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new java.lang.Class[0]);
                sGetWindowLayoutTypeMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (java.lang.Exception unused) {
            }
            sGetWindowLayoutTypeMethodAttempted = true;
        }
        java.lang.reflect.Method method = sGetWindowLayoutTypeMethod;
        if (method != null) {
            try {
                return ((java.lang.Integer) method.invoke(popupWindow, new java.lang.Object[0])).intValue();
            } catch (java.lang.Exception unused2) {
            }
        }
        return 0;
    }

    public static void setOverlapAnchor(@androidx.annotation.NonNull android.widget.PopupWindow popupWindow, boolean z) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            popupWindow.setOverlapAnchor(z);
            return;
        }
        if (!sOverlapAnchorFieldAttempted) {
            try {
                java.lang.reflect.Field declaredField = android.widget.PopupWindow.class.getDeclaredField("mOverlapAnchor");
                sOverlapAnchorField = declaredField;
                declaredField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused) {
            }
            sOverlapAnchorFieldAttempted = true;
        }
        java.lang.reflect.Field field = sOverlapAnchorField;
        if (field != null) {
            try {
                field.set(popupWindow, java.lang.Boolean.valueOf(z));
            } catch (java.lang.IllegalAccessException unused2) {
            }
        }
    }

    public static void setWindowLayoutType(@androidx.annotation.NonNull android.widget.PopupWindow popupWindow, int i) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i);
            return;
        }
        if (!sSetWindowLayoutTypeMethodAttempted) {
            try {
                java.lang.reflect.Method declaredMethod = android.widget.PopupWindow.class.getDeclaredMethod("setWindowLayoutType", java.lang.Integer.TYPE);
                sSetWindowLayoutTypeMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (java.lang.Exception unused) {
            }
            sSetWindowLayoutTypeMethodAttempted = true;
        }
        java.lang.reflect.Method method = sSetWindowLayoutTypeMethod;
        if (method != null) {
            try {
                method.invoke(popupWindow, java.lang.Integer.valueOf(i));
            } catch (java.lang.Exception unused2) {
            }
        }
    }

    public static void showAsDropDown(@androidx.annotation.NonNull android.widget.PopupWindow popupWindow, @androidx.annotation.NonNull android.view.View view, int i, int i2, int i3) {
        popupWindow.showAsDropDown(view, i, i2, i3);
    }
}
