package com.anythink.expressad.atsignalcommon.mraid;

/* loaded from: classes12.dex */
public class CallMraidJS {
    public static final java.lang.String a = "placementType";
    public static final java.lang.String b = "state";
    public static final java.lang.String c = "viewable";
    public static final java.lang.String d = "currentAppOrientation";
    public static final java.lang.String e = "loading";
    public static final java.lang.String f = "default";
    public static final java.lang.String g = "expanded";
    public static final java.lang.String h = "hidden";
    public static final java.lang.String i = "resized";
    public static final java.lang.String j = "Interstitial";
    public static final java.lang.String k = "inline";

    public static class SingletonHolder {
        private static final com.anythink.expressad.atsignalcommon.mraid.CallMraidJS a = new com.anythink.expressad.atsignalcommon.mraid.CallMraidJS();

        private SingletonHolder() {
        }
    }

    private static void a(android.webkit.WebView webView, java.lang.String str) {
        if (webView != null) {
            try {
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str);
                webView.loadUrl(str);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static com.anythink.expressad.atsignalcommon.mraid.CallMraidJS getInstance() {
        return com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.SingletonHolder.a;
    }

    public void fireAudioVolumeChange(android.webkit.WebView webView, double d2) {
        a(webView, java.lang.String.format(java.util.Locale.CHINA, "javascript:window.mraidbridge.audioVolumeChange(%s);", java.lang.Double.valueOf(d2)));
    }

    public void fireChangeEventForPropertys(android.webkit.WebView webView, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        a(webView, java.lang.String.format("javascript:window.mraidbridge.fireChangeEvent(%s);", jSONObject.toString()));
    }

    public void fireErrorEvent(android.webkit.WebView webView, java.lang.String str, java.lang.String str2) {
        a(webView, java.lang.String.format("javascript:window.mraidbridge.fireErrorEvent('%1s', '%2s');", str2, str));
    }

    public void fireNativeMethodCompleteEvent(android.webkit.WebView webView, java.lang.String str) {
        a(webView, java.lang.String.format("javascript:window.mraidbridge.nativeCallComplete('%s');", str));
    }

    public void fireReadyEvent(android.webkit.WebView webView) {
        a(webView, "javascript:window.mraidbridge.fireReadyEvent();");
    }

    public void fireSetCurrentPosition(android.webkit.WebView webView, float f2, float f3, float f4, float f5) {
        a(webView, java.lang.String.format(java.util.Locale.CHINA, "javascript:window.mraidbridge.setCurrentPosition(%.1f, %.1f, %.1f, %.1f);", java.lang.Float.valueOf(f2), java.lang.Float.valueOf(f3), java.lang.Float.valueOf(f4), java.lang.Float.valueOf(f5)));
    }

    public void fireSetDefaultPosition(android.webkit.WebView webView, float f2, float f3, float f4, float f5) {
        a(webView, java.lang.String.format(java.util.Locale.CHINA, "javascript:window.mraidbridge.setDefaultPosition(%.1f, %.1f, %.1f, %.1f);", java.lang.Float.valueOf(f2), java.lang.Float.valueOf(f3), java.lang.Float.valueOf(f4), java.lang.Float.valueOf(f5)));
    }

    public void fireSetIsViewable(android.webkit.WebView webView, java.lang.String str) {
        a(webView, java.lang.String.format("javascript:window.mraidbridge.setIsViewable(%s);", str));
    }

    public void fireSetMaxSize(android.webkit.WebView webView, float f2, float f3) {
        a(webView, java.lang.String.format(java.util.Locale.CHINA, "javascript:window.mraidbridge.setMaxSize(%.1f, %.1f);", java.lang.Float.valueOf(f2), java.lang.Float.valueOf(f3)));
    }

    public void fireSetPlacementType(android.webkit.WebView webView, java.lang.String str) {
        a(webView, java.lang.String.format("javascript:window.mraidbridge.setPlacementType(%s);", str));
    }

    public void fireSetScreenSize(android.webkit.WebView webView, float f2, float f3) {
        a(webView, java.lang.String.format(java.util.Locale.CHINA, "javascript:window.mraidbridge.setScreenSize(%.1f, %.1f);", java.lang.Float.valueOf(f2), java.lang.Float.valueOf(f3)));
    }

    public void fireSizeChangeEvent(android.webkit.WebView webView, float f2, float f3) {
        a(webView, java.lang.String.format(java.util.Locale.CHINA, "javascript:window.mraidbridge.notifySizeChangeEvent(%.1f, %.1f);", java.lang.Float.valueOf(f2), java.lang.Float.valueOf(f3)));
    }
}
