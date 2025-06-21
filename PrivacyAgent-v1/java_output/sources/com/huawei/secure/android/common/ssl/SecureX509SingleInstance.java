package com.huawei.secure.android.common.ssl;

/* loaded from: classes22.dex */
public class SecureX509SingleInstance {
    public static final java.lang.String a = "SecureX509SingleInstance";
    public static volatile com.huawei.secure.android.common.ssl.SecureX509TrustManager b;

    @android.annotation.SuppressLint({"NewApi"})
    public static com.huawei.secure.android.common.ssl.SecureX509TrustManager getInstance(android.content.Context context) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.security.KeyStoreException, java.io.IOException {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (context == null) {
            throw new java.lang.NullPointerException(com.anythink.expressad.foundation.g.b.b.a);
        }
        com.huawei.secure.android.common.ssl.util.c.a(context);
        if (b == null) {
            synchronized (com.huawei.secure.android.common.ssl.SecureX509SingleInstance.class) {
                if (b == null) {
                    java.io.InputStream filesBksIS = com.huawei.secure.android.common.ssl.util.BksUtil.getFilesBksIS(context);
                    if (filesBksIS == null) {
                        com.huawei.secure.android.common.ssl.util.g.c(a, "get assets bks");
                        filesBksIS = context.getAssets().open("hmsrootcas.bks");
                    } else {
                        com.huawei.secure.android.common.ssl.util.g.c(a, "get files bks");
                    }
                    b = new com.huawei.secure.android.common.ssl.SecureX509TrustManager(filesBksIS, "");
                    new com.huawei.secure.android.common.ssl.util.d().executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, context);
                }
            }
        }
        com.huawei.secure.android.common.ssl.util.g.a(a, "SecureX509TrustManager getInstance: cost : " + (java.lang.System.currentTimeMillis() - currentTimeMillis) + " ms");
        return b;
    }

    public static void updateBks(java.io.InputStream inputStream) {
        java.lang.String str = a;
        com.huawei.secure.android.common.ssl.util.g.c(str, "update bks");
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (inputStream != null && b != null) {
            b = new com.huawei.secure.android.common.ssl.SecureX509TrustManager(inputStream, "");
            com.huawei.secure.android.common.ssl.SecureSSLSocketFactory.b(b);
            com.huawei.secure.android.common.ssl.SecureApacheSSLSocketFactory.b(b);
        }
        com.huawei.secure.android.common.ssl.util.g.c(str, "SecureX509TrustManager update bks cost : " + (java.lang.System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
