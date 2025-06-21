package com.anythink.core.common.n;

/* loaded from: classes12.dex */
public class d extends com.anythink.core.common.m<com.anythink.core.common.f.k> {
    private static volatile com.anythink.core.common.n.d g;

    private d(android.content.Context context) {
        super(context);
    }

    public static com.anythink.core.common.n.d a(android.content.Context context) {
        if (g == null) {
            synchronized (com.anythink.core.common.n.d.class) {
                if (g == null) {
                    g = new com.anythink.core.common.n.d(context);
                }
            }
        }
        return g;
    }

    @Override // com.anythink.core.common.m
    public final void a(java.util.List<com.anythink.core.common.f.k> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.anythink.core.common.f.k> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a().toString());
        }
        com.anythink.core.d.a b = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
        if (b == null) {
            com.anythink.core.common.h.b bVar = new com.anythink.core.common.h.b(this.d, 0, arrayList);
            bVar.p();
            bVar.a(0, (com.anythink.core.common.h.k) null);
        } else if (b.C() != 1) {
            com.anythink.core.common.h.b bVar2 = new com.anythink.core.common.h.b(this.d, b.C(), arrayList);
            bVar2.p();
            bVar2.a(0, (com.anythink.core.common.h.k) null);
        } else {
            com.anythink.core.common.h.a.a aVar = new com.anythink.core.common.h.a.a(arrayList);
            aVar.a(1, b.B());
            aVar.a();
            aVar.a((com.anythink.core.common.h.a.c.a) null);
        }
    }
}
