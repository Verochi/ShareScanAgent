package com.anythink.core.d;

/* loaded from: classes12.dex */
public final class h {
    private static final java.lang.String a = "PlaceStrategySaver";
    private final android.content.Context b;
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.d.e> c = new java.util.concurrent.ConcurrentHashMap<>();
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.d.e> d = new java.util.concurrent.ConcurrentHashMap<>();
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.d.e> e = new java.util.concurrent.ConcurrentHashMap<>();
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> f = new java.util.concurrent.ConcurrentHashMap<>();
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> g = new java.util.concurrent.ConcurrentHashMap<>();

    /* renamed from: com.anythink.core.d.h$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ boolean c;

        public AnonymousClass1(org.json.JSONObject jSONObject, java.lang.String str, boolean z) {
            this.a = jSONObject;
            this.b = str;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            org.json.JSONObject jSONObject = this.a;
            com.anythink.core.common.o.r.a(com.anythink.core.d.h.this.b, com.anythink.core.common.b.h.p, com.anythink.core.d.h.b(this.b, this.c), jSONObject == null ? "" : jSONObject.toString());
        }
    }

    public h(android.content.Context context) {
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String b(java.lang.String str, boolean z) {
        return str + "_" + (z ? com.anythink.core.common.b.h.u.d : com.anythink.core.common.b.h.u.c);
    }

    private boolean d(java.lang.String str, java.lang.String str2) {
        return a(str, str2, 0) != null;
    }

    public final com.anythink.core.d.e a(java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(str2);
        int i = this.f.get(sb.toString()) == null ? 2 : 0;
        com.anythink.core.d.e a2 = a(str, str2, i);
        return (a2 == null && i == 2) ? a(str, str2, 0) : a2;
    }

    public final com.anythink.core.d.e a(java.lang.String str, java.lang.String str2, int i) {
        java.lang.String str3 = str + str2;
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.d.e> concurrentHashMap = i == 1 ? this.e : i == 2 ? this.c : this.d;
        com.anythink.core.d.e eVar = concurrentHashMap.get(str3);
        if (eVar != null) {
            return eVar;
        }
        if (i == 1) {
            return null;
        }
        java.lang.String b = com.anythink.core.common.o.r.b(this.b, com.anythink.core.common.b.h.p, b(str3, i == 2), "");
        if (!android.text.TextUtils.isEmpty(b)) {
            try {
                com.anythink.core.d.e a2 = com.anythink.core.d.e.a(new org.json.JSONObject(b));
                if (a2 != null) {
                    a2.a(i);
                    concurrentHashMap.put(str3, a2);
                    return a2;
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return null;
    }

    public final void a(java.lang.String str, int i) {
        this.g.put(str, java.lang.Integer.valueOf(i));
    }

    public final void a(java.lang.String str, java.lang.String str2, com.anythink.core.d.e eVar, org.json.JSONObject jSONObject, int i) {
        boolean z;
        if (this.b == null || eVar == null || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        java.lang.String str3 = str + str2;
        if (i == 1) {
            this.e.put(str3, eVar);
            return;
        }
        if (i == 2) {
            this.c.put(str3, eVar);
            z = true;
        } else {
            this.d.put(str3, eVar);
            z = false;
        }
        if (eVar.t() == 1) {
            com.anythink.core.common.b.o.a().I();
        } else {
            com.anythink.core.common.o.b.b.a().a(new com.anythink.core.d.h.AnonymousClass1(jSONObject, str3, z));
        }
    }

    public final com.anythink.core.d.e b(java.lang.String str, java.lang.String str2) {
        com.anythink.core.d.e a2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(str2);
        java.lang.Integer num = this.g.get(str2);
        int intValue = num == null ? 0 : num.intValue();
        return (intValue != 1 || (a2 = a(str, str2, 0)) == null) ? a(str, str2, intValue) : a2;
    }

    public final void b(java.lang.String str, java.lang.String str2, int i) {
        java.lang.String str3 = str + str2;
        if (i == 1) {
            this.e.remove(str3);
        } else {
            com.anythink.core.common.o.r.a(this.b, com.anythink.core.common.b.h.p, b(str3, i == 2));
        }
    }

    public final void c(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = str + str2;
        java.lang.Integer num = this.f.get(str3);
        if (num == null) {
            this.f.put(str3, 1);
        } else {
            this.f.put(str3, java.lang.Integer.valueOf(num.intValue() + 1));
        }
    }
}
