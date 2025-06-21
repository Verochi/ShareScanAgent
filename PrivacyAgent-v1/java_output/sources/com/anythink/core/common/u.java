package com.anythink.core.common;

/* loaded from: classes12.dex */
public class u {
    private static volatile com.anythink.core.common.u a;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.f.am> b = new java.util.concurrent.ConcurrentHashMap<>(4);

    private u() {
    }

    public static com.anythink.core.common.u a() {
        if (a == null) {
            synchronized (com.anythink.core.common.u.class) {
                if (a == null) {
                    a = new com.anythink.core.common.u();
                }
            }
        }
        return a;
    }

    private synchronized void a(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        g(str).a(str2, obj);
    }

    private synchronized com.anythink.core.common.f.am g(java.lang.String str) {
        com.anythink.core.common.f.am amVar;
        amVar = this.b.get(str);
        if (amVar == null) {
            amVar = new com.anythink.core.common.f.am();
            this.b.put(str, amVar);
        }
        return amVar;
    }

    public final com.anythink.core.common.f a(java.lang.String str, java.lang.String str2) {
        return g(str).a(str2);
    }

    public final java.lang.Object a(java.lang.String str) {
        return g(str).a();
    }

    public final java.lang.String a(java.lang.String str, int i) {
        return g(str).c(java.lang.String.valueOf(i));
    }

    public final void a(java.lang.String str, int i, java.lang.String str2) {
        g(str).b(java.lang.String.valueOf(i), str2);
    }

    public final void a(java.lang.String str, com.anythink.core.api.ATAdInfo aTAdInfo) {
        g(str).a(aTAdInfo);
    }

    public final void a(java.lang.String str, java.lang.String str2, com.anythink.core.common.f fVar) {
        g(str).a(str2, fVar);
    }

    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        g(str).a(str2, str3);
    }

    public final synchronized void a(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.util.concurrent.ConcurrentHashMap concurrentHashMap = null;
        if (map != null) {
            try {
                concurrentHashMap = new java.util.concurrent.ConcurrentHashMap(map);
            } catch (java.lang.Throwable unused) {
            }
        }
        g(str).a(concurrentHashMap);
    }

    public final void a(java.lang.String str, boolean z) {
        g(str).a(z);
    }

    public final void a(java.lang.String str, java.lang.Object[] objArr) {
        g(str).a(objArr);
    }

    public final java.lang.String b(java.lang.String str, java.lang.String str2) {
        return g(str).b(str2);
    }

    public final synchronized java.util.Map<java.lang.String, java.lang.Object> b(java.lang.String str) {
        java.util.HashMap hashMap;
        hashMap = new java.util.HashMap(2);
        java.util.Map<java.lang.String, java.lang.Object> b = g(str).b();
        if (b != null) {
            hashMap.putAll(b);
        }
        return hashMap;
    }

    public final com.anythink.core.common.f.e c(java.lang.String str) {
        return g(str).c();
    }

    public final void d(java.lang.String str) {
        g(str).a((com.anythink.core.api.ATAdInfo) null);
    }

    public final boolean e(java.lang.String str) {
        return g(str).d();
    }

    public final java.lang.String f(java.lang.String str) {
        return g(str).e();
    }
}
