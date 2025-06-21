package com.commonsware.cwac.netsecurity.luni;

/* loaded from: classes22.dex */
public abstract class X509ExtendedTrustManager implements javax.net.ssl.X509TrustManager {
    public abstract void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.net.Socket socket) throws java.security.cert.CertificateException;

    public abstract void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, javax.net.ssl.SSLEngine sSLEngine) throws java.security.cert.CertificateException;

    public abstract void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.net.Socket socket) throws java.security.cert.CertificateException;

    public abstract void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, javax.net.ssl.SSLEngine sSLEngine) throws java.security.cert.CertificateException;
}
