package com.anythink.core.b;

/* loaded from: classes12.dex */
public class i {
    public static java.lang.String a = "i";
    com.anythink.core.common.f.a b;
    java.util.Map<java.lang.String, java.lang.Object> c;
    com.anythink.core.b.i.a d;

    /* renamed from: com.anythink.core.b.i$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.api.ATBaseAdAdapter a;
        final /* synthetic */ com.anythink.core.common.f.au b;

        public AnonymousClass1(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.f.au auVar) {
            this.a = aTBaseAdAdapter;
            this.b = auVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.b.i.a(com.anythink.core.b.i.this, this.a, this.b);
        }
    }

    /* renamed from: com.anythink.core.b.i$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.api.ATBidRequestInfoListener {
        final /* synthetic */ com.anythink.core.common.f.au a;

        public AnonymousClass2(com.anythink.core.common.f.au auVar) {
            this.a = auVar;
        }

        @Override // com.anythink.core.api.ATBidRequestInfoListener
        public final void onFailed(java.lang.String str) {
            com.anythink.core.b.i.a aVar = com.anythink.core.b.i.this.d;
            if (aVar != null) {
                aVar.a(str, this.a);
            }
        }

        @Override // com.anythink.core.api.ATBidRequestInfoListener
        public final void onSuccess(com.anythink.core.api.ATBidRequestInfo aTBidRequestInfo) {
            com.anythink.core.b.i.a(com.anythink.core.b.i.this, this.a, aTBidRequestInfo);
        }
    }

    /* renamed from: com.anythink.core.b.i$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.api.ATBidRequestInfo a;
        final /* synthetic */ com.anythink.core.common.f.au b;

        public AnonymousClass3(com.anythink.core.api.ATBidRequestInfo aTBidRequestInfo, com.anythink.core.common.f.au auVar) {
            this.a = aTBidRequestInfo;
            this.b = auVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            org.json.JSONObject requestJSONObject;
            try {
                com.anythink.core.api.ATBidRequestInfo aTBidRequestInfo = this.a;
                if (aTBidRequestInfo != null && (requestJSONObject = aTBidRequestInfo.toRequestJSONObject()) != null) {
                    com.anythink.core.api.ATBidRequestInfo.fillBaseCommonParams(requestJSONObject, java.lang.String.valueOf(com.anythink.core.b.i.this.b.f), com.anythink.core.b.i.this.b.n.a(), this.b);
                    if (this.b.m() == 3) {
                        try {
                            requestJSONObject.put("unit_id", this.b.u());
                            requestJSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.EXCLUDE_OFFER, com.anythink.core.common.b.o.a().k());
                        } catch (java.lang.Throwable th) {
                            th.printStackTrace();
                        }
                        if (com.anythink.core.b.i.this.b.z == 1) {
                            requestJSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GET_OFFER, 2);
                        }
                    }
                    com.anythink.core.b.i.a aVar = com.anythink.core.b.i.this.d;
                    if (aVar != null) {
                        aVar.a(this.b, requestJSONObject);
                        return;
                    }
                    return;
                }
                com.anythink.core.b.i.a aVar2 = com.anythink.core.b.i.this.d;
                if (aVar2 != null) {
                    aVar2.a(com.anythink.core.api.ATBidRequestInfo.RETURN_PARAMS_ERROR_TYPE, this.b);
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
                com.anythink.core.b.i.a aVar3 = com.anythink.core.b.i.this.d;
                if (aVar3 != null) {
                    aVar3.a(th2.getMessage(), this.b);
                }
            }
        }
    }

    public interface a {
        void a(com.anythink.core.common.f.au auVar, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter);

        void a(com.anythink.core.common.f.au auVar, org.json.JSONObject jSONObject);

        void a(java.lang.String str, com.anythink.core.common.f.au auVar);
    }

    public i(com.anythink.core.common.f.a aVar) {
        this.b = aVar;
        this.c = aVar.q;
    }

    private void a(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.f.au auVar) {
        try {
            com.anythink.core.d.e a2 = this.b.n.a();
            com.anythink.core.common.f.a aVar = this.b;
            java.util.Map<java.lang.String, java.lang.Object> a3 = a2.a(aVar.e, aVar.d, auVar);
            com.anythink.core.common.f.h S = this.b.f167s.S();
            com.anythink.core.common.o.u.a(S, auVar, 0, false);
            com.anythink.core.common.o.h.a(a3, S);
            aTBaseAdAdapter.getBidRequestInfo(this.b.b, a3, this.c, new com.anythink.core.b.i.AnonymousClass2(auVar));
            com.anythink.core.b.i.a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.a(auVar, aTBaseAdAdapter);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.anythink.core.b.i.a aVar3 = this.d;
            if (aVar3 != null) {
                aVar3.a(th.getMessage(), auVar);
            }
        }
    }

    public static /* synthetic */ void a(com.anythink.core.b.i iVar, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.f.au auVar) {
        try {
            com.anythink.core.d.e a2 = iVar.b.n.a();
            com.anythink.core.common.f.a aVar = iVar.b;
            java.util.Map<java.lang.String, java.lang.Object> a3 = a2.a(aVar.e, aVar.d, auVar);
            com.anythink.core.common.f.h S = iVar.b.f167s.S();
            com.anythink.core.common.o.u.a(S, auVar, 0, false);
            com.anythink.core.common.o.h.a(a3, S);
            aTBaseAdAdapter.getBidRequestInfo(iVar.b.b, a3, iVar.c, iVar.new AnonymousClass2(auVar));
            com.anythink.core.b.i.a aVar2 = iVar.d;
            if (aVar2 != null) {
                aVar2.a(auVar, aTBaseAdAdapter);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.anythink.core.b.i.a aVar3 = iVar.d;
            if (aVar3 != null) {
                aVar3.a(th.getMessage(), auVar);
            }
        }
    }

    public static /* synthetic */ void a(com.anythink.core.b.i iVar, com.anythink.core.common.f.au auVar, com.anythink.core.api.ATBidRequestInfo aTBidRequestInfo) {
        com.anythink.core.common.o.b.b.a().a(iVar.new AnonymousClass3(aTBidRequestInfo, auVar));
    }

    private void a(com.anythink.core.common.f.au auVar, com.anythink.core.api.ATBidRequestInfo aTBidRequestInfo) {
        com.anythink.core.common.o.b.b.a().a(new com.anythink.core.b.i.AnonymousClass3(aTBidRequestInfo, auVar));
    }

    private void a(com.anythink.core.common.f.au auVar, com.anythink.core.b.i.a aVar) {
        this.d = aVar;
        com.anythink.core.api.ATBaseAdAdapter a2 = com.anythink.core.common.o.j.a(auVar);
        if (a2 == null) {
            aVar.a(com.anythink.core.api.ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE, auVar);
        } else {
            com.anythink.core.common.o.b.b.a().a(new com.anythink.core.b.i.AnonymousClass1(a2, auVar));
        }
    }
}
