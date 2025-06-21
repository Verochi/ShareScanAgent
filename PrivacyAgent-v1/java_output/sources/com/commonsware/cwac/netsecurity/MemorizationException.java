package com.commonsware.cwac.netsecurity;

/* loaded from: classes22.dex */
public class MemorizationException extends java.security.cert.CertificateException {
    public final java.security.cert.X509Certificate[] chain;
    public final java.lang.String host;

    public MemorizationException(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) {
        this(x509CertificateArr, str, null);
    }

    public MemorizationException(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.lang.Throwable th) {
        super("Certificate not found in keystore", th);
        this.host = str;
        this.chain = x509CertificateArr;
    }
}
