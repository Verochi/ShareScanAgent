package com.sensorsdata.analytics.android.sdk.exposure;

@android.annotation.SuppressLint({"NewApi"})
/* loaded from: classes19.dex */
public class AppPageChange implements android.view.ViewTreeObserver.OnGlobalLayoutListener, android.view.ViewTreeObserver.OnScrollChangedListener, android.view.ViewTreeObserver.OnGlobalFocusChangeListener, android.view.ViewTreeObserver.OnWindowFocusChangeListener {
    private static final java.lang.String TAG = "SA.AppPageChange";
    private final com.sensorsdata.analytics.android.sdk.exposure.ExposedTransform.LayoutCallBack mLayoutCallBack;

    public AppPageChange(com.sensorsdata.analytics.android.sdk.exposure.ExposedTransform.LayoutCallBack layoutCallBack) {
        this.mLayoutCallBack = layoutCallBack;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(android.view.View view, android.view.View view2) {
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onGlobalFocusChanged");
        this.mLayoutCallBack.viewLayoutChange();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onGlobalLayout");
        this.mLayoutCallBack.viewLayoutChange();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onScrollChanged");
        this.mLayoutCallBack.viewLayoutChange();
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z) {
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onWindowFocusChanged");
        this.mLayoutCallBack.viewLayoutChange();
    }
}
