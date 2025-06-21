package com.anythink.expressad.mbbanner.a.a;

/* loaded from: classes12.dex */
public final class a {
    private static final java.lang.String a = "BannerCallJS";

    public static void a(android.webkit.WebView webView) {
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.b(webView);
    }

    public static void a(android.webkit.WebView webView, float f, float f2) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("startX", f);
            jSONObject.put("startY", f2);
            jSONObject.put("scale", com.anythink.expressad.foundation.h.t.c(com.anythink.core.common.b.o.a().f()));
            java.lang.String encodeToString = android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(webView, "webviewshow", encodeToString);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void a(android.webkit.WebView webView, int i, int i2) {
        try {
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSizeChangeEvent(webView, i, i2);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.webkit.WebView webView, int i, int i2, int i3, int i4) {
        try {
            int i5 = com.anythink.core.common.b.o.a().f().getResources().getConfiguration().orientation;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("orientation", i5 == 2 ? "landscape" : i5 == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
            float e = com.anythink.expressad.foundation.h.k.e(com.anythink.core.common.b.o.a().f());
            float f = com.anythink.expressad.foundation.h.k.f(com.anythink.core.common.b.o.a().f());
            java.util.HashMap g = com.anythink.expressad.foundation.h.k.g(com.anythink.core.common.b.o.a().f());
            int intValue = ((java.lang.Integer) g.get("width")).intValue();
            int intValue2 = ((java.lang.Integer) g.get("height")).intValue();
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.a, com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.k);
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "default");
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.c, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
            hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.d, jSONObject);
            float f2 = i;
            float f3 = i2;
            float f4 = i3;
            float f5 = i4;
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetDefaultPosition(webView, f2, f3, f4, f5);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetCurrentPosition(webView, f2, f3, f4, f5);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetScreenSize(webView, e, f);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetMaxSize(webView, intValue, intValue2);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireChangeEventForPropertys(webView, hashMap);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireReadyEvent(webView);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, boolean z) {
        try {
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetIsViewable(windVaneWebView, z ? com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        } catch (java.lang.Throwable unused) {
        }
    }
}
