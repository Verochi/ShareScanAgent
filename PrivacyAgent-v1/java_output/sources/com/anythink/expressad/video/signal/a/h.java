package com.anythink.expressad.video.signal.a;

/* loaded from: classes12.dex */
public final class h extends com.anythink.expressad.video.signal.a.a {
    private static final java.lang.String g = "orientation";
    private static final java.lang.String h = "onSystemPause";
    private static final java.lang.String i = "onSystemResume";
    private static final java.lang.String j = "onSystemDestory";
    private static final java.lang.String k = "onSystemBackPressed";
    private static final java.lang.String l = "portrait";
    private static final java.lang.String m = "landscape";
    private android.webkit.WebView n;
    private int o = 0;

    public h(android.webkit.WebView webView) {
        this.n = webView;
    }

    @Override // com.anythink.expressad.video.signal.a.a, com.anythink.expressad.video.signal.a
    public final void a() {
        super.a();
        this.o = 1;
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a(this.n, "onSystemPause", "");
    }

    @Override // com.anythink.expressad.video.signal.a.a, com.anythink.expressad.video.signal.a
    public final void a(int i2) {
        super.a(i2);
        this.o = i2;
    }

    @Override // com.anythink.expressad.video.signal.a.a, com.anythink.expressad.video.signal.a
    public final void a(android.content.res.Configuration configuration) {
        super.a(configuration);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", m);
            } else {
                jSONObject.put("orientation", l);
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(this.n, "orientation", encodeToString);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.a, com.anythink.expressad.video.signal.a
    public final void b() {
        super.b();
        this.o = 0;
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a(this.n, "onSystemResume", "");
    }

    @Override // com.anythink.expressad.video.signal.a.a, com.anythink.expressad.video.signal.a
    public final void c() {
        super.c();
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a(this.n, "onSystemDestory", "");
    }

    @Override // com.anythink.expressad.video.signal.a.a, com.anythink.expressad.video.signal.a
    public final void g() {
        super.g();
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a(this.n, k, "");
    }

    @Override // com.anythink.expressad.video.signal.a.a, com.anythink.expressad.video.signal.a
    public final int h() {
        return this.o;
    }
}
