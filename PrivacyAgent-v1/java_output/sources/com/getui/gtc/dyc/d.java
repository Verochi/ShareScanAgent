package com.getui.gtc.dyc;

/* loaded from: classes22.dex */
class d {
    static java.lang.String a = "MHwwDQYJKoZIhvcNAQEBBQADawAwaAJhAJp1rROuvBF7sBSnvLaesj2iFhMcY8aXyLvpnNLKs2wjL3JmEnyr++SlVa35liUlzi83tnAFkn3A9GB7pHBNzawyUkBh8WUhq5bnFIkk2RaDa6+5MpG84DEv52p7RR+aWwIDAQAB";
    static java.lang.String c = "69d747c4b9f641baf4004be4297e9f3b";
    static com.getui.gtc.base.http.GtHttpClient d = new com.getui.gtc.base.http.GtHttpClient.Builder().addInterceptor(new com.getui.gtc.base.http.LoggerInterceptor(com.getui.gtc.dyc.a.a.a.a())).addInterceptor(new com.getui.gtc.dyc.d.AnonymousClass1()).build();

    /* renamed from: com.getui.gtc.dyc.d$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.getui.gtc.base.http.Interceptor {
        @Override // com.getui.gtc.base.http.Interceptor
        public final com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException {
            if (com.getui.gtc.base.util.NetworkUtil.isNetWorkAvailable(com.getui.gtc.base.GtcProvider.context())) {
                return chain.proceed(chain.request());
            }
            throw new java.lang.IllegalStateException("network is not available");
        }
    }

    private java.lang.String c(com.getui.gtc.dyc.b.b bVar) throws java.lang.Exception {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("action", bVar.d());
        jSONObject.put("cid", bVar.e());
        jSONObject.put("appid", bVar.c());
        jSONObject.put("sdk_version", bVar.g());
        jSONObject.put("tag", bVar.f());
        return jSONObject.toString();
    }

    public com.getui.gtc.dyc.h a(com.getui.gtc.dyc.b.b bVar) throws java.lang.Exception {
        return a(bVar, d.newCall(new com.getui.gtc.base.http.Request.Builder().url(bVar.a()).method("POST").body(com.getui.gtc.base.http.RequestBody.create(com.getui.gtc.base.http.MediaType.parse("application/json; charset=utf-8"), c(bVar))).cryptInterceptor(new com.getui.gtc.base.http.crypt.GtRASCryptoInterceptor(c, a)).tag("sdk config" + bVar.g()).build()).execute());
    }

    public com.getui.gtc.dyc.h a(com.getui.gtc.dyc.b.b bVar, com.getui.gtc.base.http.Response response) throws java.lang.Exception {
        org.json.JSONObject jSONObject = new org.json.JSONObject(response.body().string());
        if (!"ok".equalsIgnoreCase(jSONObject.getString("result"))) {
            throw new java.lang.Exception(jSONObject.toString());
        }
        com.getui.gtc.dyc.h hVar = new com.getui.gtc.dyc.h();
        hVar.a(java.lang.System.currentTimeMillis());
        hVar.a(bVar.g());
        hVar.d(bVar.c());
        java.lang.String optString = jSONObject.optString("tag");
        if (!android.text.TextUtils.isEmpty(optString)) {
            hVar.c(optString);
        }
        org.json.JSONObject optJSONObject = jSONObject.optJSONObject("config");
        if (optJSONObject != null) {
            java.util.HashMap hashMap = new java.util.HashMap(optJSONObject.length());
            hVar.a(hashMap);
            java.util.Iterator<java.lang.String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                hashMap.put(next, optJSONObject.optString(next));
            }
        }
        return hVar;
    }
}
