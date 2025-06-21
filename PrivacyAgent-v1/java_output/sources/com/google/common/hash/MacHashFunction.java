package com.google.common.hash;

@com.google.errorprone.annotations.Immutable
/* loaded from: classes22.dex */
final class MacHashFunction extends com.google.common.hash.AbstractHashFunction {
    public final javax.crypto.Mac n;
    public final java.security.Key t;
    public final java.lang.String u;
    public final int v;
    public final boolean w;

    public static final class MacHasher extends com.google.common.hash.AbstractByteHasher {
        public final javax.crypto.Mac b;
        public boolean c;

        public MacHasher(javax.crypto.Mac mac) {
            this.b = mac;
        }

        public /* synthetic */ MacHasher(javax.crypto.Mac mac, com.google.common.hash.MacHashFunction.AnonymousClass1 anonymousClass1) {
            this(mac);
        }

        public final void a() {
            com.google.common.base.Preconditions.checkState(!this.c, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.Hasher
        public com.google.common.hash.HashCode hash() {
            a();
            this.c = true;
            return com.google.common.hash.HashCode.fromBytesNoCopy(this.b.doFinal());
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(byte b) {
            a();
            this.b.update(b);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(java.nio.ByteBuffer byteBuffer) {
            a();
            com.google.common.base.Preconditions.checkNotNull(byteBuffer);
            this.b.update(byteBuffer);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(byte[] bArr) {
            a();
            this.b.update(bArr);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(byte[] bArr, int i, int i2) {
            a();
            this.b.update(bArr, i, i2);
        }
    }

    public MacHashFunction(java.lang.String str, java.security.Key key, java.lang.String str2) {
        javax.crypto.Mac a = a(str, key);
        this.n = a;
        this.t = (java.security.Key) com.google.common.base.Preconditions.checkNotNull(key);
        this.u = (java.lang.String) com.google.common.base.Preconditions.checkNotNull(str2);
        this.v = a.getMacLength() * 8;
        this.w = b(a);
    }

    public static javax.crypto.Mac a(java.lang.String str, java.security.Key key) {
        try {
            javax.crypto.Mac mac = javax.crypto.Mac.getInstance(str);
            mac.init(key);
            return mac;
        } catch (java.security.InvalidKeyException e) {
            throw new java.lang.IllegalArgumentException(e);
        } catch (java.security.NoSuchAlgorithmException e2) {
            throw new java.lang.IllegalStateException(e2);
        }
    }

    public static boolean b(javax.crypto.Mac mac) {
        try {
            mac.clone();
            return true;
        } catch (java.lang.CloneNotSupportedException unused) {
            return false;
        }
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.v;
    }

    @Override // com.google.common.hash.HashFunction
    public com.google.common.hash.Hasher newHasher() {
        if (this.w) {
            try {
                return new com.google.common.hash.MacHashFunction.MacHasher((javax.crypto.Mac) this.n.clone(), null);
            } catch (java.lang.CloneNotSupportedException unused) {
            }
        }
        return new com.google.common.hash.MacHashFunction.MacHasher(a(this.n.getAlgorithm(), this.t), null);
    }

    public java.lang.String toString() {
        return this.u;
    }
}
