package com.alimm.tanx.core.net.okhttp.tanxc_if;

/* loaded from: classes.dex */
public class tanxc_for implements okhttp3.Interceptor {
    private static com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_for tanxc_do;
    private int tanxc_if;

    private tanxc_for() {
    }

    public static com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_for tanxc_do() {
        if (tanxc_do == null) {
            synchronized (com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_for.class) {
                if (tanxc_do == null) {
                    tanxc_do = new com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_for();
                }
            }
        }
        return tanxc_do;
    }

    @Override // okhttp3.Interceptor
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        com.alimm.tanx.core.utils.LogUtils.d("OfflineCacheInterceptor", com.anythink.expressad.foundation.d.c.bT);
        okhttp3.Request request = chain.request();
        if (!com.alimm.tanx.core.utils.NetWorkUtil.isNetworkConnected(com.alimm.tanx.core.TanxCoreManager.getInstance().getAppContext())) {
            com.alimm.tanx.core.utils.LogUtils.d("OfflineCacheInterceptor", "没网络 offlineCacheTime：" + this.tanxc_if);
            int i = this.tanxc_if;
            if (i != 0) {
                request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + i).build();
                this.tanxc_if = 0;
            } else {
                request = request.newBuilder().header("Cache-Control", "no-cache").build();
            }
        }
        java.lang.String str = "return 前：";
        try {
            str = "return 前：" + request.url().host() + request.url().url().getFile();
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("OfflineCacheInterceptor", e);
        }
        com.alimm.tanx.core.utils.LogUtils.d("OfflineCacheInterceptor", str);
        return chain.proceed(request);
    }

    public void tanxc_do(int i) {
        this.tanxc_if = i;
    }
}
