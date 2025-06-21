package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class WebUtils {
    private static final java.lang.String TAG = "SA.WebUtils";

    private static void invokeWebViewLoad(android.view.View view, java.lang.String str, java.lang.Object[] objArr, java.lang.Class<?>[] clsArr) {
        if (view == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "WebView has not initialized.");
            return;
        }
        try {
            view.getClass().getMethod(str, clsArr).invoke(view, objArr);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void loadUrl(android.view.View view, java.lang.String str) {
        invokeWebViewLoad(view, "loadUrl", new java.lang.Object[]{str}, new java.lang.Class[]{java.lang.String.class});
    }
}
