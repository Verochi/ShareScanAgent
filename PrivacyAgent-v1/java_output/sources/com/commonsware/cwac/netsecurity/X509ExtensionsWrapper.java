package com.commonsware.cwac.netsecurity;

/* loaded from: classes22.dex */
public class X509ExtensionsWrapper implements com.commonsware.cwac.netsecurity.X509Extensions {
    private static final java.lang.String ERROR_CONTRACT = "Supplied X509TrustManager does not implement X509Extensions contract";
    private final java.lang.reflect.Method checkServerTrustedMethod;
    private java.lang.reflect.Method isUserAddedCertificateMethod;
    private final javax.net.ssl.X509TrustManager tm;

    public X509ExtensionsWrapper(javax.net.ssl.X509TrustManager x509TrustManager) throws java.lang.IllegalArgumentException {
        this.tm = x509TrustManager;
        try {
            this.checkServerTrustedMethod = x509TrustManager.getClass().getMethod("checkServerTrusted", java.security.cert.X509Certificate[].class, java.lang.String.class, java.lang.String.class);
            try {
                this.isUserAddedCertificateMethod = x509TrustManager.getClass().getMethod("isUserAddedCertificate", java.security.cert.X509Certificate.class);
            } catch (java.lang.NoSuchMethodException unused) {
            }
        } catch (java.lang.NoSuchMethodException unused2) {
            throw new java.lang.IllegalArgumentException(ERROR_CONTRACT);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        this.tm.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // com.commonsware.cwac.netsecurity.X509Extensions
    public java.util.List<java.security.cert.X509Certificate> checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.lang.String str2) throws java.security.cert.CertificateException {
        try {
            return (java.util.List) this.checkServerTrustedMethod.invoke(this.tm, x509CertificateArr, str, str2);
        } catch (java.lang.IllegalAccessException e) {
            throw new java.security.cert.CertificateException(ERROR_CONTRACT, e);
        } catch (java.lang.reflect.InvocationTargetException e2) {
            if (e2.getCause() instanceof java.security.cert.CertificateException) {
                throw ((java.security.cert.CertificateException) e2.getCause());
            }
            if (e2.getCause() instanceof java.lang.RuntimeException) {
                throw ((java.lang.RuntimeException) e2.getCause());
            }
            throw new java.security.cert.CertificateException("checkServerTrusted() failure", e2.getCause());
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        this.tm.checkServerTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return this.tm.getAcceptedIssuers();
    }

    @Override // com.commonsware.cwac.netsecurity.X509Extensions
    public boolean isUserAddedCertificate(java.security.cert.X509Certificate x509Certificate) {
        java.lang.reflect.Method method = this.isUserAddedCertificateMethod;
        if (method == null) {
            return false;
        }
        try {
            return ((java.lang.Boolean) method.invoke(this.tm, x509Certificate)).booleanValue();
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.RuntimeException(ERROR_CONTRACT, e);
        } catch (java.lang.reflect.InvocationTargetException e2) {
            if (e2.getCause() instanceof java.lang.RuntimeException) {
                throw ((java.lang.RuntimeException) e2.getCause());
            }
            throw new java.lang.RuntimeException("isUserAddedCertificat() failure", e2.getCause());
        }
    }
}
