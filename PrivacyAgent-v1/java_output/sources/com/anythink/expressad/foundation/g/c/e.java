package com.anythink.expressad.foundation.g.c;

/* loaded from: classes12.dex */
public final class e {
    private com.anythink.expressad.foundation.g.c.a a;
    private java.lang.String b;
    private com.anythink.expressad.foundation.g.c.e c;
    private java.util.List<com.anythink.expressad.foundation.g.c.e> d;

    private void a(com.anythink.expressad.foundation.g.c.e eVar) {
        this.c = eVar;
    }

    private void b(com.anythink.expressad.foundation.g.c.e eVar) {
        if (this.d == null) {
            this.d = new java.util.ArrayList();
        }
        eVar.c = this;
        this.d.add(eVar);
    }

    public final com.anythink.expressad.foundation.g.c.a a() {
        return this.a;
    }

    public final void a(com.anythink.expressad.foundation.g.c.a aVar) {
        this.a = aVar;
    }

    public final void a(com.anythink.expressad.foundation.g.c.a aVar, java.lang.String str) {
        com.anythink.expressad.foundation.g.c.e eVar = new com.anythink.expressad.foundation.g.c.e();
        eVar.a = aVar;
        eVar.b = str;
        b(eVar);
    }

    public final void a(java.lang.String str) {
        this.b = str;
    }

    public final void a(java.util.List<com.anythink.expressad.foundation.g.c.e> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        java.util.Iterator<com.anythink.expressad.foundation.g.c.e> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public final java.lang.String b() {
        return this.b;
    }

    public final com.anythink.expressad.foundation.g.c.e c() {
        return this.c;
    }

    public final java.util.List<com.anythink.expressad.foundation.g.c.e> d() {
        return this.d;
    }
}
