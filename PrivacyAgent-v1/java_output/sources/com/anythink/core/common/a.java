package com.anythink.core.common;

/* loaded from: classes12.dex */
public class a {
    private static volatile com.anythink.core.common.a a;
    private final java.lang.String b = getClass().getSimpleName();
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.List<com.anythink.core.common.f.b>> c = new java.util.concurrent.ConcurrentHashMap<>(2);
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.f.av> d = new java.util.concurrent.ConcurrentHashMap<>(2);

    /* renamed from: com.anythink.core.common.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ com.anythink.core.common.f.h b;
        final /* synthetic */ com.anythink.core.common.f.b c;
        final /* synthetic */ com.anythink.core.api.ATBaseAdAdapter d;

        public AnonymousClass1(android.content.Context context, com.anythink.core.common.f.h hVar, com.anythink.core.common.f.b bVar, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
            this.a = context;
            this.b = hVar;
            this.c = bVar;
            this.d = aTBaseAdAdapter;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.a.a.a(this.a).a(this.b.ae(), this.b.ac(), this.b.C());
            com.anythink.core.a.c.a();
            com.anythink.core.a.c.a(this.b.ac());
            com.anythink.core.a.c.a().a(this.b.ac(), this.b.C());
            com.anythink.core.common.a.this.a(this.c);
            com.anythink.core.common.a.this.b(this.c);
            com.anythink.core.api.MediationBidManager b = com.anythink.core.b.f.a().b();
            if (b != null) {
                b.notifyWinnerDisplay(this.b.ac(), this.d.getUnitGroupInfo());
            }
        }
    }

    private a() {
    }

    public static com.anythink.core.common.a a() {
        if (a == null) {
            synchronized (com.anythink.core.common.a.class) {
                if (a == null) {
                    a = new com.anythink.core.common.a();
                }
            }
        }
        return a;
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2) {
        return str + str2;
    }

    private static void a(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, java.lang.String str, java.lang.String str2, com.anythink.core.d.e eVar, com.anythink.core.common.f.au auVar, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.util.Map<java.lang.String, java.lang.Object> b = com.anythink.core.common.u.a().b(str2);
        int[] iArr = {0};
        if (b.containsKey(com.anythink.core.common.f.at.N)) {
            try {
                iArr[0] = ((java.lang.Integer) b.get(com.anythink.core.common.f.at.N)).intValue();
            } catch (java.lang.Throwable unused) {
            }
        }
        com.anythink.core.common.f.h a2 = com.anythink.core.common.o.u.a(str, str2, eVar, 0, iArr[0], map, null);
        com.anythink.core.common.o.u.a(a2, auVar, 0, true);
        com.anythink.core.common.o.u.a(aTBaseAdAdapter, a2, auVar);
        a2.q = 3;
        a2.g(aTBaseAdAdapter.getInternalNetworkPlacementId());
        aTBaseAdAdapter.setRefresh(false);
    }

    private void a(java.lang.String str, java.util.List<com.anythink.core.common.f.b> list) {
        synchronized (com.anythink.core.common.u.a().a(str)) {
            java.util.List<com.anythink.core.common.f.b> list2 = this.c.get(str);
            if (list2 == null) {
                list2 = new java.util.ArrayList<>();
                this.c.put(str, list2);
            }
            if (list2.size() != 0) {
                int i = 0;
                com.anythink.core.common.f.au unitGroupInfo = list.get(0).d().getUnitGroupInfo();
                double a2 = com.anythink.core.common.o.h.a(unitGroupInfo);
                while (true) {
                    if (i >= list2.size()) {
                        break;
                    }
                    com.anythink.core.common.f.au unitGroupInfo2 = list2.get(i).d().getUnitGroupInfo();
                    double a3 = com.anythink.core.common.o.h.a(unitGroupInfo2);
                    if (a2 <= a3) {
                        if (a2 == a3 && unitGroupInfo.ak() < unitGroupInfo2.ak()) {
                            list2.addAll(i, list);
                            break;
                        } else {
                            if (i == list2.size() - 1) {
                                list2.addAll(list);
                                break;
                            }
                            i++;
                        }
                    } else {
                        list2.addAll(i, list);
                        break;
                    }
                }
            } else {
                list2.addAll(list);
            }
        }
    }

    private static void a(org.json.JSONArray jSONArray, int i, java.lang.String str, int i2, java.lang.String str2, boolean z, int i3) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("priority", i);
            jSONObject.put("unit_id", str);
            jSONObject.put("nw_firm_id", i2);
            jSONObject.put("nw_ver", str2);
            jSONObject.put("result", z ? 1 : 0);
            if (i3 != -1) {
                jSONObject.put("reason", i3);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        jSONArray.put(jSONObject);
    }

    private static void b(java.lang.String str, com.anythink.core.common.f.au auVar) {
        if (auVar == null) {
            return;
        }
        auVar.u();
        auVar.m();
        auVar.d();
        int m = auVar.m();
        if (m != 3) {
            if (m == 4) {
                com.anythink.core.basead.b.a();
                android.content.Context f = com.anythink.core.common.b.o.a().f();
                com.anythink.core.basead.b.a();
                com.anythink.core.basead.b.b(f, com.anythink.core.basead.b.a(str, auVar.u(), auVar.d()));
                return;
            }
            if (m != 7) {
                return;
            }
        }
        com.anythink.core.common.f.q M = auVar.M();
        com.anythink.core.common.a.b.a().a(str, auVar.u());
        if (M == null || android.text.TextUtils.isEmpty(M.token)) {
            return;
        }
        com.anythink.core.common.a.a.a().b(com.anythink.core.common.b.o.a().f(), M.token);
    }

    public final com.anythink.core.common.f.av a(java.lang.String str, com.anythink.core.common.f.au auVar) {
        return this.d.get(a(str, auVar.u()));
    }

    public final com.anythink.core.common.f.b a(android.content.Context context, java.lang.String str) {
        synchronized (com.anythink.core.common.u.a().a(str)) {
            java.util.List<com.anythink.core.common.f.b> a2 = a(context, str, false, false, false, (java.util.Map<java.lang.String, java.lang.Object>) null, (com.anythink.core.common.f.c) null);
            if (a2 == null || a2.size() <= 0) {
                return null;
            }
            return a2.get(0);
        }
    }

    public final com.anythink.core.common.f.b a(android.content.Context context, java.lang.String str, boolean z, boolean z2, java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.common.f.c cVar) {
        synchronized (com.anythink.core.common.u.a().a(str)) {
            java.util.List<com.anythink.core.common.f.b> a2 = a(context, str, z, z2, false, map, cVar);
            if (a2 == null || a2.size() <= 0) {
                return null;
            }
            return a2.get(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x043d A[Catch: all -> 0x044f, TryCatch #6 {, blocks: (B:4:0x0013, B:6:0x0027, B:9:0x0029, B:11:0x0046, B:12:0x004a, B:14:0x0050, B:78:0x0059, B:17:0x005d, B:20:0x007b, B:74:0x0081, B:23:0x0098, B:26:0x00a9, B:70:0x00b3, B:29:0x00ca, B:33:0x00e0, B:34:0x0114, B:42:0x013d, B:44:0x0159, B:46:0x0164, B:48:0x016a, B:49:0x0174, B:51:0x0190, B:53:0x015d, B:36:0x0192, B:57:0x019e, B:58:0x01c8, B:60:0x01d1, B:61:0x01d4, B:63:0x01dc, B:66:0x01ec, B:83:0x01fb, B:86:0x01ff, B:88:0x0204, B:89:0x0229, B:91:0x022b, B:94:0x023f, B:96:0x025d, B:98:0x0263, B:101:0x026d, B:104:0x0275, B:106:0x0286, B:107:0x028a, B:109:0x0290, B:112:0x029c, B:117:0x02ac, B:152:0x03eb, B:154:0x03f3, B:158:0x0421, B:162:0x043d, B:163:0x044d, B:169:0x03d5, B:212:0x0234), top: B:3:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.util.List<com.anythink.core.common.f.b> a(android.content.Context context, java.lang.String str, boolean z, boolean z2, boolean z3, java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.common.f.c cVar) {
        java.lang.String str2;
        java.lang.String str3;
        com.anythink.core.d.e eVar;
        com.anythink.core.common.f.au auVar;
        java.util.Map<java.lang.String, java.lang.Object> b;
        com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter;
        boolean internalIsAdReady;
        com.anythink.core.api.BaseAd baseAd;
        java.util.ArrayList arrayList;
        java.util.ArrayList arrayList2;
        java.util.ArrayList arrayList3;
        int i;
        com.anythink.core.common.f.b bVar;
        com.anythink.core.common.f.h hVar;
        int i2;
        com.anythink.core.common.f.b bVar2;
        int i3;
        java.lang.Object a2 = com.anythink.core.common.u.a().a(str);
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        synchronized (a2) {
            com.anythink.core.d.e a3 = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).a(str);
            if (a3 == null) {
                return null;
            }
            com.anythink.core.common.f.b a4 = com.anythink.core.common.a.b.a().a(str);
            java.util.ArrayList arrayList4 = new java.util.ArrayList();
            java.util.List<com.anythink.core.common.f.b> list = this.c.get(str);
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            if (list != null) {
                java.util.Iterator<com.anythink.core.common.f.b> it = list.iterator();
                while (it.hasNext()) {
                    com.anythink.core.common.f.b next = it.next();
                    if (next == null) {
                        it.remove();
                    } else {
                        com.anythink.core.common.f.au unitGroupInfo = next.d().getUnitGroupInfo();
                        int al = unitGroupInfo.al();
                        com.anythink.core.common.f.au a5 = a3.a(unitGroupInfo.u());
                        if (com.anythink.core.a.c.a().a(str, a5 != null ? a5 : unitGroupInfo)) {
                            a(jSONArray, al, unitGroupInfo.u(), unitGroupInfo.d(), "", false, 3);
                        } else {
                            com.anythink.core.a.a a6 = com.anythink.core.a.a.a(com.anythink.core.common.b.o.a().f());
                            if (a5 == null) {
                                a5 = unitGroupInfo;
                            }
                            if (a6.a(str, a5, a3.ag())) {
                                a(jSONArray, al, unitGroupInfo.u(), unitGroupInfo.d(), "", false, 2);
                            } else {
                                long elapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
                                boolean f = next.f();
                                boolean i4 = next.i();
                                com.anythink.core.common.f.h h = next.h();
                                if (f && i4) {
                                    if (z) {
                                        hVar = h;
                                        i2 = al;
                                        bVar2 = next;
                                        i3 = 0;
                                        com.anythink.core.common.n.c.a(com.anythink.core.common.i.c.b, h.ad(), str, h.C(), h.M(), a3.ag(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime2);
                                    } else {
                                        hVar = h;
                                        i2 = al;
                                        bVar2 = next;
                                        i3 = 0;
                                    }
                                    a(jSONArray, i2, unitGroupInfo.u(), unitGroupInfo.d(), bVar2.d().getInternalNetworkSDKVersion(), true, -1);
                                    hVar.q(jSONArray.toString());
                                    hVar.t(i2);
                                    if (!z3) {
                                        if (a4 == null || com.anythink.core.common.o.h.a(a4.d().getUnitGroupInfo()) <= com.anythink.core.common.o.h.a(bVar2.d().getUnitGroupInfo())) {
                                            arrayList4.add(bVar2);
                                        } else {
                                            arrayList4.add(a4);
                                        }
                                        if (z) {
                                            com.anythink.core.common.n.c.a(hVar.ad(), str, true, -1, a3, arrayList4.size() > 0 ? (com.anythink.core.common.f.b) arrayList4.get(i3) : null, jSONArray.toString(), "", map, cVar, android.os.SystemClock.elapsedRealtime() - elapsedRealtime);
                                        }
                                        return arrayList4;
                                    }
                                    arrayList4.add(bVar2);
                                } else {
                                    if (z) {
                                        i = al;
                                        bVar = next;
                                        com.anythink.core.common.n.c.a(com.anythink.core.common.i.c.c, h.ad(), str, h.C(), h.M(), a3.ag(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime2);
                                    } else {
                                        i = al;
                                        bVar = next;
                                    }
                                    int c = bVar.c();
                                    bVar.g();
                                    if (c <= 0) {
                                        com.anythink.core.b.d.b.a(bVar);
                                    }
                                    it.remove();
                                    a(bVar);
                                    if (c == 0) {
                                        a(jSONArray, i, unitGroupInfo.u(), unitGroupInfo.d(), "", false, !f ? 0 : 1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (z3) {
                return arrayList4;
            }
            if (a4 != null) {
                arrayList4.add(a4);
                if (z) {
                    com.anythink.core.common.n.c.a(a4.d().getTrackingInfo().ad(), str, true, -1, a3, a4, jSONArray.toString(), "", map, cVar, android.os.SystemClock.elapsedRealtime() - elapsedRealtime);
                }
                return arrayList4;
            }
            boolean z4 = a3.aa() == 1 ? true : a3.aa() == 2 ? z2 : false;
            java.util.List<com.anythink.core.common.f.au> l = a3.l();
            com.anythink.core.common.u a7 = com.anythink.core.common.u.a();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(a3.ag());
            com.anythink.core.common.f a8 = a7.a(str, sb.toString());
            java.lang.String g = (a8 == null || a8.g() == null) ? "" : a8.g();
            if (l != null && l.size() > 0 && z4) {
                int i5 = 0;
                java.lang.String b2 = com.anythink.core.common.r.a().b(context, str);
                if (!android.text.TextUtils.isEmpty(b2)) {
                    for (com.anythink.core.common.f.au auVar2 : l) {
                        if (auVar2.h() != null && auVar2.h().contains(b2)) {
                            auVar = auVar2;
                            break;
                        }
                    }
                }
                auVar = null;
                if (auVar != null) {
                    java.util.Map<java.lang.String, java.lang.Object> a9 = a3.a(str, g, auVar);
                    a9.put(com.anythink.core.common.r.b, java.lang.Boolean.TRUE);
                    try {
                        com.anythink.core.api.ATBaseAdAdapter a10 = com.anythink.core.common.o.j.a(auVar);
                        boolean internalInitNetworkObjectByPlacementId = a10.internalInitNetworkObjectByPlacementId(context, a9, com.anythink.core.common.u.a().b(str));
                        if (internalInitNetworkObjectByPlacementId) {
                            try {
                                b = com.anythink.core.common.u.a().b(str);
                            } catch (java.lang.Throwable unused) {
                                str2 = g;
                                str3 = str;
                                eVar = a3;
                                if (z) {
                                }
                                if (z2) {
                                }
                                return null;
                            }
                            try {
                                int[] iArr = new int[1];
                                iArr[0] = 0;
                                if (b.containsKey(com.anythink.core.common.f.at.N)) {
                                    try {
                                        iArr[0] = ((java.lang.Integer) b.get(com.anythink.core.common.f.at.N)).intValue();
                                    } catch (java.lang.Throwable unused2) {
                                    }
                                }
                                com.anythink.core.common.f.h a11 = com.anythink.core.common.o.u.a(g, str, a3, 0, iArr[0], map, null);
                                com.anythink.core.common.o.u.a(a11, auVar, 0, true);
                                aTBaseAdAdapter = a10;
                                com.anythink.core.common.o.u.a(aTBaseAdAdapter, a11, auVar);
                                a11.q = 3;
                                a11.g(aTBaseAdAdapter.getInternalNetworkPlacementId());
                                aTBaseAdAdapter.setRefresh(false);
                            } catch (java.lang.Throwable unused3) {
                                str2 = g;
                                str3 = str;
                                eVar = a3;
                                if (z) {
                                }
                                if (z2) {
                                }
                                return null;
                            }
                        } else {
                            aTBaseAdAdapter = a10;
                        }
                        if (android.text.TextUtils.equals(java.lang.String.valueOf(a3.ag()), "0")) {
                            if (internalInitNetworkObjectByPlacementId) {
                                baseAd = aTBaseAdAdapter.getBaseAdObject(context);
                                if (baseAd != null) {
                                    internalIsAdReady = true;
                                }
                            } else {
                                baseAd = null;
                            }
                            internalIsAdReady = false;
                        } else {
                            internalIsAdReady = internalInitNetworkObjectByPlacementId ? aTBaseAdAdapter.internalIsAdReady() : false;
                            baseAd = null;
                        }
                        if (internalIsAdReady) {
                            if (baseAd != null) {
                                java.util.ArrayList arrayList5 = new java.util.ArrayList();
                                baseAd.setTrackingInfo(aTBaseAdAdapter.getTrackingInfo().S());
                                arrayList5.add(baseAd);
                                arrayList = arrayList5;
                            } else {
                                arrayList = null;
                            }
                            com.anythink.core.common.f.au auVar3 = auVar;
                            str2 = g;
                            int i6 = 1;
                            java.util.ArrayList arrayList6 = arrayList4;
                            java.util.ArrayList arrayList7 = arrayList;
                            str3 = str;
                            eVar = a3;
                            try {
                                java.util.List<com.anythink.core.common.f.b> a12 = a(str, aTBaseAdAdapter, arrayList7, auVar.q());
                                if (a12.size() > 0) {
                                    for (com.anythink.core.common.f.b bVar3 : a12) {
                                        com.anythink.core.common.f.h h2 = bVar3.h();
                                        h2.y = i6;
                                        h2.t(i5);
                                        h2.q(jSONArray.toString());
                                        if (z) {
                                            arrayList3 = arrayList6;
                                            try {
                                                com.anythink.core.common.n.c.a(h2.ad(), str, true, -1, eVar, bVar3, jSONArray.toString(), auVar3.h(), map, cVar);
                                            } catch (java.lang.Throwable unused4) {
                                                if (z) {
                                                }
                                                if (z2) {
                                                }
                                                return null;
                                            }
                                        } else {
                                            arrayList3 = arrayList6;
                                        }
                                        arrayList6 = arrayList3;
                                        i6 = 1;
                                        i5 = 0;
                                    }
                                    arrayList2 = arrayList6;
                                    arrayList2.add(a12.get(0));
                                } else {
                                    arrayList2 = arrayList6;
                                }
                                return arrayList2;
                            } catch (java.lang.Throwable unused5) {
                                if (z) {
                                }
                                if (z2) {
                                }
                                return null;
                            }
                        }
                    } catch (java.lang.Throwable unused6) {
                        str2 = g;
                        str3 = str;
                        eVar = a3;
                    }
                }
            }
            str2 = g;
            str3 = str;
            eVar = a3;
            if (z) {
                boolean f2 = a8 != null ? a8.f() : false;
                if (a8 == null) {
                    com.anythink.core.common.n.c.a("AdManage is null--isReady", "Id:" + str3 + "--format:" + eVar.ag(), com.anythink.core.common.b.o.a().q());
                }
                com.anythink.core.common.n.c.a(str2, str, false, f2 ? 5 : 1, eVar, null, jSONArray.toString(), "", map, cVar, android.os.SystemClock.elapsedRealtime() - elapsedRealtime);
            }
            if (z2) {
                com.anythink.core.common.n.c.a(str2, str, eVar, 1, jSONArray.toString(), map);
            }
            return null;
        }
    }

    public final java.util.List<com.anythink.core.common.f.b> a(java.lang.String str) {
        java.util.List<com.anythink.core.common.f.b> list = this.c.get(str);
        if (list == null || list.size() <= 0) {
            return null;
        }
        java.lang.Object a2 = com.anythink.core.common.u.a().a(str);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (a2) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public final java.util.List<com.anythink.core.common.f.b> a(java.lang.String str, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, java.util.List<? extends com.anythink.core.api.BaseAd> list, long j) {
        com.anythink.core.common.f.au unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
        com.anythink.core.common.f.h trackingInfo = aTBaseAdAdapter.getTrackingInfo();
        java.lang.String a2 = a(str, aTBaseAdAdapter.getUnitGroupInfo().u());
        com.anythink.core.common.f.av avVar = this.d.get(a2);
        if (avVar == null) {
            avVar = new com.anythink.core.common.f.av(str, unitGroupInfo.u());
            this.d.put(a2, avVar);
        }
        avVar.a(unitGroupInfo.am());
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list == null || list.size() <= 0) {
            com.anythink.core.common.f.b bVar = new com.anythink.core.common.f.b();
            bVar.a(aTBaseAdAdapter);
            bVar.c(java.lang.System.currentTimeMillis());
            bVar.b(j);
            bVar.a(unitGroupInfo.B());
            arrayList.add(bVar);
            avVar.a(trackingInfo.ad(), new com.anythink.core.common.f.aq(trackingInfo.ad(), arrayList));
        } else {
            for (com.anythink.core.api.BaseAd baseAd : list) {
                baseAd.setTrackingInfo(aTBaseAdAdapter.getTrackingInfo().S());
                com.anythink.core.common.f.b bVar2 = new com.anythink.core.common.f.b();
                bVar2.a(aTBaseAdAdapter);
                bVar2.a(baseAd);
                bVar2.c(java.lang.System.currentTimeMillis());
                bVar2.b(j);
                bVar2.a(unitGroupInfo.B());
                arrayList.add(bVar2);
            }
            avVar.a(trackingInfo.ad(), new com.anythink.core.common.f.aq(trackingInfo.ad(), arrayList));
        }
        if (arrayList.size() == 0) {
            return arrayList;
        }
        a(str, arrayList);
        return arrayList;
    }

    public final void a(android.content.Context context, com.anythink.core.common.f.b bVar) {
        com.anythink.core.api.ATBaseAdAdapter d = bVar.d();
        com.anythink.core.common.f.h h = bVar.h();
        com.anythink.core.common.f.au unitGroupInfo = d != null ? d.getUnitGroupInfo() : null;
        if (h != null) {
            com.anythink.core.common.f a2 = com.anythink.core.common.u.a().a(h.ac(), h.ae());
            if (a2 != null) {
                a2.a(h.ad(), unitGroupInfo != null ? com.anythink.core.common.o.h.a(unitGroupInfo) : 0.0d, unitGroupInfo);
            } else {
                com.anythink.core.common.n.c.a("AdManage is null--Show", "Id:" + h.ac() + "--format:" + h.ae() + "--adsource:" + h.C(), com.anythink.core.common.b.o.a().q());
            }
            com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.a.AnonymousClass1(context, h, bVar, d), 2, true);
        }
    }

    public final void a(com.anythink.core.common.f.b bVar) {
        if (bVar == null) {
            return;
        }
        com.anythink.core.common.f.h h = bVar.h();
        b(h.ac(), bVar.d().getUnitGroupInfo());
        com.anythink.core.common.f.av avVar = this.d.get(a(h.ac(), h.C()));
        if (avVar == null) {
            return;
        }
        avVar.a(bVar);
    }

    public final void b(com.anythink.core.common.f.b bVar) {
        if (bVar == null) {
            return;
        }
        java.lang.String ac = bVar.h().ac();
        synchronized (com.anythink.core.common.u.a().a(ac)) {
            java.util.List<com.anythink.core.common.f.b> list = this.c.get(ac);
            if (list != null) {
                list.remove(bVar);
            }
        }
    }

    public final void b(java.lang.String str) {
        synchronized (com.anythink.core.common.u.a().a(str)) {
            java.util.List<com.anythink.core.common.f.b> list = this.c.get(str);
            if (list != null) {
                java.util.Collections.sort(list);
            }
        }
    }
}
