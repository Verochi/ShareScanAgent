package com.anythink.network.adx;

/* loaded from: classes12.dex */
public class AdxBidRequestInfo extends com.anythink.core.api.ATBidRequestInfo {
    org.json.JSONObject a;

    public AdxBidRequestInfo(android.content.Context context, java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        this.a = jSONObject;
        try {
            jSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SUPPORT_TEMPLATE_VERSION, 1);
            com.anythink.core.d.e b = com.anythink.core.d.f.a(context).b(str);
            if (b != null) {
                int aF = b.aF();
                if (aF > 0) {
                    java.util.List<com.anythink.core.common.a.e> a = com.anythink.core.common.a.c.a().a(aF);
                    if (a.size() > 0) {
                        this.a.put(com.anythink.core.d.e.a.P, a(a));
                    }
                }
                int aE = b.aE();
                if (aE > 0) {
                    java.util.List<com.anythink.core.common.a.e> b2 = com.anythink.core.common.a.c.a().b(aE);
                    if (b2.size() > 0) {
                        this.a.put(com.anythink.core.d.e.a.O, a(b2));
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static org.json.JSONObject a(java.util.List<com.anythink.core.common.a.e> list) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            for (com.anythink.core.common.a.e eVar : list) {
                java.util.List list2 = (java.util.List) hashMap.get(eVar.a());
                if (list2 == null) {
                    list2 = new java.util.ArrayList();
                    hashMap.put(eVar.a(), list2);
                }
                list2.add(eVar.b());
            }
            for (java.util.Map.Entry entry : hashMap.entrySet()) {
                jSONObject.put((java.lang.String) entry.getKey(), new org.json.JSONArray((java.util.Collection) entry.getValue()));
            }
        } catch (java.lang.Throwable unused) {
        }
        return jSONObject;
    }

    public void fillAdAcceptType() {
        try {
            org.json.JSONObject jSONObject = this.a;
            if (jSONObject != null) {
                jSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADP_ACCEPT_TYPE, new org.json.JSONArray(com.anythink.core.api.ATAdConst.AD_SUPPORT_TYPE_ARRAY));
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void fillBannerData(java.util.Map<java.lang.String, java.lang.Object> map) {
        try {
            java.lang.String obj = map.get(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE).toString();
            if (android.text.TextUtils.isEmpty(obj)) {
                return;
            }
            java.lang.String[] split = obj.split("x");
            int parseInt = java.lang.Integer.parseInt(split[0]);
            int parseInt2 = java.lang.Integer.parseInt(split[1]);
            this.a.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, parseInt);
            this.a.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, parseInt2);
            this.a.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADP_ACCEPT_TYPE, new org.json.JSONArray(com.anythink.core.api.ATAdConst.AD_SUPPORT_TYPE_ARRAY));
        } catch (java.lang.Throwable unused) {
        }
    }

    public void fillInterstitial(java.util.Map<java.lang.String, java.lang.Object> map) {
        try {
            if (map.containsKey("unit_type")) {
                java.lang.String stringFromMap = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_type");
                if (!android.text.TextUtils.isEmpty(stringFromMap)) {
                    this.a.put("unit_type", java.lang.Integer.parseInt(stringFromMap));
                }
                fillAdAcceptType();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void fillSplashData() {
        try {
            this.a.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GET_OFFER, 2);
            fillAdAcceptType();
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.core.api.ATBidRequestInfo
    public org.json.JSONObject toRequestJSONObject() {
        return this.a;
    }
}
