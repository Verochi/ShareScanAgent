package com.anythink.expressad.atsignalcommon.base;

/* loaded from: classes12.dex */
public class ActionBar extends android.widget.LinearLayout implements android.view.View.OnClickListener {
    private android.webkit.WebView a;

    public interface a {
        void a();

        android.view.View b();
    }

    public ActionBar(android.content.Context context) {
        super(context);
    }

    public ActionBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private android.view.View a(com.anythink.expressad.atsignalcommon.base.ActionBar.a aVar) {
        android.view.View b = aVar.b();
        if (b == null) {
            return null;
        }
        android.view.View newActionItem = newActionItem();
        ((android.view.ViewGroup) ((android.view.ViewGroup) newActionItem).getChildAt(0)).addView(b);
        b.setTag(aVar);
        b.setOnClickListener(this);
        return newActionItem;
    }

    public void addAction(com.anythink.expressad.atsignalcommon.base.ActionBar.a aVar) {
        addAction(aVar, getChildCount());
    }

    public void addAction(com.anythink.expressad.atsignalcommon.base.ActionBar.a aVar, int i) {
        android.view.View view;
        android.view.View b = aVar.b();
        if (b != null) {
            view = newActionItem();
            ((android.view.ViewGroup) ((android.view.ViewGroup) view).getChildAt(0)).addView(b);
            b.setTag(aVar);
            b.setOnClickListener(this);
        } else {
            view = null;
        }
        addView(view, i);
    }

    public int getActionCount() {
        return getChildCount();
    }

    public android.webkit.WebView getWebView() {
        return this.a;
    }

    public android.view.View newActionItem() {
        android.content.Context context = getContext();
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        linearLayout.setLayoutParams(layoutParams);
        android.view.View frameLayout = new android.widget.FrameLayout(context);
        android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        frameLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(frameLayout);
        return linearLayout;
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        view.getTag();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public boolean removeAction(com.anythink.expressad.atsignalcommon.base.ActionBar.a aVar) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = getChildAt(i);
            if (childAt != null) {
                java.lang.Object tag = childAt.getTag();
                if ((tag instanceof com.anythink.expressad.atsignalcommon.base.ActionBar.a) && tag.equals(aVar)) {
                    removeView(childAt);
                    return true;
                }
            }
        }
        return false;
    }

    public void removeActionAt(int i) {
        if (i < 0 || i >= getChildCount()) {
            return;
        }
        removeViewAt(i);
    }

    public void removeAllActions() {
        removeAllViews();
    }

    public void setWebView(android.webkit.WebView webView) {
        this.a = webView;
    }
}
