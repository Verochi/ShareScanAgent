package com.anythink.nativead.a;

/* loaded from: classes12.dex */
public class a {
    public static final java.lang.String a = "a";
    private static java.util.Map<java.lang.String, com.anythink.nativead.a.a> e = new java.util.concurrent.ConcurrentHashMap(3);
    private android.content.Context b;
    private java.lang.String c;
    private com.anythink.core.common.f d;

    /* renamed from: com.anythink.nativead.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.b a;

        public AnonymousClass1(com.anythink.core.common.f.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.a.a().a(this.a);
        }
    }

    private a(android.content.Context context, java.lang.String str) {
        this.b = context.getApplicationContext();
        this.c = str;
        this.d = com.anythink.core.common.f.a(context, str, "0");
    }

    public static com.anythink.nativead.a.a a(android.content.Context context, java.lang.String str) {
        com.anythink.nativead.a.a aVar = e.get(str);
        if (aVar == null) {
            synchronized (com.anythink.nativead.a.a.class) {
                if (aVar == null) {
                    aVar = new com.anythink.nativead.a.a(context, str);
                    e.put(str, aVar);
                }
            }
        }
        return aVar;
    }

    public final com.anythink.core.api.ATAdStatusInfo a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        return this.d.a(context, map);
    }

    public final com.anythink.core.common.f.b a(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.anythink.core.common.f.b a2 = this.d.a(this.b, false, true, map);
        if (a2 == null || !(a2.e() instanceof com.anythink.nativead.unitgroup.a) || !(a2.d() instanceof com.anythink.nativead.unitgroup.api.CustomNativeAdapter)) {
            return null;
        }
        com.anythink.core.common.f.h detail = a2.e().getDetail();
        detail.B = str;
        a2.a(a2.c() + 1);
        com.anythink.core.common.o.b.b.a().a(new com.anythink.nativead.a.a.AnonymousClass1(a2));
        com.anythink.core.common.o.u.a(map, detail);
        com.anythink.core.common.o.u.a(this.c, detail);
        return a2;
    }

    public final java.util.List<com.anythink.core.api.ATAdInfo> a(android.content.Context context) {
        return this.d.b(context);
    }

    public final void a(android.content.Context context, com.anythink.core.common.b.b bVar, com.anythink.core.common.b.c cVar, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.anythink.core.common.f.v vVar = new com.anythink.core.common.f.v();
        vVar.a(context);
        vVar.e = cVar;
        vVar.d = 0;
        if (map != null) {
            try {
                vVar.g = new java.util.HashMap(map);
            } catch (java.lang.Throwable unused) {
            }
        }
        this.d.b(this.b, "0", this.c, vVar, bVar);
    }
}
