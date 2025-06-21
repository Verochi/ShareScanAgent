package com.anythink.expressad.video.signal.a;

/* loaded from: classes12.dex */
public final class l extends com.anythink.expressad.video.signal.a.e {
    private static final java.lang.String n = "onVideoStatusNotify";
    private static final java.lang.String o = "onJSClick";
    private static final java.lang.String p = "onVideoProgressNotify";
    private static final java.lang.String q = "webviewshow";
    private static final java.lang.String r = "showDataInfo";

    /* renamed from: s, reason: collision with root package name */
    private static final java.lang.String f279s = "portrait";
    private static final java.lang.String t = "landscape";
    private android.webkit.WebView u;

    public l(android.webkit.WebView webView) {
        this.u = webView;
    }

    private static java.lang.String a(int i, int i2) {
        if (i2 != 0) {
            double d = i / i2;
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(com.anythink.expressad.foundation.h.t.a(java.lang.Double.valueOf(d)));
                return sb.toString();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return java.lang.String.valueOf(i2);
    }

    @Override // com.anythink.expressad.video.signal.a.e, com.anythink.expressad.video.signal.g
    public final void a() {
        super.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a(this.u);
    }

    @Override // com.anythink.expressad.video.signal.a.e, com.anythink.expressad.video.signal.g
    public final void a(int i) {
        super.a(i);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("status", i);
            java.lang.String encodeToString = android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(this.u, n, encodeToString);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.e, com.anythink.expressad.video.signal.g
    public final void a(int i, int i2, int i3, int i4) {
        super.a(i, i2, i3, i4);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            java.lang.String str = t;
            if (i != 2 ? i2 != 2 : i2 == 1) {
                str = f279s;
            }
            jSONObject2.put("orientation", str);
            jSONObject2.put("screen_width", i3);
            jSONObject2.put("screen_height", i4);
            jSONObject.put("data", jSONObject2);
            java.lang.String encodeToString = android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(this.u, r, encodeToString);
        } catch (java.lang.Exception e) {
            if (com.anythink.expressad.a.a) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.a.e, com.anythink.expressad.video.signal.g
    public final void a(int i, java.lang.String str) {
        super.a(i, str);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("type", i);
            jSONObject.put(com.meizu.cloud.pushsdk.notification.model.AdvertisementOption.PRIORITY_VALID_TIME, str);
            java.lang.String encodeToString = android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(this.u, o, encodeToString);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.e, com.anythink.expressad.video.signal.g
    public final void a(com.anythink.expressad.video.module.AnythinkVideoView.a aVar) {
        super.a(aVar);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(androidx.core.app.NotificationCompat.CATEGORY_PROGRESS, a(aVar.a, aVar.b));
            jSONObject.put("time", java.lang.String.valueOf(aVar.a));
            jSONObject.put("duration", java.lang.String.valueOf(aVar.b));
            java.lang.String encodeToString = android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(this.u, p, encodeToString);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.e, com.anythink.expressad.video.signal.g
    public final void a(java.lang.Object obj) {
        super.a(obj);
        java.lang.String encodeToString = (obj == null || !(obj instanceof java.lang.String)) ? "" : android.util.Base64.encodeToString(obj.toString().getBytes(), 2);
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a(this.u, q, encodeToString);
    }
}
