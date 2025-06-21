package androidx.transition;

/* loaded from: classes.dex */
class ViewGroupUtilsApi14 {
    private static final int LAYOUT_TRANSITION_CHANGING = 4;
    private static final java.lang.String TAG = "ViewGroupUtilsApi14";
    private static java.lang.reflect.Method sCancelMethod;
    private static boolean sCancelMethodFetched;
    private static android.animation.LayoutTransition sEmptyLayoutTransition;
    private static java.lang.reflect.Field sLayoutSuppressedField;
    private static boolean sLayoutSuppressedFieldFetched;

    /* renamed from: androidx.transition.ViewGroupUtilsApi14$1, reason: invalid class name */
    public static class AnonymousClass1 extends android.animation.LayoutTransition {
        @Override // android.animation.LayoutTransition
        public boolean isChangingLayout() {
            return true;
        }
    }

    private ViewGroupUtilsApi14() {
    }

    private static void cancelLayoutTransition(android.animation.LayoutTransition layoutTransition) {
        if (!sCancelMethodFetched) {
            try {
                java.lang.reflect.Method declaredMethod = android.animation.LayoutTransition.class.getDeclaredMethod(com.anythink.expressad.d.a.b.dO, new java.lang.Class[0]);
                sCancelMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (java.lang.NoSuchMethodException unused) {
            }
            sCancelMethodFetched = true;
        }
        java.lang.reflect.Method method = sCancelMethod;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new java.lang.Object[0]);
            } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused2) {
            }
        }
    }

    public static void suppressLayout(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, boolean z) {
        boolean z2 = false;
        if (sEmptyLayoutTransition == null) {
            androidx.transition.ViewGroupUtilsApi14.AnonymousClass1 anonymousClass1 = new androidx.transition.ViewGroupUtilsApi14.AnonymousClass1();
            sEmptyLayoutTransition = anonymousClass1;
            anonymousClass1.setAnimator(2, null);
            sEmptyLayoutTransition.setAnimator(0, null);
            sEmptyLayoutTransition.setAnimator(1, null);
            sEmptyLayoutTransition.setAnimator(3, null);
            sEmptyLayoutTransition.setAnimator(4, null);
        }
        if (z) {
            android.animation.LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    cancelLayoutTransition(layoutTransition);
                }
                if (layoutTransition != sEmptyLayoutTransition) {
                    viewGroup.setTag(androidx.transition.R.id.transition_layout_save, layoutTransition);
                }
            }
            viewGroup.setLayoutTransition(sEmptyLayoutTransition);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!sLayoutSuppressedFieldFetched) {
            try {
                java.lang.reflect.Field declaredField = android.view.ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                sLayoutSuppressedField = declaredField;
                declaredField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused) {
            }
            sLayoutSuppressedFieldFetched = true;
        }
        java.lang.reflect.Field field = sLayoutSuppressedField;
        if (field != null) {
            try {
                boolean z3 = field.getBoolean(viewGroup);
                if (z3) {
                    try {
                        sLayoutSuppressedField.setBoolean(viewGroup, false);
                    } catch (java.lang.IllegalAccessException unused2) {
                    }
                }
                z2 = z3;
            } catch (java.lang.IllegalAccessException unused3) {
            }
        }
        if (z2) {
            viewGroup.requestLayout();
        }
        int i = androidx.transition.R.id.transition_layout_save;
        android.animation.LayoutTransition layoutTransition2 = (android.animation.LayoutTransition) viewGroup.getTag(i);
        if (layoutTransition2 != null) {
            viewGroup.setTag(i, null);
            viewGroup.setLayoutTransition(layoutTransition2);
        }
    }
}
