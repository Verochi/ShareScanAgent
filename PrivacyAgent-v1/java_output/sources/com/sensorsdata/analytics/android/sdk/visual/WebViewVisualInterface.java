package com.sensorsdata.analytics.android.sdk.visual;

/* loaded from: classes19.dex */
public class WebViewVisualInterface {
    private static final java.lang.String TAG = "SA.Visual.WebViewVisualInterface";
    private java.lang.ref.WeakReference<android.view.View> mWebView;

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.WebViewVisualInterface$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$msg;

        public AnonymousClass1(java.lang.String str) {
            this.val$msg = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String str = (java.lang.String) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callMethod(com.sensorsdata.analytics.android.sdk.visual.WebViewVisualInterface.this.mWebView.get(), "getUrl", new java.lang.Object[0]);
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.WebViewVisualInterface.TAG, "sensorsdata_visualized_alert_info url: " + str);
            com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getWebNodesManager().handlerFailure(str, this.val$msg);
        }
    }

    public WebViewVisualInterface(android.view.View view) {
        this.mWebView = new java.lang.ref.WeakReference<>(view);
    }

    @android.webkit.JavascriptInterface
    public void sensorsdata_hover_web_nodes(java.lang.String str) {
        try {
            com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getWebNodesManager().handlerMessage(str);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @android.webkit.JavascriptInterface
    public void sensorsdata_visualized_alert_info(java.lang.String str) {
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "sensorsdata_visualized_alert_info msg: " + str);
            if (this.mWebView.get() != null) {
                this.mWebView.get().post(new com.sensorsdata.analytics.android.sdk.visual.WebViewVisualInterface.AnonymousClass1(str));
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @android.webkit.JavascriptInterface
    public boolean sensorsdata_visualized_mode() {
        return com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance().isServiceRunning() || com.sensorsdata.analytics.android.sdk.visual.HeatMapService.getInstance().isServiceRunning();
    }
}
