package com.anythink.expressad.foundation.g.c;

/* loaded from: classes12.dex */
public abstract class f {
    protected com.anythink.expressad.foundation.g.c.e a;

    public f(java.lang.String str) {
        com.anythink.expressad.foundation.g.c.e eVar = new com.anythink.expressad.foundation.g.c.e();
        eVar.a(str);
        eVar.a(com.anythink.expressad.foundation.g.c.a.AD_ROOT);
        java.util.List<com.anythink.expressad.foundation.g.c.e> a = a();
        if (a.size() > 0) {
            eVar.a(a);
        }
        this.a = eVar;
    }

    public static com.anythink.expressad.foundation.g.c.e a(java.util.ArrayList<com.anythink.expressad.foundation.g.c.e> arrayList, com.anythink.expressad.foundation.g.c.a aVar, java.lang.String str) {
        com.anythink.expressad.foundation.g.c.e eVar = new com.anythink.expressad.foundation.g.c.e();
        eVar.a(aVar);
        eVar.a(str);
        arrayList.add(eVar);
        return eVar;
    }

    public abstract java.util.List<com.anythink.expressad.foundation.g.c.e> a();

    public final com.anythink.expressad.foundation.g.c.e b() {
        return this.a;
    }
}
