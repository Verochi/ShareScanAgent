package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public final class q {
    static java.util.Random a = new java.util.Random();
    private static final java.lang.String b = "PlacementPrepareUtils";

    /* renamed from: com.anythink.core.common.o.q$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.g.d {
        final /* synthetic */ com.anythink.core.common.f.ao a;

        public AnonymousClass1(com.anythink.core.common.f.ao aoVar) {
            this.a = aoVar;
        }

        @Override // com.anythink.core.common.g.d
        public final void a(com.anythink.core.common.f.au auVar, int i, int i2) {
            auVar.C(i);
            if (i2 >= 0) {
                auVar.B(i2);
                com.anythink.core.common.f.av a = com.anythink.core.common.a.a().a(this.a.c().ac(), auVar);
                if (a != null) {
                    a.b(auVar.ak());
                }
            }
        }
    }

    @androidx.annotation.WorkerThread
    public static final com.anythink.core.common.f.ao a(com.anythink.core.d.e eVar, com.anythink.core.common.f.h hVar) {
        if (eVar == null) {
            return null;
        }
        java.util.List<com.anythink.core.common.f.au> b2 = com.anythink.core.d.k.b(eVar);
        java.util.List<com.anythink.core.common.f.au> a2 = com.anythink.core.d.k.a(eVar);
        java.util.List<com.anythink.core.common.f.au> c = com.anythink.core.d.k.c(eVar);
        if (c != null) {
            int size = c.size();
            for (int i = 0; i < size; i++) {
                com.anythink.core.common.o.h.a(b2, c.get(i));
            }
        }
        com.anythink.core.c.a.a().a(hVar, b2, eVar);
        java.util.List<com.anythink.core.common.f.au> d = com.anythink.core.d.k.d(eVar);
        com.anythink.core.common.f.ao aoVar = new com.anythink.core.common.f.ao(eVar, hVar, b2.size() + a2.size() + d.size());
        aoVar.a(b2);
        aoVar.b(a2);
        aoVar.c(d);
        a(eVar, aoVar.c(), b2);
        a(eVar, aoVar.c(), a2);
        a(eVar, aoVar.c(), d);
        return aoVar;
    }

    public static java.util.List<com.anythink.core.common.f.au> a(com.anythink.core.common.f.ao aoVar, java.util.List<com.anythink.core.common.f.au> list) {
        return com.anythink.core.common.o.h.a(list, new com.anythink.core.common.o.q.AnonymousClass1(aoVar));
    }

    private static void a(com.anythink.core.d.e eVar, com.anythink.core.common.f.h hVar, java.util.List<com.anythink.core.common.f.au> list) {
        java.util.Iterator<com.anythink.core.common.f.au> it = list.iterator();
        while (it.hasNext()) {
            com.anythink.core.common.f.au next = it.next();
            if (a(hVar.K(), eVar, hVar, next)) {
                next.c();
                it.remove();
            }
        }
    }

    private static void a(java.util.List<com.anythink.core.common.f.au> list, java.util.List<com.anythink.core.common.f.au> list2, com.anythink.core.common.f.h hVar, java.util.List<com.anythink.core.common.f.au> list3) {
        java.lang.String ac = hVar.ac();
        if (list == null || list2 == null) {
            return;
        }
        boolean z = false;
        for (int size = list2.size() - 1; size >= 0; size--) {
            com.anythink.core.common.f.au auVar = list2.get(size);
            if (auVar.Z()) {
                list3.add(auVar);
            }
            if (auVar.n() != 2) {
                com.anythink.core.common.f.av a2 = com.anythink.core.common.a.a().a(ac, auVar);
                com.anythink.core.common.f.au auVar2 = null;
                com.anythink.core.common.f.b a3 = a2 != null ? a2.a((com.anythink.core.common.f.q) null).a() : null;
                if (a3 != null) {
                    auVar.a(a3.d().getUnitGroupInfo(), 0, 3, 1);
                    com.anythink.core.common.o.h.a(auVar);
                    auVar.toString();
                    auVar2 = auVar;
                }
                if (auVar2 == null) {
                    try {
                        com.anythink.core.common.f.q a4 = com.anythink.core.b.f.a().a(ac, auVar);
                        if (a4 != null && !a4.a()) {
                            auVar.a(a4, 0, 2, 1);
                            auVar2 = auVar;
                        } else if (a4 != null) {
                            com.anythink.core.b.d.b.a(a4, new com.anythink.core.common.f.y(1, auVar, hVar), true);
                        }
                    } catch (java.lang.Throwable unused) {
                    }
                }
                if (auVar2 != null) {
                    try {
                        if (auVar.m() == 7) {
                            z = true;
                        }
                        list2.remove(size);
                        com.anythink.core.common.o.h.a(list, auVar);
                    } catch (java.lang.Exception unused2) {
                    }
                }
            }
        }
        if (z) {
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                if (list2.get(size2).m() == 7) {
                    list2.remove(size2);
                }
            }
        }
    }

    private static boolean a(int i, com.anythink.core.d.e eVar, com.anythink.core.common.f.h hVar, com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.f.e c;
        com.anythink.core.common.f.h S = hVar.S();
        java.lang.String ac = hVar.ac();
        com.anythink.core.common.o.u.a(S, auVar, 0, false);
        com.anythink.core.common.f.an.a a2 = com.anythink.core.a.a.a(com.anythink.core.common.b.o.a().f()).a(ac, auVar.u(), eVar.ag());
        int i2 = a2 != null ? a2.e : 0;
        int i3 = a2 != null ? a2.d : 0;
        if (com.anythink.core.a.a.a(com.anythink.core.common.b.o.a().f()).a(ac, auVar, eVar.ag())) {
            auVar.g(-5);
            auVar.h("Out of Cap");
            com.anythink.core.common.o.o.a(ac, hVar, "Out of Cap", auVar, i2, i3);
            com.anythink.core.common.n.c.a(S, 2, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.outOfCapError, "", "Out of Cap"));
        }
        if (com.anythink.core.a.c.a().a(ac, auVar)) {
            auVar.g(-6);
            auVar.h("Out of Pacing");
            com.anythink.core.common.o.o.a(ac, hVar, "Out of Pacing", auVar, i2, i3);
            com.anythink.core.common.n.c.a(S, 3, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.inPacingError, "", "Out of Pacing"));
            return true;
        }
        if (com.anythink.core.common.c.a().a(auVar)) {
            auVar.g(-6);
            auVar.h("Request fail in pacing");
            com.anythink.core.common.o.o.a(ac, hVar, "Request fail in pacing", auVar, i2, i3);
            com.anythink.core.common.n.c.a(S, 4, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.inRequestFailPacing, "", "Request fail in pacing"));
            return true;
        }
        java.util.List<java.lang.String> m = com.anythink.core.common.b.o.a().m(ac);
        if (m != null && m.contains(auVar.u())) {
            auVar.g(-8);
            auVar.h("Request fail in filter list");
            com.anythink.core.common.o.o.a(ac, hVar, "Request fail in filter list", auVar, i2, i3, m);
            com.anythink.core.common.n.c.a(S, 5, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.filterSourceError, "", "Request fail in filter list"));
            return true;
        }
        java.util.List<java.lang.String> n = com.anythink.core.common.b.o.a().n(ac);
        if (n != null && n.contains(java.lang.String.valueOf(auVar.d()))) {
            auVar.g(-8);
            auVar.h("Filter by network firm id.");
            com.anythink.core.common.o.o.a(ac, hVar, "Filter by network firm id.", auVar, i2, i3, n);
            com.anythink.core.common.n.c.a(S, 9, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.networkFirmIdfilterSourceError, "", "Filter by network firm id."));
            return true;
        }
        if (auVar.k()) {
            if (com.anythink.core.common.c.a().b(auVar)) {
                auVar.g(-7);
                auVar.h("Bid fail in pacing");
                com.anythink.core.common.o.o.a(ac, hVar, "Bid fail in pacing", auVar, i2, i3);
                com.anythink.core.common.n.c.a(S, 4, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.inRequestFailPacing, "", "Bid fail in pacing"));
                return true;
            }
            if (auVar.V() != 1 && auVar.m() == 2 && (c = com.anythink.core.common.u.a().c(ac)) != null && c.a(auVar)) {
                auVar.g(-7);
                auVar.h("Can't Load On Showing");
                com.anythink.core.common.o.o.a(ac, hVar, "Can't Load On Showing", auVar, i2, i3);
                com.anythink.core.common.n.c.a(hVar, 7, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.loadInShowingFilter, "", "Can't Load On Showing"));
                return true;
            }
        }
        if (com.anythink.core.common.c.a().a(i, eVar, auVar)) {
            auVar.g(-8);
            auVar.h("Error Code Request fail in pacing");
            com.anythink.core.common.o.o.a(ac, hVar, "Error Code Request fail in pacing", auVar, i2, i3);
            com.anythink.core.common.n.c.a(S, 10, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
            return true;
        }
        if (i == 0 || auVar.aC() != 1) {
            return false;
        }
        auVar.h("System splash not allow preload");
        com.anythink.core.common.o.o.a(ac, hVar, "System splash not allow preload", auVar, i2, i3);
        com.anythink.core.common.n.c.a(S, 11, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.filterByRefreshSystemSplash, com.anythink.core.api.ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
        return true;
    }

    public static void b(com.anythink.core.common.f.ao aoVar, java.util.List<com.anythink.core.common.f.au> list) {
        java.util.List<com.anythink.core.common.f.au> d = aoVar.d();
        java.util.List<com.anythink.core.common.f.au> e = aoVar.e();
        java.util.List<com.anythink.core.common.f.au> f = aoVar.f();
        a(d, e, aoVar.c(), list);
        a(d, f, aoVar.c(), list);
    }
}
