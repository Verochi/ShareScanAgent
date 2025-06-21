package com.commonsware.cwac.netsecurity.config;

/* loaded from: classes22.dex */
public final class TrustAnchor {
    public final java.security.cert.X509Certificate certificate;
    public final boolean overridesPins;

    public TrustAnchor(java.security.cert.X509Certificate x509Certificate, boolean z) {
        if (x509Certificate == null) {
            throw new java.lang.NullPointerException("certificate");
        }
        this.certificate = x509Certificate;
        this.overridesPins = z;
    }
}
