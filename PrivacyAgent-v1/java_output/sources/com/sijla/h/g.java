package com.sijla.h;

/* loaded from: classes19.dex */
final class g implements java.lang.Runnable {
    private /* synthetic */ android.content.Context a;
    private /* synthetic */ java.lang.String b;
    private /* synthetic */ java.lang.String c;
    private /* synthetic */ java.lang.String d;
    private /* synthetic */ org.json.JSONObject e = null;
    private /* synthetic */ java.lang.String f;

    public g(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.f = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(com.sijla.h.c.d(this.a));
            arrayList.add(this.b);
            arrayList.add(this.c);
            arrayList.add(!com.sijla.h.c.a(this.d) ? this.d : "1");
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("nt", com.sijla.h.a.a.h(this.a));
            jSONObject.put("oaid", (java.lang.String) com.sijla.h.j.b(this.a, "oaidspkey", ""));
            jSONObject.put("cid", com.sijla.b.g.d);
            java.lang.String h = com.sijla.h.c.h();
            java.lang.String packageName = this.a.getPackageName();
            if (com.sijla.h.c.a(h)) {
                h = packageName;
            }
            jSONObject.put("akey", h);
            arrayList.add(jSONObject.toString());
            arrayList.add(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            arrayList.add(java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000));
            arrayList.add(this.f);
            arrayList.add(android.os.Build.BRAND);
            arrayList.add(android.os.Build.MODEL);
            arrayList.add(android.os.Build.VERSION.RELEASE);
            com.sijla.c.a.a(this.a, com.sijla.h.c.f(androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST), arrayList);
            com.sijla.b.g.b("Save Event Success: " + h + " " + this.b + " " + this.c);
            new com.sijla.e.f(this.a);
            com.sijla.e.f.a(this.a);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
