package com.anythink.core.common.b;

/* loaded from: classes12.dex */
public final class k extends com.anythink.core.api.ATAdInfo {
    private java.util.Map<java.lang.String, java.lang.Object> C;
    private double F;
    private com.anythink.core.api.ATBaseAdAdapter a;
    private java.util.Map<java.lang.String, java.lang.Object> x;
    private int b = -1;
    private java.lang.String c = "";
    private int d = -1;
    private double e = 0.0d;
    private int f = 0;
    private java.lang.String g = "";
    private java.lang.Double h = java.lang.Double.valueOf(0.0d);
    private java.lang.String i = "";
    private java.lang.String j = "";
    private java.lang.String k = "";
    private java.lang.String l = "";
    private java.lang.String m = "unknow";
    private java.lang.String n = "Network";
    private java.lang.String o = "";
    private int p = 1;
    private int q = 0;
    private java.lang.String r = "";

    /* renamed from: s, reason: collision with root package name */
    private java.lang.String f165s = "";
    private int t = 0;
    private java.lang.String u = "";
    private java.lang.String v = "";
    private java.util.Map<java.lang.String, java.lang.Object> w = null;
    private java.lang.String y = "";
    private int z = 0;
    private java.lang.String A = "";
    private int B = 0;
    private int D = 1;
    private java.lang.String E = "";

    public static com.anythink.core.common.b.k a(com.anythink.core.api.BaseAd baseAd) {
        if (baseAd == null) {
            return new com.anythink.core.common.b.k();
        }
        com.anythink.core.common.b.k a = a(baseAd.getDetail());
        a.x = baseAd.getNetworkInfoMap();
        return a;
    }

    public static com.anythink.core.common.b.k a(com.anythink.core.common.b.a aVar) {
        return aVar != null ? a(a(aVar.getTrackingInfo()), aVar) : new com.anythink.core.common.b.k();
    }

    private static com.anythink.core.common.b.k a(com.anythink.core.common.b.k kVar, com.anythink.core.common.b.a aVar) {
        if (aVar != null && (aVar instanceof com.anythink.core.api.ATBaseAdAdapter)) {
            com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = (com.anythink.core.api.ATBaseAdAdapter) aVar;
            kVar.a = aTBaseAdAdapter;
            kVar.x = aTBaseAdAdapter.getNetworkInfoMap();
        }
        return kVar;
    }

    private static com.anythink.core.common.b.k a(com.anythink.core.common.b.k kVar, com.anythink.core.common.f.h hVar) {
        java.lang.String str;
        com.anythink.core.api.ATRewardInfo w;
        com.anythink.core.api.ATRewardInfo aTRewardInfo;
        kVar.b = hVar.M();
        kVar.c = hVar.C();
        kVar.d = hVar.F();
        kVar.f = hVar.A();
        kVar.e = hVar.k();
        kVar.F = hVar.a();
        kVar.i = hVar.m();
        kVar.g = hVar.q();
        kVar.h = java.lang.Double.valueOf(kVar.e / 1000.0d);
        kVar.j = hVar.t();
        kVar.l = com.anythink.core.common.o.h.d(hVar.ae());
        java.lang.String ac = hVar.ac();
        java.lang.String b = hVar.b();
        if (android.text.TextUtils.isEmpty(b) || android.text.TextUtils.equals(ac, b)) {
            str = "";
        } else {
            str = ac;
            ac = b;
        }
        kVar.k = ac;
        kVar.E = str;
        kVar.m = hVar.s();
        if (hVar.M() == 35) {
            kVar.n = "Cross_Promotion";
        } else if (hVar.M() == 66) {
            kVar.n = "Adx";
        } else {
            kVar.n = "Network";
        }
        kVar.o = hVar.p();
        kVar.p = hVar.r();
        kVar.q = hVar.N();
        kVar.r = hVar.B;
        if (android.text.TextUtils.equals(com.anythink.core.common.b.h.i.b, kVar.l)) {
            java.util.Map<java.lang.String, com.anythink.core.api.ATRewardInfo> v = hVar.v();
            if (v != null && v.containsKey(kVar.r) && (aTRewardInfo = v.get(kVar.r)) != null) {
                kVar.f165s = aTRewardInfo.rewardName;
                kVar.t = aTRewardInfo.rewardNumber;
            }
            if ((android.text.TextUtils.isEmpty(kVar.f165s) || kVar.t == 0) && (w = hVar.w()) != null) {
                kVar.f165s = w.rewardName;
                kVar.t = w.rewardNumber;
            }
        }
        kVar.v = com.anythink.core.common.b.o.a().m();
        kVar.u = com.anythink.core.common.b.o.a().n();
        kVar.w = hVar.x();
        kVar.y = hVar.j();
        kVar.z = hVar.R();
        kVar.A = hVar.V();
        kVar.B = hVar.aa();
        java.util.Map<java.lang.String, java.lang.Object> e = hVar.e();
        if (e != null) {
            kVar.C = new java.util.HashMap(e);
        }
        kVar.D = hVar.d();
        return kVar;
    }

