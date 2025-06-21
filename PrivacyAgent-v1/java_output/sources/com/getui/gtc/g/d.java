package com.getui.gtc.g;

/* loaded from: classes22.dex */
public final class d {
    public static com.getui.gtc.base.http.GtHttpClient a = new com.getui.gtc.base.http.GtHttpClient.Builder().addInterceptor(new com.getui.gtc.base.http.LoggerInterceptor(com.getui.gtc.h.c.a.C0329a.a.a)).addInterceptor(new com.getui.gtc.g.d.AnonymousClass1()).build();

    /* renamed from: com.getui.gtc.g.d$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.getui.gtc.base.http.Interceptor {
        @Override // com.getui.gtc.base.http.Interceptor
        public final com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException {
            if (com.getui.gtc.base.util.NetworkUtil.isNetWorkAvailable(com.getui.gtc.base.GtcProvider.context())) {
                return chain.proceed(chain.request());
            }
            throw new java.lang.IllegalStateException("network is not available");
        }
    }
}
