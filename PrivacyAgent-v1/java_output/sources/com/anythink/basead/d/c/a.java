package com.anythink.basead.d.c;

/* loaded from: classes12.dex */
public final class a {
    private static void a(com.anythink.core.common.f.aj ajVar, com.anythink.basead.d.c cVar) {
        if (ajVar == null || cVar == null) {
            return;
        }
        ajVar.x(cVar.a());
        ajVar.y(cVar.b());
        ajVar.e(cVar.d());
        ajVar.r(cVar.c());
        ajVar.q(cVar.e());
        ajVar.b(cVar.f());
        ajVar.p(cVar.g());
        ajVar.c(cVar.h());
        ajVar.d(cVar.i());
        ajVar.f(cVar.j());
    }

    public static void a(com.anythink.core.common.f.m mVar, com.anythink.core.common.f.ai aiVar) {
        com.anythink.core.common.f.n nVar;
        if (mVar == null || aiVar == null || (nVar = mVar.n) == null || !(nVar instanceof com.anythink.core.common.f.aj)) {
            return;
        }
        com.anythink.core.common.f.n n = aiVar.n();
        if (n != null) {
            n.x(nVar.E());
            n.y(nVar.F());
            n.r(nVar.y());
            n.e(nVar.x());
            n.s(nVar.z());
            n.q(nVar.w());
            n.b(nVar.t());
            n.p(nVar.v());
            n.d(nVar.h());
            n.c(nVar.g());
            n.f(nVar.K());
            mVar.n = n;
        } else {
            aiVar.a(mVar.n);
        }
        if (!aiVar.H()) {
            com.anythink.core.common.f.n nVar2 = mVar.n;
            nVar2.a(nVar2.ai());
        }
        boolean z = !(aiVar instanceof com.anythink.core.common.f.j) || android.text.TextUtils.isEmpty(((com.anythink.core.common.f.j) aiVar).a());
        if (!com.anythink.basead.a.d.a(aiVar, mVar)) {
            mVar.n.j(2);
        }
        if (z && android.text.TextUtils.isEmpty(aiVar.D())) {
            mVar.n.t(0);
            mVar.n.v(0);
            mVar.n.J(2);
            mVar.n.j(2);
            mVar.n.C(1);
            mVar.n.u(-2);
            mVar.n.c(false);
            mVar.n.d(false);
            mVar.n.e(false);
            mVar.n.W(2);
            if (aiVar.j()) {
                mVar.n.w(1);
            }
        }
        if (mVar.j != 3 || com.anythink.basead.a.d.a(aiVar, mVar)) {
            mVar.n.V(0);
        }
        if (android.text.TextUtils.isEmpty(aiVar.D())) {
            mVar.n.U(1);
        }
    }
}
