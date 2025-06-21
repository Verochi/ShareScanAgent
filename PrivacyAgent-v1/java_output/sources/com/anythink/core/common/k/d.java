package com.anythink.core.common.k;

/* loaded from: classes12.dex */
public final class d implements com.anythink.core.common.g.c {

    /* renamed from: com.anythink.core.common.k.d$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.h a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;
        final /* synthetic */ com.anythink.core.api.ATBaseAdAdapter d;

        /* renamed from: com.anythink.core.common.k.d$1$1, reason: invalid class name and collision with other inner class name */
        public class C01661 implements com.anythink.core.common.h.k {
            final /* synthetic */ java.lang.String a;

            public C01661(java.lang.String str) {
                this.a = str;
            }

            @Override // com.anythink.core.common.h.k
            public final void onLoadCanceled(int i) {
            }

            @Override // com.anythink.core.common.h.k
            public final void onLoadError(int i, java.lang.String str, com.anythink.core.api.AdError adError) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("S2S reward error! PlacementId: ");
                sb.append(this.a);
                sb.append(", ");
                sb.append(adError.printStackTrace());
            }

            @Override // com.anythink.core.common.h.k
            public final void onLoadFinish(int i, java.lang.Object obj) {
                if (com.anythink.core.common.b.o.a().A()) {
                    new java.lang.StringBuilder("S2S reward succeeded. PlacementId: ").append(this.a);
                }
            }

            @Override // com.anythink.core.common.h.k
            public final void onLoadStart(int i) {
            }
        }

        public AnonymousClass1(com.anythink.core.common.f.h hVar, long j, long j2, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
            this.a = hVar;
            this.b = j;
            this.c = j2;
            this.d = aTBaseAdAdapter;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                java.lang.String ac = this.a.ac();
                java.lang.String b = this.a.b();
                java.lang.String str = "";
                if (android.text.TextUtils.isEmpty(b) || android.text.TextUtils.equals(ac, b)) {
                    b = ac;
                } else {
                    str = ac;
                }
                com.anythink.core.d.e a = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).a(b);
                if (a.k() != 1) {
                    return;
                }
                long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
                long j = this.b;
                long j2 = (j == 0 || elapsedRealtime < j) ? elapsedRealtime : j;
                org.json.JSONObject jSONObject = new org.json.JSONObject(com.anythink.core.common.k.a.a(a.G()));
                int optInt = jSONObject.optInt("a");
                java.lang.String optString = jSONObject.optString("b");
                java.lang.Object opt = jSONObject.opt("api_c");
                if (opt == null) {
                    opt = new org.json.JSONObject();
                }
                com.anythink.core.common.k.b a2 = com.anythink.core.common.k.a.a(optString, com.anythink.core.common.k.d.b(b, str, this.c, j2, this.a, this.d, opt));
                if (android.text.TextUtils.isEmpty(a2.a())) {
                    com.anythink.core.common.n.c.a(b, str, this.a, a, "", a2.b());
                } else {
                    new com.anythink.core.common.k.c(com.anythink.core.common.b.o.a().f(), optInt, a2.a(), this.a, a, b, str).a(0, (com.anythink.core.common.h.k) new com.anythink.core.common.k.d.AnonymousClass1.C01661(ac));
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0099 A[Catch: all -> 0x00a3, TryCatch #1 {all -> 0x00a3, blocks: (B:8:0x0013, B:10:0x0099, B:11:0x009e), top: B:7:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String b(java.lang.String str, java.lang.String str2, long j, long j2, com.anythink.core.common.f.h hVar, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, java.lang.Object obj) {
        java.lang.String str3;
        java.util.Map<java.lang.String, java.lang.Object> networkInfoMap;
        try {
            networkInfoMap = aTBaseAdAdapter.getNetworkInfoMap();
        } catch (java.lang.Throwable unused) {
        }
        try {
            if (networkInfoMap != null) {
                str3 = new org.json.JSONObject(networkInfoMap).toString();
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("pl_id", str);
                jSONObject.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId, hVar.ad());
                jSONObject.put("show_id", hVar.q());
                jSONObject.put("unit_id", hVar.C());
                jSONObject.put("nw_firm_id", hVar.M());
                jSONObject.put("scenario_id", hVar.B);
                jSONObject.put("rv_start_ts", j);
                jSONObject.put("r_callback_ts", j2);
                jSONObject.put("rv_play_dur", j2 - j);
                jSONObject.put("tp_bid_id", hVar.j());
                jSONObject.put("extra_info", str3);
                jSONObject.put("user_id", aTBaseAdAdapter.getUserId());
                jSONObject.put("extra_data", aTBaseAdAdapter.getUserCustomData());
                jSONObject.put("curr_ts", java.lang.System.currentTimeMillis());
                jSONObject.put("api_c", obj);
                jSONObject.put(com.anythink.core.d.e.a.i, com.anythink.core.common.b.k.a(hVar, aTBaseAdAdapter).toString());
                if (!android.text.TextUtils.isEmpty(str2)) {
                    jSONObject.put(com.anythink.core.d.e.a.ao, str2);
                }
                return jSONObject.toString();
            }
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("pl_id", str);
            jSONObject2.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId, hVar.ad());
            jSONObject2.put("show_id", hVar.q());
            jSONObject2.put("unit_id", hVar.C());
            jSONObject2.put("nw_firm_id", hVar.M());
            jSONObject2.put("scenario_id", hVar.B);
            jSONObject2.put("rv_start_ts", j);
            jSONObject2.put("r_callback_ts", j2);
            jSONObject2.put("rv_play_dur", j2 - j);
            jSONObject2.put("tp_bid_id", hVar.j());
            jSONObject2.put("extra_info", str3);
            jSONObject2.put("user_id", aTBaseAdAdapter.getUserId());
            jSONObject2.put("extra_data", aTBaseAdAdapter.getUserCustomData());
            jSONObject2.put("curr_ts", java.lang.System.currentTimeMillis());
            jSONObject2.put("api_c", obj);
            jSONObject2.put(com.anythink.core.d.e.a.i, com.anythink.core.common.b.k.a(hVar, aTBaseAdAdapter).toString());
            if (!android.text.TextUtils.isEmpty(str2)) {
            }
            return jSONObject2.toString();
        } catch (java.lang.Throwable unused2) {
            return "";
        }
        str3 = "";
    }

    @Override // com.anythink.core.common.g.c
    public final void a(long j, long j2, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.f.h hVar) {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.k.d.AnonymousClass1(hVar, j2, j, aTBaseAdAdapter), 2, true);
    }
}
