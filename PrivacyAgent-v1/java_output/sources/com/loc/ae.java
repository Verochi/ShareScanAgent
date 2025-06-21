package com.loc;

/* loaded from: classes23.dex */
public final class ae extends com.loc.ag {
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    protected byte[] j;

    public ae(android.content.Context context) {
        super(context);
    }

    @Override // com.loc.bu
    public final byte[] d() {
        byte[] bArr = this.j;
        if (bArr != null) {
            return bArr;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("method", "remap");
            jSONObject.put("package_name", com.loc.m.c(this.k));
            jSONObject.put("model", android.os.Build.MODEL);
            jSONObject.put("os_version", android.os.Build.VERSION.RELEASE);
            jSONObject.put("os_type", "Android");
            jSONObject.put("sdk_version", "4.3.13");
            java.lang.String a = com.loc.ac.a();
            this.a = a;
            jSONObject.put("t1", a);
            jSONObject.put("old_t1", com.loc.z.g(this.k));
            java.lang.String b = com.loc.ac.b();
            this.b = b;
            jSONObject.put("t2", b);
            jSONObject.put("old_t2", com.loc.z.h(this.k));
            java.lang.String c = com.loc.ac.c();
            this.c = c;
            jSONObject.put("t3", c);
            jSONObject.put("old_t3", com.loc.z.i(this.k));
            java.lang.String d = com.loc.ac.d();
            this.d = d;
            jSONObject.put(com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_1, d);
            jSONObject.put("old_s1", com.loc.z.j(this.k));
            java.lang.String e = com.loc.ac.e();
            this.e = e;
            jSONObject.put(com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_2, e);
            jSONObject.put("old_s2", com.loc.z.k(this.k));
            java.lang.String f = com.loc.ac.f();
            this.f = f;
            jSONObject.put(com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_3, f);
            jSONObject.put("old_s3", com.loc.z.l(this.k));
            java.lang.String g = com.loc.ac.g();
            this.g = g;
            jSONObject.put(com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_4, g);
            jSONObject.put("old_s4", com.loc.z.m(this.k));
            jSONObject.put("uuid", com.loc.ac.a(this.k));
            jSONObject.put("android_id", com.loc.p.g());
            jSONObject.put("hostname", com.loc.ac.h());
            java.lang.String t = com.loc.p.t(this.k);
            this.h = t;
            jSONObject.put("gaid", t);
            jSONObject.put("old_gaid", com.loc.z.n(this.k));
            java.lang.String e2 = com.loc.p.e(this.k);
            this.i = e2;
            jSONObject.put("oaid", e2);
            jSONObject.put("old_oaid", com.loc.z.b(this.k));
            jSONObject.put("aaid", com.loc.z.c(this.k));
            jSONObject.put("resetToken", com.loc.z.f(this.k));
            jSONObject.put("uabc", com.loc.z.e(this.k));
            this.j = com.loc.ac.a(com.loc.y.d(jSONObject.toString().getBytes("utf-8")), com.loc.y.c("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());
        } catch (java.lang.Throwable unused) {
        }
        return this.j;
    }
}
