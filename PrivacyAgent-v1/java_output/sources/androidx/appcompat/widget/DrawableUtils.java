package androidx.appcompat.widget;

@android.annotation.SuppressLint({"RestrictedAPI"})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET = {android.R.attr.state_checked};
    private static final int[] EMPTY_STATE_SET = new int[0];
    public static final android.graphics.Rect INSETS_NONE = new android.graphics.Rect();
    private static final java.lang.String TAG = "DrawableUtils";
    private static final java.lang.String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
    private static java.lang.Class<?> sInsetsClazz;

    static {
        try {
            sInsetsClazz = java.lang.Class.forName("android.graphics.Insets");
        } catch (java.lang.ClassNotFoundException unused) {
        }
    }

    private DrawableUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean canSafelyMutateDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        if (!(drawable instanceof android.graphics.drawable.DrawableContainer)) {
            if (drawable instanceof androidx.core.graphics.drawable.WrappedDrawable) {
                return canSafelyMutateDrawable(((androidx.core.graphics.drawable.WrappedDrawable) drawable).getWrappedDrawable());
            }
            if (drawable instanceof androidx.appcompat.graphics.drawable.DrawableWrapper) {
                return canSafelyMutateDrawable(((androidx.appcompat.graphics.drawable.DrawableWrapper) drawable).getWrappedDrawable());
            }
            if (drawable instanceof android.graphics.drawable.ScaleDrawable) {
                return canSafelyMutateDrawable(((android.graphics.drawable.ScaleDrawable) drawable).getDrawable());
            }
            return true;
        }
        android.graphics.drawable.Drawable.ConstantState constantState = drawable.getConstantState();
        if (!(constantState instanceof android.graphics.drawable.DrawableContainer.DrawableContainerState)) {
            return true;
        }
        for (android.graphics.drawable.Drawable drawable2 : ((android.graphics.drawable.DrawableContainer.DrawableContainerState) constantState).getChildren()) {
            if (!canSafelyMutateDrawable(drawable2)) {
                return false;
            }
        }
        return true;
    }

    public static void fixDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        if (android.os.Build.VERSION.SDK_INT == 21 && VECTOR_DRAWABLE_CLAZZ_NAME.equals(drawable.getClass().getName())) {
            fixVectorDrawableTinting(drawable);
        }
    }

    private static void fixVectorDrawableTinting(android.graphics.drawable.Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(CHECKED_STATE_SET);
        } else {
            drawable.setState(EMPTY_STATE_SET);
        }
        drawable.setState(state);
    }

    public static android.graphics.Rect getOpticalBounds(android.graphics.drawable.Drawable drawable) {
        char c;
        android.graphics.Insets opticalInsets;
        int i;
        int i2;
        int i3;
        int i4;
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            opticalInsets = drawable.getOpticalInsets();
            android.graphics.Rect rect = new android.graphics.Rect();
            i = opticalInsets.left;
            rect.left = i;
            i2 = opticalInsets.right;
            rect.right = i2;
            i3 = opticalInsets.top;
            rect.top = i3;
            i4 = opticalInsets.bottom;
            rect.bottom = i4;
            return rect;
        }
        if (sInsetsClazz != null) {
            try {
                android.graphics.drawable.Drawable unwrap = androidx.core.graphics.drawable.DrawableCompat.unwrap(drawable);
                java.lang.Object invoke = unwrap.getClass().getMethod("getOpticalInsets", new java.lang.Class[0]).invoke(unwrap, new java.lang.Object[0]);
                if (invoke != null) {
                    android.graphics.Rect rect2 = new android.graphics.Rect();
                    for (java.lang.reflect.Field field : sInsetsClazz.getFields()) {
                        java.lang.String name = field.getName();
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals(com.sensorsdata.sf.ui.view.UIProperty.bottom)) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 115029:
                                if (name.equals(com.sensorsdata.sf.ui.view.UIProperty.top)) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3317767:
                                if (name.equals(com.sensorsdata.sf.ui.view.UIProperty.left)) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 108511772:
                                if (name.equals(com.sensorsdata.sf.ui.view.UIProperty.right)) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        if (c == 0) {
                            rect2.left = field.getInt(invoke);
                        } else if (c == 1) {
                            rect2.top = field.getInt(invoke);
                        } else if (c == 2) {
                            rect2.right = field.getInt(invoke);
                        } else if (c == 3) {
                            rect2.bottom = field.getInt(invoke);
                        }
                    }
                    return rect2;
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return INSETS_NONE;
    }

    public static android.graphics.PorterDuff.Mode parseTintMode(int i, android.graphics.PorterDuff.Mode mode) {
        if (i == 3) {
            return android.graphics.PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return android.graphics.PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return android.graphics.PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return android.graphics.PorterDuff.Mode.MULTIPLY;
            case 15:
                return android.graphics.PorterDuff.Mode.SCREEN;
            case 16:
                return android.graphics.PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
