package com.anythink.basead.f.a;

/* loaded from: classes12.dex */
public final class b {
    private static com.anythink.basead.f.a.b a;
    private android.content.Context b;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.basead.c.c> d = new java.util.concurrent.ConcurrentHashMap<>();
    private java.text.SimpleDateFormat c = new java.text.SimpleDateFormat("yyyyMMdd");

    /* renamed from: com.anythink.basead.f.a.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.basead.c.c a;

        public AnonymousClass1(com.anythink.basead.c.c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.b.c.a(com.anythink.basead.f.a.b.this.b).c(this.a.f);
            com.anythink.basead.b.c.a(com.anythink.basead.f.a.b.this.b).a(this.a);
        }
    }

    private b(android.content.Context context) {
        this.b = context.getApplicationContext();
    }

    public static com.anythink.basead.f.a.b a(android.content.Context context) {
        if (a == null) {
            a = new com.anythink.basead.f.a.b(context);
        }
        return a;
    }

    public final java.lang.String a() {
        java.util.List<com.anythink.basead.c.c> b = com.anythink.basead.b.c.a(this.b).b(this.c.format(new java.util.Date(java.lang.System.currentTimeMillis())));
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        if (b != null) {
            java.util.Iterator<com.anythink.basead.c.c> it = b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a);
            }
        }
        return jSONArray.toString();
    }

    public final void a(com.anythink.core.common.f.z zVar) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String format = this.c.format(new java.util.Date(currentTimeMillis));
        com.anythink.basead.c.c d = d(zVar);
        if (d.f.equals(format)) {
            d.d++;
        } else {
            d.d = 1;
            d.f = format;
        }
        d.e = currentTimeMillis;
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.basead.f.a.b.AnonymousClass1(d), 2, true);
    }

    public final boolean a(java.lang.String str) {
        java.util.List<com.anythink.core.common.f.z> Q;
        com.anythink.core.d.e a2 = com.anythink.core.d.f.a(this.b).a(str);
        if (a2 == null || (Q = a2.Q()) == null || Q.size() <= 0) {
            return false;
        }
        java.util.Iterator<com.anythink.core.common.f.z> it = Q.iterator();
        while (it.hasNext()) {
            if (!b(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean b(com.anythink.core.common.f.z zVar) {
        com.anythink.basead.c.c d = d(zVar);
        int i = zVar.W;
        return i != -1 && d.d >= i;
    }

    public final boolean c(com.anythink.core.common.f.z zVar) {
        return java.lang.System.currentTimeMillis() - d(zVar).e <= zVar.X;
    }

    public final com.anythink.basead.c.c d(com.anythink.core.common.f.z zVar) {
        java.lang.String format = this.c.format(new java.util.Date(java.lang.System.currentTimeMillis()));
        com.anythink.basead.c.c cVar = this.d.get(zVar.s());
        if (cVar == null) {
            cVar = com.anythink.basead.b.c.a(this.b).a(zVar.s());
            if (cVar == null) {
                cVar = new com.anythink.basead.c.c();
                cVar.a = zVar.s();
                cVar.b = zVar.W;
                cVar.c = zVar.X;
                cVar.e = 0L;
                cVar.d = 0;
                cVar.f = format;
            }
            this.d.put(zVar.s(), cVar);
        }
        if (!android.text.TextUtils.equals(format, cVar.f)) {
            cVar.f = format;
            cVar.d = 0;
        }
        return cVar;
    }
}
