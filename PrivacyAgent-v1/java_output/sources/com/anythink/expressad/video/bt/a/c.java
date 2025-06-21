package com.anythink.expressad.video.bt.a;

/* loaded from: classes12.dex */
public final class c {
    public static final int a = -999;
    private static final java.lang.String b = "OperateViews";
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.LinkedHashMap<java.lang.String, android.view.View>> c = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.LinkedHashMap<java.lang.String, java.lang.String> d = new java.util.LinkedHashMap<>();
    private static java.util.LinkedHashMap<java.lang.String, com.anythink.expressad.foundation.d.c> e = new java.util.LinkedHashMap<>();
    private static java.util.LinkedHashMap<java.lang.String, com.anythink.expressad.videocommon.e.d> f = new java.util.LinkedHashMap<>();
    private static java.util.LinkedHashMap<java.lang.String, java.lang.String> g = new java.util.LinkedHashMap<>();
    private static java.util.LinkedHashMap<java.lang.String, java.lang.Integer> h = new java.util.LinkedHashMap<>();
    private static java.util.LinkedHashMap<java.lang.String, android.app.Activity> i = new java.util.LinkedHashMap<>();
    private static volatile int j = 10000;
    private static int k = 0;
    private static int l = 1;
    private static java.lang.String m = "";
    private static int n;
    private static int o;
    private static int p;
    private static int q;
    private static int r;

