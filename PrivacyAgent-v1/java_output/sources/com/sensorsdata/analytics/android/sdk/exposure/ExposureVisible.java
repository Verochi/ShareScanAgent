package com.sensorsdata.analytics.android.sdk.exposure;

/* loaded from: classes19.dex */
public class ExposureVisible {
    private final java.util.HashMap<java.lang.String, java.lang.Boolean> mVisible = new java.util.HashMap<>();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.ViewParent] */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.view.ViewParent] */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.view.ViewParent] */
    private boolean isParentVisible(android.view.View view) {
        if (view == null) {
            return false;
        }
        android.view.View parent = view.getParent();
        while (parent instanceof android.view.View) {
            if (!isViewSelfVisible(parent, new android.graphics.Rect()) || (parent = parent.getParent()) == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isViewSelfVisible(android.view.View view, android.graphics.Rect rect) {
        boolean booleanValue;
        if (view == null || view.getWindowVisibility() == 8) {
            com.sensorsdata.analytics.android.sdk.SALog.i("SA.ExposureVisible", "view.getWindowVisibility() == View.GONE");
            return false;
        }
        java.lang.Boolean bool = this.mVisible.get(view.hashCode() + "");
        if (bool == null) {
            booleanValue = view.getLocalVisibleRect(rect);
            this.mVisible.put(view.hashCode() + "", java.lang.Boolean.valueOf(booleanValue));
        } else {
            booleanValue = bool.booleanValue();
        }
        if (com.sensorsdata.analytics.android.sdk.util.WindowHelper.isDecorView(view.getClass())) {
            return true;
        }
        if (view.getWidth() > 0 && view.getHeight() > 0 && view.getAlpha() > 0.0f && booleanValue) {
            return (view.getAnimation() != null && view.getAnimation().getFillAfter()) || view.getVisibility() == 0;
        }
        com.sensorsdata.analytics.android.sdk.SALog.i("SA.ExposureVisible", "isViewSelfVisible，width = " + view.getWidth() + ",height = " + view.getHeight() + "，alpha = " + view.getAlpha());
        return false;
    }

    public void cleanVisible() {
        this.mVisible.clear();
    }

    public boolean isVisible(android.view.View view, android.graphics.Rect rect) {
        if (isViewSelfVisible(view, rect) && isParentVisible(view)) {
            return view.isShown();
        }
        return false;
    }
}
