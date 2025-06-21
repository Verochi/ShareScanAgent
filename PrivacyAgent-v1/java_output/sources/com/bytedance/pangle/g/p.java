package com.bytedance.pangle.g;

/* loaded from: classes12.dex */
final class p extends com.bytedance.pangle.g.r {
    private final byte[] a;
    private int b;

    public p(java.security.cert.X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.b = -1;
        this.a = bArr;
    }

    @Override // java.security.cert.Certificate
    public final boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.bytedance.pangle.g.p)) {
            return false;
        }
        try {
            return java.util.Arrays.equals(getEncoded(), ((com.bytedance.pangle.g.p) obj).getEncoded());
        } catch (java.security.cert.CertificateEncodingException unused) {
            return false;
        }
    }

    @Override // com.bytedance.pangle.g.r, java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.a;
    }

    @Override // java.security.cert.Certificate
    public final int hashCode() {
        if (this.b == -1) {
            try {
                this.b = java.util.Arrays.hashCode(getEncoded());
            } catch (java.security.cert.CertificateEncodingException unused) {
                this.b = 0;
            }
        }
        return this.b;
    }
}
