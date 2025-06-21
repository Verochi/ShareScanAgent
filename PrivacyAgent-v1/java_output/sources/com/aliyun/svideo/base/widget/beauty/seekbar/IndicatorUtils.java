package com.aliyun.svideo.base.widget.beauty.seekbar;

/* loaded from: classes.dex */
public class IndicatorUtils {
    public static int dp2px(android.content.Context context, float f) {
        return (int) android.util.TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    private static int indexOfViewInParent(android.view.View view, android.view.ViewGroup viewGroup) {
        int i = 0;
        while (i < viewGroup.getChildCount() && viewGroup.getChildAt(i) != view) {
            i++;
        }
        return i;
    }

    public static boolean isViewCovered(android.view.View view) {
        android.graphics.Rect rect = new android.graphics.Rect();
        if (!(view.getGlobalVisibleRect(rect) && (rect.bottom - rect.top >= view.getMeasuredHeight()) && (rect.right - rect.left >= view.getMeasuredWidth()))) {
            return true;
        }
        android.view.View view2 = view;
        while (view2.getParent() instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view2.getParent();
            if (viewGroup.getVisibility() != 0) {
                return true;
            }
            for (int indexOfViewInParent = indexOfViewInParent(view2, viewGroup) + 1; indexOfViewInParent < viewGroup.getChildCount(); indexOfViewInParent++) {
                android.graphics.Rect rect2 = new android.graphics.Rect();
                view.getGlobalVisibleRect(rect2);
                android.view.View childAt = viewGroup.getChildAt(indexOfViewInParent);
                android.graphics.Rect rect3 = new android.graphics.Rect();
                childAt.getGlobalVisibleRect(rect3);
                if (android.graphics.Rect.intersects(rect2, rect3)) {
                    return true;
                }
            }
            view2 = viewGroup;
        }
        return false;
    }

    public static int px2sp(android.content.Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int sp2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
