package com.huawei.hms.framework.network.grs.f;

/* loaded from: classes22.dex */
public abstract class a {
    protected com.huawei.hms.framework.network.grs.local.model.a a;
    protected java.util.List<com.huawei.hms.framework.network.grs.local.model.b> b;
    protected java.util.Map<java.lang.String, java.lang.String> c = new java.util.concurrent.ConcurrentHashMap(16);
    protected boolean d = false;
    protected boolean e = false;
    protected boolean f = false;
    protected java.util.Set<java.lang.String> g = new java.util.HashSet(16);

    private java.util.Map<java.lang.String, java.lang.String> a(java.util.List<com.huawei.hms.framework.network.grs.local.model.b> list, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, java.lang.String str) {
        java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap(16);
        concurrentHashMap.put("no_route_country", "no-country");
        for (com.huawei.hms.framework.network.grs.local.model.b bVar : list) {
            if (bVar.a().contains(grsBaseInfo.getIssueCountry())) {
                concurrentHashMap.put(grsBaseInfo.getIssueCountry(), bVar.b());
            }
            if (bVar.a().contains(grsBaseInfo.getRegCountry())) {
                concurrentHashMap.put(grsBaseInfo.getRegCountry(), bVar.b());
            }
            if (bVar.a().contains(grsBaseInfo.getSerCountry())) {
                concurrentHashMap.put(grsBaseInfo.getSerCountry(), bVar.b());
            }
            if (bVar.a().contains(str)) {
                com.huawei.hms.framework.common.Logger.v("AbstractLocalManager", "get countryGroupID from geoIp");
                concurrentHashMap.put(str, bVar.b());
            }
        }
        return concurrentHashMap;
    }

    private int b(java.lang.String str, android.content.Context context) {
        if (f(com.huawei.hms.framework.network.grs.h.c.a(str, context)) != 0) {
            return -1;
        }
        com.huawei.hms.framework.common.Logger.i("AbstractLocalManager", "load APP_CONFIG_FILE success{%s}.", str);
        return 0;
    }

    private int f(java.lang.String str) {
        int b;
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        if (this.e && (b = b(str)) != 0) {
            return b;
        }
        int a = a(str);
        return a != 0 ? a : e(str);
    }

    private int g(java.lang.String str) {
        java.util.List<com.huawei.hms.framework.network.grs.local.model.b> list;
        int c;
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        return (!this.e || !((list = this.b) == null || list.isEmpty()) || (c = c(str)) == 0) ? d(str) : c;
    }

    public abstract int a(java.lang.String str);

