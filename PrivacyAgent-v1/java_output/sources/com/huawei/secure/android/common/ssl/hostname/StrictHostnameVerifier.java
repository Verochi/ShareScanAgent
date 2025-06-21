package com.huawei.secure.android.common.ssl.hostname;

/* loaded from: classes22.dex */
public class StrictHostnameVerifier implements javax.net.ssl.HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
        try {
            java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate) sSLSession.getPeerCertificates()[0];
            com.huawei.secure.android.common.ssl.util.g.a("", "verify: certificate is : " + x509Certificate.getSubjectDN().getName());
            com.huawei.secure.android.common.ssl.hostname.b.a(str, x509Certificate, true);
            return true;
        } catch (javax.net.ssl.SSLException e) {
            com.huawei.secure.android.common.ssl.util.g.b("", "SSLException : " + e.getMessage());
            return false;
        }
    }
}