    /* renamed from: com.anythink.expressad.video.bt.a.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ android.graphics.Rect c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;

        public AnonymousClass1(java.lang.Object obj, java.lang.String str, android.graphics.Rect rect, int i, int i2) {
            this.a = obj;
            this.b = str;
            this.c = rect;
            this.d = i;
            this.e = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.lang.String str;
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) this.a).a;
            if (windVaneWebView != null) {
                str = windVaneWebView.getRid();
            } else {
                str = "";
                windVaneWebView = null;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b = com.anythink.expressad.video.bt.a.c.this.b(this.b, str);
            java.lang.String b2 = com.anythink.expressad.video.bt.a.c.b();
            com.anythink.expressad.video.bt.a.c.d.put(b2, str);
            com.anythink.expressad.video.bt.module.AnythinkBTLayout anythinkBTLayout = new com.anythink.expressad.video.bt.module.AnythinkBTLayout(com.anythink.core.common.b.o.a().f());
            b.put(b2, anythinkBTLayout);
            anythinkBTLayout.setInstanceId(b2);
            anythinkBTLayout.setUnitId(this.b);
            anythinkBTLayout.setWebView(windVaneWebView);
            anythinkBTLayout.setRect(this.c);
            int i = this.d;
            if (i > 0 || this.e > 0) {
                anythinkBTLayout.setLayout(i, this.e);
            }
            com.anythink.expressad.video.bt.a.c.a(this.a, b2);
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.a.c$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ android.graphics.Rect f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;

        public AnonymousClass2(java.lang.Object obj, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, android.graphics.Rect rect, int i, int i2) {
            this.a = obj;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = rect;
            this.g = i;
            this.h = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.lang.String str;
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) this.a).a;
            if (windVaneWebView != null) {
                str = windVaneWebView.getRid();
            } else {
                str = "";
                windVaneWebView = null;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b = com.anythink.expressad.video.bt.a.c.this.b(this.b, str);
            java.lang.String b2 = com.anythink.expressad.video.bt.a.c.b();
            com.anythink.expressad.video.bt.a.c.d.put(b2, str);
            com.anythink.expressad.video.bt.module.AnythinkBTWebView anythinkBTWebView = new com.anythink.expressad.video.bt.module.AnythinkBTWebView(com.anythink.core.common.b.o.a().f());
            b.put(b2, anythinkBTWebView);
            anythinkBTWebView.setInstanceId(b2);
            anythinkBTWebView.setUnitId(this.b);
            anythinkBTWebView.setFileURL(this.c);
            anythinkBTWebView.setFilePath(this.d);
            anythinkBTWebView.setHtml(this.e);
            anythinkBTWebView.setRect(this.f);
            anythinkBTWebView.setWebViewRid(str);
            anythinkBTWebView.setCreateWebView(windVaneWebView);
            int i = this.g;
            if (i > 0 || this.h > 0) {
                anythinkBTWebView.setLayout(i, this.h);
            }
            anythinkBTWebView.preload();
            com.anythink.expressad.video.bt.a.c.a(this.a, b2);
        }
    }

    public static class a {
        private static com.anythink.expressad.video.bt.a.c a = new com.anythink.expressad.video.bt.a.c((byte) 0);

        private a() {
        }
    }

    private c() {
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    public static void E(java.lang.Object obj, org.json.JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
            }
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public static void I(java.lang.Object obj, org.json.JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
            }
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public static void J(java.lang.Object obj, org.json.JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
            } else {
                c(obj, "android mediaPlayer not support setScaleType");
            }
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r7v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, org.json.JSONObject] */
    public static void P(java.lang.Object obj, org.json.JSONObject jSONObject) {
        java.lang.String str;
        java.lang.Object obj2;
        java.lang.String str2;
        java.lang.String str3;
        java.io.File file;
        ?? r3 = "message";
        java.lang.String str4 = "code";
        ?? jSONObject2 = new org.json.JSONObject();
        int i2 = 1;
        try {
            jSONObject2.put("code", 0);
            jSONObject2.put("message", "");
            org.json.JSONArray jSONArray = jSONObject.getJSONArray("resource");
            if (jSONArray != null && jSONArray.length() > 0) {
                ?? jSONArray2 = new org.json.JSONArray();
                int length = jSONArray.length();
                int i3 = 0;
                r3 = r3;
                while (i3 < length) {
                    org.json.JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                    java.lang.String optString = jSONObject3.optString("ref", "");
                    int i4 = jSONObject3.getInt("type");
                    ?? jSONObject4 = new org.json.JSONObject();
                    if (i4 != i2 || android.text.TextUtils.isEmpty(optString)) {
                        obj2 = r3;
                        str2 = str4;
                        if (i4 == 2 && !android.text.TextUtils.isEmpty(optString)) {
                            org.json.JSONObject jSONObject5 = new org.json.JSONObject();
                            jSONObject5.put("type", 2);
                            jSONObject5.put("path", com.anythink.expressad.videocommon.b.i.a().c(optString) == null ? "" : com.anythink.expressad.videocommon.b.i.a().c(optString));
                            jSONObject4.put(optString, jSONObject5);
                            jSONArray2.put(jSONObject4);
                        } else if (i4 == 3 && !android.text.TextUtils.isEmpty(optString)) {
                            try {
                                file = new java.io.File(optString);
                            } catch (java.lang.Throwable th) {
                                if (com.anythink.expressad.a.a) {
                                    th.printStackTrace();
                                }
                            }
                            if (file.exists() && file.isFile() && file.canRead()) {
                                str3 = "file:////".concat(java.lang.String.valueOf(optString));
                                org.json.JSONObject jSONObject6 = new org.json.JSONObject();
                                jSONObject6.put("type", 3);
                                jSONObject6.put("path", str3);
                                jSONObject4.put(optString, jSONObject6);
                                jSONArray2.put(jSONObject4);
                            }
                            str3 = "";
                            org.json.JSONObject jSONObject62 = new org.json.JSONObject();
                            jSONObject62.put("type", 3);
                            jSONObject62.put("path", str3);
                            jSONObject4.put(optString, jSONObject62);
                            jSONArray2.put(jSONObject4);
                        } else if (i4 == 4 && !android.text.TextUtils.isEmpty(optString)) {
                            org.json.JSONObject jSONObject7 = new org.json.JSONObject();
                            jSONObject7.put("type", 4);
                            jSONObject7.put("path", com.anythink.expressad.foundation.h.s.a(optString) == null ? "" : com.anythink.expressad.foundation.h.s.a(optString));
                            jSONObject4.put(optString, jSONObject7);
                            jSONArray2.put(jSONObject4);
                        }
                        i3++;
                        r3 = obj2;
                        str4 = str2;
                        i2 = 1;
                    } else {
                        org.json.JSONObject jSONObject8 = new org.json.JSONObject();
                        com.anythink.expressad.videocommon.b.a.a();
                        com.anythink.core.common.a.j b2 = com.anythink.expressad.videocommon.b.a.b(optString);
                        if (b2 != null) {
                            jSONObject8.put("type", i2);
                            obj2 = r3;
                            str2 = str4;
                            try {
                                jSONObject8.put("videoDataLength", b2.d());
                                java.lang.String b3 = b2.b();
                                if (android.text.TextUtils.isEmpty(b3)) {
                                    jSONObject8.put("path", "");
                                    jSONObject8.put("path4Web", "");
                                } else {
                                    jSONObject8.put("path", b3);
                                    jSONObject8.put("path4Web", b3);
                                }
                                if (b2.c() == 100) {
                                    jSONObject8.put("downloaded", 1);
                                } else {
                                    jSONObject8.put("downloaded", 0);
                                }
                                jSONObject4.put(optString, jSONObject8);
                                jSONArray2.put(jSONObject4);
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                r3 = obj2;
                                str = str2;
                            }
                        } else {
                            obj2 = r3;
                            str2 = str4;
                        }
                        i3++;
                        r3 = obj2;
                        str4 = str2;
                        i2 = 1;
                    }
                }
                obj2 = r3;
                str2 = str4;
                jSONObject2.put("resource", jSONArray2);
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            }
            str = "code";
            r3 = 1;
            try {
                try {
                    jSONObject2.put(str, 1);
                    try {
                        jSONObject2.put("message", "resource is null");
                        com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        return;
                    } catch (org.json.JSONException e2) {
                        e = e2;
                        e.getMessage();
                        return;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            } catch (org.json.JSONException e3) {
                e = e3;
            } catch (java.lang.Throwable th4) {
                th = th4;
                r3 = "message";
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            str = str4;
        }
        try {
            jSONObject2.put(str, 1);
            jSONObject2.put(r3, th.getLocalizedMessage());
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (org.json.JSONException e4) {
            e4.getMessage();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.widget.LinearLayout$LayoutParams] */
    private static android.view.ViewGroup.LayoutParams a(android.view.ViewGroup.LayoutParams layoutParams, android.graphics.Rect rect, int i2, int i3) {
        if (rect == null) {
            rect = new android.graphics.Rect(a, a, a, a);
        }
        android.content.Context f2 = com.anythink.core.common.b.o.a().f();
        if (f2 == null) {
            return layoutParams;
        }
        if (layoutParams instanceof android.widget.FrameLayout.LayoutParams) {
            android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(-1, -1);
            int i4 = rect.left;
            if (i4 != -999) {
                layoutParams2.leftMargin = com.anythink.expressad.foundation.h.t.b(f2, i4);
            }
            int i5 = rect.top;
            if (i5 != -999) {
                layoutParams2.topMargin = com.anythink.expressad.foundation.h.t.b(f2, i5);
            }
            int i6 = rect.right;
            if (i6 != -999) {
                layoutParams2.rightMargin = com.anythink.expressad.foundation.h.t.b(f2, i6);
            }
            int i7 = rect.bottom;
            if (i7 != -999) {
                layoutParams2.bottomMargin = com.anythink.expressad.foundation.h.t.b(f2, i7);
            }
            if (i2 > 0) {
                layoutParams2.width = com.anythink.expressad.foundation.h.t.b(f2, i2);
            }
            if (i3 > 0) {
                layoutParams2.height = com.anythink.expressad.foundation.h.t.b(f2, i3);
            }
            return layoutParams2;
        }
        if (layoutParams instanceof android.widget.RelativeLayout.LayoutParams) {
            android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            int i8 = rect.left;
            if (i8 != -999) {
                layoutParams3.leftMargin = com.anythink.expressad.foundation.h.t.b(f2, i8);
            }
            int i9 = rect.top;
            if (i9 != -999) {
                layoutParams3.topMargin = com.anythink.expressad.foundation.h.t.b(f2, i9);
            }
            int i10 = rect.right;
            if (i10 != -999) {
                layoutParams3.rightMargin = com.anythink.expressad.foundation.h.t.b(f2, i10);
            }
            int i11 = rect.bottom;
            if (i11 != -999) {
                layoutParams3.bottomMargin = com.anythink.expressad.foundation.h.t.b(f2, i11);
            }
            if (i2 > 0) {
                layoutParams3.width = com.anythink.expressad.foundation.h.t.b(f2, i2);
            }
            if (i3 > 0) {
                layoutParams3.height = com.anythink.expressad.foundation.h.t.b(f2, i3);
            }
            return layoutParams3;
        }
        if (layoutParams instanceof android.widget.LinearLayout.LayoutParams) {
            layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -1);
            int i12 = rect.left;
            if (i12 != -999) {
                ((android.widget.LinearLayout.LayoutParams) layoutParams).leftMargin = com.anythink.expressad.foundation.h.t.b(f2, i12);
            }
            int i13 = rect.top;
            if (i13 != -999) {
                ((android.widget.LinearLayout.LayoutParams) layoutParams).topMargin = com.anythink.expressad.foundation.h.t.b(f2, i13);
            }
            int i14 = rect.right;
            if (i14 != -999) {
                ((android.widget.LinearLayout.LayoutParams) layoutParams).rightMargin = com.anythink.expressad.foundation.h.t.b(f2, i14);
            }
            int i15 = rect.bottom;
            if (i15 != -999) {
                ((android.widget.LinearLayout.LayoutParams) layoutParams).bottomMargin = com.anythink.expressad.foundation.h.t.b(f2, i15);
            }
            if (i2 > 0) {
                ((android.widget.LinearLayout.LayoutParams) layoutParams).width = com.anythink.expressad.foundation.h.t.b(f2, i2);
            }
            if (i3 > 0) {
                ((android.widget.LinearLayout.LayoutParams) layoutParams).height = com.anythink.expressad.foundation.h.t.b(f2, i3);
            }
        }
        return layoutParams;
    }

    public static com.anythink.expressad.foundation.d.c a(java.lang.String str) {
        if (e.containsKey(str)) {
            return e.get(str);
        }
        return null;
    }

    public static com.anythink.expressad.video.bt.a.c a() {
        return com.anythink.expressad.video.bt.a.c.a.a;
    }

    public static void a(int i2, int i3, int i4, int i5, int i6) {
        java.lang.String.format("%1$s-%2$s-%3$s-%4$s-%5$s", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4), java.lang.Integer.valueOf(i5), java.lang.Integer.valueOf(i6));
        m = com.anythink.expressad.foundation.h.h.a(i2, i3, i4, i5, i6);
        n = i2;
        o = i3;
        p = i4;
        q = i5;
        r = i6;
    }

    public static void a(android.webkit.WebView webView, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", l);
            jSONObject.put("message", str);
            jSONObject.put("data", new org.json.JSONObject());
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(webView, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
    }

    public static void a(android.webkit.WebView webView, java.lang.String str, java.lang.String str2) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", k);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put("data", jSONObject2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(webView, str, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception e2) {
            a(webView, e2.getMessage());
            e2.getMessage();
        }
    }

    public static void a(java.lang.Object obj) {
        try {
            a(obj, "");
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public static void a(java.lang.Object obj, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", k);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("id", str);
            jSONObject.put("data", jSONObject2);
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception e2) {
            c(obj, e2.getMessage());
            e2.getMessage();
        }
    }

    private static void a(java.lang.Object obj, java.lang.String str, java.lang.String str2) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", k);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put("data", jSONObject2);
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, str, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception e2) {
            c(obj, e2.getMessage());
            e2.getMessage();
        }
    }

    public static void a(java.lang.String str, int i2) {
        h.put(str, java.lang.Integer.valueOf(i2));
    }

    public static void a(java.lang.String str, android.app.Activity activity) {
        i.put(str, activity);
    }

    private static void a(java.lang.String str, com.anythink.expressad.foundation.d.c cVar) {
        if (com.anythink.expressad.foundation.g.a.f.k == null || android.text.TextUtils.isEmpty(cVar.aZ())) {
            return;
        }
        com.anythink.expressad.foundation.g.a.f.a(str, cVar, "reward");
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        d.put(str, str2);
    }

    private static void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = com.anythink.expressad.video.bt.a.c.a.a.b(str, str2);
            if (b2 == null || b2.size() <= 0) {
                return;
            }
            for (android.view.View view : b2.values()) {
                if (view instanceof com.anythink.expressad.video.bt.module.ATTempContainer) {
                    ((com.anythink.expressad.video.bt.module.ATTempContainer) view).notifyEvent(str3);
                } else if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTWebView) {
                    ((com.anythink.expressad.video.bt.module.AnythinkBTWebView) view).notifyEvent(str3);
                } else if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTLayout) {
                    ((com.anythink.expressad.video.bt.module.AnythinkBTLayout) view).notifyEvent(str3);
                }
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public static com.anythink.expressad.videocommon.e.d b(java.lang.String str) {
        if (f.containsKey(str)) {
            return f.get(str);
        }
        return null;
    }