    public int a(java.lang.String str, android.content.Context context) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.huawei.hms.framework.network.grs.GrsApp.getInstance().getBrand(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR));
        sb.append(str);
        return b(sb.toString(), context) != 0 ? -1 : 0;
    }

    public java.lang.String a(android.content.Context context, com.huawei.hms.framework.network.grs.e.a aVar, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, java.lang.String str, java.lang.String str2, boolean z) {
        java.util.Map<java.lang.String, java.lang.String> a = a(context, aVar, grsBaseInfo, str, z);
        if (a != null) {
            return a.get(str2);
        }
        com.huawei.hms.framework.common.Logger.w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", str);
        return null;
    }

    public java.util.List<com.huawei.hms.framework.network.grs.local.model.b> a(org.json.JSONArray jSONArray) {
        org.json.JSONArray jSONArray2;
        if (jSONArray == null || jSONArray.length() == 0) {
            return new java.util.ArrayList();
        }
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList(16);
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                com.huawei.hms.framework.network.grs.local.model.b bVar = new com.huawei.hms.framework.network.grs.local.model.b();
                bVar.b(jSONObject.getString("id"));
                bVar.c(jSONObject.getString("name"));
                bVar.a(jSONObject.getString("description"));
                if (jSONObject.has("countriesOrAreas")) {
                    jSONArray2 = jSONObject.getJSONArray("countriesOrAreas");
                } else if (jSONObject.has("countries")) {
                    jSONArray2 = jSONObject.getJSONArray("countries");
                } else {
                    com.huawei.hms.framework.common.Logger.w("AbstractLocalManager", "current country or area group has not config countries or areas.");
                    jSONArray2 = null;
                }
                java.util.HashSet hashSet = new java.util.HashSet(16);
                if (jSONArray2 != null && jSONArray2.length() != 0) {
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        hashSet.add((java.lang.String) jSONArray2.get(i2));
                    }
                    bVar.a(hashSet);
                    arrayList.add(bVar);
                }
                return new java.util.ArrayList();
            }
            return arrayList;
        } catch (org.json.JSONException e) {
            com.huawei.hms.framework.common.Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e.getMessage()));
            return new java.util.ArrayList();
        }
    }

    public java.util.Map<java.lang.String, java.lang.String> a(android.content.Context context, com.huawei.hms.framework.network.grs.e.a aVar, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, java.lang.String str, boolean z) {
        com.huawei.hms.framework.network.grs.local.model.a aVar2 = this.a;
        if (aVar2 == null) {
            com.huawei.hms.framework.common.Logger.w("AbstractLocalManager", "application data is null.");
            return null;
        }
        com.huawei.hms.framework.network.grs.local.model.c a = aVar2.a(str);
        if (a == null) {
            com.huawei.hms.framework.common.Logger.w("AbstractLocalManager", "service not found in local config{%s}", str);
            return null;
        }
        java.lang.String b = com.huawei.hms.framework.network.grs.f.e.b(context, aVar, a.b(), grsBaseInfo, z);
        if (b == null) {
            com.huawei.hms.framework.common.Logger.w("AbstractLocalManager", "country not found by routeby in local config{%s}", a.b());
            return null;
        }
        java.util.List<com.huawei.hms.framework.network.grs.local.model.b> a2 = a.a();
        com.huawei.hms.framework.network.grs.local.model.d a3 = a.a(((a2 == null || a2.size() == 0) ? this.c : a(a2, grsBaseInfo, b)).get(b));
        if (a3 == null) {
            return null;
        }
        return a3.a();
    }

    public void a() {
        com.huawei.hms.framework.network.grs.local.model.a aVar = this.a;
        if (aVar != null) {
            aVar.a();
            this.f = true;
        }
    }

    public void a(android.content.Context context, java.util.List<java.lang.String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (java.lang.String str : list) {
            if (java.util.regex.Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", str)) {
                if (g(com.huawei.hms.framework.network.grs.h.c.a(com.huawei.hms.framework.network.grs.GrsApp.getInstance().getBrand(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + str, context)) == 0) {
                    com.huawei.hms.framework.common.Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, sucess.", str);
                } else {
                    com.huawei.hms.framework.common.Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, failure.", str);
                }
            }
        }
    }

    public void a(com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo) {
        this.c.put("no_route_country", "no-country");
        java.util.List<com.huawei.hms.framework.network.grs.local.model.b> list = this.b;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (com.huawei.hms.framework.network.grs.local.model.b bVar : this.b) {
            if (bVar.a().contains(grsBaseInfo.getIssueCountry())) {
                this.c.put(grsBaseInfo.getIssueCountry(), bVar.b());
            }
            if (bVar.a().contains(grsBaseInfo.getRegCountry())) {
                this.c.put(grsBaseInfo.getRegCountry(), bVar.b());
            }
            if (bVar.a().contains(grsBaseInfo.getSerCountry())) {
                this.c.put(grsBaseInfo.getSerCountry(), bVar.b());
            }
        }
        this.b = null;
    }

    public abstract int b(java.lang.String str);

    public com.huawei.hms.framework.network.grs.local.model.a b() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(org.json.JSONArray jSONArray) {
        java.util.List<com.huawei.hms.framework.network.grs.local.model.b> list;
        java.lang.String str;
        java.util.Iterator<java.lang.String> keys;
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
            com.huawei.hms.framework.network.grs.local.model.c cVar = new com.huawei.hms.framework.network.grs.local.model.c();
            java.lang.String string = jSONObject.getString("name");
            cVar.b(string);
            if (!this.g.contains(string)) {
                this.g.add(string);
                if (this.e) {
                    cVar.c(jSONObject.getString("routeBy"));
                    org.json.JSONArray jSONArray2 = jSONObject.getJSONArray("servings");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        org.json.JSONObject jSONObject2 = (org.json.JSONObject) jSONArray2.get(i2);
                        com.huawei.hms.framework.network.grs.local.model.d dVar = new com.huawei.hms.framework.network.grs.local.model.d();
                        java.lang.String str2 = "countryOrAreaGroup";
                        if (!jSONObject2.has("countryOrAreaGroup")) {
                            str2 = "countryGroup";
                            if (!jSONObject2.has("countryGroup")) {
                                com.huawei.hms.framework.common.Logger.v("AbstractLocalManager", "maybe this service{%s} routeBy is unconditional.", string);
                                str = "no-country";
                                dVar.a(str);
                                org.json.JSONObject jSONObject3 = jSONObject2.getJSONObject("addresses");
                                java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap(16);
                                keys = jSONObject3.keys();
                                while (keys.hasNext()) {
                                    java.lang.String next = keys.next();
                                    java.lang.String string2 = jSONObject3.getString(next);
                                    if (!android.text.TextUtils.isEmpty(next) && !android.text.TextUtils.isEmpty(string2)) {
                                        concurrentHashMap.put(next, jSONObject3.getString(next));
                                    }
                                }
                                dVar.a(concurrentHashMap);
                                cVar.a(dVar.b(), dVar);
                            }
                        }
                        str = jSONObject2.getString(str2);
                        dVar.a(str);
                        org.json.JSONObject jSONObject32 = jSONObject2.getJSONObject("addresses");
                        java.util.concurrent.ConcurrentHashMap concurrentHashMap2 = new java.util.concurrent.ConcurrentHashMap(16);
                        keys = jSONObject32.keys();
                        while (keys.hasNext()) {
                        }
                        dVar.a(concurrentHashMap2);
                        cVar.a(dVar.b(), dVar);
                    }
                    java.lang.String str3 = "countryOrAreaGroups";
                    if (!jSONObject.has("countryOrAreaGroups")) {
                        str3 = "countryGroups";
                        if (!jSONObject.has("countryGroups")) {
                            com.huawei.hms.framework.common.Logger.i("AbstractLocalManager", "service use default countryOrAreaGroup");
                            list = null;
                            cVar.a(list);
                            if (this.a == null) {
                                this.a = new com.huawei.hms.framework.network.grs.local.model.a();
                            }
                            this.a.a(string, cVar);
                        }
                    }
                    list = a(jSONObject.getJSONArray(str3));
                    cVar.a(list);
                    if (this.a == null) {
                    }
                    this.a.a(string, cVar);
                }
            }
        }
    }

    public int c(java.lang.String str) {
        org.json.JSONArray jSONArray;
        this.b = new java.util.ArrayList(16);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                com.huawei.hms.framework.common.Logger.e("AbstractLocalManager", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONArray = null;
            }
            if (jSONArray == null) {
                return -1;
            }
            this.b.addAll(a(jSONArray));
            return 0;
        } catch (org.json.JSONException e) {
            com.huawei.hms.framework.common.Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    public java.util.Set<java.lang.String> c() {
        return this.g;
    }

    public int d(java.lang.String str) {
        try {
            b(new org.json.JSONObject(str).getJSONArray("services"));
            return 0;
        } catch (org.json.JSONException e) {
            com.huawei.hms.framework.common.Logger.w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check! %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    public boolean d() {
        return this.f;
    }

    public abstract int e(java.lang.String str);

    public boolean e() {
        return this.d;
    }
}
