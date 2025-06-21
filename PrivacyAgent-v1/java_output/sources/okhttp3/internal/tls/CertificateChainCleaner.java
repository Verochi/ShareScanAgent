package okhttp3.internal.tls;

/* loaded from: classes24.dex */
public abstract class CertificateChainCleaner {
    public static okhttp3.internal.tls.CertificateChainCleaner get(javax.net.ssl.X509TrustManager x509TrustManager) {
        return okhttp3.internal.platform.Platform.get().buildCertificateChainCleaner(x509TrustManager);
    }

    public static okhttp3.internal.tls.CertificateChainCleaner get(java.security.cert.X509Certificate... x509CertificateArr) {
        return new okhttp3.internal.tls.BasicCertificateChainCleaner(new okhttp3.internal.tls.BasicTrustRootIndex(x509CertificateArr));
    }

    public abstract java.util.List<java.security.cert.Certificate> clean(java.util.List<java.security.cert.Certificate> list, java.lang.String str) throws javax.net.ssl.SSLPeerUnverifiedException;
}
