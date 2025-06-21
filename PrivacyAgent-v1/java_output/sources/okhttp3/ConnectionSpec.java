package okhttp3;

/* loaded from: classes23.dex */
public final class ConnectionSpec {
    public static final okhttp3.ConnectionSpec CLEARTEXT;
    public static final okhttp3.ConnectionSpec COMPATIBLE_TLS;
    public static final okhttp3.ConnectionSpec MODERN_TLS;
    public static final okhttp3.ConnectionSpec RESTRICTED_TLS;
    public static final okhttp3.CipherSuite[] e;
    public static final okhttp3.CipherSuite[] f;
    public final boolean a;
    public final boolean b;

    @javax.annotation.Nullable
    public final java.lang.String[] c;

    @javax.annotation.Nullable
    public final java.lang.String[] d;

    public static final class Builder {
        public boolean a;

        @javax.annotation.Nullable
        public java.lang.String[] b;

        @javax.annotation.Nullable
        public java.lang.String[] c;
        public boolean d;

        public Builder(okhttp3.ConnectionSpec connectionSpec) {
            this.a = connectionSpec.a;
            this.b = connectionSpec.c;
            this.c = connectionSpec.d;
            this.d = connectionSpec.b;
        }

        public Builder(boolean z) {
            this.a = z;
        }

        public okhttp3.ConnectionSpec.Builder allEnabledCipherSuites() {
            if (!this.a) {
                throw new java.lang.IllegalStateException("no cipher suites for cleartext connections");
            }
            this.b = null;
            return this;
        }

        public okhttp3.ConnectionSpec.Builder allEnabledTlsVersions() {
            if (!this.a) {
                throw new java.lang.IllegalStateException("no TLS versions for cleartext connections");
            }
            this.c = null;
            return this;
        }

        public okhttp3.ConnectionSpec build() {
            return new okhttp3.ConnectionSpec(this);
        }

        public okhttp3.ConnectionSpec.Builder cipherSuites(java.lang.String... strArr) {
            if (!this.a) {
                throw new java.lang.IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new java.lang.IllegalArgumentException("At least one cipher suite is required");
            }
            this.b = (java.lang.String[]) strArr.clone();
            return this;
        }

        public okhttp3.ConnectionSpec.Builder cipherSuites(okhttp3.CipherSuite... cipherSuiteArr) {
            if (!this.a) {
                throw new java.lang.IllegalStateException("no cipher suites for cleartext connections");
            }
            java.lang.String[] strArr = new java.lang.String[cipherSuiteArr.length];
            for (int i = 0; i < cipherSuiteArr.length; i++) {
                strArr[i] = cipherSuiteArr[i].a;
            }
            return cipherSuites(strArr);
        }

        public okhttp3.ConnectionSpec.Builder supportsTlsExtensions(boolean z) {
            if (!this.a) {
                throw new java.lang.IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.d = z;
            return this;
        }

        public okhttp3.ConnectionSpec.Builder tlsVersions(java.lang.String... strArr) {
            if (!this.a) {
                throw new java.lang.IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new java.lang.IllegalArgumentException("At least one TLS version is required");
            }
            this.c = (java.lang.String[]) strArr.clone();
            return this;
        }

        public okhttp3.ConnectionSpec.Builder tlsVersions(okhttp3.TlsVersion... tlsVersionArr) {
            if (!this.a) {
                throw new java.lang.IllegalStateException("no TLS versions for cleartext connections");
            }
            java.lang.String[] strArr = new java.lang.String[tlsVersionArr.length];
            for (int i = 0; i < tlsVersionArr.length; i++) {
                strArr[i] = tlsVersionArr[i].javaName;
            }
            return tlsVersions(strArr);
        }
    }

