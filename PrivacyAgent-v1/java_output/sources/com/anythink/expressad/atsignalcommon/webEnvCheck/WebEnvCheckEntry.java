package com.anythink.expressad.atsignalcommon.webEnvCheck;

/* loaded from: classes12.dex */
public class WebEnvCheckEntry {
    public void check(android.content.Context context) {
        try {
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = new com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView(context);
            java.lang.String str = "<html><script>" + com.anythink.expressad.d.b.b.a().b() + "</script></html>";
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadDataWithBaseURL(windVaneWebView, null, str, "text/html", "utf-8", null);
            windVaneWebView.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
