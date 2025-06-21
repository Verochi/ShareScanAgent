package com.commonsware.cwac.netsecurity.config;

/* loaded from: classes22.dex */
public class ResourceCertificateSource implements com.commonsware.cwac.netsecurity.config.CertificateSource {
    private java.util.Set<java.security.cert.X509Certificate> mCertificates;
    private android.content.Context mContext;
    private com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateIndex mIndex;
    private final java.lang.Object mLock = new java.lang.Object();
    private final int mResourceId;

    public ResourceCertificateSource(int i, android.content.Context context) {
        this.mResourceId = i;
        this.mContext = context;
    }

    private void ensureInitialized() {
        java.security.cert.CertificateFactory certificateFactory;
        java.io.InputStream openRawResource;
        synchronized (this.mLock) {
            if (this.mCertificates != null) {
                return;
            }
            java.util.HashSet hashSet = new java.util.HashSet();
            java.io.InputStream inputStream = null;
            try {
                try {
                    certificateFactory = java.security.cert.CertificateFactory.getInstance("X.509");
                    openRawResource = this.mContext.getResources().openRawResource(this.mResourceId);
                } catch (java.security.cert.CertificateException e) {
                    e = e;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                java.util.Collection<? extends java.security.cert.Certificate> generateCertificates = certificateFactory.generateCertificates(openRawResource);
                if (openRawResource != null) {
                    try {
                        openRawResource.close();
                    } catch (java.lang.RuntimeException e2) {
                        throw e2;
                    } catch (java.lang.Exception unused) {
                    }
                }
                com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateIndex trustedCertificateIndex = new com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateIndex();
                for (java.security.cert.Certificate certificate : generateCertificates) {
                    hashSet.add((java.security.cert.X509Certificate) certificate);
                    trustedCertificateIndex.index((java.security.cert.X509Certificate) certificate);
                }
                this.mCertificates = hashSet;
                this.mIndex = trustedCertificateIndex;
                this.mContext = null;
            } catch (java.security.cert.CertificateException e3) {
                e = e3;
                inputStream = openRawResource;
                throw new java.lang.RuntimeException("Failed to load trust anchors from id " + this.mResourceId, e);
            } catch (java.lang.Throwable th2) {
                th = th2;
                inputStream = openRawResource;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.lang.RuntimeException e4) {
                        throw e4;
                    } catch (java.lang.Exception unused2) {
                    }
                }
                throw th;
            }
        }
    }

    @Override // com.commonsware.cwac.netsecurity.config.CertificateSource
    public java.util.Set<java.security.cert.X509Certificate> findAllByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
        ensureInitialized();
        java.util.Set<java.security.cert.TrustAnchor> findAllByIssuerAndSignature = this.mIndex.findAllByIssuerAndSignature(x509Certificate);
        if (findAllByIssuerAndSignature.isEmpty()) {
            return java.util.Collections.emptySet();
        }
        java.util.HashSet hashSet = new java.util.HashSet(findAllByIssuerAndSignature.size());
        java.util.Iterator<java.security.cert.TrustAnchor> it = findAllByIssuerAndSignature.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getTrustedCert());
        }
        return hashSet;
    }

    @Override // com.commonsware.cwac.netsecurity.config.CertificateSource
    public java.security.cert.X509Certificate findByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
        ensureInitialized();
        java.security.cert.TrustAnchor findByIssuerAndSignature = this.mIndex.findByIssuerAndSignature(x509Certificate);
        if (findByIssuerAndSignature == null) {
            return null;
        }
        return findByIssuerAndSignature.getTrustedCert();
    }

    @Override // com.commonsware.cwac.netsecurity.config.CertificateSource
    public java.security.cert.X509Certificate findBySubjectAndPublicKey(java.security.cert.X509Certificate x509Certificate) {
        ensureInitialized();
        java.security.cert.TrustAnchor findBySubjectAndPublicKey = this.mIndex.findBySubjectAndPublicKey(x509Certificate);
        if (findBySubjectAndPublicKey == null) {
            return null;
        }
        return findBySubjectAndPublicKey.getTrustedCert();
    }

    @Override // com.commonsware.cwac.netsecurity.config.CertificateSource
    public java.util.Set<java.security.cert.X509Certificate> getCertificates() {
        ensureInitialized();
        return this.mCertificates;
    }

    @Override // com.commonsware.cwac.netsecurity.config.CertificateSource
    public void handleTrustStorageUpdate() {
    }
}
