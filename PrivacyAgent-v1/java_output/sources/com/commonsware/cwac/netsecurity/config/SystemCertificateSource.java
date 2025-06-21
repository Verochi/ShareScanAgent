package com.commonsware.cwac.netsecurity.config;

/* loaded from: classes22.dex */
public final class SystemCertificateSource extends com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource {

    public static class NoPreloadHolder {
        private static final com.commonsware.cwac.netsecurity.config.SystemCertificateSource INSTANCE = new com.commonsware.cwac.netsecurity.config.SystemCertificateSource(null);

        private NoPreloadHolder() {
        }
    }

    private SystemCertificateSource() {
        super(new java.io.File(java.lang.System.getenv("ANDROID_ROOT") + "/etc/security/cacerts"));
    }

    public /* synthetic */ SystemCertificateSource(com.commonsware.cwac.netsecurity.config.SystemCertificateSource.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.commonsware.cwac.netsecurity.config.SystemCertificateSource getInstance() {
        return com.commonsware.cwac.netsecurity.config.SystemCertificateSource.NoPreloadHolder.INSTANCE;
    }

    @Override // com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource, com.commonsware.cwac.netsecurity.config.CertificateSource
    public /* bridge */ /* synthetic */ java.util.Set findAllByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
        return super.findAllByIssuerAndSignature(x509Certificate);
    }

    @Override // com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource, com.commonsware.cwac.netsecurity.config.CertificateSource
    public /* bridge */ /* synthetic */ java.security.cert.X509Certificate findByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
        return super.findByIssuerAndSignature(x509Certificate);
    }

    @Override // com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource, com.commonsware.cwac.netsecurity.config.CertificateSource
    public /* bridge */ /* synthetic */ java.security.cert.X509Certificate findBySubjectAndPublicKey(java.security.cert.X509Certificate x509Certificate) {
        return super.findBySubjectAndPublicKey(x509Certificate);
    }

    @Override // com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource, com.commonsware.cwac.netsecurity.config.CertificateSource
    public /* bridge */ /* synthetic */ java.util.Set getCertificates() {
        return super.getCertificates();
    }

    @Override // com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource, com.commonsware.cwac.netsecurity.config.CertificateSource
    public /* bridge */ /* synthetic */ void handleTrustStorageUpdate() {
        super.handleTrustStorageUpdate();
    }

    @Override // com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource
    public boolean isCertMarkedAsRemoved(java.lang.String str) {
        return false;
    }
}
