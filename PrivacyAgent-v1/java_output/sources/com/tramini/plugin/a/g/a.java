package com.tramini.plugin.a.g;

/* loaded from: classes19.dex */
public class a {
    public static final java.lang.String a = "a";
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 3;
    private static com.tramini.plugin.a.g.a e;

    /* renamed from: com.tramini.plugin.a.g.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ org.json.JSONObject b;
        final /* synthetic */ org.json.JSONObject c;
        final /* synthetic */ int d;

        /* renamed from: com.tramini.plugin.a.g.a$1$1, reason: invalid class name and collision with other inner class name */
        public class C05091 implements com.tramini.plugin.a.e.b {
            public C05091() {
            }

            @Override // com.tramini.plugin.a.e.b
            public final void a() {
            }

            @Override // com.tramini.plugin.a.e.b
            public final void a(java.lang.Object obj) {
                com.tramini.plugin.a.b.c.a().b(com.tramini.plugin.a.b.c.a().b());
            }

            @Override // com.tramini.plugin.a.e.b
            public final void b() {
                com.tramini.plugin.a.b.c.a().b(com.tramini.plugin.a.b.c.a().b());
            }
        }

        public AnonymousClass1(java.lang.String str, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, int i) {
            this.a = str;
            this.b = jSONObject;
            this.c = jSONObject2;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            new com.tramini.plugin.a.e.e(com.tramini.plugin.a.b.c.a().b(), this.a, this.b, this.c).a(this.d, new com.tramini.plugin.a.g.a.AnonymousClass1.C05091());
        }
    }

    private a() {
    }

    public static com.tramini.plugin.a.g.a a() {
        if (e == null) {
            e = new com.tramini.plugin.a.g.a();
        }
        return e;
    }

    private synchronized void a(int i, java.lang.String str, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        int i2;
        com.tramini.plugin.b.b b2 = com.tramini.plugin.b.c.a(com.tramini.plugin.a.b.c.a().b()).b();
        if (b2 == null) {
            return;
        }
        com.tramini.plugin.a.d.c cVar = b2.f().get(str);
        if (cVar != null) {
            i2 = cVar.b;
            int i3 = cVar.c;
            if (i2 == 0 && i3 == 0) {
                i2 = 0;
            } else if (i2 != i3) {
                i2 += new java.util.Random().nextInt(i3 - i2);
            }
        } else {
            i2 = 5000;
        }
        com.tramini.plugin.a.b.c.a().a(new com.tramini.plugin.a.g.a.AnonymousClass1(str, jSONObject, jSONObject2, i), i2);
    }

    private void a(int i, java.lang.String str, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, int i2) {
        com.tramini.plugin.a.b.c.a().a(new com.tramini.plugin.a.g.a.AnonymousClass1(str, jSONObject, jSONObject2, i), i2);
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("type", 14);
            jSONObject.put("setting_id", str2);
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        a(0, str, (org.json.JSONObject) null, jSONObject);
    }

    public final void a(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        try {
            jSONObject2.put("sdk_time", java.lang.System.currentTimeMillis());
            jSONObject2.put("type", 17);
            jSONObject2.put("setting_id", str2);
        } catch (java.lang.Throwable unused) {
        }
        a(3, str, jSONObject, jSONObject2);
    }

    public final synchronized void a(java.lang.String str, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        a(1, str, jSONObject, jSONObject2);
    }
}
