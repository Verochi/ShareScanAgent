package com.huawei.hms.framework.network.grs;

/* loaded from: classes22.dex */
public class a {
    private static final java.lang.String e = "a";
    private final com.huawei.hms.framework.network.grs.GrsBaseInfo a;
    private com.huawei.hms.framework.network.grs.e.a b;
    private com.huawei.hms.framework.network.grs.g.h c;
    private com.huawei.hms.framework.network.grs.e.c d;

    /* renamed from: com.huawei.hms.framework.network.grs.a$a, reason: collision with other inner class name */
    public static class C0363a implements com.huawei.hms.framework.network.grs.b {
        java.lang.String a;
        java.util.Map<java.lang.String, java.lang.String> b;
        com.huawei.hms.framework.network.grs.IQueryUrlsCallBack c;
        android.content.Context d;
        com.huawei.hms.framework.network.grs.GrsBaseInfo e;
        com.huawei.hms.framework.network.grs.e.a f;

        public C0363a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, com.huawei.hms.framework.network.grs.IQueryUrlsCallBack iQueryUrlsCallBack, android.content.Context context, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.a = str;
            this.b = map;
            this.c = iQueryUrlsCallBack;
            this.d = context;
            this.e = grsBaseInfo;
            this.f = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            java.util.Map<java.lang.String, java.lang.String> map = this.b;
            if (map != null && !map.isEmpty()) {
                com.huawei.hms.framework.common.Logger.i(com.huawei.hms.framework.network.grs.a.e, "get expired cache localUrls");
                this.c.onCallBackSuccess(this.b);
            } else {
                if (this.b != null) {
                    this.c.onCallBackFail(-3);
                    return;
                }
                com.huawei.hms.framework.common.Logger.i(com.huawei.hms.framework.network.grs.a.e, "access local config for return a domain.");
                this.c.onCallBackSuccess(com.huawei.hms.framework.network.grs.f.b.a(this.d.getPackageName(), this.e).a(this.d, this.f, this.e, this.a, true));
            }
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            java.util.Map<java.lang.String, java.lang.String> a = com.huawei.hms.framework.network.grs.a.a(dVar.j(), this.a);
            if (a.isEmpty()) {
                java.util.Map<java.lang.String, java.lang.String> map = this.b;
                if (map != null && !map.isEmpty()) {
                    com.huawei.hms.framework.common.Logger.i(com.huawei.hms.framework.network.grs.a.e, "get expired cache localUrls");
                    this.c.onCallBackSuccess(this.b);
                    return;
                } else if (this.b != null) {
                    this.c.onCallBackFail(-5);
                    return;
                } else {
                    com.huawei.hms.framework.common.Logger.i(com.huawei.hms.framework.network.grs.a.e, "access local config for return a domain.");
                    a = com.huawei.hms.framework.network.grs.f.b.a(this.d.getPackageName(), this.e).a(this.d, this.f, this.e, this.a, true);
                }
            } else {
                com.huawei.hms.framework.common.Logger.i(com.huawei.hms.framework.network.grs.a.e, "get url is from remote server");
            }
            this.c.onCallBackSuccess(a);
        }
    }

    public static class b implements com.huawei.hms.framework.network.grs.b {
        java.lang.String a;
        java.lang.String b;
        com.huawei.hms.framework.network.grs.IQueryUrlCallBack c;
        java.lang.String d;
        android.content.Context e;
        com.huawei.hms.framework.network.grs.GrsBaseInfo f;
        com.huawei.hms.framework.network.grs.e.a g;

        public b(java.lang.String str, java.lang.String str2, com.huawei.hms.framework.network.grs.IQueryUrlCallBack iQueryUrlCallBack, java.lang.String str3, android.content.Context context, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.a = str;
            this.b = str2;
            this.c = iQueryUrlCallBack;
            this.d = str3;
            this.e = context;
            this.f = grsBaseInfo;
            this.g = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            if (!android.text.TextUtils.isEmpty(this.d)) {
                com.huawei.hms.framework.common.Logger.i(com.huawei.hms.framework.network.grs.a.e, "get expired cache localUrl");
                this.c.onCallBackSuccess(this.d);
            } else {
                if (!android.text.TextUtils.isEmpty(this.d)) {
                    this.c.onCallBackFail(-3);
                    return;
                }
                com.huawei.hms.framework.common.Logger.i(com.huawei.hms.framework.network.grs.a.e, "access local config for return a domain.");
                this.c.onCallBackSuccess(com.huawei.hms.framework.network.grs.f.b.a(this.e.getPackageName(), this.f).a(this.e, this.g, this.f, this.a, this.b, true));
            }
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            java.lang.String a;
            com.huawei.hms.framework.network.grs.IQueryUrlCallBack iQueryUrlCallBack;
            java.util.Map<java.lang.String, java.lang.String> a2 = com.huawei.hms.framework.network.grs.a.a(dVar.j(), this.a);
            if (a2.containsKey(this.b)) {
                com.huawei.hms.framework.common.Logger.i(com.huawei.hms.framework.network.grs.a.e, "get url is from remote server");
                iQueryUrlCallBack = this.c;
                a = a2.get(this.b);
            } else if (!android.text.TextUtils.isEmpty(this.d)) {
                com.huawei.hms.framework.common.Logger.i(com.huawei.hms.framework.network.grs.a.e, "get expired cache localUrl");
                this.c.onCallBackSuccess(this.d);
                return;
            } else if (!android.text.TextUtils.isEmpty(this.d)) {
                this.c.onCallBackFail(-5);
                return;
            } else {
                com.huawei.hms.framework.common.Logger.i(com.huawei.hms.framework.network.grs.a.e, "access local config for return a domain.");
                a = com.huawei.hms.framework.network.grs.f.b.a(this.e.getPackageName(), this.f).a(this.e, this.g, this.f, this.a, this.b, true);
                iQueryUrlCallBack = this.c;
            }
            iQueryUrlCallBack.onCallBackSuccess(a);
        }
    }

    public a(com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar, com.huawei.hms.framework.network.grs.g.h hVar, com.huawei.hms.framework.network.grs.e.c cVar) {
        this.a = grsBaseInfo;
        this.b = aVar;
        this.c = hVar;
        this.d = cVar;
    }

    public static com.huawei.hms.framework.network.grs.local.model.CountryCodeBean a(android.content.Context context, boolean z) {
        return new com.huawei.hms.framework.network.grs.local.model.CountryCodeBean(context, z);
    }

    public static java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> a(java.lang.String str) {
        java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap(16);
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.hms.framework.common.Logger.v(e, "isSpExpire jsonValue is null.");
            return concurrentHashMap;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (!android.text.TextUtils.isEmpty(next)) {
                    concurrentHashMap.put(next, a(jSONObject2));
                }
            }
            return concurrentHashMap;
        } catch (org.json.JSONException e2) {
            com.huawei.hms.framework.common.Logger.w(e, "getServicesUrlsMap occur a JSONException: %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e2.getMessage()));
            return concurrentHashMap;
        }
    }

    private java.util.Map<java.lang.String, java.lang.String> a(java.lang.String str, com.huawei.hms.framework.network.grs.e.b bVar, android.content.Context context) {
        java.util.Map<java.lang.String, java.lang.String> a = this.b.a(this.a, str, bVar, context);
        if (a == null || a.isEmpty()) {
            java.util.Map<java.lang.String, java.lang.String> a2 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName(), this.a).a(context, this.b, this.a, str, false);
            return a2 != null ? a2 : new java.util.HashMap();
        }
        com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
        return a;
    }

    public static java.util.Map<java.lang.String, java.lang.String> a(java.lang.String str, java.lang.String str2) {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.hms.framework.common.Logger.w(e, "isSpExpire jsonValue from server is null.");
            return hashMap;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            org.json.JSONObject jSONObject2 = jSONObject.has(str2) ? jSONObject.getJSONObject(str2) : null;
            if (jSONObject2 == null) {
                com.huawei.hms.framework.common.Logger.w(e, "getServiceNameUrls: paser null from server json data by {%s}.", str2);
                return hashMap;
            }
            java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                hashMap.put(next, jSONObject2.get(next).toString());
            }
            return hashMap;
        } catch (org.json.JSONException e2) {
            com.huawei.hms.framework.common.Logger.w(e, "Method{getServiceNameUrls} query url from SP occur an JSONException: %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e2.getMessage()));
            return hashMap;
        }
    }

    public static java.util.Map<java.lang.String, java.lang.String> a(org.json.JSONObject jSONObject) {
        java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap(16);
        try {
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                java.lang.String obj = jSONObject.get(next).toString();
                if (!android.text.TextUtils.isEmpty(next) && !android.text.TextUtils.isEmpty(obj)) {
                    concurrentHashMap.put(next, obj);
                }
            }
            return concurrentHashMap;
        } catch (org.json.JSONException e2) {
            com.huawei.hms.framework.common.Logger.w(e, "getServiceUrls occur a JSONException: %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e2.getMessage()));
            return concurrentHashMap;
        }
    }

    public java.lang.String a(android.content.Context context, java.lang.String str) {
        com.huawei.hms.framework.network.grs.g.d a = this.c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.a, context), str, this.d);
        return a == null ? "" : a.m() ? this.b.a().a(this.a.getGrsParasKey(true, true, context), "") : a.j();
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2, android.content.Context context) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        java.lang.String str3 = a(str, bVar, context).get(str2);
        if (bVar.a() && !android.text.TextUtils.isEmpty(str3)) {
            com.huawei.hms.framework.common.Logger.i(e, "get unexpired cache localUrl: %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(str3));
            com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
            return str3;
        }
        java.lang.String str4 = a(a(context, str), str).get(str2);
        if (!android.text.TextUtils.isEmpty(str4)) {
            com.huawei.hms.framework.common.Logger.i(e, "get url is from remote server");
            com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
            return str4;
        }
        if (android.text.TextUtils.isEmpty(str3)) {
            com.huawei.hms.framework.common.Logger.i(e, "access local config for return a domain.");
            str3 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName(), this.a).a(context, this.b, this.a, str, str2, true);
        } else {
            com.huawei.hms.framework.common.Logger.i(e, "get expired cache localUrl");
        }
        com.huawei.hms.framework.common.Logger.i(e, "synGetGrsUrl: %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(str3));
        return str3;
    }

    public java.util.Map<java.lang.String, java.lang.String> a(java.lang.String str, android.content.Context context) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        java.util.Map<java.lang.String, java.lang.String> a = a(str, bVar, context);
        if (bVar.a() && !a.isEmpty()) {
            com.huawei.hms.framework.common.Logger.i(e, "get unexpired cache localUrls: %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(new org.json.JSONObject(a).toString()));
            com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
            return a;
        }
        java.util.Map<java.lang.String, java.lang.String> a2 = a(a(context, str), str);
        if (!a2.isEmpty()) {
            com.huawei.hms.framework.common.Logger.i(e, "get url is from remote server");
            com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
            return a2;
        }
        if (a.isEmpty()) {
            com.huawei.hms.framework.common.Logger.i(e, "access local config for return a domain.");
            a = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName(), this.a).a(context, this.b, this.a, str, true);
        } else {
            com.huawei.hms.framework.common.Logger.i(e, "get expired cache localUrls");
        }
        java.lang.String str2 = e;
        java.lang.Object[] objArr = new java.lang.Object[1];
        objArr[0] = com.huawei.hms.framework.common.StringUtils.anonymizeMessage(a != null ? new org.json.JSONObject(a).toString() : "");
        com.huawei.hms.framework.common.Logger.i(str2, "synGetGrsUrls: %s", objArr);
        return a;
    }

    public void a(java.lang.String str, com.huawei.hms.framework.network.grs.IQueryUrlsCallBack iQueryUrlsCallBack, android.content.Context context) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        java.util.Map<java.lang.String, java.lang.String> a = a(str, bVar, context);
        if (!bVar.a()) {
            this.c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.a, context), new com.huawei.hms.framework.network.grs.a.C0363a(str, a, iQueryUrlsCallBack, context, this.a, this.b), str, this.d);
            return;
        }
        java.lang.String str2 = e;
        com.huawei.hms.framework.common.Logger.i(str2, "get unexpired cache localUrls");
        if (a.isEmpty()) {
            iQueryUrlsCallBack.onCallBackFail(-5);
            return;
        }
        com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
        com.huawei.hms.framework.common.Logger.i(str2, "ayncGetGrsUrls: %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(new org.json.JSONObject(a).toString()));
        iQueryUrlsCallBack.onCallBackSuccess(a);
    }

    public void a(java.lang.String str, java.lang.String str2, com.huawei.hms.framework.network.grs.IQueryUrlCallBack iQueryUrlCallBack, android.content.Context context) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        java.lang.String str3 = a(str, bVar, context).get(str2);
        if (!bVar.a()) {
            this.c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.a, context), new com.huawei.hms.framework.network.grs.a.b(str, str2, iQueryUrlCallBack, str3, context, this.a, this.b), str, this.d);
            return;
        }
        java.lang.String str4 = e;
        com.huawei.hms.framework.common.Logger.i(str4, "get unexpired cache localUrl");
        if (android.text.TextUtils.isEmpty(str3)) {
            iQueryUrlCallBack.onCallBackFail(-5);
            return;
        }
        com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
        com.huawei.hms.framework.common.Logger.i(str4, "ayncGetGrsUrl: %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(str3));
        iQueryUrlCallBack.onCallBackSuccess(str3);
    }
}