    private static com.anythink.core.common.b.k a(com.anythink.core.common.f.h hVar) {
        com.anythink.core.common.b.k kVar = new com.anythink.core.common.b.k();
        return hVar != null ? a(kVar, hVar) : kVar;
    }

    public static com.anythink.core.common.b.k a(com.anythink.core.common.f.h hVar, com.anythink.core.common.b.a aVar) {
        return a(a(hVar), aVar);
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getABTestId() {
        return this.B;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getATAdFormat() {
        return this.l;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getATPlacementId() {
        return this.k;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getAdNetworkType() {
        return this.n;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getAdsourceId() {
        return this.c;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getAdsourceIndex() {
        return this.d;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final double getBidFloor() {
        return this.F;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getChannel() {
        return this.v;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getCountry() {
        return this.j;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getCurrency() {
        return this.i;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getCustomRule() {
        return this.w != null ? new org.json.JSONObject(this.w).toString() : "";
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getDismissType() {
        return this.z;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final double getEcpm() {
        return this.e;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getEcpmLevel() {
        return this.p;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getEcpmPrecision() {
        return this.m;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.util.Map<java.lang.String, java.lang.Object> getExtInfoMap() {
        return this.x;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.util.Map<java.lang.String, java.lang.Object> getLocalExtra() {
        return this.C;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getNetworkFirmId() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getNetworkPlacementId() {
        return this.o;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getPlacementType() {
        return this.D;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.Double getPublisherRevenue() {
        return this.h;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getRewardUserCustomData() {
        com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = this.a;
        return aTBaseAdAdapter != null ? aTBaseAdAdapter.getUserCustomData() : "";
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getScenarioId() {
        return this.r;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getScenarioRewardName() {
        return this.f165s;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getScenarioRewardNumber() {
        return this.t;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getSegmentId() {
        return this.q;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getSharedPlacementId() {
        return this.E;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getShowId() {
        return this.g;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getSubChannel() {
        return this.u;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getTpBidId() {
        return this.y;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final java.lang.String getWaterfallId() {
        return this.A;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int isHeaderBiddingAdsource() {
        return this.f;
    }

    public final java.lang.String toString() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("id", this.g);
            jSONObject.put("publisher_revenue", this.h);
            jSONObject.put("currency", this.i);
            jSONObject.put("country", this.j);
            jSONObject.put("adunit_id", this.k);
            jSONObject.put("adunit_format", this.l);
            jSONObject.put(com.anythink.core.common.j.R, this.m);
            jSONObject.put("network_type", this.n);
            jSONObject.put("network_placement_id", this.o);
            jSONObject.put(com.anythink.core.common.j.Q, this.p);
            jSONObject.put(com.anythink.core.api.ATCustomRuleKeys.SEGMENT_ID, this.q);
            if (!android.text.TextUtils.isEmpty(this.r)) {
                jSONObject.put("scenario_id", this.r);
            }
            if (!android.text.TextUtils.isEmpty(this.f165s) && this.t != 0) {
                jSONObject.put("scenario_reward_name", this.f165s);
                jSONObject.put("scenario_reward_number", this.t);
            }
            if (!android.text.TextUtils.isEmpty(this.v)) {
                jSONObject.put("channel", this.v);
            }
            if (!android.text.TextUtils.isEmpty(this.u)) {
                jSONObject.put("sub_channel", this.u);
            }
            java.util.Map<java.lang.String, java.lang.Object> map = this.w;
            if (map != null && map.size() > 0) {
                jSONObject.put("custom_rule", new org.json.JSONObject(this.w));
            }
            jSONObject.put("network_firm_id", this.b);
            jSONObject.put("adsource_id", this.c);
            jSONObject.put("adsource_index", this.d);
            jSONObject.put("adsource_price", this.e);
            jSONObject.put("adsource_isheaderbidding", this.f);
            java.util.Map<java.lang.String, java.lang.Object> map2 = this.x;
            if (map2 != null && map2.size() > 0) {
                jSONObject.put("ext_info", new org.json.JSONObject(this.x));
            }
            com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = this.a;
            if (aTBaseAdAdapter != null) {
                jSONObject.put(com.bytedance.sdk.openadsdk.mediation.MediationConstant.REWARD_CUSTOM_DATA, aTBaseAdAdapter.getUserCustomData());
            }
            if (!android.text.TextUtils.isEmpty(this.y)) {
                jSONObject.put("tp_bid_id", this.y);
            }
            int i = this.z;
            if (i != 0) {
                jSONObject.put("dismiss_type", i);
            }
            if (!android.text.TextUtils.isEmpty(this.A)) {
                jSONObject.put(com.anythink.core.d.e.a.U, this.A);
            }
            jSONObject.put(com.anythink.core.common.h.c.I, this.B);
            java.util.Map<java.lang.String, java.lang.Object> map3 = this.C;
            if (map3 != null && map3.size() > 0) {
                jSONObject.put("user_load_extra_data", new org.json.JSONObject(this.C));
            }
            jSONObject.put("placement_type", this.D);
            if (!android.text.TextUtils.isEmpty(this.E)) {
                jSONObject.put("shared_placement_id", this.E);
            }
            jSONObject.put("bid_floor", this.F);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }
}
