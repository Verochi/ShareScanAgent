package okhttp3;

/* loaded from: classes23.dex */
public final class Handshake {
    public final okhttp3.TlsVersion a;
    public final okhttp3.CipherSuite b;
    public final java.util.List<java.security.cert.Certificate> c;
    public final java.util.List<java.security.cert.Certificate> d;

    public Handshake(okhttp3.TlsVersion tlsVersion, okhttp3.CipherSuite cipherSuite, java.util.List<java.security.cert.Certificate> list, java.util.List<java.security.cert.Certificate> list2) {
        this.a = tlsVersion;
        this.b = cipherSuite;
        this.c = list;
        this.d = list2;
    }

    public static okhttp3.Handshake get(javax.net.ssl.SSLSession sSLSession) throws java.io.IOException {
        java.security.cert.Certificate[] certificateArr;
        java.lang.String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new java.lang.IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new java.io.IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        okhttp3.CipherSuite forJavaName = okhttp3.CipherSuite.forJavaName(cipherSuite);
        java.lang.String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new java.lang.IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new java.io.IOException("tlsVersion == NONE");
        }
        okhttp3.TlsVersion forJavaName2 = okhttp3.TlsVersion.forJavaName(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (javax.net.ssl.SSLPeerUnverifiedException unused) {
            certificateArr = null;
        }
        java.util.List immutableList = certificateArr != null ? okhttp3.internal.Util.immutableList(certificateArr) : java.util.Collections.emptyList();
        java.security.cert.Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new okhttp3.Handshake(forJavaName2, forJavaName, immutableList, localCertificates != null ? okhttp3.internal.Util.immutableList(localCertificates) : java.util.Collections.emptyList());
    }

    public static okhttp3.Handshake get(okhttp3.TlsVersion tlsVersion, okhttp3.CipherSuite cipherSuite, java.util.List<java.security.cert.Certificate> list, java.util.List<java.security.cert.Certificate> list2) {
        if (tlsVersion == null) {
            throw new java.lang.NullPointerException("tlsVersion == null");
        }
        if (cipherSuite != null) {
            return new okhttp3.Handshake(tlsVersion, cipherSuite, okhttp3.internal.Util.immutableList(list), okhttp3.internal.Util.immutableList(list2));
        }
        throw new java.lang.NullPointerException("cipherSuite == null");
    }

    public final java.util.List<java.lang.String> a(java.util.List<java.security.cert.Certificate> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.security.cert.Certificate certificate : list) {
            if (certificate instanceof java.security.cert.X509Certificate) {
                arrayList.add(java.lang.String.valueOf(((java.security.cert.X509Certificate) certificate).getSubjectDN()));
            } else {
                arrayList.add(certificate.getType());
            }
        }
        return arrayList;
    }

    public okhttp3.CipherSuite cipherSuite() {
        return this.b;
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (!(obj instanceof okhttp3.Handshake)) {
            return false;
        }
        okhttp3.Handshake handshake = (okhttp3.Handshake) obj;
        return this.a.equals(handshake.a) && this.b.equals(handshake.b) && this.c.equals(handshake.c) && this.d.equals(handshake.d);
    }

    public int hashCode() {
        return ((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public java.util.List<java.security.cert.Certificate> localCertificates() {
        return this.d;
    }

    @javax.annotation.Nullable
    public java.security.Principal localPrincipal() {
        if (this.d.isEmpty()) {
            return null;
        }
        return ((java.security.cert.X509Certificate) this.d.get(0)).getSubjectX500Principal();
    }

    public java.util.List<java.security.cert.Certificate> peerCertificates() {
        return this.c;
    }

    @javax.annotation.Nullable
    public java.security.Principal peerPrincipal() {
        if (this.c.isEmpty()) {
            return null;
        }
        return ((java.security.cert.X509Certificate) this.c.get(0)).getSubjectX500Principal();
    }

    public okhttp3.TlsVersion tlsVersion() {
        return this.a;
    }

    public java.lang.String toString() {
        return "Handshake{tlsVersion=" + this.a + " cipherSuite=" + this.b + " peerCertificates=" + a(this.c) + " localCertificates=" + a(this.d) + '}';
    }
}