    public static java.lang.String b() {
        int i2 = j + 1;
        j = i2;
        return java.lang.String.valueOf(i2);
    }

    public static void b(java.lang.Object obj, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i2);
                int optInt = jSONObject.optInt("type");
                java.lang.String optString = jSONObject.optString("url");
                int optInt2 = jSONObject.optInt(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_REPORT);
                boolean z = true;
                if (optInt2 == 0) {
                    android.content.Context f2 = com.anythink.core.common.b.o.a().f();
                    if (optInt == 0) {
                        z = false;
                    }
                    com.anythink.expressad.a.a.a(f2, (com.anythink.expressad.foundation.d.c) null, "", optString, z);
                } else {
                    com.anythink.expressad.a.a.a(com.anythink.core.common.b.o.a().f(), null, "", optString, false, optInt != 0, optInt2);
                }
            }
            a(obj, "");
        } catch (java.lang.Throwable unused) {
        }
    }

    public static java.lang.String c(java.lang.String str) {
        return g.containsKey(str) ? g.get(str) : "";
    }

    private static void c(java.lang.Object obj, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", l);
            jSONObject.put("message", str);
            jSONObject.put("data", new org.json.JSONObject());
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
    }

    public static void d(java.lang.String str) {
        i.remove(str);
    }

    public static int e(java.lang.String str) {
        if (h.containsKey(str)) {
            return h.get(str).intValue();
        }
        return 2;
    }

    public static void f(java.lang.Object obj, org.json.JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            java.lang.String optString = jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
            } else {
                a(obj, optString);
            }
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public static void f(java.lang.String str) {
        if (g.containsKey(str)) {
            g.remove(str);
        }
        if (f.containsKey(str)) {
            f.remove(str);
        }
        if (e.containsKey(str)) {
            e.remove(str);
        }
        if (d.containsKey(str)) {
            d.remove(str);
        }
    }

    public static void g(java.lang.String str) {
        if (h.containsKey(str)) {
            h.remove(str);
        }
    }

    private static java.lang.String h(java.lang.String str) {
        return d.containsKey(str) ? d.get(str) : "";
    }

    private static android.app.Activity i(java.lang.String str) {
        if (i.containsKey(str)) {
            return i.get(str);
        }
        return null;
    }

    public final void A(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exit");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (!(view instanceof com.anythink.expressad.video.bt.module.AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
            } else {
                ((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) view).play();
                a(obj, optString2);
            }
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void B(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exit");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (!(view instanceof com.anythink.expressad.video.bt.module.AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
            } else {
                ((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) view).pause();
                a(obj, optString2);
            }
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void C(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exit");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (!(view instanceof com.anythink.expressad.video.bt.module.AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
            } else {
                ((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) view).resume();
                a(obj, optString2);
            }
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void D(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exit");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (!(view instanceof com.anythink.expressad.video.bt.module.AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
            } else {
                ((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) view).stop();
                a(obj, optString2);
            }
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void F(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (!(view instanceof com.anythink.expressad.video.bt.module.AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
            } else if (((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) view).playMute()) {
                a(obj, optString2);
            } else {
                c(obj, "set mute failed");
            }
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void G(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exit");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (!(view instanceof com.anythink.expressad.video.bt.module.AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
            } else if (!((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) view).playUnMute()) {
                a(obj, "set unmute failed");
            } else {
                a(obj, optString2);
                a(obj, "onUnmute", optString2);
            }
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void H(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (!(view instanceof com.anythink.expressad.video.bt.module.AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
                return;
            }
            int mute = ((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) view).getMute();
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("code", k);
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            jSONObject3.put("id", optString2);
            jSONObject3.put("mute", mute);
            jSONObject2.put("data", jSONObject3);
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void K(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (!(view instanceof com.anythink.expressad.video.bt.module.ATTempContainer)) {
                c(obj, "view not exist");
            } else {
                ((com.anythink.expressad.video.bt.module.ATTempContainer) view).preload();
                a(obj, optString2);
            }
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void L(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (b2.size() <= 0) {
                c(obj, "unitId or instanceId not exist");
                return;
            }
            com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer = null;
            for (android.view.View view : b2.values()) {
                if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTContainer) {
                    anythinkBTContainer = (com.anythink.expressad.video.bt.module.AnythinkBTContainer) view;
                } else if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTWebView) {
                    ((com.anythink.expressad.video.bt.module.AnythinkBTWebView) view).onDestory();
                } else if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTVideoView) {
                    java.lang.String instanceId = ((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) view).getInstanceId();
                    com.anythink.expressad.video.bt.a.a.a();
                    com.anythink.expressad.video.bt.a.a.a(instanceId);
                    ((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) view).onDestory();
                } else if (view instanceof com.anythink.expressad.video.bt.module.ATTempContainer) {
                    ((com.anythink.expressad.video.bt.module.ATTempContainer) view).onDestroy();
                }
            }
            if (anythinkBTContainer == null) {
                c(obj, "not found AnythinkBTContainer");
                return;
            }
            anythinkBTContainer.onAdClose();
            c.remove(b2);
            b2.clear();
            c.remove(optString + "_" + h2);
            a(obj, optString2);
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void M(java.lang.Object obj, org.json.JSONObject jSONObject) {
        try {
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a;
            java.lang.String rid = windVaneWebView != null ? windVaneWebView.getRid() : "";
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("eventName");
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, rid);
            if (b2 == null || b2.size() <= 0) {
                c(obj, "unitId not exist");
                return;
            }
            for (android.view.View view : b2.values()) {
                if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTWebView) {
                    ((com.anythink.expressad.video.bt.module.AnythinkBTWebView) view).broadcast(optString2, optJSONObject);
                }
                if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTLayout) {
                    ((com.anythink.expressad.video.bt.module.AnythinkBTLayout) view).broadcast(optString2, optJSONObject);
                }
            }
            a(obj, "");
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void N(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.videocommon.c.c cVar;
        java.lang.String str;
        try {
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a;
            java.lang.String rid = windVaneWebView != null ? windVaneWebView.getRid() : "";
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            java.lang.String optString3 = optJSONObject.optString("userId");
            boolean optBoolean = optJSONObject.optBoolean("expired");
            org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("reward");
            java.lang.String optString4 = optJSONObject.optString("extra");
            if (optJSONObject2 != null) {
                cVar = new com.anythink.expressad.videocommon.c.c(optJSONObject2.optString("name"), optJSONObject2.optInt("amount"));
                str = optJSONObject2.optString("id");
            } else {
                cVar = null;
                str = "";
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, rid);
            if (b2.size() <= 0 || !g.containsKey(optString2)) {
                c(obj, "unitId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (!(view instanceof com.anythink.expressad.video.bt.module.ATTempContainer)) {
                c(obj, "instanceId not exist");
                return;
            }
            com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer = (com.anythink.expressad.video.bt.module.ATTempContainer) view;
            aTTempContainer.setReward(cVar);
            aTTempContainer.setUserId(optString3);
            aTTempContainer.setRewardId(str);
            aTTempContainer.setCampaignExpired(optBoolean);
            if (!android.text.TextUtils.isEmpty(optString4)) {
                aTTempContainer.setDeveloperExtraData(optString4);
            }
            a(obj, optString2);
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void O(java.lang.Object obj, org.json.JSONObject jSONObject) {
        try {
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a;
            java.lang.String rid = windVaneWebView != null ? windVaneWebView.getRid() : "";
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            java.lang.String optString3 = optJSONObject.optString("eventName");
            org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("eventData");
            if (optJSONObject2 == null) {
                optJSONObject2 = new org.json.JSONObject();
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, rid);
            if (b2.size() <= 0) {
                c(obj, "unitId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (view instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    android.view.View childAt = viewGroup.getChildAt(i2);
                    if (childAt instanceof com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView) {
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) childAt, optString3, android.util.Base64.encodeToString(optJSONObject2.toString().getBytes(), 2));
                        a(obj, optString2);
                        return;
                    }
                }
            }
            c(obj, "instanceId not exist");
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void Q(java.lang.Object obj, org.json.JSONObject jSONObject) {
        java.util.Objects.toString(jSONObject);
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !android.text.TextUtils.isEmpty(optString)) {
                java.lang.String str = "";
                com.anythink.expressad.foundation.d.c b2 = com.anythink.expressad.foundation.d.c.b(optJSONObject.optJSONObject("campaign"));
                if (b2 != null && !android.text.TextUtils.isEmpty(optString)) {
                    b2.l(optString);
                    str = b2.Z();
                }
                com.anythink.expressad.videocommon.e.d a2 = com.anythink.expressad.videocommon.e.d.a(optJSONObject.optJSONObject("unitSetting"));
                if (a2 != null) {
                    a2.a(optString);
                }
                com.anythink.expressad.video.bt.module.AnythinkBTNativeEC anythinkBTNativeEC = new com.anythink.expressad.video.bt.module.AnythinkBTNativeEC(com.anythink.core.common.b.o.a().f());
                anythinkBTNativeEC.setCampaign(b2);
                com.anythink.expressad.video.signal.a.j jVar = new com.anythink.expressad.video.signal.a.j(null, b2);
                jVar.a(optString);
                anythinkBTNativeEC.setJSCommon(jVar);
                anythinkBTNativeEC.setUnitId(optString);
                anythinkBTNativeEC.setRewardUnitSetting(a2);
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a;
                if (windVaneWebView != null) {
                    str = windVaneWebView.getRid();
                    anythinkBTNativeEC.setCreateWebView(windVaneWebView);
                }
                java.util.LinkedHashMap<java.lang.String, android.view.View> b3 = b(optString, str);
                java.lang.String b4 = b();
                d.put(b4, str);
                anythinkBTNativeEC.setInstanceId(b4);
                b3.put(b4, anythinkBTNativeEC);
                anythinkBTNativeEC.preLoadData();
                if (b2 == null) {
                    c(obj, "campaign is null");
                    return;
                } else {
                    a(obj, b4);
                    return;
                }
            }
            c(obj, "unitId or data is empty");
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void a(java.lang.Object obj, org.json.JSONObject jSONObject) {
        android.graphics.Rect rect;
        int i2;
        int i3;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            if (android.text.TextUtils.isEmpty(optString)) {
                c(obj, "unitId is empty");
                return;
            }
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            int optInt = optJSONObject.optInt("delay", 0);
            org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            android.graphics.Rect rect2 = new android.graphics.Rect(a, a, a, a);
            if (optJSONObject2 != null) {
                android.graphics.Rect rect3 = new android.graphics.Rect(optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.left, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.top, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.right, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.bottom, a));
                int optInt2 = optJSONObject2.optInt("width");
                i3 = optJSONObject2.optInt("height");
                rect = rect3;
                i2 = optInt2;
            } else {
                rect = rect2;
                i2 = 0;
                i3 = 0;
            }
            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new com.anythink.expressad.video.bt.a.c.AnonymousClass1(obj, optString, rect, i2, i3), optInt);
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final synchronized java.util.LinkedHashMap<java.lang.String, android.view.View> b(java.lang.String str, java.lang.String str2) {
        if (c.containsKey(str + "_" + str2)) {
            return c.get(str + "_" + str2);
        }
        java.util.LinkedHashMap<java.lang.String, android.view.View> linkedHashMap = new java.util.LinkedHashMap<>();
        c.put(str + "_" + str2, linkedHashMap);
        return linkedHashMap;
    }

    public final void b(java.lang.Object obj, org.json.JSONObject jSONObject) {
        android.graphics.Rect rect;
        int i2;
        int i3;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            if (android.text.TextUtils.isEmpty(optString)) {
                c(obj, "unitId is empty");
                return;
            }
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            int optInt = optJSONObject.optInt("delay", 0);
            java.lang.String optString2 = optJSONObject.optString("fileURL");
            java.lang.String optString3 = optJSONObject.optString(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_FILE_PATH);
            java.lang.String optString4 = optJSONObject.optString(com.baidu.mobads.sdk.internal.a.f);
            org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            android.graphics.Rect rect2 = new android.graphics.Rect(a, a, a, a);
            if (optJSONObject2 != null) {
                android.graphics.Rect rect3 = new android.graphics.Rect(optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.left, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.top, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.right, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.bottom, a));
                int optInt2 = optJSONObject2.optInt("width");
                i3 = optJSONObject2.optInt("height");
                rect = rect3;
                i2 = optInt2;
            } else {
                rect = rect2;
                i2 = 0;
                i3 = 0;
            }
            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new com.anythink.expressad.video.bt.a.c.AnonymousClass2(obj, optString, optString2, optString3, optString4, rect, i2, i3), optInt);
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void c(java.lang.Object obj, org.json.JSONObject jSONObject) {
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !android.text.TextUtils.isEmpty(optString)) {
                java.lang.String str = "";
                com.anythink.expressad.foundation.d.c b2 = com.anythink.expressad.foundation.d.c.b(optJSONObject.optJSONObject("campaign"));
                if (b2 != null && !android.text.TextUtils.isEmpty(optString)) {
                    b2.l(optString);
                    str = b2.Z();
                }
                int optInt = optJSONObject.optInt("show_time", 0);
                int optInt2 = optJSONObject.optInt("show_mute", 0);
                int optInt3 = optJSONObject.optInt("show_close", 0);
                int optInt4 = optJSONObject.optInt("orientation", 1);
                int optInt5 = optJSONObject.optInt("show_pgb", 0);
                com.anythink.expressad.video.bt.module.AnythinkBTVideoView anythinkBTVideoView = new com.anythink.expressad.video.bt.module.AnythinkBTVideoView(com.anythink.core.common.b.o.a().f());
                anythinkBTVideoView.setCampaign(b2);
                anythinkBTVideoView.setUnitId(optString);
                anythinkBTVideoView.setShowMute(optInt2);
                anythinkBTVideoView.setShowTime(optInt);
                anythinkBTVideoView.setShowClose(optInt3);
                anythinkBTVideoView.setOrientation(optInt4);
                anythinkBTVideoView.setProgressBarState(optInt5);
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a;
                if (windVaneWebView != null) {
                    str = windVaneWebView.getRid();
                    anythinkBTVideoView.setCreateWebView(windVaneWebView);
                }
                java.util.LinkedHashMap<java.lang.String, android.view.View> b3 = b(optString, str);
                java.lang.String b4 = b();
                d.put(b4, str);
                anythinkBTVideoView.setInstanceId(b4);
                b3.put(b4, anythinkBTVideoView);
                anythinkBTVideoView.preLoadData();
                if (b2 == null) {
                    c(obj, "campaign is null");
                } else {
                    a(obj, b4);
                }
                com.anythink.expressad.video.bt.a.a.a();
                com.anythink.expressad.video.bt.a.a.a(b4, anythinkBTVideoView);
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void d(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !android.text.TextUtils.isEmpty(optString)) {
                int optInt = optJSONObject.optInt("mute");
                java.lang.String str = "";
                com.anythink.expressad.foundation.d.c b2 = com.anythink.expressad.foundation.d.c.b(optJSONObject.optJSONObject("campaign"));
                if (b2 != null && !android.text.TextUtils.isEmpty(optString)) {
                    b2.l(optString);
                    str = b2.Z();
                }
                com.anythink.expressad.videocommon.e.d a2 = com.anythink.expressad.videocommon.e.d.a(optJSONObject.optJSONObject("unitSetting"));
                if (a2 != null) {
                    a2.a(optString);
                }
                java.lang.String optString2 = optJSONObject.optString("userId");
                if (android.text.TextUtils.isEmpty(str) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                    str = windVaneWebView.getRid();
                }
                java.util.LinkedHashMap<java.lang.String, android.view.View> b3 = b(optString, str);
                java.lang.String b4 = b();
                d.put(b4, str);
                com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer = new com.anythink.expressad.video.bt.module.ATTempContainer(com.anythink.core.common.b.o.a().f());
                aTTempContainer.setInstanceId(b4);
                aTTempContainer.setUnitId(optString);
                aTTempContainer.setCampaign(b2);
                aTTempContainer.setRewardUnitSetting(a2);
                aTTempContainer.setBigOffer(true);
                if (!android.text.TextUtils.isEmpty(optString2)) {
                    aTTempContainer.setUserId(optString2);
                }
                org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("reward");
                if (optJSONObject2 != null) {
                    java.lang.String optString3 = optJSONObject2.optString("id");
                    com.anythink.expressad.videocommon.c.c cVar = new com.anythink.expressad.videocommon.c.c(optJSONObject2.optString("name"), optJSONObject2.optInt("amount"));
                    if (!android.text.TextUtils.isEmpty(optString3)) {
                        aTTempContainer.setRewardId(optString3);
                    }
                    if (!android.text.TextUtils.isEmpty(cVar.a())) {
                        aTTempContainer.setReward(cVar);
                    }
                }
                java.lang.String optString4 = optJSONObject.optString("extra");
                if (!android.text.TextUtils.isEmpty(optString4)) {
                    aTTempContainer.setDeveloperExtraData(optString4);
                }
                aTTempContainer.setMute(optInt);
                b3.put(b4, aTTempContainer);
                g.put(b4, optString);
                e.put(b4, b2);
                f.put(b4, a2);
                a(obj, b4);
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void e(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") != null && !android.text.TextUtils.isEmpty(optString)) {
                java.lang.String h2 = h(optString2);
                if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                    h2 = windVaneWebView.getRid();
                }
                java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
                if (b2 == null || !b2.containsKey(optString2)) {
                    c(obj, "unitId or instanceId not exist");
                    return;
                }
                android.view.View view = b2.get(optString2);
                b2.remove(optString2);
                if (view != null && view.getParent() != null) {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(view);
                    }
                    if (view instanceof android.view.ViewGroup) {
                        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) view;
                        if (viewGroup2.getChildCount() > 0) {
                            int childCount = viewGroup2.getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                android.view.View childAt = viewGroup2.getChildAt(i2);
                                if (childAt instanceof com.anythink.expressad.video.bt.module.AnythinkBTWebView) {
                                    b2.remove(((com.anythink.expressad.video.bt.module.AnythinkBTWebView) childAt).getInstanceId());
                                    ((com.anythink.expressad.video.bt.module.AnythinkBTWebView) childAt).onDestory();
                                } else if (childAt instanceof com.anythink.expressad.video.bt.module.AnythinkBTVideoView) {
                                    b2.remove(((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) childAt).getInstanceId());
                                    ((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) childAt).onDestory();
                                } else if (childAt instanceof com.anythink.expressad.video.bt.module.ATTempContainer) {
                                    b2.remove(((com.anythink.expressad.video.bt.module.ATTempContainer) childAt).getInstanceId());
                                    ((com.anythink.expressad.video.bt.module.ATTempContainer) childAt).onDestroy();
                                }
                            }
                        }
                    }
                }
                if (view instanceof com.anythink.expressad.video.bt.module.ATTempContainer) {
                    ((com.anythink.expressad.video.bt.module.ATTempContainer) view).onDestroy();
                }
                if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTWebView) {
                    ((com.anythink.expressad.video.bt.module.AnythinkBTWebView) view).onDestory();
                }
                if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTVideoView) {
                    ((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) view).onDestory();
                }
                a(obj, optString2);
                a(obj, "onComponentDestroy", optString2);
                return;
            }
            c(obj, "unidId or data is empty");
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public final void g(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            if (optJSONObject2 == null) {
                c(obj, "rect not exist");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            android.graphics.Rect rect = new android.graphics.Rect(optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.left, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.top, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.right, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.bottom, a));
            int optInt = optJSONObject2.optInt("width");
            int optInt2 = optJSONObject2.optInt("height");
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (view == null) {
                c(obj, "view is null");
                return;
            }
            if (view.getParent() != null) {
                view.setLayoutParams(a(view.getLayoutParams(), rect, optInt, optInt2));
                view.requestLayout();
            } else {
                if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTWebView) {
                    ((com.anythink.expressad.video.bt.module.AnythinkBTWebView) view).setRect(rect);
                    ((com.anythink.expressad.video.bt.module.AnythinkBTWebView) view).setLayout(optInt, optInt2);
                }
                if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTVideoView) {
                    ((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) view).setRect(rect);
                    ((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) view).setLayout(optInt, optInt2);
                }
            }
            a(obj, optString2);
            a(obj, "onViewRectChanged", optString2);
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void h(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "params not enough");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (view == null || view.getParent() == null) {
                c(obj, "view is null");
                return;
            }
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
            if (viewGroup == null) {
                c(obj, "parent is null");
                return;
            }
            viewGroup.removeView(view);
            a(obj, optString2);
            a(obj, "onRemoveFromView", optString2);
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void i(java.lang.Object obj, org.json.JSONObject jSONObject) {
        int optInt;
        android.graphics.Rect rect;
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            java.lang.String optString3 = optJSONObject.optString("id");
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString3) || !b2.containsKey(optString2)) {
                c(obj, "instanceId is not exist");
                return;
            }
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) b2.get(optString2);
            android.view.View view = b2.get(optString3);
            com.anythink.core.common.o.w.a(view);
            if (viewGroup != null && view != null) {
                org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                int i2 = 0;
                if (view instanceof com.anythink.expressad.video.bt.module.ATTempContainer) {
                    java.lang.String.format("%1$s-%2$s-%3$s-%4$s-%5$s", java.lang.Integer.valueOf(n), java.lang.Integer.valueOf(o), java.lang.Integer.valueOf(p), java.lang.Integer.valueOf(q), java.lang.Integer.valueOf(r));
                    ((com.anythink.expressad.video.bt.module.ATTempContainer) view).setNotchPadding(n, o, p, q, r);
                    java.util.Iterator<android.view.View> it = b2.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        android.view.View next = it.next();
                        if (next instanceof com.anythink.expressad.video.bt.module.AnythinkBTContainer) {
                            com.anythink.core.common.o.w.a(view);
                            ((com.anythink.expressad.video.bt.module.AnythinkBTContainer) next).appendSubView((com.anythink.expressad.video.bt.module.AnythinkBTContainer) next, (com.anythink.expressad.video.bt.module.ATTempContainer) view, optJSONObject2);
                            break;
                        }
                    }
                } else {
                    if (optJSONObject2 != null) {
                        android.graphics.Rect rect2 = new android.graphics.Rect(optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.left, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.top, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.right, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.bottom, a));
                        i2 = optJSONObject2.optInt("width");
                        optInt = optJSONObject2.optInt("height");
                        rect = rect2;
                    } else if (view instanceof com.anythink.expressad.video.bt.module.BTBaseView) {
                        rect = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getRect();
                        i2 = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getViewWidth();
                        optInt = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getViewHeight();
                    } else {
                        rect = null;
                        optInt = 0;
                    }
                    android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
                    if (viewGroup instanceof android.widget.FrameLayout) {
                        layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof android.widget.RelativeLayout) {
                        layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof android.widget.LinearLayout) {
                        layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -1);
                    }
                    android.view.ViewGroup.LayoutParams a2 = a(layoutParams, rect, i2, optInt);
                    com.anythink.core.common.o.w.a(view);
                    viewGroup.addView(view, a2);
                }
                a(obj, optString2);
                a(obj, "onAppendView", optString2);
                return;
            }
            c(obj, "view is not exist");
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void j(java.lang.Object obj, org.json.JSONObject jSONObject) {
        int optInt;
        int optInt2;
        android.graphics.Rect rect;
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !android.text.TextUtils.isEmpty(optString)) {
                java.lang.String optString3 = optJSONObject.optString("id");
                java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
                if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                    c(obj, "instanceId is not exist");
                    return;
                }
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) b2.get(optString3);
                android.view.View view = b2.get(optString2);
                com.anythink.core.common.o.w.a(view);
                if (viewGroup != null && view != null) {
                    org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                    if (view instanceof com.anythink.expressad.video.bt.module.ATTempContainer) {
                        java.util.Iterator<android.view.View> it = b2.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            android.view.View next = it.next();
                            if (next instanceof com.anythink.expressad.video.bt.module.AnythinkBTContainer) {
                                com.anythink.core.common.o.w.a(view);
                                ((com.anythink.expressad.video.bt.module.AnythinkBTContainer) next).appendSubView((com.anythink.expressad.video.bt.module.AnythinkBTContainer) next, (com.anythink.expressad.video.bt.module.ATTempContainer) view, optJSONObject2);
                                break;
                            }
                        }
                    } else {
                        if (optJSONObject2 != null) {
                            android.graphics.Rect rect2 = new android.graphics.Rect(optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.left, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.top, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.right, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.bottom, a));
                            optInt = optJSONObject2.optInt("width");
                            optInt2 = optJSONObject2.optInt("height");
                            rect = rect2;
                        } else if (view instanceof com.anythink.expressad.video.bt.module.BTBaseView) {
                            rect = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getRect();
                            optInt = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getViewWidth();
                            optInt2 = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getViewHeight();
                        } else {
                            optInt = 0;
                            rect = null;
                            optInt2 = 0;
                        }
                        android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
                        if (viewGroup instanceof android.widget.FrameLayout) {
                            layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof android.widget.RelativeLayout) {
                            layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof android.widget.LinearLayout) {
                            layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -1);
                        }
                        android.view.ViewGroup.LayoutParams a2 = a(layoutParams, rect, optInt, optInt2);
                        com.anythink.core.common.o.w.a(view);
                        viewGroup.addView(view, a2);
                    }
                    a(obj, optString2);
                    a(obj, "onAppendViewTo", optString2);
                    return;
                }
                c(obj, "view is not exist");
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void k(java.lang.Object obj, org.json.JSONObject jSONObject) {
        int optInt;
        android.graphics.Rect rect;
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            java.lang.String optString3 = optJSONObject.optString("id");
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString3) || !b2.containsKey(optString2)) {
                c(obj, "instanceId is not exist");
                return;
            }
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) b2.get(optString2);
            android.view.View view = b2.get(optString3);
            if (viewGroup != null && view != null) {
                org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                int i2 = 0;
                if (view instanceof com.anythink.expressad.video.bt.module.ATTempContainer) {
                    java.lang.String.format("%1$s-%2$s-%3$s-%4$s-%5$s", java.lang.Integer.valueOf(n), java.lang.Integer.valueOf(o), java.lang.Integer.valueOf(p), java.lang.Integer.valueOf(q), java.lang.Integer.valueOf(r));
                    ((com.anythink.expressad.video.bt.module.ATTempContainer) view).setNotchPadding(n, o, p, q, r);
                    java.util.Iterator<android.view.View> it = b2.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        android.view.View next = it.next();
                        if (next instanceof com.anythink.expressad.video.bt.module.AnythinkBTContainer) {
                            com.anythink.core.common.o.w.a(view);
                            ((com.anythink.expressad.video.bt.module.AnythinkBTContainer) next).appendSubView((com.anythink.expressad.video.bt.module.AnythinkBTContainer) next, (com.anythink.expressad.video.bt.module.ATTempContainer) view, optJSONObject2);
                            break;
                        }
                    }
                } else {
                    if (optJSONObject2 != null) {
                        android.graphics.Rect rect2 = new android.graphics.Rect(optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.left, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.top, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.right, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.bottom, a));
                        i2 = optJSONObject2.optInt("width");
                        optInt = optJSONObject2.optInt("height");
                        rect = rect2;
                    } else if (view instanceof com.anythink.expressad.video.bt.module.BTBaseView) {
                        rect = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getRect();
                        i2 = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getViewWidth();
                        optInt = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getViewHeight();
                    } else {
                        rect = null;
                        optInt = 0;
                    }
                    android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
                    if (viewGroup instanceof android.widget.FrameLayout) {
                        layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof android.widget.RelativeLayout) {
                        layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof android.widget.LinearLayout) {
                        layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -1);
                    }
                    viewGroup.addView(view, a(layoutParams, rect, i2, optInt));
                }
                a(obj, optString2);
                a(obj, "onAppendView", optString2);
                return;
            }
            c(obj, "view is not exist");
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void l(java.lang.Object obj, org.json.JSONObject jSONObject) {
        int optInt;
        int optInt2;
        android.graphics.Rect rect;
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !android.text.TextUtils.isEmpty(optString)) {
                java.lang.String optString3 = optJSONObject.optString("id");
                java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
                if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                    c(obj, "instanceId is not exist");
                    return;
                }
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) b2.get(optString3);
                android.view.View view = b2.get(optString2);
                if (viewGroup != null && view != null) {
                    org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                    if (view instanceof com.anythink.expressad.video.bt.module.ATTempContainer) {
                        java.util.Iterator<android.view.View> it = b2.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            android.view.View next = it.next();
                            if (next instanceof com.anythink.expressad.video.bt.module.AnythinkBTContainer) {
                                com.anythink.core.common.o.w.a(view);
                                ((com.anythink.expressad.video.bt.module.AnythinkBTContainer) next).appendSubView((com.anythink.expressad.video.bt.module.AnythinkBTContainer) next, (com.anythink.expressad.video.bt.module.ATTempContainer) view, optJSONObject2);
                                break;
                            }
                        }
                    } else {
                        if (optJSONObject2 != null) {
                            android.graphics.Rect rect2 = new android.graphics.Rect(optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.left, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.top, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.right, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.bottom, a));
                            optInt = optJSONObject2.optInt("width");
                            optInt2 = optJSONObject2.optInt("height");
                            rect = rect2;
                        } else if (view instanceof com.anythink.expressad.video.bt.module.BTBaseView) {
                            rect = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getRect();
                            optInt = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getViewWidth();
                            optInt2 = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getViewHeight();
                        } else {
                            optInt = 0;
                            rect = null;
                            optInt2 = 0;
                        }
                        android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
                        if (viewGroup instanceof android.widget.FrameLayout) {
                            layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof android.widget.RelativeLayout) {
                            layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof android.widget.LinearLayout) {
                            layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -1);
                        }
                        viewGroup.addView(view, a(layoutParams, rect, optInt, optInt2));
                    }
                    a(obj, optString2);
                    a(obj, "onAppendViewTo", optString2);
                    return;
                }
                c(obj, "view is not exist");
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void m(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId is not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (view == null || view.getParent() == null) {
                c(obj, "view is null");
                return;
            }
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
            if (viewGroup == null) {
                c(obj, "parent is null");
                return;
            }
            viewGroup.bringChildToFront(view);
            a(obj, optString2);
            a(obj, "onBringViewToFront", optString2);
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void n(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (view == null) {
                c(obj, "view not exist");
                return;
            }
            view.setVisibility(8);
            a(obj, optString2);
            a(obj, "onHideView", optString2);
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void o(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (view == null) {
                c(obj, "view not exist");
                return;
            }
            view.setVisibility(0);
            a(obj, optString2);
            a(obj, "onShowView", optString2);
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void p(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            java.lang.String optString3 = optJSONObject.optString("color");
            if (android.text.TextUtils.isEmpty(optString3)) {
                c(obj, "color is not exist");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (view == null) {
                c(obj, "view not exist");
                return;
            }
            a(obj, optString2);
            view.setBackgroundColor(android.graphics.Color.parseColor(optString3));
            a(obj, "onViewBgColorChanged", optString2);
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void q(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            double optDouble = optJSONObject.optDouble("alpha", 1.0d);
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (view == null) {
                c(obj, "view not exist");
                return;
            }
            view.setAlpha((float) optDouble);
            a(obj, optString2);
            a(obj, "onViewAlphaChanged", optString2);
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void r(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            double optDouble = optJSONObject.optDouble("vertical", 1.0d);
            double optDouble2 = optJSONObject.optDouble("horizon", 1.0d);
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (view == null) {
                c(obj, "view not exist");
                return;
            }
            view.setScaleX((float) optDouble2);
            view.setScaleY((float) optDouble);
            a(obj, optString2);
            a(obj, "onViewScaleChanged", optString2);
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void s(java.lang.Object obj, org.json.JSONObject jSONObject) {
        int optInt;
        int optInt2;
        android.graphics.Rect rect;
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            java.lang.String optString3 = optJSONObject.optString("targetComponentId");
            org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                c(obj, "instanceId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            android.view.View view2 = b2.get(optString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                return;
            }
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view2.getParent();
            int indexOfChild = viewGroup.indexOfChild(view2);
            if (optJSONObject2 != null) {
                android.graphics.Rect rect2 = new android.graphics.Rect(optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.left, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.top, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.right, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.bottom, a));
                optInt = optJSONObject2.optInt("width");
                optInt2 = optJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof com.anythink.expressad.video.bt.module.BTBaseView) {
                rect = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getRect();
                optInt = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getViewWidth();
                optInt2 = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getViewHeight();
            } else {
                optInt = 0;
                rect = null;
                optInt2 = 0;
            }
            android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof android.widget.FrameLayout) {
                layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof android.widget.RelativeLayout) {
                layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof android.widget.LinearLayout) {
                layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -1);
            }
            android.view.ViewGroup.LayoutParams a2 = a(layoutParams, rect, optInt, optInt2);
            com.anythink.core.common.o.w.a(view);
            viewGroup.addView(view, indexOfChild + 1, a2);
            a(obj, optString2);
            a(obj, "onInsertViewAbove", optString2);
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void t(java.lang.Object obj, org.json.JSONObject jSONObject) {
        int optInt;
        int optInt2;
        android.graphics.Rect rect;
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            java.lang.String optString3 = optJSONObject.optString("targetComponentId");
            org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                c(obj, "instanceId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            android.view.View view2 = b2.get(optString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                return;
            }
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view2.getParent();
            int indexOfChild = viewGroup.indexOfChild(view2);
            if (optJSONObject2 != null) {
                android.graphics.Rect rect2 = new android.graphics.Rect(optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.left, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.top, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.right, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.bottom, a));
                optInt = optJSONObject2.optInt("width");
                optInt2 = optJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof com.anythink.expressad.video.bt.module.BTBaseView) {
                rect = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getRect();
                optInt = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getViewWidth();
                optInt2 = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getViewHeight();
            } else {
                rect = null;
                optInt = 0;
                optInt2 = 0;
            }
            android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof android.widget.FrameLayout) {
                layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof android.widget.RelativeLayout) {
                layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof android.widget.LinearLayout) {
                layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -1);
            }
            android.view.ViewGroup.LayoutParams a2 = a(layoutParams, rect, optInt, optInt2);
            com.anythink.core.common.o.w.a(view);
            int i2 = indexOfChild - 1;
            viewGroup.addView(view, i2 >= 0 ? i2 : 0, a2);
            a(obj, optString2);
            a(obj, "onInsertViewBelow", optString2);
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void u(java.lang.Object obj, org.json.JSONObject jSONObject) {
        int optInt;
        int optInt2;
        android.graphics.Rect rect;
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            java.lang.String optString3 = optJSONObject.optString("targetComponentId");
            org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                c(obj, "instanceId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            android.view.View view2 = b2.get(optString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                return;
            }
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view2.getParent();
            int indexOfChild = viewGroup.indexOfChild(view2);
            if (optJSONObject2 != null) {
                android.graphics.Rect rect2 = new android.graphics.Rect(optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.left, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.top, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.right, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.bottom, a));
                optInt = optJSONObject2.optInt("width");
                optInt2 = optJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof com.anythink.expressad.video.bt.module.BTBaseView) {
                rect = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getRect();
                optInt = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getViewWidth();
                optInt2 = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getViewHeight();
            } else {
                optInt = 0;
                rect = null;
                optInt2 = 0;
            }
            android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof android.widget.FrameLayout) {
                layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof android.widget.RelativeLayout) {
                layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof android.widget.LinearLayout) {
                layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -1);
            }
            viewGroup.addView(view, indexOfChild + 1, a(layoutParams, rect, optInt, optInt2));
            a(obj, optString2);
            a(obj, "onInsertViewAbove", optString2);
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void v(java.lang.Object obj, org.json.JSONObject jSONObject) {
        int optInt;
        int optInt2;
        android.graphics.Rect rect;
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            java.lang.String optString3 = optJSONObject.optString("targetComponentId");
            org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                c(obj, "instanceId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            android.view.View view2 = b2.get(optString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                return;
            }
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view2.getParent();
            int indexOfChild = viewGroup.indexOfChild(view2);
            if (optJSONObject2 != null) {
                android.graphics.Rect rect2 = new android.graphics.Rect(optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.left, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.top, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.right, a), optJSONObject2.optInt(com.sensorsdata.sf.ui.view.UIProperty.bottom, a));
                optInt = optJSONObject2.optInt("width");
                optInt2 = optJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof com.anythink.expressad.video.bt.module.BTBaseView) {
                rect = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getRect();
                optInt = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getViewWidth();
                optInt2 = ((com.anythink.expressad.video.bt.module.BTBaseView) view).getViewHeight();
            } else {
                optInt = 0;
                rect = null;
                optInt2 = 0;
            }
            android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof android.widget.FrameLayout) {
                layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof android.widget.RelativeLayout) {
                layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof android.widget.LinearLayout) {
                layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -1);
            }
            viewGroup.addView(view, indexOfChild, a(layoutParams, rect, optInt, optInt2));
            a(obj, optString2);
            a(obj, "onInsertViewBelow", optString2);
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void w(java.lang.Object obj, org.json.JSONObject jSONObject) {
        int i2;
        int i3;
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("content");
            if (optJSONObject2 == null) {
                c(obj, "content is empty");
                return;
            }
            java.lang.String optString3 = optJSONObject2.optString("fileURL");
            java.lang.String optString4 = optJSONObject2.optString(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_FILE_PATH);
            java.lang.String optString5 = optJSONObject2.optString(com.baidu.mobads.sdk.internal.a.f);
            if (android.text.TextUtils.isEmpty(optString3) && android.text.TextUtils.isEmpty(optString4) && android.text.TextUtils.isEmpty(optString5)) {
                c(obj, "url is empty");
                return;
            }
            org.json.JSONArray optJSONArray = optJSONObject2.optJSONArray("campaigns");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    com.anythink.expressad.foundation.d.c b2 = com.anythink.expressad.foundation.d.c.b(optJSONArray.getJSONObject(i4));
                    if (b2 != null) {
                        b2.l(optString);
                        arrayList.add(b2);
                    }
                }
            }
            java.lang.String optString6 = optJSONObject2.optString("unitId");
            com.anythink.expressad.videocommon.e.d a2 = com.anythink.expressad.videocommon.e.d.a(optJSONObject2.optJSONObject("unitSetting"));
            if (a2 != null) {
                a2.a(optString6);
            }
            org.json.JSONObject optJSONObject3 = jSONObject.optJSONObject("rect");
            android.graphics.Rect rect = new android.graphics.Rect(a, a, a, a);
            if (optJSONObject3 != null) {
                android.graphics.Rect rect2 = new android.graphics.Rect(optJSONObject3.optInt(com.sensorsdata.sf.ui.view.UIProperty.left, a), optJSONObject3.optInt(com.sensorsdata.sf.ui.view.UIProperty.top, a), optJSONObject3.optInt(com.sensorsdata.sf.ui.view.UIProperty.right, a), optJSONObject3.optInt(com.sensorsdata.sf.ui.view.UIProperty.bottom, a));
                int optInt = optJSONObject3.optInt("width");
                i2 = optJSONObject3.optInt("height");
                i3 = optInt;
                rect = rect2;
            } else {
                i2 = 0;
                i3 = 0;
            }
            int optInt2 = optJSONObject2.optInt("refreshCache", 0);
            try {
                java.util.LinkedHashMap<java.lang.String, android.view.View> b3 = b(optString, h2);
                if (!b3.containsKey(optString2)) {
                    c(obj, "instanceId not exist");
                    return;
                }
                android.view.View view = b3.get(optString2);
                if (!(view instanceof com.anythink.expressad.video.bt.module.AnythinkBTWebView)) {
                    c(obj, "view not exist");
                    return;
                }
                com.anythink.expressad.video.bt.module.AnythinkBTWebView anythinkBTWebView = (com.anythink.expressad.video.bt.module.AnythinkBTWebView) view;
                anythinkBTWebView.setHtml(optString5);
                anythinkBTWebView.setFilePath(optString4);
                anythinkBTWebView.setFileURL(optString3);
                anythinkBTWebView.setRect(rect);
                anythinkBTWebView.setLayout(i3, i2);
                anythinkBTWebView.setCampaigns(arrayList);
                anythinkBTWebView.setRewardUnitSetting(a2);
                anythinkBTWebView.webviewLoad(optInt2);
                a(obj, optString2);
            } catch (java.lang.Throwable th) {
                th = th;
                c(obj, th.getMessage());
                th.getMessage();
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public final void x(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (!(view instanceof com.anythink.expressad.video.bt.module.AnythinkBTWebView)) {
                c(obj, "view not exist");
            } else if (((com.anythink.expressad.video.bt.module.AnythinkBTWebView) view).webviewReload()) {
                a(obj, optString2);
            } else {
                c(obj, "reload failed");
            }
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void y(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (!(view instanceof com.anythink.expressad.video.bt.module.AnythinkBTWebView)) {
                c(obj, "view not exist");
            } else if (((com.anythink.expressad.video.bt.module.AnythinkBTWebView) view).webviewGoBack()) {
                a(obj, optString2);
            } else {
                c(obj, "webviewGoBack failed");
            }
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }

    public final void z(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            java.lang.String optString2 = jSONObject.optString("id");
            java.lang.String h2 = h(optString2);
            if (android.text.TextUtils.isEmpty(h2) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                h2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            java.util.LinkedHashMap<java.lang.String, android.view.View> b2 = b(optString, h2);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                return;
            }
            android.view.View view = b2.get(optString2);
            if (!(view instanceof com.anythink.expressad.video.bt.module.AnythinkBTWebView)) {
                c(obj, "view not exist");
            } else if (((com.anythink.expressad.video.bt.module.AnythinkBTWebView) view).webviewGoForward()) {
                a(obj, optString2);
            } else {
                c(obj, "webviewGoForward failed");
            }
        } catch (java.lang.Throwable th) {
            c(obj, th.getMessage());
            th.getMessage();
        }
    }
}
