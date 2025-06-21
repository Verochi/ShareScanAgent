package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public class c {
    private static final java.lang.String y = "portrait";
    private static final java.lang.String z = "landscape";
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    public java.lang.String j;
    public java.lang.String k;
    public java.lang.String l;
    public java.lang.String m;
    public java.lang.String n;
    public java.lang.String o;
    public java.lang.String p;
    public java.lang.String q;
    public java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    public java.lang.String f247s;
    public java.lang.String t;
    public java.lang.String u;
    public int v;
    public java.lang.String w;
    public org.json.JSONObject x;
    public java.lang.String c = com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM;
    public java.lang.String a = com.anythink.expressad.foundation.h.k.b();
    public java.lang.String b = com.anythink.expressad.foundation.h.k.c();
    public java.lang.String f = com.anythink.core.common.o.e.f();

    public c(android.content.Context context) {
        this.d = com.anythink.core.common.o.e.d(context);
        int a = com.anythink.expressad.foundation.h.k.a();
        this.g = java.lang.String.valueOf(a);
        this.h = com.anythink.expressad.foundation.h.k.a(context, a);
        this.i = com.anythink.core.common.o.e.i();
        this.j = com.anythink.expressad.foundation.b.a.b().f();
        this.k = com.anythink.expressad.foundation.b.a.b().e();
        this.l = java.lang.String.valueOf(com.anythink.expressad.foundation.h.t.f(context));
        this.m = java.lang.String.valueOf(com.anythink.expressad.foundation.h.t.e(context));
        this.r = java.lang.String.valueOf(com.anythink.expressad.foundation.h.t.c(context));
        this.f247s = com.anythink.expressad.foundation.b.a.b().i().toString();
        this.u = com.anythink.core.common.o.e.b();
        this.v = com.anythink.core.common.o.a().c();
        if (context.getResources().getConfiguration().orientation == 2) {
            this.n = z;
        } else {
            this.n = y;
        }
        com.anythink.core.api.IExHandler b = com.anythink.core.common.b.o.a().b();
        java.lang.String[] split = (b != null ? b.fillCDataParam("at_device1|||at_device12|||at_device3") : "|||").split("\\|\\|\\|");
        if (split != null) {
            this.e = split.length > 0 ? split[0] : "";
            this.w = split.length > 1 ? split[1] : "";
            this.q = split.length > 2 ? split[2] : "";
        }
        this.o = com.anythink.expressad.foundation.g.a.co;
        this.p = com.anythink.expressad.foundation.g.a.cp;
        this.t = com.anythink.expressad.foundation.h.k.e();
        this.x = b();
    }

    private org.json.JSONObject b() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.anythink.expressad.foundation.h.k.i());
            jSONObject.put("cid", sb.toString());
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(com.anythink.expressad.foundation.h.k.f());
            jSONObject.put("dmt", sb2.toString());
            jSONObject.put("dmf", com.anythink.expressad.foundation.h.k.g());
            jSONObject.put(com.anythink.expressad.d.a.b.dx, com.anythink.expressad.foundation.h.k.h());
            jSONObject.put(com.anythink.core.common.o.d.b("aW1laQ=="), this.e);
            jSONObject.put(com.anythink.core.common.o.d.b("bWFj"), this.w);
            jSONObject.put("oaid", this.q);
            jSONObject.put("android_id", this.d);
        } catch (org.json.JSONException unused) {
        }
        return jSONObject;
    }

    public org.json.JSONObject a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.alipay.sdk.m.p.e.p, this.a);
            jSONObject.put("system_version", this.b);
            jSONObject.put("network_type", this.g);
            jSONObject.put("network_type_str", this.h);
            jSONObject.put("device_ua", this.i);
            com.anythink.core.common.f.ax L = com.anythink.core.common.b.o.a().L();
            if (L != null) {
                jSONObject.put("has_wx", L.a());
                jSONObject.put("integrated_wx", L.b());
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(L.c());
                jSONObject.put("opensdk_ver", sb.toString());
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(L.d());
                jSONObject.put("wx_api_ver", sb2.toString());
            }
            jSONObject.put("brand", this.u);
            jSONObject.put("plantform", this.c);
            jSONObject.put(com.anythink.core.common.o.d.b("ZGV2aWNlX2ltZWk="), this.e);
            jSONObject.put("android_id", this.d);
            jSONObject.put("google_ad_id", this.f);
            jSONObject.put("oaid", this.q);
            jSONObject.put("appkey", this.j);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.u, this.k);
            jSONObject.put("screen_width", this.l);
            jSONObject.put("screen_height", this.m);
            jSONObject.put("orientation", this.n);
            jSONObject.put("scale", this.r);
            jSONObject.put("b", this.o);
            jSONObject.put("c", this.p);
            jSONObject.put("web_env", this.f247s);
            jSONObject.put("f", this.t);
            jSONObject.put("misk_spt", this.v);
            jSONObject.put("dvi", com.anythink.expressad.foundation.h.j.a(this.x.toString()));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
