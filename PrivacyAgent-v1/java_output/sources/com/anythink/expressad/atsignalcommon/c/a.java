package com.anythink.expressad.atsignalcommon.c;

/* loaded from: classes12.dex */
public final class a {
    private static int b = 0;
    private static int c = 1;
    private java.lang.String a;
    private java.lang.String d;
    private java.lang.String e;
    private com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView f;

    /* renamed from: com.anythink.expressad.atsignalcommon.c.a$a, reason: collision with other inner class name */
    public static class C0181a {
        static com.anythink.expressad.atsignalcommon.c.a a = new com.anythink.expressad.atsignalcommon.c.a((byte) 0);

        private C0181a() {
        }
    }

    private a() {
        this.a = "ShakeCacheManager";
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    public static com.anythink.expressad.atsignalcommon.c.a a() {
        return com.anythink.expressad.atsignalcommon.c.a.C0181a.a;
    }

    private static void a(java.lang.Object obj, android.webkit.WebView webView, java.lang.String str, java.lang.String str2) {
        if (webView != null) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("currentCache", str);
                a(obj, str2, jSONObject);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void a(java.lang.Object obj, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView) {
        if (windVaneWebView != null) {
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, "releaseShake", "");
        }
    }

    private void a(java.lang.Object obj, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if ((str + str2 + str3).equals(this.d)) {
            a(obj, windVaneWebView);
        }
    }

    private static void a(java.lang.Object obj, java.lang.String str, org.json.JSONObject jSONObject) {
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("code", c);
            jSONObject2.put("message", str);
            jSONObject2.put("data", jSONObject);
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    private static void a(java.lang.Object obj, org.json.JSONObject jSONObject) {
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("code", b);
            jSONObject2.put("message", "");
            jSONObject2.put("data", jSONObject);
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (java.lang.Exception e) {
            a(obj, e.getMessage(), new org.json.JSONObject());
            e.getMessage();
        }
    }

    private static void b(java.lang.Object obj) {
        a(obj, new org.json.JSONObject());
    }

    public final void a(java.lang.Object obj) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("cache", this.e);
            a(obj, jSONObject);
        } catch (org.json.JSONException e) {
            a(obj, e.getMessage(), new org.json.JSONObject());
        }
    }

    public final void a(java.lang.Object obj, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(this.e) && this.e.equals(str)) {
            this.e = "";
            this.f = null;
            a(obj, windVaneWebView);
            a(obj, new org.json.JSONObject());
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("currentCache", this.e);
            a(obj, "cache is exception", jSONObject);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public final void a(java.lang.Object obj, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, java.lang.String str, java.lang.String str2) {
        if ((!android.text.TextUtils.isEmpty(this.e) && this.e.equals(str)) || (android.text.TextUtils.isEmpty(this.e) && android.text.TextUtils.isEmpty(str))) {
            this.e = str2;
            if (!android.text.TextUtils.isEmpty(str2)) {
                try {
                    this.d = new org.json.JSONObject(str2).optString("sid");
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
            }
            this.f = windVaneWebView;
            a(obj, new org.json.JSONObject());
            return;
        }
        java.lang.String str3 = this.e;
        if (windVaneWebView != null) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("currentCache", str3);
                a(obj, "cache had changed", jSONObject);
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
