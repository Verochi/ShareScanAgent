package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class h0 implements javax.net.ssl.X509TrustManager {
    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        if (x509CertificateArr == null || x509CertificateArr.length != 2) {
            throw new java.security.cert.CertificateException("ca chain is illegal");
        }
        java.security.cert.X509Certificate f = com.zx.a.I8b7.i0.f();
        if (f == null) {
            throw new java.security.cert.CertificateException("getCurEnvCA is null");
        }
        if (!new java.math.BigInteger(1, f.getPublicKey().getEncoded()).toString(16).equals(new java.math.BigInteger(1, x509CertificateArr[1].getPublicKey().getEncoded()).toString(16))) {
            throw new java.security.cert.CertificateException("Trust anchor for certification illegal code: 10003");
        }
        try {
            x509CertificateArr[0].verify(f.getPublicKey());
            try {
                x509CertificateArr[0].checkValidity();
            } catch (java.lang.Exception unused) {
                throw new java.security.cert.CertificateException("Trust anchor for certification illegal code: 10005");
            }
        } catch (java.lang.Exception unused2) {
            throw new java.security.cert.CertificateException("Trust anchor for certification illegal code: 10004");
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return new java.security.cert.X509Certificate[0];
    }
}
