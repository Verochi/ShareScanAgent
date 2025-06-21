package com.commonsware.cwac.netsecurity;

/* loaded from: classes22.dex */
public class MemorizationMismatchException extends com.commonsware.cwac.netsecurity.MemorizationException {
    public MemorizationMismatchException(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.lang.Throwable th) {
        super(x509CertificateArr, str, th);
    }
}
