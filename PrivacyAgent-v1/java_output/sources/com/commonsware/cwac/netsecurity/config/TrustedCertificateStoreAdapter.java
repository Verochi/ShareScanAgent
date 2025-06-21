package com.commonsware.cwac.netsecurity.config;

/* loaded from: classes22.dex */
public class TrustedCertificateStoreAdapter extends com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore {
    private final com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig mConfig;

    public TrustedCertificateStoreAdapter(com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig networkSecurityConfig) {
        this.mConfig = networkSecurityConfig;
    }

    @Override // com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore
    public java.util.Set<java.security.cert.X509Certificate> findAllIssuers(java.security.cert.X509Certificate x509Certificate) {
        return this.mConfig.findAllCertificatesByIssuerAndSignature(x509Certificate);
    }

    @Override // com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore
    public java.security.cert.X509Certificate getTrustAnchor(java.security.cert.X509Certificate x509Certificate) {
        com.commonsware.cwac.netsecurity.config.TrustAnchor findTrustAnchorBySubjectAndPublicKey = this.mConfig.findTrustAnchorBySubjectAndPublicKey(x509Certificate);
        if (findTrustAnchorBySubjectAndPublicKey == null) {
            return null;
        }
        return findTrustAnchorBySubjectAndPublicKey.certificate;
    }
}
