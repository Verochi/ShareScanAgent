package com.commonsware.cwac.netsecurity.config;

/* loaded from: classes22.dex */
public class RootTrustManager extends com.commonsware.cwac.netsecurity.luni.X509ExtendedTrustManager {
    private final com.commonsware.cwac.netsecurity.config.ApplicationConfig mConfig;

    public RootTrustManager(com.commonsware.cwac.netsecurity.config.ApplicationConfig applicationConfig) {
        if (applicationConfig == null) {
            throw new java.lang.NullPointerException("config must not be null");
        }
        this.mConfig = applicationConfig;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        this.mConfig.getConfigForHostname("").getTrustManager().checkClientTrusted(x509CertificateArr, str);
    }

    @Override // com.commonsware.cwac.netsecurity.luni.X509ExtendedTrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.net.Socket socket) throws java.security.cert.CertificateException {
        this.mConfig.getConfigForHostname("").getTrustManager().checkClientTrusted(x509CertificateArr, str, socket);
    }

    @Override // com.commonsware.cwac.netsecurity.luni.X509ExtendedTrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, javax.net.ssl.SSLEngine sSLEngine) throws java.security.cert.CertificateException {
        this.mConfig.getConfigForHostname("").getTrustManager().checkClientTrusted(x509CertificateArr, str, sSLEngine);
    }

    public java.util.List<java.security.cert.X509Certificate> checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.lang.String str2) throws java.security.cert.CertificateException {
        if (str2 == null && this.mConfig.hasPerDomainConfigs()) {
            throw new java.security.cert.CertificateException("Domain specific configurations require that the hostname be provided");
        }
        return this.mConfig.getConfigForHostname(str2).getTrustManager().checkServerTrusted(x509CertificateArr, str, str2);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        if (this.mConfig.hasPerDomainConfigs()) {
            throw new java.security.cert.CertificateException("Domain specific configurations require that hostname aware checkServerTrusted(X509Certificate[], String, String) is used");
        }
        this.mConfig.getConfigForHostname("").getTrustManager().checkServerTrusted(x509CertificateArr, str);
    }

    @Override // com.commonsware.cwac.netsecurity.luni.X509ExtendedTrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.net.Socket socket) throws java.security.cert.CertificateException {
        if (!(socket instanceof javax.net.ssl.SSLSocket)) {
            checkServerTrusted(x509CertificateArr, str);
            return;
        }
        javax.net.ssl.SSLSocket sSLSocket = (javax.net.ssl.SSLSocket) socket;
        javax.net.ssl.SSLSession sSLSession = null;
        try {
            java.lang.reflect.Method method = sSLSocket.getClass().getMethod("getHandshakeSession", new java.lang.Class[0]);
            if (method != null) {
                sSLSession = (javax.net.ssl.SSLSession) method.invoke(sSLSocket, new java.lang.Object[0]);
            }
        } catch (java.lang.Exception unused) {
        }
        if (sSLSession == null) {
            throw new java.security.cert.CertificateException("Not in handshake; no session available");
        }
        this.mConfig.getConfigForHostname(sSLSession.getPeerHost()).getTrustManager().checkServerTrusted(x509CertificateArr, str, socket);
    }

    @Override // com.commonsware.cwac.netsecurity.luni.X509ExtendedTrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, javax.net.ssl.SSLEngine sSLEngine) throws java.security.cert.CertificateException {
        javax.net.ssl.SSLSession sSLSession = null;
        try {
            java.lang.reflect.Method method = sSLEngine.getClass().getMethod("getHandshakeSession", new java.lang.Class[0]);
            if (method != null) {
                sSLSession = (javax.net.ssl.SSLSession) method.invoke(sSLEngine, new java.lang.Object[0]);
            }
        } catch (java.lang.Exception unused) {
        }
        if (sSLSession == null) {
            throw new java.security.cert.CertificateException("Not in handshake; no session available");
        }
        this.mConfig.getConfigForHostname(sSLSession.getPeerHost()).getTrustManager().checkServerTrusted(x509CertificateArr, str, sSLEngine);
    }

    @Override // javax.net.ssl.X509TrustManager
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return this.mConfig.getConfigForHostname("").getTrustManager().getAcceptedIssuers();
    }

    public boolean isSameTrustConfiguration(java.lang.String str, java.lang.String str2) {
        return this.mConfig.getConfigForHostname(str).equals(this.mConfig.getConfigForHostname(str2));
    }
}
