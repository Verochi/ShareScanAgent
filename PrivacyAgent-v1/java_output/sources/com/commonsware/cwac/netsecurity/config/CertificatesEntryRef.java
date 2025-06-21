package com.commonsware.cwac.netsecurity.config;

/* loaded from: classes22.dex */
public final class CertificatesEntryRef {
    private final boolean mOverridesPins;
    private final com.commonsware.cwac.netsecurity.config.CertificateSource mSource;

    public CertificatesEntryRef(com.commonsware.cwac.netsecurity.config.CertificateSource certificateSource, boolean z) {
        this.mSource = certificateSource;
        this.mOverridesPins = z;
    }

    public java.util.Set<java.security.cert.X509Certificate> findAllCertificatesByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
        return this.mSource.findAllByIssuerAndSignature(x509Certificate);
    }

    public com.commonsware.cwac.netsecurity.config.TrustAnchor findByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
        java.security.cert.X509Certificate findByIssuerAndSignature = this.mSource.findByIssuerAndSignature(x509Certificate);
        if (findByIssuerAndSignature == null) {
            return null;
        }
        return new com.commonsware.cwac.netsecurity.config.TrustAnchor(findByIssuerAndSignature, this.mOverridesPins);
    }

    public com.commonsware.cwac.netsecurity.config.TrustAnchor findBySubjectAndPublicKey(java.security.cert.X509Certificate x509Certificate) {
        java.security.cert.X509Certificate findBySubjectAndPublicKey = this.mSource.findBySubjectAndPublicKey(x509Certificate);
        if (findBySubjectAndPublicKey == null) {
            return null;
        }
        return new com.commonsware.cwac.netsecurity.config.TrustAnchor(findBySubjectAndPublicKey, this.mOverridesPins);
    }

    public java.util.Set<com.commonsware.cwac.netsecurity.config.TrustAnchor> getTrustAnchors() {
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Iterator<java.security.cert.X509Certificate> it = this.mSource.getCertificates().iterator();
        while (it.hasNext()) {
            hashSet.add(new com.commonsware.cwac.netsecurity.config.TrustAnchor(it.next(), this.mOverridesPins));
        }
        return hashSet;
    }

    public void handleTrustStorageUpdate() {
        this.mSource.handleTrustStorageUpdate();
    }

    public boolean overridesPins() {
        return this.mOverridesPins;
    }
}
