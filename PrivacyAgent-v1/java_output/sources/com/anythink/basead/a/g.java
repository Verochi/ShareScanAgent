package com.anythink.basead.a;

/* loaded from: classes12.dex */
public class g {
    private static volatile com.anythink.basead.a.g b;
    com.anythink.basead.a.f a;
    private android.content.Context c;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.f.l> d = new java.util.concurrent.ConcurrentHashMap<>();

    private g(android.content.Context context) {
        this.c = context;
    }

    public static com.anythink.basead.a.g a(android.content.Context context) {
        if (b == null) {
            synchronized (com.anythink.basead.a.g.class) {
                if (b == null) {
                    b = new com.anythink.basead.a.g(context);
                }
            }
        }
        return b;
    }

    private void b() {
        if (this.a != null) {
            com.anythink.core.common.k.a(this.c).a(this.a);
            this.a = null;
        }
    }

    public final void a() {
        if (this.c != null && this.a == null) {
            this.a = new com.anythink.basead.a.f();
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction(com.anythink.china.common.a.b);
            intentFilter.addAction(com.anythink.china.common.a.c);
            intentFilter.addAction(com.anythink.china.common.a.d);
            intentFilter.addAction(com.anythink.china.common.a.e);
            com.anythink.core.common.k.a(this.c).a(this.a, intentFilter);
        }
    }

    public final void a(java.lang.String str, com.anythink.core.common.f.l lVar) {
        this.d.put(str, lVar);
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.f.l lVar = this.d.get(str);
        if (lVar != null) {
            com.anythink.basead.c.i iVar = new com.anythink.basead.c.i("", "");
            com.anythink.basead.c.b bVar = new com.anythink.basead.c.b();
            iVar.i = bVar;
            bVar.a = str2;
            com.anythink.basead.a.a.a(18, lVar, iVar);
        }
    }

    public final void b(java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.f.l lVar = this.d.get(str);
        if (lVar != null) {
            com.anythink.basead.c.i iVar = new com.anythink.basead.c.i("", "");
            com.anythink.basead.c.b bVar = new com.anythink.basead.c.b();
            iVar.i = bVar;
            bVar.a = str2;
            com.anythink.basead.a.a.a(19, lVar, iVar);
        }
    }

    public final void c(java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.f.l lVar = this.d.get(str);
        if (lVar != null) {
            com.anythink.basead.c.i iVar = new com.anythink.basead.c.i("", "");
            com.anythink.basead.c.b bVar = new com.anythink.basead.c.b();
            iVar.i = bVar;
            bVar.a = str2;
            com.anythink.basead.a.a.a(20, lVar, iVar);
        }
    }

    public final void d(java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.f.l remove = this.d.remove(str);
        if (remove != null) {
            com.anythink.basead.c.i iVar = new com.anythink.basead.c.i("", "");
            com.anythink.basead.c.b bVar = new com.anythink.basead.c.b();
            iVar.i = bVar;
            bVar.a = str2;
            com.anythink.basead.a.a.a(21, remove, iVar);
        }
        if (this.d.size() != 0 || this.a == null) {
            return;
        }
        com.anythink.core.common.k.a(this.c).a(this.a);
        this.a = null;
    }
}
