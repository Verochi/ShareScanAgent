package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class ViewSize implements com.alimm.tanx.core.utils.NotConfused {
    public static void setViewSize(android.view.View view, int i, int i2) {
        if (view.getParent() instanceof android.widget.FrameLayout) {
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
            view.requestLayout();
            return;
        }
        if (view.getParent() instanceof android.widget.RelativeLayout) {
            android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.width = i;
            layoutParams2.height = i2;
            view.setLayoutParams(layoutParams2);
            view.requestLayout();
            return;
        }
        if (view.getParent() instanceof android.widget.LinearLayout) {
            android.widget.LinearLayout.LayoutParams layoutParams3 = (android.widget.LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams3.width = i;
            layoutParams3.height = i2;
            view.setLayoutParams(layoutParams3);
            view.requestLayout();
        }
    }
}
