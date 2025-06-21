package com.alimm.tanx.core.net.okhttp.tanxc_if;

/* loaded from: classes.dex */
public class tanxc_if implements okhttp3.Interceptor {
    private static com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_if tanxc_do;
    private int tanxc_if;

    private tanxc_if() {
    }

    public static com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_if tanxc_do() {
        if (tanxc_do == null) {
            synchronized (com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_if.class) {
                if (tanxc_do == null) {
                    tanxc_do = new com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_if();
                }
            }
        }
        return tanxc_do;
    }

    @Override // okhttp3.Interceptor
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        okhttp3.Response proceed = chain.proceed(chain.request().newBuilder().build());
        int i = this.tanxc_if;
        if (i == 0) {
            return proceed.newBuilder().header("Cache-Control", "no-cache").removeHeader(com.google.common.net.HttpHeaders.PRAGMA).build();
        }
        okhttp3.Response build = proceed.newBuilder().header("Cache-Control", "public, max-age=" + i).removeHeader(com.google.common.net.HttpHeaders.PRAGMA).build();
        this.tanxc_if = 0;
        return build;
    }

    public void tanxc_do(int i) {
        this.tanxc_if = i;
    }
}