    static {
        okhttp3.CipherSuite cipherSuite = okhttp3.CipherSuite.TLS_AES_128_GCM_SHA256;
        okhttp3.CipherSuite cipherSuite2 = okhttp3.CipherSuite.TLS_AES_256_GCM_SHA384;
        okhttp3.CipherSuite cipherSuite3 = okhttp3.CipherSuite.TLS_CHACHA20_POLY1305_SHA256;
        okhttp3.CipherSuite cipherSuite4 = okhttp3.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        okhttp3.CipherSuite cipherSuite5 = okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        okhttp3.CipherSuite cipherSuite6 = okhttp3.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        okhttp3.CipherSuite cipherSuite7 = okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        okhttp3.CipherSuite cipherSuite8 = okhttp3.CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        okhttp3.CipherSuite cipherSuite9 = okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        okhttp3.CipherSuite[] cipherSuiteArr = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9};
        e = cipherSuiteArr;
        okhttp3.CipherSuite[] cipherSuiteArr2 = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, okhttp3.CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, okhttp3.CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, okhttp3.CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, okhttp3.CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, okhttp3.CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f = cipherSuiteArr2;
        okhttp3.ConnectionSpec.Builder cipherSuites = new okhttp3.ConnectionSpec.Builder(true).cipherSuites(cipherSuiteArr);
        okhttp3.TlsVersion tlsVersion = okhttp3.TlsVersion.TLS_1_3;
        okhttp3.TlsVersion tlsVersion2 = okhttp3.TlsVersion.TLS_1_2;
        RESTRICTED_TLS = cipherSuites.tlsVersions(tlsVersion, tlsVersion2).supportsTlsExtensions(true).build();
        MODERN_TLS = new okhttp3.ConnectionSpec.Builder(true).cipherSuites(cipherSuiteArr2).tlsVersions(tlsVersion, tlsVersion2).supportsTlsExtensions(true).build();
        COMPATIBLE_TLS = new okhttp3.ConnectionSpec.Builder(true).cipherSuites(cipherSuiteArr2).tlsVersions(tlsVersion, tlsVersion2, okhttp3.TlsVersion.TLS_1_1, okhttp3.TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
        CLEARTEXT = new okhttp3.ConnectionSpec.Builder(false).build();
    }

    public ConnectionSpec(okhttp3.ConnectionSpec.Builder builder) {
        this.a = builder.a;
        this.c = builder.b;
        this.d = builder.c;
        this.b = builder.d;
    }

    public void a(javax.net.ssl.SSLSocket sSLSocket, boolean z) {
        okhttp3.ConnectionSpec b = b(sSLSocket, z);
        java.lang.String[] strArr = b.d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        java.lang.String[] strArr2 = b.c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public final okhttp3.ConnectionSpec b(javax.net.ssl.SSLSocket sSLSocket, boolean z) {
        java.lang.String[] intersect = this.c != null ? okhttp3.internal.Util.intersect(okhttp3.CipherSuite.b, sSLSocket.getEnabledCipherSuites(), this.c) : sSLSocket.getEnabledCipherSuites();
        java.lang.String[] intersect2 = this.d != null ? okhttp3.internal.Util.intersect(okhttp3.internal.Util.NATURAL_ORDER, sSLSocket.getEnabledProtocols(), this.d) : sSLSocket.getEnabledProtocols();
        java.lang.String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int indexOf = okhttp3.internal.Util.indexOf(okhttp3.CipherSuite.b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && indexOf != -1) {
            intersect = okhttp3.internal.Util.concat(intersect, supportedCipherSuites[indexOf]);
        }
        return new okhttp3.ConnectionSpec.Builder(this).cipherSuites(intersect).tlsVersions(intersect2).build();
    }

    @javax.annotation.Nullable
    public java.util.List<okhttp3.CipherSuite> cipherSuites() {
        java.lang.String[] strArr = this.c;
        if (strArr != null) {
            return okhttp3.CipherSuite.b(strArr);
        }
        return null;
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (!(obj instanceof okhttp3.ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        okhttp3.ConnectionSpec connectionSpec = (okhttp3.ConnectionSpec) obj;
        boolean z = this.a;
        if (z != connectionSpec.a) {
            return false;
        }
        return !z || (java.util.Arrays.equals(this.c, connectionSpec.c) && java.util.Arrays.equals(this.d, connectionSpec.d) && this.b == connectionSpec.b);
    }

    public int hashCode() {
        if (this.a) {
            return ((((527 + java.util.Arrays.hashCode(this.c)) * 31) + java.util.Arrays.hashCode(this.d)) * 31) + (!this.b ? 1 : 0);
        }
        return 17;
    }

    public boolean isCompatible(javax.net.ssl.SSLSocket sSLSocket) {
        if (!this.a) {
            return false;
        }
        java.lang.String[] strArr = this.d;
        if (strArr != null && !okhttp3.internal.Util.nonEmptyIntersection(okhttp3.internal.Util.NATURAL_ORDER, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        java.lang.String[] strArr2 = this.c;
        return strArr2 == null || okhttp3.internal.Util.nonEmptyIntersection(okhttp3.CipherSuite.b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean isTls() {
        return this.a;
    }

    public boolean supportsTlsExtensions() {
        return this.b;
    }

    @javax.annotation.Nullable
    public java.util.List<okhttp3.TlsVersion> tlsVersions() {
        java.lang.String[] strArr = this.d;
        if (strArr != null) {
            return okhttp3.TlsVersion.forJavaNames(strArr);
        }
        return null;
    }

    public java.lang.String toString() {
        if (!this.a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + java.util.Objects.toString(cipherSuites(), "[all enabled]") + ", tlsVersions=" + java.util.Objects.toString(tlsVersions(), "[all enabled]") + ", supportsTlsExtensions=" + this.b + ")";
    }
}
