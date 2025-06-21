package com.anythink.core.b;

/* loaded from: classes12.dex */
public class a extends com.anythink.core.b.d {
    public static final java.lang.String a = "a";
    private java.util.List<com.anythink.core.common.f.au> b;
    private com.anythink.core.b.b.a c;
    private long d;

    /* renamed from: com.anythink.core.b.a$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.core.b.b.b {
        final /* synthetic */ com.anythink.core.common.f.au a;

        /* renamed from: com.anythink.core.b.a$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01581 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.core.api.ATBiddingResult a;
            final /* synthetic */ com.anythink.core.b.c.a b;

            public RunnableC01581(com.anythink.core.api.ATBiddingResult aTBiddingResult, com.anythink.core.b.c.a aVar) {
                this.a = aTBiddingResult;
                this.b = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.b.a.this.a(this.a.isSuccessWithUseType(), this.a, com.anythink.core.b.a.AnonymousClass1.this.a, com.anythink.core.b.a.a(this.a), this.b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.f.au auVar) {
            super(aTBaseAdAdapter);
            this.a = auVar;
        }

        private void a(com.anythink.core.api.ATBiddingResult aTBiddingResult, com.anythink.core.b.c.a aVar) {
            com.anythink.core.common.o.b.b.a().a(new com.anythink.core.b.a.AnonymousClass1.RunnableC01581(aTBiddingResult, aVar));
        }

        @Override // com.anythink.core.api.ATBiddingListener
        public final void onC2SBidResult(com.anythink.core.api.ATBiddingResult aTBiddingResult) {
            com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = this.c;
            if (aTBaseAdAdapter != null) {
                aTBaseAdAdapter.releaseLoadResource();
            }
            a(aTBiddingResult, null);
        }

        @Override // com.anythink.core.api.ATBiddingListener
        public final void onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult aTBiddingResult, com.anythink.core.api.BaseAd baseAd) {
            com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = this.c;
            if (aTBaseAdAdapter != null) {
                aTBaseAdAdapter.releaseLoadResource();
            }
            a(aTBiddingResult, new com.anythink.core.b.c.a(this.c, baseAd));
        }
    }

    public a(com.anythink.core.common.f.a aVar) {
        super(aVar);
        this.b = java.util.Collections.synchronizedList(new java.util.ArrayList(this.f.j));
    }

    public static /* synthetic */ int a(com.anythink.core.api.ATBiddingResult aTBiddingResult) {
        if (aTBiddingResult.isSuccessWithUseType()) {
            return 0;
        }
        return android.text.TextUtils.equals(aTBiddingResult.errorMsg, com.anythink.core.api.ATBidRequestInfo.BID_TYPE_ERROR_TYPE) ? -10 : -1;
    }

    private static com.anythink.core.api.ATBiddingResult a(java.lang.String str) {
        return com.anythink.core.api.ATBiddingResult.fail(str);
    }

    private com.anythink.core.common.f.q a(com.anythink.core.common.f.au auVar, com.anythink.core.common.f.o oVar, long j, com.anythink.core.b.c.a aVar) {
        auVar.a(j);
        auVar.a(oVar.currency);
        double a2 = a(oVar.getSortPrice(), auVar);
        boolean isSamePrice = oVar.isSamePrice();
        double a3 = isSamePrice ? a2 : a(oVar.getPrice(), auVar);
        if (a2 <= 0.0d) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("NetworkName:");
            sb.append(auVar.e());
            sb.append(",AdSourceId:");
            sb.append(auVar.u());
            sb.append(" c2s sort price return 0,please check network placement c2s config");
            a2 = com.anythink.core.common.o.h.a(auVar);
        }
        double d = a2;
        if (a3 <= 0.0d) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("NetworkName:");
            sb2.append(auVar.e());
            sb2.append(",AdSourceId:");
            sb2.append(auVar.u());
            sb2.append(" c2s real price return 0,please check network placement c2s config");
            a3 = com.anythink.core.common.o.h.a(auVar);
        }
        com.anythink.core.common.f.q qVar = new com.anythink.core.common.f.q(oVar.isSuccessWithUseType(), d, a3, oVar.token, oVar.winNoticeUrl, oVar.loseNoticeUrl, oVar.displayNoticeUrl, "");
        qVar.l = a(auVar);
        qVar.setBiddingNotice(oVar.biddingNotice);
        qVar.f = auVar.o() + java.lang.System.currentTimeMillis();
        qVar.e = auVar.o();
        qVar.k = auVar.u();
        qVar.d = auVar.d();
        qVar.r = aVar;
        qVar.f175s = aVar != null;
        a(auVar.d(), qVar, 0.0d, isSamePrice);
        return qVar;
    }

    private synchronized void a(com.anythink.core.api.ATBiddingResult aTBiddingResult, com.anythink.core.common.f.au auVar) {
        a(false, aTBiddingResult, auVar, -1, (com.anythink.core.b.c.a) null);
    }

    private void a(com.anythink.core.common.f.au auVar, com.anythink.core.common.f.o oVar, long j, int i, com.anythink.core.b.c.a aVar) {
        a(auVar, oVar, j, i, aVar, false);
    }

    private void a(com.anythink.core.common.f.q qVar, com.anythink.core.common.f.au auVar, double d) {
        com.anythink.core.b.d.b.a(qVar, new com.anythink.core.common.f.y(2, auVar, this.f.f167s, d), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        if (r1.get(r2 + "_c2sfirstStatus") == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(boolean z, com.anythink.core.api.ATBiddingResult aTBiddingResult, com.anythink.core.common.f.au auVar, int i, com.anythink.core.b.c.a aVar) {
        boolean z2;
        double ad = auVar.ad();
        boolean z3 = false;
        if (z && auVar.aA() && ad > 0.0d) {
            com.anythink.core.api.ATAdConst.CURRENCY currency = aTBiddingResult.currency;
            if (currency != com.anythink.core.api.ATAdConst.CURRENCY.USD) {
                ad = a(ad, currency);
            }
            aTBiddingResult.getPrice();
            z2 = aTBiddingResult.getPrice() < ad;
        } else {
            z2 = false;
        }
        if (z) {
            com.anythink.core.b.f a2 = com.anythink.core.b.f.a();
            java.lang.String u = auVar.u();
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> concurrentHashMap = a2.b;
            if (concurrentHashMap != null) {
            }
            z3 = true;
            com.anythink.core.common.n.c.a(this.f.e, auVar, z3, android.os.SystemClock.elapsedRealtime() - this.d, this.f);
        }
        com.anythink.core.b.f a3 = com.anythink.core.b.f.a();
        java.lang.String u2 = auVar.u();
        if (a3.b == null) {
            a3.b = new java.util.concurrent.ConcurrentHashMap<>();
        }
        a3.b.put(u2 + "_c2sfirstStatus", 1);
        if (this.h.get()) {
            com.anythink.core.common.f.q a4 = a(auVar, aTBiddingResult, android.os.SystemClock.elapsedRealtime() - this.d, aVar);
            com.anythink.core.b.d.b.a(a4, new com.anythink.core.common.f.y(4, auVar, this.f.f167s, a4.getPrice()), true);
            return;
        }
        boolean a5 = a(auVar, aTBiddingResult, android.os.SystemClock.elapsedRealtime() - this.d, i, aVar, z2);
        java.util.List<com.anythink.core.common.f.au> synchronizedList = java.util.Collections.synchronizedList(new java.util.ArrayList(1));
        synchronizedList.add(auVar);
        this.b.remove(auVar);
        if (this.b.size() == 0) {
            this.h.set(true);
        }
        if (this.c != null) {
            if (!a5) {
                a5 = a(auVar, aTBiddingResult.errorMsg, -1);
            }
            if (a5) {
                this.c.a(synchronizedList, (java.util.List<com.anythink.core.common.f.au>) null);
                return;
            }
            this.c.a((java.util.List<com.anythink.core.common.f.au>) null, synchronizedList);
        }
    }

    private boolean a(com.anythink.core.common.f.au auVar, com.anythink.core.common.f.o oVar, long j, int i, com.anythink.core.b.c.a aVar, boolean z) {
        com.anythink.core.common.f.q a2;
        double price;
        boolean isSuccessWithUseType = oVar.isSuccessWithUseType();
        if (isSuccessWithUseType || z) {
            a2 = a(auVar, oVar, j, aVar);
            price = a2.getPrice();
        } else {
            a2 = null;
            price = 0.0d;
        }
        if (!isSuccessWithUseType || z) {
            if (z) {
                com.anythink.core.b.d.a(auVar, com.anythink.core.api.ATBidRequestInfo.LESS_THAN_BID_FLOOR_TYPE, j, -11);
                auVar.a(price);
                auVar.d(price);
                a(a2, auVar, auVar.ad());
            } else {
                com.anythink.core.b.d.a(auVar, oVar.errorMsg, j, i);
            }
            java.lang.String str = com.anythink.core.common.b.h.m.m;
            com.anythink.core.common.f.a aVar2 = this.f;
            com.anythink.core.common.o.o.a(str, aVar2.e, com.anythink.core.common.o.h.d(java.lang.String.valueOf(aVar2.f)), auVar);
            return false;
        }
        auVar.u();
        auVar.d();
        oVar.getPrice();
        oVar.getSortPrice();
        oVar.currency.toString();
        a(auVar, a2);
        java.lang.String str2 = com.anythink.core.common.b.h.m.l;
        com.anythink.core.common.f.a aVar3 = this.f;
        com.anythink.core.common.o.o.a(str2, aVar3.e, com.anythink.core.common.o.h.d(java.lang.String.valueOf(aVar3.f)), auVar);
        return true;
    }

    private static int b(com.anythink.core.api.ATBiddingResult aTBiddingResult) {
        if (aTBiddingResult.isSuccessWithUseType()) {
            return 0;
        }
        return android.text.TextUtils.equals(aTBiddingResult.errorMsg, com.anythink.core.api.ATBidRequestInfo.BID_TYPE_ERROR_TYPE) ? -10 : -1;
    }

    @Override // com.anythink.core.b.d
    public final synchronized void a() {
        if (!this.h.get()) {
            this.h.set(true);
            java.util.ArrayList arrayList = new java.util.ArrayList(3);
            java.util.ArrayList arrayList2 = new java.util.ArrayList(3);
            for (com.anythink.core.common.f.au auVar : this.b) {
                if (a(auVar, "bid timeout", -3)) {
                    arrayList.add(auVar);
                } else {
                    a(auVar, com.anythink.core.api.ATBiddingResult.fail("bid timeout!"), android.os.SystemClock.elapsedRealtime() - this.d, -3, (com.anythink.core.b.c.a) null);
                    arrayList2.add(auVar);
                }
            }
            this.b.clear();
            com.anythink.core.b.b.a aVar = this.c;
            if (aVar != null) {
                aVar.a(arrayList, arrayList2);
            }
            this.c = null;
        }
    }

    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    @Override // com.anythink.core.b.d
    public final void a(com.anythink.core.b.b.a aVar) {
        int i;
        this.c = aVar;
        java.util.List<com.anythink.core.common.f.au> list = this.f.j;
        int size = list.size();
        this.d = android.os.SystemClock.elapsedRealtime();
        ?? r11 = 0;
        int i2 = 0;
        while (i2 < size) {
            com.anythink.core.common.f.au auVar = list.get(i2);
            com.anythink.core.api.ATBaseAdAdapter a2 = com.anythink.core.common.o.j.a(auVar);
            if (a2 == null) {
                a(false, com.anythink.core.api.ATBiddingResult.fail(auVar.i() + "not exist!"), auVar, -9, (com.anythink.core.b.c.a) null);
                i = i2;
            } else {
                try {
                    com.anythink.core.b.a.AnonymousClass1 anonymousClass1 = new com.anythink.core.b.a.AnonymousClass1(a2, auVar);
                    a2.getInternalNetworkName();
                    com.anythink.core.d.e a3 = com.anythink.core.d.f.a(this.f.b).a(this.f.e);
                    com.anythink.core.common.f.a aVar2 = this.f;
                    java.util.Map<java.lang.String, java.lang.Object> a4 = a3.a(aVar2.e, aVar2.d, auVar);
                    try {
                        double ad = auVar.ad();
                        if (ad > 0.0d) {
                            a4.put("bid_floor", java.lang.Double.valueOf(ad * a(auVar)));
                        }
                    } catch (java.lang.Throwable th) {
                        new java.lang.StringBuilder("C2S startBidRequest with exception:").append(th.getMessage());
                    }
                    com.anythink.core.common.f.h S = this.f.f167s.S();
                    com.anythink.core.common.o.u.a(S, auVar, r11, r11);
                    com.anythink.core.common.o.h.a(a4, S);
                    com.anythink.core.common.f.a aVar3 = this.f;
                    if (aVar3.t == 8) {
                        i = i2;
                        try {
                            double d = aVar3.u;
                            a4.put(com.anythink.core.common.b.h.o.j, d < 0.0d ? "0" : java.lang.Double.valueOf(d));
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            th.printStackTrace();
                            a(com.anythink.core.api.ATBiddingResult.fail(th.getMessage()), auVar);
                            i2 = i + 1;
                            r11 = 0;
                        }
                    } else {
                        i = i2;
                    }
                    if (auVar.d() == 22) {
                        com.anythink.core.common.o.b.a(a3, a4, auVar, this.f.x);
                    }
                    com.anythink.core.common.f.v vVar = this.f.c;
                    android.content.Context a5 = vVar != null ? vVar.a() : null;
                    if (a5 == null) {
                        a5 = this.f.b;
                    }
                    boolean internalStartBiddingRequest = a2.internalStartBiddingRequest(a5, a4, this.f.q, anonymousClass1);
                    aVar.a(auVar, a2);
                    if (!internalStartBiddingRequest) {
                        a(com.anythink.core.api.ATBiddingResult.fail("This network don't support head bidding in current AT's version."), auVar);
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    i = i2;
                    th.printStackTrace();
                    a(com.anythink.core.api.ATBiddingResult.fail(th.getMessage()), auVar);
                    i2 = i + 1;
                    r11 = 0;
                }
            }
            i2 = i + 1;
            r11 = 0;
        }
    }

    @Override // com.anythink.core.b.d
    public final void a(com.anythink.core.common.f.au auVar, com.anythink.core.common.f.o oVar, long j) {
        a(auVar, oVar, j, -1, (com.anythink.core.b.c.a) null);
    }
}
