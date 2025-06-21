package com.huawei.hms.framework.network.grs.f;

/* loaded from: classes22.dex */
public class d extends com.huawei.hms.framework.network.grs.f.a {
    public d(android.content.Context context, java.lang.String str, boolean z) {
        this.e = z;
        if (a(android.text.TextUtils.isEmpty(str) ? "grs_app_global_route_config.json" : str, context) == 0) {
            this.d = true;
        }
    }

    public d(boolean z, boolean z2) {
        this.e = z2;
        this.d = z;
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int a(java.lang.String str) {
        this.a = new com.huawei.hms.framework.network.grs.local.model.a();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str).getJSONArray("applications").getJSONObject(0);
            this.a.b(jSONObject.getString("name"));
            org.json.JSONArray jSONArray = jSONObject.getJSONArray("services");
            if (jSONArray != null && jSONArray.length() != 0) {
                if (jSONObject.has("customservices")) {
                    b(jSONObject.getJSONArray("customservices"));
                }
                return 0;
            }
            return -1;
        } catch (org.json.JSONException e) {
            com.huawei.hms.framework.common.Logger.w("LocalManagerV2", "parse appbean failed maybe json style is wrong. %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int b(java.lang.String str) {
        org.json.JSONArray jSONArray;
        org.json.JSONArray jSONArray2;
        this.b = new java.util.ArrayList(16);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                com.huawei.hms.framework.common.Logger.e("LocalManagerV2", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONArray = null;
            }
            if (jSONArray == null) {
                return -1;
            }
            if (jSONArray.length() != 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    org.json.JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    com.huawei.hms.framework.network.grs.local.model.b bVar = new com.huawei.hms.framework.network.grs.local.model.b();
                    bVar.b(jSONObject2.getString("id"));
                    bVar.c(jSONObject2.getString("name"));
                    bVar.a(jSONObject2.getString("description"));
                    if (jSONObject2.has("countriesOrAreas")) {
                        jSONArray2 = jSONObject2.getJSONArray("countriesOrAreas");
                    } else if (jSONObject2.has("countries")) {
                        jSONArray2 = jSONObject2.getJSONArray("countries");
                    } else {
                        com.huawei.hms.framework.common.Logger.w("LocalManagerV2", "current country or area group has not config countries or areas.");
                        jSONArray2 = null;
                    }
                    java.util.HashSet hashSet = new java.util.HashSet(16);
                    if (jSONArray2 != null && jSONArray2.length() != 0) {
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            hashSet.add((java.lang.String) jSONArray2.get(i2));
                        }
                        bVar.a(hashSet);
                        this.b.add(bVar);
                    }
                    return -1;
                }
            }
            return 0;
        } catch (org.json.JSONException e) {
            com.huawei.hms.framework.common.Logger.w("LocalManagerV2", "parse countrygroup failed maybe json style is wrong. %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int e(java.lang.String str) {
        return d(str);
    }
}
