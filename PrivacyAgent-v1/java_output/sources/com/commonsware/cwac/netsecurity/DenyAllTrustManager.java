package com.commonsware.cwac.netsecurity;

/* loaded from: classes22.dex */
public class DenyAllTrustManager implements com.commonsware.cwac.netsecurity.X509Extensions {
    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        throw new java.security.cert.CertificateException();
    }

    @Override // com.commonsware.cwac.netsecurity.X509Extensions
    public java.util.List<java.security.cert.X509Certificate> checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.lang.String str2) throws java.security.cert.CertificateException {
        throw new java.security.cert.CertificateException();
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        throw new java.security.cert.CertificateException();
    }

    @Override // javax.net.ssl.X509TrustManager
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return new java.security.cert.X509Certificate[0];
    }

    @Override // com.commonsware.cwac.netsecurity.X509Extensions
    public boolean isUserAddedCertificate(java.security.cert.X509Certificate x509Certificate) {
        return false;
    }
}
