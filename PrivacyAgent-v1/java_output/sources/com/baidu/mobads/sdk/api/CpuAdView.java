package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public final class CpuAdView extends android.widget.RelativeLayout {
    private com.baidu.mobads.sdk.internal.cs mAdProd;

    public interface CpuAdViewInternalStatusListener {
        void loadDataError(java.lang.String str);

        void onAdClick();

        void onAdImpression(java.lang.String str);

        void onContentClick();

        void onContentImpression(java.lang.String str);

        void onExitLp();

        void onLpContentStatus(java.util.Map<java.lang.String, java.lang.Object> map);
    }

    public CpuAdView(android.content.Context context) {
        super(context);
    }

    public CpuAdView(android.content.Context context, java.lang.String str, int i, com.baidu.mobads.sdk.api.CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        com.baidu.mobads.sdk.internal.cr crVar = new com.baidu.mobads.sdk.internal.cr(context);
        this.mAdProd = new com.baidu.mobads.sdk.internal.cs(context, crVar, str, i, cPUWebAdRequestParam);
        addView(crVar, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    public CpuAdView(android.content.Context context, java.lang.String str, int i, com.baidu.mobads.sdk.api.CPUWebAdRequestParam cPUWebAdRequestParam, com.baidu.mobads.sdk.api.CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        super(context);
        com.baidu.mobads.sdk.internal.cr crVar = new com.baidu.mobads.sdk.internal.cr(context);
        com.baidu.mobads.sdk.internal.cs csVar = new com.baidu.mobads.sdk.internal.cs(context, crVar, str, i, cPUWebAdRequestParam);
        this.mAdProd = csVar;
        csVar.a(cpuAdViewInternalStatusListener);
        addView(crVar, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    public boolean canGoBack() {
        try {
            android.webkit.WebView webView = (android.webkit.WebView) this.mAdProd.w();
            if (webView != null) {
                return webView.canGoBack();
            }
            return false;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public void goBack() {
        try {
            android.webkit.WebView webView = (android.webkit.WebView) this.mAdProd.w();
            if (webView != null) {
                webView.goBack();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void onDestroy() {
        android.view.View w = this.mAdProd.w();
        if (w instanceof android.webkit.WebView) {
            ((android.webkit.WebView) w).destroy();
        }
    }

    public boolean onKeyBackDown(int i, android.view.KeyEvent keyEvent) {
        if (i != 4 || !canGoBack()) {
            return false;
        }
        goBack();
        return true;
    }

    public void onPause() {
        android.view.View w = this.mAdProd.w();
        if (w instanceof android.webkit.WebView) {
            ((android.webkit.WebView) w).onPause();
        }
    }

    public void onResume() {
        android.view.View w = this.mAdProd.w();
        if (w instanceof android.webkit.WebView) {
            ((android.webkit.WebView) w).onResume();
        }
    }

    public void requestData() {
        com.baidu.mobads.sdk.internal.cs csVar = this.mAdProd;
        if (csVar != null) {
            csVar.a();
        }
    }
}
