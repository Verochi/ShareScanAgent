package okhttp3.internal.tls;

/* loaded from: classes24.dex */
public final class BasicCertificateChainCleaner extends okhttp3.internal.tls.CertificateChainCleaner {
    public final okhttp3.internal.tls.TrustRootIndex a;

    public BasicCertificateChainCleaner(okhttp3.internal.tls.TrustRootIndex trustRootIndex) {
        this.a = trustRootIndex;
    }

    public final boolean a(java.security.cert.X509Certificate x509Certificate, java.security.cert.X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (java.security.GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    public java.util.List<java.security.cert.Certificate> clean(java.util.List<java.security.cert.Certificate> list, java.lang.String str) throws javax.net.ssl.SSLPeerUnverifiedException {
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque(list);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add((java.security.cert.Certificate) arrayDeque.removeFirst());
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate) arrayList.get(arrayList.size() - 1);
            java.security.cert.X509Certificate findByIssuerAndSignature = this.a.findByIssuerAndSignature(x509Certificate);
            if (findByIssuerAndSignature == null) {
                java.util.Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    java.security.cert.X509Certificate x509Certificate2 = (java.security.cert.X509Certificate) it.next();
                    if (a(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z) {
                    return arrayList;
                }
                throw new javax.net.ssl.SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
            if (arrayList.size() > 1 || !x509Certificate.equals(findByIssuerAndSignature)) {
                arrayList.add(findByIssuerAndSignature);
            }
            if (a(findByIssuerAndSignature, findByIssuerAndSignature)) {
                return arrayList;
            }
            z = true;
        }
        throw new javax.net.ssl.SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof okhttp3.internal.tls.BasicCertificateChainCleaner) && ((okhttp3.internal.tls.BasicCertificateChainCleaner) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
