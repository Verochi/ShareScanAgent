package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public final class y {
    private static final java.lang.String a = "ViewUtils";
    private static boolean b;

    private static int a(android.view.View view, android.view.ViewGroup viewGroup) {
        int i = 0;
        while (i < viewGroup.getChildCount() && viewGroup.getChildAt(i) != view) {
            i++;
        }
        return i;
    }

    public static boolean a(android.view.View view) {
        if (view.getVisibility() != 0 || view.getAlpha() < 0.5f) {
            return true;
        }
        if (view.getParent() != null && (view.getParent() instanceof android.view.ViewGroup) && ((android.view.ViewGroup) view.getParent()).getVisibility() != 0) {
            return true;
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        if (!(view.getGlobalVisibleRect(rect) && ((rect.bottom - rect.top) * (rect.right - rect.left) >= (view.getMeasuredHeight() * view.getMeasuredWidth()) / 2))) {
            return true;
        }
        android.view.View view2 = view;
        while (view2.getParent() instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view2.getParent();
            for (int a2 = a(view2, viewGroup) + 1; a2 < viewGroup.getChildCount(); a2++) {
                android.view.View childAt = viewGroup.getChildAt(a2);
                if (childAt.getVisibility() == 0 && a(view, childAt)) {
                    if (childAt instanceof android.view.ViewGroup) {
                        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) childAt;
                        if (viewGroup2.getChildCount() > 0) {
                            boolean b2 = b(view, viewGroup2);
                            b = false;
                            if (b2) {
                                return true;
                            }
                        }
                    }
                    if (b(childAt)) {
                        return true;
                    }
                }
            }
            view2 = viewGroup;
        }
        return false;
    }

    private static boolean a(android.view.View view, android.view.View view2) {
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getGlobalVisibleRect(rect);
        android.graphics.Rect rect2 = new android.graphics.Rect();
        view2.getGlobalVisibleRect(rect2);
        return android.graphics.Rect.intersects(rect, rect2) && ((java.lang.Math.min(rect.right, rect2.right) - java.lang.Math.max(rect.left, rect2.left)) * (java.lang.Math.min(rect.bottom, rect2.bottom) - java.lang.Math.max(rect.top, rect2.top))) * 2 >= view.getMeasuredHeight() * view.getMeasuredWidth();
    }

    private static boolean b(android.view.View view) {
        return view.getAlpha() > 0.5f && view.getBackground() != null && view.getBackground().getAlpha() > 127;
    }

    private static boolean b(android.view.View view, android.view.ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            android.view.View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0 && a(view, childAt)) {
                if ((childAt instanceof android.webkit.WebView) && childAt.getVisibility() == 0) {
                    b = true;
                }
                if (b(childAt)) {
                    b = true;
                }
                if (b) {
                    break;
                }
                if (childAt instanceof android.view.ViewGroup) {
                    b(view, (android.view.ViewGroup) childAt);
                }
            }
        }
        return b;
    }
}
