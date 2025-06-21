package com.anythink.core.b;

/* loaded from: classes12.dex */
public final class h extends com.anythink.core.b.d {
    private java.lang.String a;
    private long b;
    private com.anythink.core.b.b.a c;

    /* renamed from: com.anythink.core.b.h$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.api.MediationBidManager.BidListener {
        final /* synthetic */ com.anythink.core.b.b.a a;

        public AnonymousClass1(com.anythink.core.b.b.a aVar) {
            this.a = aVar;
        }

        @Override // com.anythink.core.api.MediationBidManager.BidListener
        public final void onBidFail(java.lang.String str) {
        }

        @Override // com.anythink.core.api.MediationBidManager.BidListener
        public final void onBidStart(com.anythink.core.common.f.au auVar, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
            com.anythink.core.b.b.a aVar = this.a;
            if (aVar != null) {
                aVar.a(auVar, aTBaseAdAdapter);
            }
        }

        @Override // com.anythink.core.api.MediationBidManager.BidListener
        public final void onBidSuccess(java.util.List<com.anythink.core.common.f.au> list) {
            com.anythink.core.b.h.this.a(list, -1);
        }
    }

    public h(com.anythink.core.common.f.a aVar) {
        super(aVar);
        this.a = "IH Bidding";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(java.util.List<com.anythink.core.common.f.au> list, int i) {
        if (this.h.get()) {
            return;
        }
        this.h.set(true);
        java.util.List<com.anythink.core.common.f.au> arrayList = list == null ? new java.util.ArrayList<>() : list;
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime() - this.b;
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.Iterator<com.anythink.core.common.f.au> it = this.f.j.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            com.anythink.core.common.f.au next = it.next();
            java.util.Iterator<com.anythink.core.common.f.au> it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                com.anythink.core.common.f.au next2 = it2.next();
                if (next.u().equals(next2.u())) {
                    next2.a(elapsedRealtime);
                    next2.g(0);
                    com.anythink.core.common.f.q qVar = new com.anythink.core.common.f.q(true, next2.y(), next2.z(), "", "", "", "");
                    qVar.f = next2.o() + java.lang.System.currentTimeMillis();
                    qVar.e = next2.o();
                    a(next2, qVar);
                    z = true;
                    break;
                }
            }
            if (!z) {
                if (com.anythink.core.api.MediationBidManager.NO_BID_TOKEN_ERROR.equals(next.A())) {
                    b(next, "No Bid Info.", 0L, -2);
                } else {
                    b(next, "No Bid Info.", elapsedRealtime, i);
                }
                if (a(next, "No Bid Info.", i)) {
                    arrayList.add(next);
                } else {
                    arrayList2.add(next);
                }
            }
        }
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("IH Bidding Success List", com.anythink.core.b.d.a(arrayList));
                jSONObject.put("IH Bidding Fail List", com.anythink.core.b.d.a(arrayList2));
            } catch (java.lang.Exception unused) {
            }
            com.anythink.core.common.o.o.a(this.a, jSONObject.toString(), false);
        }
        this.h.set(true);
        com.anythink.core.b.b.a aVar = this.c;
        if (aVar != null) {
            aVar.a(arrayList, arrayList2);
        }
    }

    private void b(com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.f.q qVar = new com.anythink.core.common.f.q(true, auVar.y(), auVar.z(), "", "", "", "");
        qVar.f = auVar.o() + java.lang.System.currentTimeMillis();
        qVar.e = auVar.o();
        a(auVar, qVar);
    }

    private static void b(com.anythink.core.common.f.au auVar, java.lang.String str, long j, int i) {
        com.anythink.core.b.d.a(auVar, str, j, i);
    }

    @Override // com.anythink.core.b.d
    public final void a() {
        a((java.util.List<com.anythink.core.common.f.au>) null, -3);
    }

    @Override // com.anythink.core.b.d
    public final void a(com.anythink.core.b.b.a aVar) {
        this.c = aVar;
        this.b = android.os.SystemClock.elapsedRealtime();
        java.util.List<com.anythink.core.common.f.au> list = this.f.j;
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("Start IH Bidding List", com.anythink.core.b.d.a(list));
            } catch (java.lang.Exception unused) {
            }
            com.anythink.core.common.o.o.a(com.anythink.core.common.o.o.a, jSONObject.toString(), false);
        }
        if (com.anythink.core.b.f.a().b() == null) {
            java.util.Iterator<com.anythink.core.common.f.au> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.anythink.core.api.ATBaseAdAdapter a = com.anythink.core.common.o.j.a(it.next());
                if (a != null) {
                    com.anythink.core.api.MediationBidManager bidManager = a.getBidManager();
                    if (bidManager != null) {
                        com.anythink.core.b.f.a().a(bidManager);
                    }
                }
            }
        }
        com.anythink.core.api.MediationBidManager b = com.anythink.core.b.f.a().b();
        if (b == null) {
            a((java.util.List<com.anythink.core.common.f.au>) null, -9);
        } else {
            b.setBidRequestUrl(this.f.o);
            b.startBid(this.f, new com.anythink.core.b.h.AnonymousClass1(aVar));
        }
    }

    @Override // com.anythink.core.b.d
    public final void a(com.anythink.core.common.f.au auVar, com.anythink.core.common.f.o oVar, long j) {
    }
}
