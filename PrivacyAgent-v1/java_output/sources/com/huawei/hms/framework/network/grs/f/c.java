package com.huawei.hms.framework.network.grs.f;

/* loaded from: classes22.dex */
public class c extends com.huawei.hms.framework.network.grs.f.a {
    public c(android.content.Context context, boolean z) {
        this.e = z;
        if (a("grs_sdk_global_route_config.json", context) == 0) {
            this.d = true;
        }
    }

    private java.util.List<com.huawei.hms.framework.network.grs.local.model.b> a(org.json.JSONObject jSONObject) {
        org.json.JSONArray jSONArray;
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList(16);
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                com.huawei.hms.framework.network.grs.local.model.b bVar = new com.huawei.hms.framework.network.grs.local.model.b();
                bVar.b(next);
                org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                bVar.c(jSONObject2.getString("name"));
                bVar.a(jSONObject2.getString("description"));
                if (jSONObject2.has("countriesOrAreas")) {
                    jSONArray = jSONObject2.getJSONArray("countriesOrAreas");
                } else if (jSONObject2.has("countries")) {
                    jSONArray = jSONObject2.getJSONArray("countries");
                } else {
                    com.huawei.hms.framework.common.Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
                    jSONArray = null;
                }
                java.util.HashSet hashSet = new java.util.HashSet(16);
                if (jSONArray != null && jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        hashSet.add((java.lang.String) jSONArray.get(i));
                    }
                    bVar.a(hashSet);
                    arrayList.add(bVar);
                }
                return new java.util.ArrayList();
            }
            return arrayList;
        } catch (org.json.JSONException e) {
            com.huawei.hms.framework.common.Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong. %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e.getMessage()));
            return new java.util.ArrayList();
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int a(java.lang.String str) {
        this.a = new com.huawei.hms.framework.network.grs.local.model.a();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str).getJSONObject("application");
            java.lang.String string = jSONObject.getString("name");
            long j = jSONObject.getLong("cacheControl");
            org.json.JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.a.b(string);
            this.a.a(j);
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    return 0;
                }
            }
            return -1;
        } catch (org.json.JSONException e) {
            com.huawei.hms.framework.common.Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong. %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    public java.util.List<com.huawei.hms.framework.network.grs.local.model.b> a(org.json.JSONArray jSONArray, org.json.JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0) ? new java.util.ArrayList() : a(jSONObject);
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int b(java.lang.String str) {
        org.json.JSONObject jSONObject;
        this.b = new java.util.ArrayList(16);
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(str);
            if (jSONObject2.has("countryOrAreaGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryOrAreaGroups");
            } else if (jSONObject2.has("countryGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryGroups");
            } else {
                com.huawei.hms.framework.common.Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONObject = null;
            }
            if (jSONObject == null) {
                return -1;
            }
            if (jSONObject.length() != 0) {
                this.b.addAll(a(jSONObject));
            }
            return 0;
        } catch (org.json.JSONException e) {
            com.huawei.hms.framework.common.Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong. %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2 A[Catch: JSONException -> 0x0120, TryCatch #0 {JSONException -> 0x0120, blocks: (B:3:0x000c, B:4:0x001d, B:6:0x0023, B:9:0x0039, B:12:0x0042, B:13:0x0056, B:15:0x005c, B:17:0x006d, B:19:0x0086, B:20:0x009c, B:22:0x00a2, B:24:0x00b6, B:31:0x00bc, B:35:0x00cd, B:36:0x0072, B:38:0x0078, B:39:0x007f, B:42:0x00e1, B:44:0x00ec, B:45:0x00fb, B:46:0x0105, B:48:0x010c, B:49:0x0113, B:53:0x00f1, B:55:0x00f7, B:56:0x0100), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010c A[Catch: JSONException -> 0x0120, TryCatch #0 {JSONException -> 0x0120, blocks: (B:3:0x000c, B:4:0x001d, B:6:0x0023, B:9:0x0039, B:12:0x0042, B:13:0x0056, B:15:0x005c, B:17:0x006d, B:19:0x0086, B:20:0x009c, B:22:0x00a2, B:24:0x00b6, B:31:0x00bc, B:35:0x00cd, B:36:0x0072, B:38:0x0078, B:39:0x007f, B:42:0x00e1, B:44:0x00ec, B:45:0x00fb, B:46:0x0105, B:48:0x010c, B:49:0x0113, B:53:0x00f1, B:55:0x00f7, B:56:0x0100), top: B:2:0x000c }] */
    @Override // com.huawei.hms.framework.network.grs.f.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e(java.lang.String str) {
        org.json.JSONObject jSONObject;
        java.lang.String str2;
        java.lang.String string;
        java.util.Iterator<java.lang.String> keys;
        java.lang.String str3 = "countryGroup";
        java.lang.String str4 = "countryOrAreaGroup";
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(str).getJSONObject("services");
            java.util.Iterator<java.lang.String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                java.lang.String next = keys2.next();
                com.huawei.hms.framework.network.grs.local.model.c cVar = new com.huawei.hms.framework.network.grs.local.model.c();
                cVar.b(next);
                if (!this.g.contains(next)) {
                    this.g.add(next);
                    if (this.e) {
                        org.json.JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                        cVar.c(jSONObject3.getString("routeBy"));
                        org.json.JSONArray jSONArray = jSONObject3.getJSONArray("servings");
                        int i = 0;
                        while (i < jSONArray.length()) {
                            org.json.JSONObject jSONObject4 = (org.json.JSONObject) jSONArray.get(i);
                            com.huawei.hms.framework.network.grs.local.model.d dVar = new com.huawei.hms.framework.network.grs.local.model.d();
                            if (jSONObject4.has(str4)) {
                                string = jSONObject4.getString(str4);
                            } else if (jSONObject4.has(str3)) {
                                string = jSONObject4.getString(str3);
                            } else {
                                com.huawei.hms.framework.common.Logger.v("LocalManagerV1", "maybe this service routeBy is unconditional.");
                                str2 = "no-country";
                                dVar.a(str2);
                                org.json.JSONObject jSONObject5 = jSONObject4.getJSONObject("addresses");
                                java.lang.String str5 = str3;
                                java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap(16);
                                keys = jSONObject5.keys();
                                while (keys.hasNext()) {
                                    java.util.Iterator<java.lang.String> it = keys;
                                    java.lang.String next2 = keys.next();
                                    java.lang.String string2 = jSONObject5.getString(next2);
                                    if (android.text.TextUtils.isEmpty(next2) || android.text.TextUtils.isEmpty(string2)) {
                                        keys = it;
                                    } else {
                                        concurrentHashMap.put(next2, jSONObject5.getString(next2));
                                        keys = it;
                                        str4 = str4;
                                    }
                                }
                                dVar.a(concurrentHashMap);
                                cVar.a(dVar.b(), dVar);
                                i++;
                                str3 = str5;
                                str4 = str4;
                            }
                            str2 = string;
                            dVar.a(str2);
                            org.json.JSONObject jSONObject52 = jSONObject4.getJSONObject("addresses");
                            java.lang.String str52 = str3;
                            java.util.concurrent.ConcurrentHashMap concurrentHashMap2 = new java.util.concurrent.ConcurrentHashMap(16);
                            keys = jSONObject52.keys();
                            while (keys.hasNext()) {
                            }
                            dVar.a(concurrentHashMap2);
                            cVar.a(dVar.b(), dVar);
                            i++;
                            str3 = str52;
                            str4 = str4;
                        }
                        java.lang.String str6 = str3;
                        java.lang.String str7 = str4;
                        java.util.List<com.huawei.hms.framework.network.grs.local.model.b> list = null;
                        if (jSONObject3.has("countryOrAreaGroups")) {
                            jSONObject = jSONObject3.getJSONObject("countryOrAreaGroups");
                        } else if (jSONObject3.has("countryGroups")) {
                            jSONObject = jSONObject3.getJSONObject("countryGroups");
                        } else {
                            com.huawei.hms.framework.common.Logger.v("LocalManagerV1", "service use default countryOrAreaGroup");
                            cVar.a(list);
                            if (this.a == null) {
                                this.a = new com.huawei.hms.framework.network.grs.local.model.a();
                            }
                            this.a.a(next, cVar);
                            str3 = str6;
                            str4 = str7;
                        }
                        list = a((org.json.JSONArray) null, jSONObject);
                        cVar.a(list);
                        if (this.a == null) {
                        }
                        this.a.a(next, cVar);
                        str3 = str6;
                        str4 = str7;
                    }
                }
            }
            return 0;
        } catch (org.json.JSONException e) {
            com.huawei.hms.framework.common.Logger.w("LocalManagerV1", "parse 1.0 services failed maybe because of json style.please check! %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }
}
