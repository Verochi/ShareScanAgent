package com.efs.sdk.h5pagesdk;

/* loaded from: classes22.dex */
public class H5Manager {
    public static final java.lang.String TAG = "H5Manager";
    private static com.efs.sdk.base.EfsReporter g = null;
    private static com.efs.sdk.h5pagesdk.H5ConfigMananger h = null;
    public static boolean isDebug = true;

    public static com.efs.sdk.h5pagesdk.H5ConfigMananger getH5ConfigMananger() {
        return h;
    }

    public static com.efs.sdk.base.EfsReporter getReporter() {
        return g;
    }

    public static void init(android.content.Context context, com.efs.sdk.base.EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            com.efs.sdk.base.core.util.Log.e(TAG, "init H5 manager error! parameter is null!");
        } else {
            g = efsReporter;
            h = new com.efs.sdk.h5pagesdk.H5ConfigMananger(context, efsReporter);
        }
    }

    public static void setWebView(android.view.View view) {
        com.efs.sdk.h5pagesdk.H5ConfigMananger h5ConfigMananger;
        if (view == null || (h5ConfigMananger = h) == null) {
            if (isDebug) {
                com.efs.sdk.base.core.util.Log.e(TAG, "webView为null，或H5功能未初始化完成");
                return;
            }
            return;
        }
        if (h5ConfigMananger.isH5TracerEnable() || com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            com.efs.sdk.h5pagesdk.UApmJSBridge uApmJSBridge = new com.efs.sdk.h5pagesdk.UApmJSBridge();
            try {
                java.lang.Class<?> cls = view.getClass();
                try {
                    java.lang.Object invoke = cls.getMethod("getSettings", new java.lang.Class[0]).invoke(view, new java.lang.Object[0]);
                    if (invoke != null) {
                        invoke.getClass().getMethod("setJavaScriptEnabled", java.lang.Boolean.TYPE).invoke(invoke, java.lang.Boolean.TRUE);
                    }
                } catch (java.lang.Throwable unused) {
                }
                cls.getMethod("addJavascriptInterface", java.lang.Object.class, java.lang.String.class).invoke(view, uApmJSBridge, "UAPM_JSBridge");
                return;
            } catch (java.lang.Throwable unused2) {
                return;
            }
        }
        if (isDebug) {
            com.efs.sdk.base.core.util.Log.d(TAG, "未注入JavascriptInterface：H5命中状态=" + h.isH5TracerEnable() + "; 集成测试状态=" + com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod());
        }
    }
}
