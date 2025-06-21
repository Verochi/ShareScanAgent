package androidx.core.view;

/* loaded from: classes.dex */
public final class ViewParentCompat {
    private static final java.lang.String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    private ViewParentCompat() {
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] iArr = sTempNestedScrollConsumed;
        if (iArr == null) {
            sTempNestedScrollConsumed = new int[2];
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return sTempNestedScrollConsumed;
    }

    public static void notifySubtreeAccessibilityStateChanged(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i);
    }

    public static boolean onNestedFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2, boolean z) {
        try {
            return viewParent.onNestedFling(view, f, f2, z);
        } catch (java.lang.AbstractMethodError unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("ViewParent ");
            sb.append(viewParent);
            sb.append(" does not implement interface method onNestedFling");
            return false;
        }
    }

    public static boolean onNestedPreFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2) {
        try {
            return viewParent.onNestedPreFling(view, f, f2);
        } catch (java.lang.AbstractMethodError unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("ViewParent ");
            sb.append(viewParent);
            sb.append(" does not implement interface method onNestedPreFling");
            return false;
        }
    }

    public static void onNestedPreScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(viewParent, view, i, i2, iArr, 0);
    }

    public static void onNestedPreScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof androidx.core.view.NestedScrollingParent2) {
            ((androidx.core.view.NestedScrollingParent2) viewParent).onNestedPreScroll(view, i, i2, iArr, i3);
            return;
        }
        if (i3 == 0) {
            try {
                viewParent.onNestedPreScroll(view, i, i2, iArr);
            } catch (java.lang.AbstractMethodError unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("ViewParent ");
                sb.append(viewParent);
                sb.append(" does not implement interface method onNestedPreScroll");
            }
        }
    }

    public static void onNestedScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int i3, int i4) {
        onNestedScroll(viewParent, view, i, i2, i3, i4, 0, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int i3, int i4, int i5) {
        onNestedScroll(viewParent, view, i, i2, i3, i4, i5, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int i3, int i4, int i5, @androidx.annotation.NonNull int[] iArr) {
        if (viewParent instanceof androidx.core.view.NestedScrollingParent3) {
            ((androidx.core.view.NestedScrollingParent3) viewParent).onNestedScroll(view, i, i2, i3, i4, i5, iArr);
            return;
        }
        iArr[0] = iArr[0] + i3;
        iArr[1] = iArr[1] + i4;
        if (viewParent instanceof androidx.core.view.NestedScrollingParent2) {
            ((androidx.core.view.NestedScrollingParent2) viewParent).onNestedScroll(view, i, i2, i3, i4, i5);
            return;
        }
        if (i5 == 0) {
            try {
                viewParent.onNestedScroll(view, i, i2, i3, i4);
            } catch (java.lang.AbstractMethodError unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("ViewParent ");
                sb.append(viewParent);
                sb.append(" does not implement interface method onNestedScroll");
            }
        }
    }

    public static void onNestedScrollAccepted(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
        onNestedScrollAccepted(viewParent, view, view2, i, 0);
    }

    public static void onNestedScrollAccepted(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i, int i2) {
        if (viewParent instanceof androidx.core.view.NestedScrollingParent2) {
            ((androidx.core.view.NestedScrollingParent2) viewParent).onNestedScrollAccepted(view, view2, i, i2);
            return;
        }
        if (i2 == 0) {
            try {
                viewParent.onNestedScrollAccepted(view, view2, i);
            } catch (java.lang.AbstractMethodError unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("ViewParent ");
                sb.append(viewParent);
                sb.append(" does not implement interface method onNestedScrollAccepted");
            }
        }
    }

    public static boolean onStartNestedScroll(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
        return onStartNestedScroll(viewParent, view, view2, i, 0);
    }

    public static boolean onStartNestedScroll(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i, int i2) {
        if (viewParent instanceof androidx.core.view.NestedScrollingParent2) {
            return ((androidx.core.view.NestedScrollingParent2) viewParent).onStartNestedScroll(view, view2, i, i2);
        }
        if (i2 != 0) {
            return false;
        }
        try {
            return viewParent.onStartNestedScroll(view, view2, i);
        } catch (java.lang.AbstractMethodError unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("ViewParent ");
            sb.append(viewParent);
            sb.append(" does not implement interface method onStartNestedScroll");
            return false;
        }
    }

    public static void onStopNestedScroll(android.view.ViewParent viewParent, android.view.View view) {
        onStopNestedScroll(viewParent, view, 0);
    }

    public static void onStopNestedScroll(android.view.ViewParent viewParent, android.view.View view, int i) {
        if (viewParent instanceof androidx.core.view.NestedScrollingParent2) {
            ((androidx.core.view.NestedScrollingParent2) viewParent).onStopNestedScroll(view, i);
            return;
        }
        if (i == 0) {
            try {
                viewParent.onStopNestedScroll(view);
            } catch (java.lang.AbstractMethodError unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("ViewParent ");
                sb.append(viewParent);
                sb.append(" does not implement interface method onStopNestedScroll");
            }
        }
    }

    @java.lang.Deprecated
    public static boolean requestSendAccessibilityEvent(android.view.ViewParent viewParent, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }
}
