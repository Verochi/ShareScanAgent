package com.getui.gtc.extension.distribution.gbd.h;

/* loaded from: classes22.dex */
public final class a {
    private static final java.lang.String a = "GBD_DC_MK";

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* renamed from: com.getui.gtc.extension.distribution.gbd.h.a$1, reason: invalid class name */
    public static class AnonymousClass1<R, T> implements com.getui.gtc.dim.DimCallback<T, R> {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ com.getui.gtc.dim.Caller b;
        final /* synthetic */ com.getui.gtc.extension.distribution.gbd.f.j c;

        public AnonymousClass1(java.lang.String str, com.getui.gtc.dim.Caller caller, com.getui.gtc.extension.distribution.gbd.f.j jVar) {
            this.a = str;
            this.b = caller;
            this.c = jVar;
        }

        @Override // com.getui.gtc.dim.DimCallback
        public final R get(T t) {
            com.getui.gtc.extension.distribution.gbd.h.a.a("source get sys trace, key: " + this.a + ", caller: " + this.b);
            try {
                return (R) this.c.a(t);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                return null;
            }
        }
    }

    public static java.lang.Object a(boolean z, java.lang.String str, com.getui.gtc.extension.distribution.gbd.f.f fVar) {
        com.getui.gtc.dim.DimRequest.Builder key;
        java.lang.StringBuilder sb;
        java.lang.String str2;
        if (z && com.getui.gtc.extension.distribution.gbd.d.d.cT && com.getui.gtc.extension.distribution.gbd.d.c.k) {
            key = new com.getui.gtc.dim.DimRequest.Builder().key(str).caller(com.getui.gtc.dim.Caller.UNKNOWN);
            sb = new java.lang.StringBuilder("g d c :");
            sb.append(str);
            str2 = " , mock stack";
        } else {
            key = new com.getui.gtc.dim.DimRequest.Builder().key(str);
            if (fVar != null) {
                fVar.a(key);
            }
            sb = new java.lang.StringBuilder("g d c :");
            sb.append(str);
            str2 = " , not mock stack";
        }
        sb.append(str2);
        b(sb.toString());
        return com.getui.gtc.dim.DimManager.getInstance().get(key.build());
    }

    public static <T, R> R a(boolean z, java.lang.String str, T t, com.getui.gtc.extension.distribution.gbd.f.j<T, R> jVar) {
        if (str == null || t == null || jVar == null) {
            a("g d : params is null");
            return null;
        }
        if (z) {
            try {
                if (com.getui.gtc.extension.distribution.gbd.d.d.cT && com.getui.gtc.extension.distribution.gbd.d.c.k) {
                    com.getui.gtc.dim.Caller a2 = com.getui.gtc.extension.distribution.gbd.j.a.a(str);
                    com.getui.gtc.dim.DimSource of = com.getui.gtc.dim.DimSource.of(a2);
                    if (of != null) {
                        return (R) of.get(t, new com.getui.gtc.extension.distribution.gbd.h.a.AnonymousClass1(str, a2, jVar));
                    }
                    a("source get sys trace, key: " + str + ", caller: no caller");
                    return null;
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                return null;
            }
        }
        a("source enable is false or gtc not support source");
        return jVar.a(t);
    }

    public static void a(java.lang.String str) {
        a(new java.lang.Throwable(str));
    }

    private static void a(java.lang.Throwable th) {
        if (com.getui.gtc.extension.distribution.gbd.d.d.cU) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    private static <T> T b(boolean z, java.lang.String str, com.getui.gtc.extension.distribution.gbd.f.f fVar) {
        return (T) a(z, str, fVar);
    }

    private static void b(java.lang.String str) {
        if (com.getui.gtc.extension.distribution.gbd.d.d.cU) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, str);
        }
    }
}
