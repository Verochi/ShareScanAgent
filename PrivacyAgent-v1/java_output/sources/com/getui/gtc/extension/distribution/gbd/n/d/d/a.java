package com.getui.gtc.extension.distribution.gbd.n.d.d;

/* loaded from: classes22.dex */
public final class a {
    private com.getui.gtc.extension.distribution.gbd.n.d.d.b a;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.d.d.a$a, reason: collision with other inner class name */
    public static class C0323a {
        com.getui.gtc.extension.distribution.gbd.n.d.b.g a;
        int b;

        public C0323a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, int i) {
            this.a = gVar;
            this.b = i;
        }
    }

    public a(com.getui.gtc.extension.distribution.gbd.n.d.d.b bVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(bVar);
        this.a = bVar;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.e a(com.getui.gtc.extension.distribution.gbd.n.d.b.e eVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(eVar);
        com.getui.gtc.extension.distribution.gbd.n.d.b.e a = com.getui.gtc.extension.distribution.gbd.n.d.b.e.a(eVar.g);
        a(eVar.a("body", (com.getui.gtc.extension.distribution.gbd.n.d.b.i) eVar), a.a("body", (com.getui.gtc.extension.distribution.gbd.n.d.b.i) a));
        return a;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.d.a.C0323a a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        java.lang.String str = gVar.c.a;
        com.getui.gtc.extension.distribution.gbd.n.d.b.b bVar = new com.getui.gtc.extension.distribution.gbd.n.d.b.b();
        com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2 = new com.getui.gtc.extension.distribution.gbd.n.d.b.g(com.getui.gtc.extension.distribution.gbd.n.d.c.g.a(str), gVar.g, bVar);
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.a> it = gVar.p().iterator();
        int i = 0;
        while (it.hasNext()) {
            com.getui.gtc.extension.distribution.gbd.n.d.b.a next = it.next();
            if (this.a.a(str, gVar, next)) {
                bVar.a(next);
            } else {
                i++;
            }
        }
        bVar.a(this.a.b(str));
        return new com.getui.gtc.extension.distribution.gbd.n.d.d.a.C0323a(gVar2, i);
    }

    private boolean b(com.getui.gtc.extension.distribution.gbd.n.d.b.e eVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(eVar);
        com.getui.gtc.extension.distribution.gbd.n.d.b.e a = com.getui.gtc.extension.distribution.gbd.n.d.b.e.a(eVar.g);
        return a(eVar.a("body", (com.getui.gtc.extension.distribution.gbd.n.d.b.i) eVar), a.a("body", (com.getui.gtc.extension.distribution.gbd.n.d.b.i) a)) == 0;
    }

    public final int a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
        int i;
        int a;
        int i2 = 0;
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar : java.util.Collections.unmodifiableList(gVar.e)) {
            if (iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.g) {
                com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar3 = (com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar;
                if (this.a.a(gVar3.c.a)) {
                    com.getui.gtc.extension.distribution.gbd.n.d.d.a.C0323a a2 = a(gVar3);
                    com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar4 = a2.a;
                    gVar2.a((com.getui.gtc.extension.distribution.gbd.n.d.b.i) gVar4);
                    i = i2 + a2.b;
                    a = a(gVar3, gVar4);
                } else {
                    i = i2 + 1;
                    a = a(gVar3, gVar2);
                }
                i2 = i + a;
            } else if (iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.j) {
                gVar2.a((com.getui.gtc.extension.distribution.gbd.n.d.b.i) new com.getui.gtc.extension.distribution.gbd.n.d.b.j(((com.getui.gtc.extension.distribution.gbd.n.d.b.j) iVar).c(), iVar.g));
            }
        }
        return i2;
    }
}
