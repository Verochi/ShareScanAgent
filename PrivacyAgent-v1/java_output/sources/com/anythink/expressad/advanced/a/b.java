package com.anythink.expressad.advanced.a;

/* loaded from: classes12.dex */
public final class b {
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
    public java.lang.String c = com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM;
    public java.lang.String a = com.anythink.expressad.foundation.h.k.b();
    public java.lang.String b = com.anythink.expressad.foundation.h.k.c();
    public java.lang.String f = com.anythink.core.common.o.e.f();

    public b(android.content.Context context) {
        java.lang.String str;
        this.e = com.anythink.core.common.o.e.d(context);
        int a = com.anythink.expressad.foundation.h.k.a();
        this.h = java.lang.String.valueOf(a);
        this.i = com.anythink.expressad.foundation.h.k.a(context, a);
        this.j = com.anythink.core.common.o.e.i();
        this.k = com.anythink.expressad.foundation.b.a.b().f();
        this.l = com.anythink.expressad.foundation.b.a.b().e();
        this.m = java.lang.String.valueOf(com.anythink.expressad.foundation.h.t.f(context));
        this.n = java.lang.String.valueOf(com.anythink.expressad.foundation.h.t.e(context));
        this.p = java.lang.String.valueOf(com.anythink.expressad.foundation.h.t.c(context));
        if (context.getResources().getConfiguration().orientation == 2) {
            this.o = "landscape";
        } else {
            this.o = "portrait";
        }
        com.anythink.core.api.IExHandler b = com.anythink.core.common.b.o.a().b();
        if (b != null) {
            str = b.fillCDataParam("at_device1|||at_device2|||at_device3");
            str.replace("at_device1", "").replace("at_device2", "").replace("at_device3", "");
        } else {
            str = "";
        }
        if (android.text.TextUtils.isEmpty(str)) {
            this.d = "";
            this.g = "";
        } else {
            java.lang.String[] split = str.split("\\|\\|\\|");
            try {
                this.d = split[0];
            } catch (java.lang.Throwable unused) {
            }
            try {
                this.g = split[2];
            } catch (java.lang.Throwable unused2) {
            }
        }
    }

    public final org.json.JSONObject a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.alipay.sdk.m.p.e.p, this.a);
            jSONObject.put("system_version", this.b);
            jSONObject.put("network_type", this.h);
            jSONObject.put("network_type_str", this.i);
            jSONObject.put("device_ua", this.j);
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
            jSONObject.put("plantform", this.c);
            jSONObject.put(com.anythink.core.common.o.d.b("ZGV2aWNlX2ltZWk="), this.d);
            jSONObject.put("android_id", this.e);
            jSONObject.put("google_ad_id", this.f);
            jSONObject.put("oaid", this.g);
            jSONObject.put("appkey", this.k);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.u, this.l);
            jSONObject.put("screen_width", this.m);
            jSONObject.put("screen_height", this.n);
            jSONObject.put("orientation", this.o);
            jSONObject.put("scale", this.p);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
