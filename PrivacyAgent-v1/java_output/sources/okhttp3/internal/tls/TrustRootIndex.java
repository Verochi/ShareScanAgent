package okhttp3.internal.tls;

/* loaded from: classes24.dex */
public interface TrustRootIndex {
    java.security.cert.X509Certificate findByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate);
}
