package androidx.transition;

/* loaded from: classes.dex */
class ViewGroupUtils {
    private static java.lang.reflect.Method sGetChildDrawingOrderMethod = null;
    private static boolean sGetChildDrawingOrderMethodFetched = false;
    private static boolean sTryHiddenSuppressLayout = true;

    private ViewGroupUtils() {
    }

    public static int getChildDrawingOrder(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, int i) {
        int childDrawingOrder;
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            childDrawingOrder = viewGroup.getChildDrawingOrder(i);
            return childDrawingOrder;
        }
        if (!sGetChildDrawingOrderMethodFetched) {
            try {
                java.lang.Class cls = java.lang.Integer.TYPE;
                java.lang.reflect.Method declaredMethod = android.view.ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", cls, cls);
                sGetChildDrawingOrderMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (java.lang.NoSuchMethodException unused) {
            }
            sGetChildDrawingOrderMethodFetched = true;
        }
        java.lang.reflect.Method method = sGetChildDrawingOrderMethod;
        if (method != null) {
            try {
                return ((java.lang.Integer) method.invoke(viewGroup, java.lang.Integer.valueOf(viewGroup.getChildCount()), java.lang.Integer.valueOf(i))).intValue();
            } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused2) {
            }
        }
        return i;
    }

    public static androidx.transition.ViewGroupOverlayImpl getOverlay(@androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        return new androidx.transition.ViewGroupOverlayApi18(viewGroup);
    }

    @androidx.annotation.RequiresApi(18)
    @android.annotation.SuppressLint({"NewApi"})
    private static void hiddenSuppressLayout(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, boolean z) {
        if (sTryHiddenSuppressLayout) {
            try {
                viewGroup.suppressLayout(z);
            } catch (java.lang.NoSuchMethodError unused) {
                sTryHiddenSuppressLayout = false;
            }
        }
    }

    public static void suppressLayout(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, boolean z) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else {
            hiddenSuppressLayout(viewGroup, z);
        }
    }
}
