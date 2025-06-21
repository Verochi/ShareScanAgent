package com.vivo.push.d;

/* loaded from: classes19.dex */
final class d extends com.vivo.push.d.z {
    public d(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        com.vivo.push.b.i iVar = (com.vivo.push.b.i) oVar;
        java.lang.String e = iVar.e();
        com.vivo.push.e.a().a(iVar.g(), iVar.h(), e);
        if (android.text.TextUtils.isEmpty(iVar.g()) && !android.text.TextUtils.isEmpty(e)) {
            com.vivo.push.e.a().a(e);
        }
        com.vivo.push.m.b(new com.vivo.push.d.e(this, e, iVar));
    }
}
