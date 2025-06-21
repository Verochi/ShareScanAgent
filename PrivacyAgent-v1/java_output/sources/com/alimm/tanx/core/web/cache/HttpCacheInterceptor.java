package com.alimm.tanx.core.web.cache;

/* loaded from: classes.dex */
public class HttpCacheInterceptor implements okhttp3.Interceptor {
    @Override // okhttp3.Interceptor
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        okhttp3.Request request = chain.request();
        java.lang.String header = request.header(com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.KEY_CACHE);
        okhttp3.Response proceed = chain.proceed(request);
        try {
            if (!android.text.TextUtils.isEmpty(header)) {
                if (header.equals(com.alimm.tanx.core.web.cache.CacheType.NORMAL.ordinal() + "")) {
                    return proceed;
                }
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
        return proceed.newBuilder().removeHeader("pragma").removeHeader("Cache-Control").header("Cache-Control", "max-age=3153600000").build();
    }
}
