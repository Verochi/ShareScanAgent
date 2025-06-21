package com.anythink.expressad.videocommon.e;

/* loaded from: classes12.dex */
public class c {
    public static final java.lang.String a = "reward";
    private static final java.lang.String c = "RewardSettingManager";
    private static java.util.Map<java.lang.String, com.anythink.expressad.videocommon.e.d> e = new java.util.HashMap(3);
    private static volatile com.anythink.expressad.videocommon.e.c f;
    public com.anythink.expressad.videocommon.e.a b;
    private java.lang.Object d = new java.lang.Object();

    /* renamed from: com.anythink.expressad.videocommon.e.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.videocommon.b.i.d {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str) {
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str, java.lang.String str2) {
        }
    }

    private c() {
        this.b = null;
        this.b = c();
    }

    public static com.anythink.expressad.videocommon.e.c a() {
        if (f == null) {
            synchronized (com.anythink.expressad.videocommon.e.c.class) {
                if (f == null) {
                    f = new com.anythink.expressad.videocommon.e.c();
                }
            }
        }
        return f;
    }

    private static com.anythink.expressad.videocommon.e.d a(boolean z) {
        com.anythink.expressad.videocommon.e.d dVar = new com.anythink.expressad.videocommon.e.d();
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(new com.anythink.expressad.videocommon.c.b(1, 15, null));
            dVar.a((java.util.List<com.anythink.expressad.videocommon.c.b>) arrayList);
            dVar.B();
            dVar.z();
            dVar.C();
            dVar.H();
            dVar.E();
            dVar.G();
            dVar.t();
            dVar.u();
            dVar.w();
            dVar.y();
            dVar.s();
            dVar.i();
            dVar.T();
            dVar.g();
            if (z) {
                dVar.a(5);
            } else {
                dVar.a(-1);
            }
            dVar.d();
            dVar.c();
            dVar.q();
            dVar.N();
            dVar.P();
            java.util.ArrayList<java.lang.Integer> arrayList2 = new java.util.ArrayList<>();
            arrayList2.add(4);
            arrayList2.add(6);
            dVar.a(arrayList2);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return dVar;
    }

    private void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.anythink.expressad.videocommon.b.i.a().b(str, (com.anythink.expressad.videocommon.b.i.a) new com.anythink.expressad.videocommon.e.c.AnonymousClass1());
    }

    private static boolean b(java.lang.String str) {
        org.json.JSONArray optJSONArray;
        try {
            if (!android.text.TextUtils.isEmpty(str) && (optJSONArray = new org.json.JSONObject(str).optJSONArray("unitSetting")) != null) {
                java.lang.String optString = optJSONArray.optJSONObject(0).optString("unitId");
                if (optJSONArray.length() > 0) {
                    if (!android.text.TextUtils.isEmpty(optString)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static com.anythink.expressad.videocommon.e.a c() {
        com.anythink.expressad.videocommon.e.a aVar = new com.anythink.expressad.videocommon.e.a();
        java.util.HashMap hashMap = new java.util.HashMap(5);
        hashMap.put("1", 1000);
        hashMap.put("9", 1000);
        hashMap.put("8", 1000);
        java.util.HashMap hashMap2 = new java.util.HashMap(3);
        hashMap2.put("1", new com.anythink.expressad.videocommon.c.c("Virtual Item", 1));
        aVar.a(hashMap);
        aVar.b(hashMap2);
        aVar.a();
        aVar.b();
        aVar.d();
        aVar.f();
        aVar.h();
        return aVar;
    }

    public final com.anythink.expressad.videocommon.e.d a(java.lang.String str, java.lang.String str2) {
        synchronized (this.d) {
            java.lang.String str3 = "reward_" + str + "_" + str2;
            if (e.containsKey(str3)) {
                return e.get(str3);
            }
            com.anythink.expressad.videocommon.e.d c2 = com.anythink.expressad.videocommon.e.d.c(com.anythink.expressad.foundation.a.a.a.a().a(str3));
            e.put(str3, c2);
            return c2;
        }
    }

    public final com.anythink.expressad.videocommon.e.d a(java.lang.String str, java.lang.String str2, boolean z) {
        com.anythink.expressad.videocommon.e.d dVar;
        synchronized (this.d) {
            java.lang.String str3 = "reward_" + str + "_" + str2;
            dVar = e.get(str3);
            if (dVar == null) {
                dVar = a(z);
                e.put(str3, dVar);
            }
        }
        return dVar;
    }

    public final void a(java.lang.String str, boolean z) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.lang.String J = a().a(com.anythink.expressad.foundation.b.a.b().e(), str, z) != null ? com.anythink.expressad.videocommon.e.d.J() : "";
        if (android.text.TextUtils.isEmpty(J) || !android.text.TextUtils.isEmpty(com.anythink.expressad.videocommon.b.i.a().c(J)) || android.text.TextUtils.isEmpty(J)) {
            return;
        }
        com.anythink.expressad.videocommon.b.i.a().b(J, (com.anythink.expressad.videocommon.b.i.a) new com.anythink.expressad.videocommon.e.c.AnonymousClass1());
    }

    public final com.anythink.expressad.videocommon.e.a b() {
        com.anythink.expressad.videocommon.e.a aVar = this.b;
        return aVar == null ? c() : aVar;
    }
}
