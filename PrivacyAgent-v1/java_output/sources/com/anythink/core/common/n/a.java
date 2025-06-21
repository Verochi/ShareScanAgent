package com.anythink.core.common.n;

/* loaded from: classes12.dex */
public class a extends com.anythink.core.common.m<com.anythink.core.common.f.i> {
    private static volatile com.anythink.core.common.n.a g;

    /* renamed from: com.anythink.core.common.n.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.at a;
        final /* synthetic */ int b;
        final /* synthetic */ com.anythink.core.common.f.au c;
        final /* synthetic */ long d;

        public AnonymousClass1(com.anythink.core.common.f.at atVar, int i, com.anythink.core.common.f.au auVar, long j) {
            this.a = atVar;
            this.b = i;
            this.c = auVar;
            this.d = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if ((this.a instanceof com.anythink.core.common.f.h) && com.anythink.core.common.b.o.a().H()) {
                com.anythink.core.common.b.j.a().a(this.b, (com.anythink.core.common.f.h) this.a);
            }
            com.anythink.core.common.f.i a = com.anythink.core.common.n.a.a(com.anythink.core.common.n.a.this, this.b, this.a, this.c, this.d);
            if (a == null) {
                return;
            }
            com.anythink.core.common.n.a.super.a((com.anythink.core.common.n.a) a, com.anythink.core.common.n.a.b(this.b, this.a));
        }
    }

    private a(android.content.Context context) {
        super(context);
    }

    public static /* synthetic */ com.anythink.core.common.f.i a(com.anythink.core.common.n.a aVar, int i, com.anythink.core.common.f.at atVar, com.anythink.core.common.f.au auVar, long j) {
        com.anythink.core.common.f.h hVar;
        java.lang.String ac;
        com.anythink.core.d.e a;
        java.util.List<java.lang.String> I;
        java.util.List<com.anythink.core.common.f.b> a2;
        com.anythink.core.common.f.q M;
        if (i == 13) {
            com.anythink.core.common.f.q M2 = auVar != null ? auVar.M() : null;
            if (M2 != null) {
                com.anythink.core.b.d.b.a(M2, auVar);
            }
        }
        if (i == 4) {
            com.anythink.core.common.f.q M3 = auVar != null ? auVar.M() : null;
            if (M3 != null) {
                com.anythink.core.b.d.b.a(M3, true, M3.getSortPrice(), true);
            }
            if ((atVar instanceof com.anythink.core.common.f.h) && (a = com.anythink.core.d.f.a(aVar.d).a((ac = (hVar = (com.anythink.core.common.f.h) atVar).ac()))) != null && (I = a.I()) != null && I.size() != 0 && (a2 = com.anythink.core.common.a.a().a(ac)) != null) {
                for (com.anythink.core.common.f.b bVar : a2) {
                    if (bVar != null && bVar.c() == 0) {
                        com.anythink.core.common.f.h h = bVar.h();
                        com.anythink.core.common.f.au unitGroupInfo = bVar.d().getUnitGroupInfo();
                        if (I.contains(java.lang.String.valueOf(unitGroupInfo.d())) && !android.text.TextUtils.equals(hVar.o(), h.o()) && (M = unitGroupInfo.M()) != null) {
                            com.anythink.core.b.d.b.a(M, false, com.anythink.core.common.o.h.a(auVar), hVar.A() == 1);
                        }
                    }
                }
            }
        }
        if (i == 4) {
            if (atVar instanceof com.anythink.core.common.f.h) {
                if (auVar != null) {
                    com.anythink.core.common.f.h hVar2 = (com.anythink.core.common.f.h) atVar;
                    com.anythink.core.c.a.a().a(hVar2, auVar);
                    if (auVar.L() && auVar.aq() > 0.0d) {
                        hVar2.b(auVar.aq());
                    }
                }
                if (((com.anythink.core.common.f.h) atVar).d() == 2) {
                    com.anythink.core.common.w.a().a(atVar.ac());
                }
                com.anythink.core.common.d.a().a(atVar.ac(), atVar.ad(), ((com.anythink.core.common.f.h) atVar).C());
            }
            com.anythink.core.c.b.a().a(atVar, auVar);
        }
        if (i == 6 && (atVar instanceof com.anythink.core.common.f.h)) {
            com.anythink.core.common.d.a().b(atVar.ac(), atVar.ad(), ((com.anythink.core.common.f.h) atVar).C());
        }
        com.anythink.core.d.a b = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
        com.anythink.core.common.f.i iVar = new com.anythink.core.common.f.i();
        iVar.a = i;
        iVar.b = atVar;
        if (j <= 0) {
            j = java.lang.System.currentTimeMillis();
        }
        iVar.c = j;
        com.anythink.core.common.q.a(com.anythink.core.common.b.o.a().f()).a(i, iVar, b);
        if (4 == i && (atVar instanceof com.anythink.core.common.f.h)) {
            com.anythink.core.common.p.a();
            com.anythink.core.common.p.a((com.anythink.core.common.f.h) atVar);
        }
        if (a(i, atVar, b)) {
            return null;
        }
        return iVar;
    }

    public static com.anythink.core.common.n.a a(android.content.Context context) {
        if (g == null) {
            synchronized (com.anythink.core.common.n.a.class) {
                if (g == null) {
                    g = new com.anythink.core.common.n.a(context);
                }
            }
        }
        return g;
    }

    private static void a(int i, com.anythink.core.common.f.au auVar) {
        if (i == 13) {
            com.anythink.core.common.f.q M = auVar != null ? auVar.M() : null;
            if (M != null) {
                com.anythink.core.b.d.b.a(M, auVar);
            }
        }
    }

    private void a(com.anythink.core.common.f.h hVar, com.anythink.core.common.f.au auVar) {
        java.util.List<java.lang.String> I;
        java.util.List<com.anythink.core.common.f.b> a;
        com.anythink.core.common.f.q M;
        java.lang.String ac = hVar.ac();
        com.anythink.core.d.e a2 = com.anythink.core.d.f.a(this.d).a(ac);
        if (a2 == null || (I = a2.I()) == null || I.size() == 0 || (a = com.anythink.core.common.a.a().a(ac)) == null) {
            return;
        }
        for (com.anythink.core.common.f.b bVar : a) {
            if (bVar != null && bVar.c() == 0) {
                com.anythink.core.common.f.h h = bVar.h();
                com.anythink.core.common.f.au unitGroupInfo = bVar.d().getUnitGroupInfo();
                if (I.contains(java.lang.String.valueOf(unitGroupInfo.d())) && !android.text.TextUtils.equals(hVar.o(), h.o()) && (M = unitGroupInfo.M()) != null) {
                    com.anythink.core.b.d.b.a(M, false, com.anythink.core.common.o.h.a(auVar), hVar.A() == 1);
                }
            }
        }
    }

    private static boolean a(int i, com.anythink.core.common.f.at atVar, com.anythink.core.d.a aVar) {
        java.lang.String au = aVar.au();
        if (!android.text.TextUtils.isEmpty(au) && (atVar instanceof com.anythink.core.common.f.h)) {
            try {
                org.json.JSONArray jSONArray = new org.json.JSONArray(au);
                int length = jSONArray.length();
                java.lang.String valueOf = java.lang.String.valueOf(((com.anythink.core.common.f.h) atVar).M());
                for (int i2 = 0; i2 < length; i2++) {
                    if (android.text.TextUtils.equals(valueOf, jSONArray.optString(i2))) {
                        return true;
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        java.util.Map<java.lang.String, java.lang.String> as = aVar.as();
        if (as != null && as.containsKey(java.lang.String.valueOf(i))) {
            java.lang.String str = as.get(java.lang.String.valueOf(i));
            if (!android.text.TextUtils.isEmpty(str) && str.contains(atVar.ae())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0181 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0182 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.anythink.core.common.f.i b(int i, com.anythink.core.common.f.at atVar, com.anythink.core.common.f.au auVar, long j) {
        com.anythink.core.d.a b;
        java.util.List<java.lang.String> I;
        java.util.List<com.anythink.core.common.f.b> a;
        com.anythink.core.common.f.q M;
        if (i == 13) {
            com.anythink.core.common.f.q M2 = auVar != null ? auVar.M() : null;
            if (M2 != null) {
                com.anythink.core.b.d.b.a(M2, auVar);
            }
        }
        if (i == 4) {
            com.anythink.core.common.f.q M3 = auVar != null ? auVar.M() : null;
            if (M3 != null) {
                com.anythink.core.b.d.b.a(M3, true, M3.getSortPrice(), true);
            }
            if (atVar instanceof com.anythink.core.common.f.h) {
                com.anythink.core.common.f.h hVar = (com.anythink.core.common.f.h) atVar;
                java.lang.String ac = hVar.ac();
                com.anythink.core.d.e a2 = com.anythink.core.d.f.a(this.d).a(ac);
                if (a2 != null && (I = a2.I()) != null && I.size() != 0 && (a = com.anythink.core.common.a.a().a(ac)) != null) {
                    for (com.anythink.core.common.f.b bVar : a) {
                        if (bVar != null && bVar.c() == 0) {
                            com.anythink.core.common.f.h h = bVar.h();
                            com.anythink.core.common.f.au unitGroupInfo = bVar.d().getUnitGroupInfo();
                            if (I.contains(java.lang.String.valueOf(unitGroupInfo.d())) && !android.text.TextUtils.equals(hVar.o(), h.o()) && (M = unitGroupInfo.M()) != null) {
                                com.anythink.core.b.d.b.a(M, false, com.anythink.core.common.o.h.a(auVar), hVar.A() == 1);
                            }
                        }
                    }
                }
                if (i == 4) {
                    if (atVar instanceof com.anythink.core.common.f.h) {
                        if (auVar != null) {
                            com.anythink.core.common.f.h hVar2 = (com.anythink.core.common.f.h) atVar;
                            com.anythink.core.c.a.a().a(hVar2, auVar);
                            if (auVar.L() && auVar.aq() > 0.0d) {
                                hVar2.b(auVar.aq());
                            }
                        }
                        if (((com.anythink.core.common.f.h) atVar).d() == 2) {
                            com.anythink.core.common.w.a().a(atVar.ac());
                        }
                        com.anythink.core.common.d.a().a(atVar.ac(), atVar.ad(), ((com.anythink.core.common.f.h) atVar).C());
                    }
                    com.anythink.core.c.b.a().a(atVar, auVar);
                }
                if (i == 6 && (atVar instanceof com.anythink.core.common.f.h)) {
                    com.anythink.core.common.d.a().b(atVar.ac(), atVar.ad(), ((com.anythink.core.common.f.h) atVar).C());
                }
                b = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
                com.anythink.core.common.f.i iVar = new com.anythink.core.common.f.i();
                iVar.a = i;
                iVar.b = atVar;
                iVar.c = j <= 0 ? j : java.lang.System.currentTimeMillis();
                com.anythink.core.common.q.a(com.anythink.core.common.b.o.a().f()).a(i, iVar, b);
                if (4 == i && (atVar instanceof com.anythink.core.common.f.h)) {
                    com.anythink.core.common.p.a();
                    com.anythink.core.common.p.a((com.anythink.core.common.f.h) atVar);
                }
                if (a(i, atVar, b)) {
                    return iVar;
                }
                return null;
            }
        }
        if (i == 4) {
        }
        if (i == 6) {
            com.anythink.core.common.d.a().b(atVar.ac(), atVar.ad(), ((com.anythink.core.common.f.h) atVar).C());
        }
        b = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
        com.anythink.core.common.f.i iVar2 = new com.anythink.core.common.f.i();
        iVar2.a = i;
        iVar2.b = atVar;
        iVar2.c = j <= 0 ? j : java.lang.System.currentTimeMillis();
        com.anythink.core.common.q.a(com.anythink.core.common.b.o.a().f()).a(i, iVar2, b);
        if (4 == i) {
            com.anythink.core.common.p.a();
            com.anythink.core.common.p.a((com.anythink.core.common.f.h) atVar);
        }
        if (a(i, atVar, b)) {
        }
    }

    private void b(int i, com.anythink.core.common.f.at atVar, com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.f.h hVar;
        java.lang.String ac;
        com.anythink.core.d.e a;
        java.util.List<java.lang.String> I;
        java.util.List<com.anythink.core.common.f.b> a2;
        com.anythink.core.common.f.q M;
        if (i == 4) {
            com.anythink.core.common.f.q M2 = auVar != null ? auVar.M() : null;
            if (M2 != null) {
                com.anythink.core.b.d.b.a(M2, true, M2.getSortPrice(), true);
            }
            if (!(atVar instanceof com.anythink.core.common.f.h) || (a = com.anythink.core.d.f.a(this.d).a((ac = (hVar = (com.anythink.core.common.f.h) atVar).ac()))) == null || (I = a.I()) == null || I.size() == 0 || (a2 = com.anythink.core.common.a.a().a(ac)) == null) {
                return;
            }
            for (com.anythink.core.common.f.b bVar : a2) {
                if (bVar != null && bVar.c() == 0) {
                    com.anythink.core.common.f.h h = bVar.h();
                    com.anythink.core.common.f.au unitGroupInfo = bVar.d().getUnitGroupInfo();
                    if (I.contains(java.lang.String.valueOf(unitGroupInfo.d())) && !android.text.TextUtils.equals(hVar.o(), h.o()) && (M = unitGroupInfo.M()) != null) {
                        com.anythink.core.b.d.b.a(M, false, com.anythink.core.common.o.h.a(auVar), hVar.A() == 1);
                    }
                }
            }
        }
    }

    public static /* synthetic */ boolean b(int i, com.anythink.core.common.f.at atVar) {
        java.util.Map<java.lang.String, java.lang.String> a;
        if (atVar instanceof com.anythink.core.common.f.h) {
            com.anythink.core.common.f.h hVar = (com.anythink.core.common.f.h) atVar;
            if (hVar.M() == 67) {
                return true;
            }
            if (hVar.M() != 0 && !android.text.TextUtils.isEmpty(atVar.ae()) && (a = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o()).a(i)) != null) {
                if (a.containsKey("0")) {
                    java.lang.String str = a.get("0");
                    return !android.text.TextUtils.isEmpty(str) && str.contains(atVar.ae());
                }
                com.anythink.core.common.f.h hVar2 = (com.anythink.core.common.f.h) atVar;
                if (a.containsKey(java.lang.String.valueOf(hVar2.M()))) {
                    java.lang.String str2 = a.get(java.lang.String.valueOf(hVar2.M()));
                    if (!android.text.TextUtils.isEmpty(str2) && str2.contains(atVar.ae())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void c(int i, com.anythink.core.common.f.at atVar, com.anythink.core.common.f.au auVar) {
        if (i == 4) {
            if (atVar instanceof com.anythink.core.common.f.h) {
                if (auVar != null) {
                    com.anythink.core.common.f.h hVar = (com.anythink.core.common.f.h) atVar;
                    com.anythink.core.c.a.a().a(hVar, auVar);
                    if (auVar.L() && auVar.aq() > 0.0d) {
                        hVar.b(auVar.aq());
                    }
                }
                if (((com.anythink.core.common.f.h) atVar).d() == 2) {
                    com.anythink.core.common.w.a().a(atVar.ac());
                }
                com.anythink.core.common.d.a().a(atVar.ac(), atVar.ad(), ((com.anythink.core.common.f.h) atVar).C());
            }
            com.anythink.core.c.b.a().a(atVar, auVar);
        }
    }

    private static boolean c(int i, com.anythink.core.common.f.at atVar) {
        java.util.Map<java.lang.String, java.lang.String> a;
        if (!(atVar instanceof com.anythink.core.common.f.h)) {
            return false;
        }
        com.anythink.core.common.f.h hVar = (com.anythink.core.common.f.h) atVar;
        if (hVar.M() == 67) {
            return true;
        }
        if (hVar.M() != 0 && !android.text.TextUtils.isEmpty(atVar.ae()) && (a = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o()).a(i)) != null) {
            if (a.containsKey("0")) {
                java.lang.String str = a.get("0");
                return !android.text.TextUtils.isEmpty(str) && str.contains(atVar.ae());
            }
            com.anythink.core.common.f.h hVar2 = (com.anythink.core.common.f.h) atVar;
            if (a.containsKey(java.lang.String.valueOf(hVar2.M()))) {
                java.lang.String str2 = a.get(java.lang.String.valueOf(hVar2.M()));
                if (!android.text.TextUtils.isEmpty(str2) && str2.contains(atVar.ae())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void d(int i, com.anythink.core.common.f.at atVar) {
        if (4 == i && (atVar instanceof com.anythink.core.common.f.h)) {
            com.anythink.core.common.p.a();
            com.anythink.core.common.p.a((com.anythink.core.common.f.h) atVar);
        }
    }

    private static void e(int i, com.anythink.core.common.f.at atVar) {
        if (atVar instanceof com.anythink.core.common.f.h) {
            if (i == 4) {
                ((com.anythink.core.common.f.h) atVar).h();
                return;
            }
            if (i == 6) {
                ((com.anythink.core.common.f.h) atVar).i();
            } else if (i == 10) {
                com.anythink.core.common.e.a(atVar.T(), com.anythink.core.common.e.c, (com.anythink.core.common.f.h) atVar);
            } else {
                if (i != 21) {
                    return;
                }
                com.anythink.core.common.b.o.a().M();
            }
        }
    }

    public final void a(int i, com.anythink.core.common.f.at atVar) {
        a(i, atVar, null, -1L);
    }

    public final void a(int i, com.anythink.core.common.f.at atVar, com.anythink.core.common.f.au auVar) {
        a(i, atVar, auVar, -1L);
    }

    public final void a(int i, com.anythink.core.common.f.at atVar, com.anythink.core.common.f.au auVar, long j) {
        if (atVar == null) {
            return;
        }
        synchronized (atVar) {
            e(i, atVar);
        }
        this.e.post(new com.anythink.core.common.n.a.AnonymousClass1(atVar, i, auVar, j));
    }

    @Override // com.anythink.core.common.m
    public final void a(java.util.List<com.anythink.core.common.f.i> list) {
        com.anythink.core.d.a b = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
        if (b == null) {
            new com.anythink.core.common.h.o(this.d, 0, list).a(0, (com.anythink.core.common.h.k) null);
            return;
        }
        int C = b.C();
        if (C == 1) {
            com.anythink.core.common.h.a.e eVar = new com.anythink.core.common.h.a.e(list);
            eVar.a(1, b.B());
            eVar.a((com.anythink.core.common.h.a.c.a) null);
        } else {
            if (C != 2) {
                new com.anythink.core.common.h.o(this.d, b.C(), list).a(0, (com.anythink.core.common.h.k) null);
                return;
            }
            new com.anythink.core.common.h.o(this.d, b.C(), list).a(0, (com.anythink.core.common.h.k) null);
            com.anythink.core.common.h.a.e eVar2 = new com.anythink.core.common.h.a.e(list);
            eVar2.a(2, b.B());
            eVar2.a((com.anythink.core.common.h.a.c.a) null);
        }
    }
}
