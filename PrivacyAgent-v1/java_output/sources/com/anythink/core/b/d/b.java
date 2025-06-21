package com.anythink.core.b.d;

/* loaded from: classes12.dex */
public class b {
    static final java.lang.String a = "b";
    public static final java.lang.String b = "${AUCTION_PRICE}";
    public static final java.lang.String c = "${AUCTION_LOSS}";
    public static final java.lang.String d = "${AUCTION_SEAT_ID}";
    public static final java.lang.String e = "${AUCTION_BID_TO_WIN}";
    public static final java.lang.String f = "${AUCTION_CURRENCY}";
    public static final int g = 1;
    public static final int h = 2;
    public static final int i = 3;
    public static final int j = 4;

    /* renamed from: com.anythink.core.b.d.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.h a;
        final /* synthetic */ long b;
        final /* synthetic */ int c;
        final /* synthetic */ java.util.List d;
        final /* synthetic */ int e;

        public AnonymousClass1(com.anythink.core.common.f.h hVar, long j, int i, java.util.List list, int i2) {
            this.a = hVar;
            this.b = j;
            this.c = i;
            this.d = list;
            this.e = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.lang.String str = com.anythink.core.b.d.b.b;
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            this.a.e(this.b);
            this.a.f(java.lang.System.currentTimeMillis());
            this.a.q = this.c;
            for (int i = 0; i < this.d.size(); i++) {
                com.anythink.core.common.f.au auVar = (com.anythink.core.common.f.au) this.d.get(i);
                if (auVar.m() != 7 && auVar.k()) {
                    try {
                        int p = auVar.p();
                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                        jSONObject.put("sorttype", p);
                        jSONObject.put("unit_id", auVar.u());
                        jSONObject.put("bidresult", auVar.O());
                        jSONObject.put("bidprice", auVar.L() ? java.lang.String.valueOf(auVar.y()) : "0");
                        jSONObject.put(com.anythink.core.common.j.ao, auVar.L() ? java.lang.String.valueOf(auVar.af()) : "0");
                        jSONObject.put("nw_firm_id", java.lang.String.valueOf(auVar.d()));
                        jSONObject.put("tp_bid_id", auVar.M() != null ? auVar.M().g : null);
                        jSONObject.put("rl_bid_status", auVar.N());
                        jSONObject.put("errormsg", auVar.A());
                        int W = auVar.W();
                        java.lang.String valueOf = java.lang.String.valueOf(this.e);
                        if ("4".equals(valueOf) || "2".equals(valueOf) || "3".equals(valueOf)) {
                            if (W == -1) {
                                try {
                                    W = java.lang.Integer.parseInt(valueOf);
                                } catch (java.lang.Exception unused) {
                                }
                            }
                            jSONObject.put("ad_type", W);
                        }
                        jSONObject.put("ads_list_type", auVar.a());
                        jSONArray.put(jSONObject);
                    } catch (java.lang.Exception unused2) {
                    }
                }
            }
            this.a.y(java.lang.String.valueOf(this.e));
            this.a.r(jSONArray.toString());
            com.anythink.core.common.n.a.a(com.anythink.core.common.b.o.a().f()).a(11, this.a);
        }
    }

    private static double a(com.anythink.core.common.f.q qVar, double d2) {
        double d3 = qVar.l;
        return d3 > 0.0d ? d2 * d3 : d2;
    }

    private static com.anythink.core.common.f.au a(com.anythink.core.common.f.q qVar) {
        if (qVar != null) {
            return qVar.f();
        }
        return null;
    }

    public static void a(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.f.au auVar, com.anythink.core.common.f.h hVar, com.anythink.core.api.BaseAd... baseAdArr) {
        com.anythink.core.common.f.q M;
        com.anythink.core.api.BaseAd baseAd;
        if (aTBaseAdAdapter == null || auVar == null || (M = auVar.M()) == null) {
            return;
        }
        java.util.Map<java.lang.String, java.lang.Object> networkInfoMap = (baseAdArr == null || baseAdArr.length <= 0 || (baseAd = baseAdArr[0]) == null) ? aTBaseAdAdapter.getNetworkInfoMap() : baseAd.getNetworkInfoMap();
        com.anythink.core.common.f.bb bbVar = new com.anythink.core.common.f.bb();
        bbVar.a(hVar.S());
        bbVar.a(networkInfoMap);
        bbVar.a(auVar);
        if (bbVar.b() != 0) {
            auVar.A(bbVar.b());
        }
        M.u = bbVar;
    }

    public static void a(com.anythink.core.common.f.b bVar) {
        a(bVar, false);
    }

    public static void a(com.anythink.core.common.f.b bVar, boolean z) {
        try {
            com.anythink.core.common.f.au unitGroupInfo = bVar.d().getUnitGroupInfo();
            com.anythink.core.common.f.h h2 = bVar.h();
            com.anythink.core.common.f.q M = unitGroupInfo.M();
            if (M != null) {
                a(M, new com.anythink.core.common.f.y(z ? 2 : 1, unitGroupInfo, h2), true);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void a(com.anythink.core.common.f.bb bbVar) {
        com.anythink.core.common.n.c.a(bbVar);
    }

    public static void a(com.anythink.core.common.f.h hVar, java.util.List<com.anythink.core.common.f.au> list, long j2, int i2, int i3) {
        com.anythink.core.common.o.b.b.a().a(new com.anythink.core.b.d.b.AnonymousClass1(hVar, j2, i2, list, i3));
    }

    public static void a(com.anythink.core.common.f.q qVar, com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.f.bb bbVar;
        if (qVar == null || auVar == null || (bbVar = qVar.u) == null || qVar.d()) {
            return;
        }
        double a2 = com.anythink.core.common.o.h.a(auVar);
        double d2 = qVar.q;
        double a3 = com.anythink.core.b.d.a.a(auVar);
        double a4 = com.anythink.core.b.d.a.a(a2, d2, a3);
        bbVar.a(a2);
        bbVar.b(d2);
        bbVar.c(a3);
        bbVar.d(a4);
        double a5 = a(qVar, a2);
        double a6 = a(qVar, a4);
        boolean v = bbVar.v();
        if (auVar.Y()) {
            com.anythink.core.common.a.a.a().a(qVar);
        }
        if (v) {
            java.lang.String a7 = com.anythink.core.b.d.a.a(qVar, a5, a6);
            if (android.text.TextUtils.isEmpty(a7)) {
                com.anythink.core.common.n.c.a(bbVar);
            } else {
                com.anythink.core.common.h.f.a(a7, bbVar).a(0, (com.anythink.core.common.h.k) null);
            }
            com.anythink.core.api.ATBiddingNotice aTBiddingNotice = qVar.biddingNotice;
            if (aTBiddingNotice != null) {
                try {
                    aTBiddingNotice.notifyBidWin(a5, a6, new java.util.HashMap());
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                    new java.lang.StringBuilder("notifyBidWin: error: ").append(th.getMessage());
                }
            }
            com.anythink.core.common.f.q.a a8 = bbVar.a();
            if (a8 != null) {
                a8.a();
            }
        } else {
            com.anythink.core.common.n.c.a(bbVar);
        }
        qVar.g();
    }

    public static void a(com.anythink.core.common.f.q qVar, com.anythink.core.common.f.y yVar, boolean z) {
        boolean z2;
        if (qVar == null) {
            return;
        }
        if (z) {
            com.anythink.core.b.f.a().a(yVar.g(), qVar);
            if (yVar.a()) {
                com.anythink.core.common.a.a.a().b(com.anythink.core.common.b.o.a().f(), qVar.token);
            }
        }
        if (qVar.d()) {
            return;
        }
        double sortPrice = qVar.getSortPrice();
        int i2 = qVar.d;
        com.anythink.core.common.f.au f2 = qVar.f();
        if (f2 != null) {
            sortPrice = com.anythink.core.common.o.h.a(f2);
            i2 = f2.d();
            z2 = f2.k();
        } else {
            z2 = true;
        }
        if (yVar.b() > 0.0d && yVar.b() > sortPrice) {
            sortPrice = yVar.b();
            i2 = qVar.d;
            z2 = true;
        }
        int c2 = yVar.c();
        double sortPrice2 = qVar.getSortPrice();
        int i3 = qVar.d;
        if (sortPrice <= sortPrice2) {
            sortPrice = 0.01d + sortPrice2;
        }
        double d2 = sortPrice;
        double n = yVar.n();
        double a2 = com.anythink.core.b.d.a.a(d2, n);
        java.lang.String b2 = com.anythink.core.b.d.a.b(z2, c2, i3);
        com.anythink.core.common.n.c.a(yVar, d2, b2, n, a2, qVar.originPrice);
        double a3 = a(qVar, a2);
        if (yVar.a()) {
            com.anythink.core.common.a.a.a().a(qVar);
        }
        if (yVar.q() && !b2.equals("-1")) {
            synchronized (qVar) {
                com.anythink.core.api.ATBiddingNotice aTBiddingNotice = qVar.biddingNotice;
                if (aTBiddingNotice != null) {
                    java.util.HashMap hashMap = new java.util.HashMap(3);
                    hashMap.put(com.anythink.core.api.ATBiddingNotice.ADN_ID, java.lang.Integer.valueOf(com.anythink.core.b.d.a.a(z2, i2, i3)));
                    try {
                        aTBiddingNotice.notifyBidLoss(com.anythink.core.b.d.a.a(z2, c2), a3, hashMap);
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                        new java.lang.StringBuilder("notifyBidLoss: error: ").append(th.getMessage());
                    }
                }
            }
            java.lang.String a4 = com.anythink.core.b.d.a.a(qVar, i2, z2, a3, b2);
            if (!android.text.TextUtils.isEmpty(a4)) {
                a(a4);
            }
        }
        qVar.e();
        qVar.g();
    }

    public static void a(com.anythink.core.common.f.q qVar, boolean z, double d2, boolean z2) {
        if (qVar == null) {
            return;
        }
        double d3 = qVar.l;
        java.lang.String str = qVar.j;
        int i2 = qVar.d;
        if (d3 > 0.0d) {
            d2 *= d3;
        }
        if (z) {
            if (android.text.TextUtils.isEmpty(str)) {
                str = qVar.displayNoticeUrl;
            }
            if (!android.text.TextUtils.isEmpty(str)) {
                a(str.replace(b, com.anythink.core.b.d.a.a(qVar, d2)));
            }
        } else {
            java.lang.String str2 = qVar.displayNoticeUrl;
            if (!android.text.TextUtils.isEmpty(str2)) {
                a(str2.replace(b, com.anythink.core.b.d.a.a(qVar, d2)).replace(c, com.anythink.core.b.d.a.b(z2, 2, i2)));
            }
        }
        synchronized (qVar) {
            com.anythink.core.api.ATBiddingNotice aTBiddingNotice = qVar.biddingNotice;
            if (aTBiddingNotice != null) {
                aTBiddingNotice.notifyBidDisplay(z, d2);
                if (z) {
                    qVar.e();
                }
            }
        }
    }

    private static void a(java.lang.String str) {
        com.anythink.core.common.h.f.a(str).a(0, (com.anythink.core.common.h.k) null);
    }

    private static void a(java.lang.String str, com.anythink.core.common.f.bb bbVar) {
        if (bbVar == null) {
            return;
        }
        com.anythink.core.common.h.f.a(str, bbVar).a(0, (com.anythink.core.common.h.k) null);
    }
}
