package com.commonsware.cwac.netsecurity;

/* loaded from: classes22.dex */
public class CertificateNotMemorizedException extends com.commonsware.cwac.netsecurity.MemorizationException {
    public CertificateNotMemorizedException(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) {
        super(x509CertificateArr, str);
    }
}
