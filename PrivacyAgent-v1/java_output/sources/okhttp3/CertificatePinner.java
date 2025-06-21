package okhttp3;

/* loaded from: classes23.dex */
public final class CertificatePinner {
    public static final okhttp3.CertificatePinner DEFAULT = new okhttp3.CertificatePinner.Builder().build();
    public final java.util.Set<okhttp3.CertificatePinner.Pin> a;

    @javax.annotation.Nullable
    public final okhttp3.internal.tls.CertificateChainCleaner b;

    public static final class Builder {
        public final java.util.List<okhttp3.CertificatePinner.Pin> a = new java.util.ArrayList();

        public okhttp3.CertificatePinner.Builder add(java.lang.String str, java.lang.String... strArr) {
            if (str == null) {
                throw new java.lang.NullPointerException("pattern == null");
            }
            for (java.lang.String str2 : strArr) {
                this.a.add(new okhttp3.CertificatePinner.Pin(str, str2));
            }
            return this;
        }

        public okhttp3.CertificatePinner build() {
            return new okhttp3.CertificatePinner(new java.util.LinkedHashSet(this.a), null);
        }
    }

    public static final class Pin {
        public final java.lang.String a;
        public final java.lang.String b;
        public final java.lang.String c;
        public final okio.ByteString d;

        public Pin(java.lang.String str, java.lang.String str2) {
            java.lang.String host;
            this.a = str;
            if (str.startsWith("*.")) {
                host = okhttp3.HttpUrl.get("http://" + str.substring(2)).host();
            } else {
                host = okhttp3.HttpUrl.get("http://" + str).host();
            }
            this.b = host;
            if (str2.startsWith("sha1/")) {
                this.c = "sha1/";
                this.d = okio.ByteString.decodeBase64(str2.substring(5));
            } else {
                if (!str2.startsWith("sha256/")) {
                    throw new java.lang.IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
                }
                this.c = "sha256/";
                this.d = okio.ByteString.decodeBase64(str2.substring(7));
            }
            if (this.d != null) {
                return;
            }
            throw new java.lang.IllegalArgumentException("pins must be base64: " + str2);
        }

        public boolean a(java.lang.String str) {
            if (!this.a.startsWith("*.")) {
                return str.equals(this.b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.b.length()) {
                java.lang.String str2 = this.b;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(java.lang.Object obj) {
            if (obj instanceof okhttp3.CertificatePinner.Pin) {
                okhttp3.CertificatePinner.Pin pin = (okhttp3.CertificatePinner.Pin) obj;
                if (this.a.equals(pin.a) && this.c.equals(pin.c) && this.d.equals(pin.d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.a.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public java.lang.String toString() {
            return this.c + this.d.base64();
        }
    }

    public CertificatePinner(java.util.Set<okhttp3.CertificatePinner.Pin> set, @javax.annotation.Nullable okhttp3.internal.tls.CertificateChainCleaner certificateChainCleaner) {
        this.a = set;
        this.b = certificateChainCleaner;
    }

    public static okio.ByteString b(java.security.cert.X509Certificate x509Certificate) {
        return okio.ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    public static okio.ByteString c(java.security.cert.X509Certificate x509Certificate) {
        return okio.ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public static java.lang.String pin(java.security.cert.Certificate certificate) {
        if (!(certificate instanceof java.security.cert.X509Certificate)) {
            throw new java.lang.IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + c((java.security.cert.X509Certificate) certificate).base64();
    }

    public java.util.List<okhttp3.CertificatePinner.Pin> a(java.lang.String str) {
        java.util.List<okhttp3.CertificatePinner.Pin> emptyList = java.util.Collections.emptyList();
        for (okhttp3.CertificatePinner.Pin pin : this.a) {
            if (pin.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new java.util.ArrayList<>();
                }
                emptyList.add(pin);
            }
        }
        return emptyList;
    }

    public void check(java.lang.String str, java.util.List<java.security.cert.Certificate> list) throws javax.net.ssl.SSLPeerUnverifiedException {
        java.util.List<okhttp3.CertificatePinner.Pin> a = a(str);
        if (a.isEmpty()) {
            return;
        }
        okhttp3.internal.tls.CertificateChainCleaner certificateChainCleaner = this.b;
        if (certificateChainCleaner != null) {
            list = certificateChainCleaner.clean(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate) list.get(i);
            int size2 = a.size();
            okio.ByteString byteString = null;
            okio.ByteString byteString2 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                okhttp3.CertificatePinner.Pin pin = a.get(i2);
                if (pin.c.equals("sha256/")) {
                    if (byteString == null) {
                        byteString = c(x509Certificate);
                    }
                    if (pin.d.equals(byteString)) {
                        return;
                    }
                } else {
                    if (!pin.c.equals("sha1/")) {
                        throw new java.lang.AssertionError("unsupported hashAlgorithm: " + pin.c);
                    }
                    if (byteString2 == null) {
                        byteString2 = b(x509Certificate);
                    }
                    if (pin.d.equals(byteString2)) {
                        return;
                    }
                }
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            java.security.cert.X509Certificate x509Certificate2 = (java.security.cert.X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(pin(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        int size4 = a.size();
        for (int i4 = 0; i4 < size4; i4++) {
            okhttp3.CertificatePinner.Pin pin2 = a.get(i4);
            sb.append("\n    ");
            sb.append(pin2);
        }
        throw new javax.net.ssl.SSLPeerUnverifiedException(sb.toString());
    }

    public void check(java.lang.String str, java.security.cert.Certificate... certificateArr) throws javax.net.ssl.SSLPeerUnverifiedException {
        check(str, java.util.Arrays.asList(certificateArr));
    }

    public okhttp3.CertificatePinner d(@javax.annotation.Nullable okhttp3.internal.tls.CertificateChainCleaner certificateChainCleaner) {
        return java.util.Objects.equals(this.b, certificateChainCleaner) ? this : new okhttp3.CertificatePinner(this.a, certificateChainCleaner);
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof okhttp3.CertificatePinner) {
            okhttp3.CertificatePinner certificatePinner = (okhttp3.CertificatePinner) obj;
            if (java.util.Objects.equals(this.b, certificatePinner.b) && this.a.equals(certificatePinner.a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (java.util.Objects.hashCode(this.b) * 31) + this.a.hashCode();
    }
}
