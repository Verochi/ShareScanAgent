package com.vivo.push.d;

/* loaded from: classes19.dex */
final class b extends com.vivo.push.l {
    public b(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        com.vivo.push.model.b a = com.vivo.push.util.t.a(this.a);
        try {
            if (((com.vivo.push.b.d) oVar).d() ? com.vivo.push.d.f.a(this.a) : com.vivo.push.d.f.b(this.a)) {
                com.vivo.push.model.b a2 = com.vivo.push.util.t.a(this.a);
                if (a == null || a2 == null || a2.a() == null || !a2.a().equals(a.a())) {
                    if (a != null && a.a() != null) {
                        com.vivo.push.a.a.a(this.a, a.a(), new com.vivo.push.b.y(a.a()));
                    }
                    if (a2 == null || a2.a() == null) {
                        return;
                    }
                    com.vivo.push.a.a.a(this.a, a2.a(), new com.vivo.push.b.f());
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
