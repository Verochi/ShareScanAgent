package com.igexin.push.g.a;

/* loaded from: classes23.dex */
public class c {
    public static com.getui.gtc.base.http.GtHttpClient a = new com.getui.gtc.base.http.GtHttpClient.Builder().addInterceptor(new com.getui.gtc.base.http.LoggerInterceptor(com.igexin.c.a.c.a.a().a)).addInterceptor(new com.igexin.push.g.a.c.AnonymousClass1()).build();
    private static java.lang.String b = "c";

    /* renamed from: com.igexin.push.g.a.c$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.getui.gtc.base.http.Interceptor {
        @Override // com.getui.gtc.base.http.Interceptor
        public final com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException {
            if (com.getui.gtc.base.GtcProvider.context() == null || com.getui.gtc.base.util.NetworkUtil.isNetWorkAvailable(com.getui.gtc.base.GtcProvider.context())) {
                return chain.proceed(chain.request());
            }
            throw new java.lang.IllegalStateException("network is not available");
        }
    }

    public static void a(java.lang.String str, byte[] bArr, com.getui.gtc.base.http.Call.Callback callback) {
        try {
            a.newCall(new com.getui.gtc.base.http.Request.Builder().url(str).method("POST").cryptInterceptor(new com.getui.gtc.base.http.crypt.GtRASCryptoInterceptor("69d747c4b9f641baf4004be4297e9f3b", "MHwwDQYJKoZIhvcNAQEBBQADawAwaAJhAJp1rROuvBF7sBSnvLaesj2iFhMcY8aXyLvpnNLKs2wjL3JmEnyr++SlVa35liUlzi83tnAFkn3A9GB7pHBNzawyUkBh8WUhq5bnFIkk2RaDa6+5MpG84DEv52p7RR+aWwIDAQAB")).body(com.getui.gtc.base.http.RequestBody.create(com.getui.gtc.base.http.MediaType.parse("application/json; charset=utf-8"), bArr)).build()).enqueue(callback);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }
}
