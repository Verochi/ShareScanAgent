package com.huawei.secure.android.common.ssl;

/* loaded from: classes22.dex */
public class WebViewSSLCheck {
    public static final java.lang.String a = "WebViewSSLCheck";

    public static void checkServerCertificateNew(android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError, android.content.Context context) {
        checkServerCertificateNew(sslErrorHandler, sslError, null, context, null);
    }

    public static void checkServerCertificateNew(android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError, java.lang.String str, android.content.Context context, com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.Callback callback) {
        java.lang.String str2 = a;
        com.huawei.secure.android.common.ssl.util.g.c(str2, " error type : " + sslError.getPrimaryError() + " , cn is : " + sslError.getCertificate().getIssuedTo().getCName());
        java.security.cert.X509Certificate a2 = com.huawei.secure.android.common.ssl.util.b.a(sslError.getCertificate());
        java.security.cert.X509Certificate a3 = new com.huawei.secure.android.common.ssl.util.j(context).a();
        com.huawei.secure.android.common.ssl.util.g.a(str2, "checkServerCertificateNew: error certificate is : " + a2);
        if (com.huawei.secure.android.common.ssl.util.b.a(a3, a2)) {
            com.huawei.secure.android.common.ssl.util.g.c(str2, "checkServerCertificateNew: proceed");
            if (callback != null) {
                callback.onProceed(context, str);
                return;
            } else {
                sslErrorHandler.proceed();
                return;
            }
        }
        com.huawei.secure.android.common.ssl.util.g.b(str2, "checkServerCertificateNew: cancel");
        if (callback != null) {
            callback.onCancel(context, str);
        } else {
            sslErrorHandler.cancel();
        }
    }

    public static boolean checkServerCertificateNew(java.lang.String str, android.net.http.SslError sslError) {
        return checkServerCertificateNew(com.huawei.secure.android.common.ssl.util.b.a(str), sslError);
    }

    public static boolean checkServerCertificateNew(java.security.cert.X509Certificate x509Certificate, android.net.http.SslError sslError) {
        return com.huawei.secure.android.common.ssl.util.b.a(x509Certificate, com.huawei.secure.android.common.ssl.util.b.a(sslError.getCertificate()));
    }
}
