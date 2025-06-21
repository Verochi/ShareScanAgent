package com.commonsware.cwac.netsecurity.conscrypt;

/* loaded from: classes22.dex */
public final class TrustedCertificateIndex {
    private final java.util.Map<javax.security.auth.x500.X500Principal, java.util.List<java.security.cert.TrustAnchor>> subjectToTrustAnchors = new java.util.HashMap();

    public TrustedCertificateIndex() {
    }

    public TrustedCertificateIndex(java.util.Set<java.security.cert.TrustAnchor> set) {
        index(set);
    }

    private static java.security.cert.TrustAnchor findBySubjectAndPublicKey(java.security.cert.X509Certificate x509Certificate, java.util.Collection<java.security.cert.TrustAnchor> collection) {
        java.security.PublicKey publicKey;
        java.security.PublicKey publicKey2 = x509Certificate.getPublicKey();
        for (java.security.cert.TrustAnchor trustAnchor : collection) {
            try {
                java.security.cert.X509Certificate trustedCert = trustAnchor.getTrustedCert();
                publicKey = trustedCert != null ? trustedCert.getPublicKey() : trustAnchor.getCAPublicKey();
            } catch (java.lang.Exception unused) {
            }
            if (publicKey.equals(publicKey2)) {
                return trustAnchor;
            }
            if ("X.509".equals(publicKey.getFormat()) && "X.509".equals(publicKey2.getFormat())) {
                byte[] encoded = publicKey.getEncoded();
                byte[] encoded2 = publicKey2.getEncoded();
                if (encoded2 != null && encoded != null && java.util.Arrays.equals(encoded, encoded2)) {
                    return trustAnchor;
                }
            }
        }
        return null;
    }

    private void index(java.util.Set<java.security.cert.TrustAnchor> set) {
        java.util.Iterator<java.security.cert.TrustAnchor> it = set.iterator();
        while (it.hasNext()) {
            index(it.next());
        }
    }

    public java.util.Set<java.security.cert.TrustAnchor> findAllByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
        javax.security.auth.x500.X500Principal issuerX500Principal = x509Certificate.getIssuerX500Principal();
        synchronized (this.subjectToTrustAnchors) {
            java.util.List<java.security.cert.TrustAnchor> list = this.subjectToTrustAnchors.get(issuerX500Principal);
            if (list == null) {
                return java.util.Collections.emptySet();
            }
            java.util.HashSet hashSet = new java.util.HashSet();
            for (java.security.cert.TrustAnchor trustAnchor : list) {
                try {
                    java.security.cert.X509Certificate trustedCert = trustAnchor.getTrustedCert();
                    java.security.PublicKey publicKey = trustedCert != null ? trustedCert.getPublicKey() : trustAnchor.getCAPublicKey();
                    if (publicKey != null) {
                        x509Certificate.verify(publicKey);
                        hashSet.add(trustAnchor);
                    }
                } catch (java.lang.Exception unused) {
                }
            }
            return hashSet;
        }
    }

    public java.security.cert.TrustAnchor findByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
        javax.security.auth.x500.X500Principal issuerX500Principal = x509Certificate.getIssuerX500Principal();
        synchronized (this.subjectToTrustAnchors) {
            java.util.List<java.security.cert.TrustAnchor> list = this.subjectToTrustAnchors.get(issuerX500Principal);
            if (list == null) {
                return null;
            }
            for (java.security.cert.TrustAnchor trustAnchor : list) {
                try {
                    java.security.cert.X509Certificate trustedCert = trustAnchor.getTrustedCert();
                    x509Certificate.verify(trustedCert != null ? trustedCert.getPublicKey() : trustAnchor.getCAPublicKey());
                    return trustAnchor;
                } catch (java.lang.Exception unused) {
                }
            }
            return null;
        }
    }

    public java.security.cert.TrustAnchor findBySubjectAndPublicKey(java.security.cert.X509Certificate x509Certificate) {
        javax.security.auth.x500.X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
        synchronized (this.subjectToTrustAnchors) {
            java.util.List<java.security.cert.TrustAnchor> list = this.subjectToTrustAnchors.get(subjectX500Principal);
            if (list == null) {
                return null;
            }
            return findBySubjectAndPublicKey(x509Certificate, list);
        }
    }

    public java.security.cert.TrustAnchor index(java.security.cert.X509Certificate x509Certificate) {
        java.security.cert.TrustAnchor trustAnchor = new java.security.cert.TrustAnchor(x509Certificate, null);
        index(trustAnchor);
        return trustAnchor;
    }

    public void index(java.security.cert.TrustAnchor trustAnchor) {
        java.security.cert.X509Certificate trustedCert = trustAnchor.getTrustedCert();
        javax.security.auth.x500.X500Principal subjectX500Principal = trustedCert != null ? trustedCert.getSubjectX500Principal() : trustAnchor.getCA();
        synchronized (this.subjectToTrustAnchors) {
            java.util.List<java.security.cert.TrustAnchor> list = this.subjectToTrustAnchors.get(subjectX500Principal);
            if (list == null) {
                list = new java.util.ArrayList<>(1);
                this.subjectToTrustAnchors.put(subjectX500Principal, list);
            } else if (trustedCert != null) {
                java.util.Iterator<java.security.cert.TrustAnchor> it = list.iterator();
                while (it.hasNext()) {
                    if (trustedCert.equals(it.next().getTrustedCert())) {
                        return;
                    }
                }
            }
            list.add(trustAnchor);
        }
    }

    public void reset() {
        synchronized (this.subjectToTrustAnchors) {
            this.subjectToTrustAnchors.clear();
        }
    }

    public void reset(java.util.Set<java.security.cert.TrustAnchor> set) {
        synchronized (this.subjectToTrustAnchors) {
            reset();
            index(set);
        }
    }
}
