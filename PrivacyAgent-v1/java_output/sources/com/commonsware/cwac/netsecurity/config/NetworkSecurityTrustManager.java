package com.commonsware.cwac.netsecurity.config;

/* loaded from: classes22.dex */
public class NetworkSecurityTrustManager extends com.commonsware.cwac.netsecurity.luni.X509ExtendedTrustManager {
    private final com.commonsware.cwac.netsecurity.conscrypt.TrustManagerImpl mDelegate;
    private java.security.cert.X509Certificate[] mIssuers;
    private final java.lang.Object mIssuersLock = new java.lang.Object();
    private final com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig mNetworkSecurityConfig;

    public NetworkSecurityTrustManager(com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig networkSecurityConfig) {
        if (networkSecurityConfig == null) {
            throw new java.lang.NullPointerException("config must not be null");
        }
        this.mNetworkSecurityConfig = networkSecurityConfig;
        try {
            com.commonsware.cwac.netsecurity.config.TrustedCertificateStoreAdapter trustedCertificateStoreAdapter = new com.commonsware.cwac.netsecurity.config.TrustedCertificateStoreAdapter(networkSecurityConfig);
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance(java.security.KeyStore.getDefaultType());
            keyStore.load(null);
            this.mDelegate = new com.commonsware.cwac.netsecurity.conscrypt.TrustManagerImpl(keyStore, null, trustedCertificateStoreAdapter);
        } catch (java.io.IOException | java.security.GeneralSecurityException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    private void checkPins(java.util.List<java.security.cert.X509Certificate> list) throws java.security.cert.CertificateException {
        com.commonsware.cwac.netsecurity.config.PinSet pins = this.mNetworkSecurityConfig.getPins();
        if (pins.pins.isEmpty() || java.lang.System.currentTimeMillis() > pins.expirationTime || !isPinningEnforced(list)) {
            return;
        }
        java.util.Set<java.lang.String> pinAlgorithms = pins.getPinAlgorithms();
        java.util.HashMap hashMap = new java.util.HashMap(pinAlgorithms.size());
        for (int size = list.size() - 1; size >= 0; size--) {
            byte[] encoded = list.get(size).getPublicKey().getEncoded();
            for (java.lang.String str : pinAlgorithms) {
                java.security.MessageDigest messageDigest = (java.security.MessageDigest) hashMap.get(str);
                if (messageDigest == null) {
                    try {
                        messageDigest = java.security.MessageDigest.getInstance(str);
                        hashMap.put(str, messageDigest);
                    } catch (java.security.GeneralSecurityException e) {
                        throw new java.lang.RuntimeException(e);
                    }
                }
                if (pins.pins.contains(new com.commonsware.cwac.netsecurity.config.Pin(str, messageDigest.digest(encoded)))) {
                    return;
                }
            }
        }
        throw new java.security.cert.CertificateException("Pin verification failed");
    }

    private boolean isPinningEnforced(java.util.List<java.security.cert.X509Certificate> list) throws java.security.cert.CertificateException {
        if (list.isEmpty()) {
            return false;
        }
        if (this.mNetworkSecurityConfig.findTrustAnchorBySubjectAndPublicKey(list.get(list.size() - 1)) != null) {
            return !r2.overridesPins;
        }
        throw new java.security.cert.CertificateException("Trusted chain does not end in a TrustAnchor");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        this.mDelegate.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // com.commonsware.cwac.netsecurity.luni.X509ExtendedTrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.net.Socket socket) throws java.security.cert.CertificateException {
        this.mDelegate.checkClientTrusted(x509CertificateArr, str, socket);
    }

    @Override // com.commonsware.cwac.netsecurity.luni.X509ExtendedTrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, javax.net.ssl.SSLEngine sSLEngine) throws java.security.cert.CertificateException {
        this.mDelegate.checkClientTrusted(x509CertificateArr, str, sSLEngine);
    }

    public java.util.List<java.security.cert.X509Certificate> checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.lang.String str2) throws java.security.cert.CertificateException {
        java.util.List<java.security.cert.X509Certificate> checkServerTrusted = this.mDelegate.checkServerTrusted(x509CertificateArr, str, str2);
        checkPins(checkServerTrusted);
        return checkServerTrusted;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        checkServerTrusted(x509CertificateArr, str, (java.lang.String) null);
    }

    @Override // com.commonsware.cwac.netsecurity.luni.X509ExtendedTrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.net.Socket socket) throws java.security.cert.CertificateException {
        checkPins(this.mDelegate.getTrustedChainForServer(x509CertificateArr, str, socket));
    }

    @Override // com.commonsware.cwac.netsecurity.luni.X509ExtendedTrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, javax.net.ssl.SSLEngine sSLEngine) throws java.security.cert.CertificateException {
        checkPins(this.mDelegate.getTrustedChainForServer(x509CertificateArr, str, sSLEngine));
    }

    @Override // javax.net.ssl.X509TrustManager
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        java.security.cert.X509Certificate[] x509CertificateArr;
        synchronized (this.mIssuersLock) {
            if (this.mIssuers == null) {
                java.util.Set<com.commonsware.cwac.netsecurity.config.TrustAnchor> trustAnchors = this.mNetworkSecurityConfig.getTrustAnchors();
                java.security.cert.X509Certificate[] x509CertificateArr2 = new java.security.cert.X509Certificate[trustAnchors.size()];
                java.util.Iterator<com.commonsware.cwac.netsecurity.config.TrustAnchor> it = trustAnchors.iterator();
                int i = 0;
                while (it.hasNext()) {
                    x509CertificateArr2[i] = it.next().certificate;
                    i++;
                }
                this.mIssuers = x509CertificateArr2;
            }
            x509CertificateArr = (java.security.cert.X509Certificate[]) this.mIssuers.clone();
        }
        return x509CertificateArr;
    }

    public void handleTrustStorageUpdate() {
        synchronized (this.mIssuersLock) {
            this.mIssuers = null;
            this.mDelegate.handleTrustStorageUpdate();
        }
    }
}
