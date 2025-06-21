package okhttp3.internal.tls;

/* loaded from: classes24.dex */
public final class BasicTrustRootIndex implements okhttp3.internal.tls.TrustRootIndex {
    public final java.util.Map<javax.security.auth.x500.X500Principal, java.util.Set<java.security.cert.X509Certificate>> a = new java.util.LinkedHashMap();

    public BasicTrustRootIndex(java.security.cert.X509Certificate... x509CertificateArr) {
        for (java.security.cert.X509Certificate x509Certificate : x509CertificateArr) {
            javax.security.auth.x500.X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            java.util.Set<java.security.cert.X509Certificate> set = this.a.get(subjectX500Principal);
            if (set == null) {
                set = new java.util.LinkedHashSet<>(1);
                this.a.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof okhttp3.internal.tls.BasicTrustRootIndex) && ((okhttp3.internal.tls.BasicTrustRootIndex) obj).a.equals(this.a);
    }

    @Override // okhttp3.internal.tls.TrustRootIndex
    public java.security.cert.X509Certificate findByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
        java.util.Set<java.security.cert.X509Certificate> set = this.a.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (java.security.cert.X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
