package com.alimm.tanx.core.net.okhttp;

/* loaded from: classes.dex */
public class tanxc_do {
    private static com.alimm.tanx.core.net.okhttp.tanxc_do tanxc_do;
    private static com.alimm.tanx.core.net.okhttp.tanxc_do tanxc_if;
    private okhttp3.OkHttpClient tanxc_for;
    private okhttp3.OkHttpClient tanxc_int;
    private final java.util.ArrayList<java.lang.String> tanxc_try = new java.util.ArrayList<>();
    private final android.os.Handler tanxc_new = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do$1, reason: invalid class name */
    public class AnonymousClass1 implements javax.net.ssl.HostnameVerifier {
        public AnonymousClass1() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
            return true;
        }
    }

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do$2, reason: invalid class name */
    public class AnonymousClass2 implements javax.net.ssl.HostnameVerifier {
        public AnonymousClass2() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
            return true;
        }
    }

    private tanxc_do(boolean z) {
        okhttp3.Cache cache = new okhttp3.Cache(new java.io.File(com.alimm.tanx.core.utils.FileUtils.getExternalDir(com.alimm.tanx.core.TanxCoreSdk.getApplication(), 0).getPath() + "/okhttp_cache/"), 52428800L);
        if (z) {
            okhttp3.OkHttpClient.Builder hostnameVerifier = new okhttp3.OkHttpClient.Builder().cache(cache).hostnameVerifier(new com.alimm.tanx.core.net.okhttp.tanxc_do.AnonymousClass1());
            java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.SECONDS;
            this.tanxc_int = hostnameVerifier.connectTimeout(10L, timeUnit).readTimeout(10L, timeUnit).writeTimeout(10L, timeUnit).addInterceptor(com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_for.tanxc_do()).addNetworkInterceptor(com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_if.tanxc_do()).addInterceptor(new com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_do()).build();
        } else {
            okhttp3.OkHttpClient.Builder hostnameVerifier2 = new okhttp3.OkHttpClient.Builder().cache(cache).hostnameVerifier(new com.alimm.tanx.core.net.okhttp.tanxc_do.AnonymousClass2());
            java.util.concurrent.TimeUnit timeUnit2 = java.util.concurrent.TimeUnit.SECONDS;
            this.tanxc_for = hostnameVerifier2.connectTimeout(10L, timeUnit2).readTimeout(10L, timeUnit2).writeTimeout(10L, timeUnit2).addInterceptor(com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_for.tanxc_do()).addNetworkInterceptor(com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_if.tanxc_do()).build();
        }
    }

    public static com.alimm.tanx.core.net.okhttp.tanxc_do tanxc_do() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (tanxc_do == null) {
            synchronized (com.alimm.tanx.core.net.okhttp.tanxc_do.class) {
                if (tanxc_do == null) {
                    tanxc_do = new com.alimm.tanx.core.net.okhttp.tanxc_do(false);
                    com.alimm.tanx.core.utils.LogUtils.d("splashTimeConsuming", "new OkHttpUtil ->" + (java.lang.System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
        return tanxc_do;
    }

    public static com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for tanxc_if(boolean z) {
        return new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for(z);
    }

    public static com.alimm.tanx.core.net.okhttp.tanxc_do tanxc_if() {
        if (tanxc_if == null) {
            synchronized (com.alimm.tanx.core.net.okhttp.tanxc_do.class) {
                if (tanxc_if == null) {
                    tanxc_if = new com.alimm.tanx.core.net.okhttp.tanxc_do(true);
                }
            }
        }
        return tanxc_if;
    }

    public static com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if tanxc_new() {
        return new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if();
    }

    public static com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do tanxc_try() {
        return new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do();
    }

    public okhttp3.OkHttpClient tanxc_do(boolean z) {
        return z ? this.tanxc_int : this.tanxc_for;
    }

    public void tanxc_do(java.lang.String str) {
        okhttp3.Dispatcher dispatcher = this.tanxc_for.dispatcher();
        synchronized (dispatcher) {
            for (okhttp3.Call call : dispatcher.queuedCalls()) {
                if (str.equals(call.request().tag())) {
                    call.cancel();
                }
            }
            for (okhttp3.Call call2 : dispatcher.runningCalls()) {
                if (str.equals(call2.request().tag())) {
                    call2.cancel();
                }
            }
        }
    }

    public android.os.Handler tanxc_for() {
        return this.tanxc_new;
    }

    public java.util.ArrayList<java.lang.String> tanxc_int() {
        return this.tanxc_try;
    }
}
