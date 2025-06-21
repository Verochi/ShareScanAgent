package com.vivo.push.d;

/* loaded from: classes19.dex */
final class a extends com.vivo.push.l {
    public a(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        com.vivo.push.b.c cVar = (com.vivo.push.b.c) oVar;
        com.vivo.push.model.b a = com.vivo.push.util.t.a(this.a);
        if (a == null) {
            com.vivo.push.e.a().a(cVar.h(), 1005, new java.lang.Object[0]);
            return;
        }
        java.lang.String a2 = a.a();
        if (a.c()) {
            com.vivo.push.e.a().a(cVar.h(), 1004, new java.lang.Object[0]);
            oVar = new com.vivo.push.b.e();
        } else {
            int a3 = com.vivo.push.util.s.a(cVar);
            if (a3 != 0) {
                com.vivo.push.e.a().a(cVar.h(), a3, new java.lang.Object[0]);
                return;
            }
        }
        com.vivo.push.a.a.a(this.a, a2, oVar);
    }
}
