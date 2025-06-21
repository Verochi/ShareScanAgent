package com.loc;

/* loaded from: classes23.dex */
public class ad {
    private static com.loc.ad a;
    private static boolean b;
    private static boolean c;
    private android.content.Context d;

    /* renamed from: com.loc.ad$1, reason: invalid class name */
    public class AnonymousClass1 extends com.loc.cu {
        public AnonymousClass1() {
        }

        @Override // com.loc.cu
        public final void a() {
            com.loc.ad.this.b();
        }
    }

    /* renamed from: com.loc.ad$2, reason: invalid class name */
    public class AnonymousClass2 extends com.loc.cu {
        public AnonymousClass2() {
        }

        @Override // com.loc.cu
        public final void a() {
            com.loc.ad.this.c();
        }
    }

    private ad(android.content.Context context) {
        this.d = context;
    }

    public static com.loc.ad a(android.content.Context context) {
        if (a == null) {
            synchronized (com.loc.ad.class) {
                if (a == null) {
                    a = new com.loc.ad(context);
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            if (b) {
                b = false;
                return;
            }
            b = true;
            com.loc.ab abVar = new com.loc.ab(this.d);
            new com.loc.bp();
            com.loc.bv a2 = com.loc.bp.a(abVar);
            if (a2 != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(com.loc.y.a(com.loc.ac.a(a2.a, com.loc.y.c("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    com.loc.z.f(this.d, abVar.a);
                    com.loc.z.g(this.d, abVar.b);
                    com.loc.z.h(this.d, abVar.c);
                    com.loc.z.i(this.d, abVar.d);
                    com.loc.z.j(this.d, abVar.e);
                    com.loc.z.k(this.d, abVar.f);
                    com.loc.z.l(this.d, abVar.g);
                    com.loc.z.b(this.d, abVar.i);
                    com.loc.z.m(this.d, abVar.h);
                    com.loc.z.a(this.d, android.os.SystemClock.elapsedRealtime());
                    java.lang.String optString = jSONObject.optString("aaid", "");
                    java.lang.String optString2 = jSONObject.optString("resetToken", "");
                    java.lang.String optString3 = jSONObject.optString("uabc", "");
                    if (!android.text.TextUtils.isEmpty(optString)) {
                        com.loc.z.c(this.d, optString);
                    }
                    if (!android.text.TextUtils.isEmpty(optString2)) {
                        com.loc.z.e(this.d, optString2);
                    }
                    if (!android.text.TextUtils.isEmpty(optString3)) {
                        com.loc.z.d(this.d, optString3);
                    }
                }
            }
            b = false;
        } catch (java.lang.Throwable unused) {
            b = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            if (c) {
                c = false;
                return;
            }
            c = true;
            com.loc.ae aeVar = new com.loc.ae(this.d);
            new com.loc.bp();
            com.loc.bv a2 = com.loc.bp.a(aeVar);
            if (a2 != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(com.loc.y.a(com.loc.ac.a(a2.a, com.loc.y.c("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    com.loc.z.f(this.d, aeVar.a);
                    com.loc.z.g(this.d, aeVar.b);
                    com.loc.z.h(this.d, aeVar.c);
                    com.loc.z.i(this.d, aeVar.d);
                    com.loc.z.j(this.d, aeVar.e);
                    com.loc.z.k(this.d, aeVar.f);
                    com.loc.z.l(this.d, aeVar.g);
                    com.loc.z.b(this.d, aeVar.i);
                    com.loc.z.m(this.d, aeVar.h);
                    com.loc.z.a(this.d, android.os.SystemClock.elapsedRealtime());
                    java.lang.String optString = jSONObject.optString("aaid", "");
                    java.lang.String optString2 = jSONObject.optString("resetToken", "");
                    java.lang.String optString3 = jSONObject.optString("uabc", "");
                    if (!android.text.TextUtils.isEmpty(optString)) {
                        com.loc.z.c(this.d, optString);
                    }
                    if (!android.text.TextUtils.isEmpty(optString2)) {
                        com.loc.z.e(this.d, optString2);
                    }
                    if (!android.text.TextUtils.isEmpty(optString3)) {
                        com.loc.z.d(this.d, optString3);
                    }
                }
            }
            c = false;
        } catch (java.lang.Throwable unused) {
            c = false;
        }
    }

    public final java.lang.String a() {
        com.loc.ct a2;
        com.loc.cu anonymousClass2;
        java.lang.String str = "";
        try {
            if (com.loc.aa.d) {
                str = com.loc.z.c(this.d);
                long d = com.loc.z.d(this.d);
                long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
                if (android.text.TextUtils.isEmpty(str)) {
                    a2 = com.loc.ct.a();
                    anonymousClass2 = new com.loc.ad.AnonymousClass1();
                } else if (elapsedRealtime - d > com.loc.aa.b) {
                    a2 = com.loc.ct.a();
                    anonymousClass2 = new com.loc.ad.AnonymousClass2();
                }
                a2.b(anonymousClass2);
            }
        } catch (java.lang.Throwable unused) {
        }
        return str;
    }
}
