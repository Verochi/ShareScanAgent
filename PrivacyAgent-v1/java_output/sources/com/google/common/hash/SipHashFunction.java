package com.google.common.hash;

@com.google.errorprone.annotations.Immutable
/* loaded from: classes22.dex */
final class SipHashFunction extends com.google.common.hash.AbstractHashFunction implements java.io.Serializable {
    static final com.google.common.hash.HashFunction SIP_HASH_24 = new com.google.common.hash.SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;
    private final int c;
    private final int d;
    private final long k0;
    private final long k1;

    public static final class SipHasher extends com.google.common.hash.AbstractStreamingHasher {
        public final int d;
        public final int e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j;
        public long k;

        public SipHasher(int i, int i2, long j, long j2) {
            super(8);
            this.j = 0L;
            this.k = 0L;
            this.d = i;
            this.e = i2;
            this.f = 8317987319222330741L ^ j;
            this.g = 7237128888997146477L ^ j2;
            this.h = 7816392313619706465L ^ j;
            this.i = 8387220255154660723L ^ j2;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public com.google.common.hash.HashCode a() {
            long j = this.k ^ (this.j << 56);
            this.k = j;
            g(j);
            this.h ^= 255;
            h(this.e);
            return com.google.common.hash.HashCode.fromLong(((this.f ^ this.g) ^ this.h) ^ this.i);
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void d(java.nio.ByteBuffer byteBuffer) {
            this.j += 8;
            g(byteBuffer.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void e(java.nio.ByteBuffer byteBuffer) {
            this.j += byteBuffer.remaining();
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                this.k ^= (byteBuffer.get() & 255) << i;
                i += 8;
            }
        }

        public final void g(long j) {
            this.i ^= j;
            h(this.d);
            this.f = j ^ this.f;
        }

        public final void h(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                long j = this.f;
                long j2 = this.g;
                this.f = j + j2;
                this.h += this.i;
                this.g = java.lang.Long.rotateLeft(j2, 13);
                long rotateLeft = java.lang.Long.rotateLeft(this.i, 16);
                long j3 = this.g;
                long j4 = this.f;
                this.g = j3 ^ j4;
                this.i = rotateLeft ^ this.h;
                long rotateLeft2 = java.lang.Long.rotateLeft(j4, 32);
                long j5 = this.h;
                long j6 = this.g;
                this.h = j5 + j6;
                this.f = rotateLeft2 + this.i;
                this.g = java.lang.Long.rotateLeft(j6, 17);
                long rotateLeft3 = java.lang.Long.rotateLeft(this.i, 21);
                long j7 = this.g;
                long j8 = this.h;
                this.g = j7 ^ j8;
                this.i = rotateLeft3 ^ this.f;
                this.h = java.lang.Long.rotateLeft(j8, 32);
            }
        }
    }

    public SipHashFunction(int i, int i2, long j, long j2) {
        com.google.common.base.Preconditions.checkArgument(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i);
        com.google.common.base.Preconditions.checkArgument(i2 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i2);
        this.c = i;
        this.d = i2;
        this.k0 = j;
        this.k1 = j2;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!(obj instanceof com.google.common.hash.SipHashFunction)) {
            return false;
        }
        com.google.common.hash.SipHashFunction sipHashFunction = (com.google.common.hash.SipHashFunction) obj;
        return this.c == sipHashFunction.c && this.d == sipHashFunction.d && this.k0 == sipHashFunction.k0 && this.k1 == sipHashFunction.k1;
    }

    public int hashCode() {
        return (int) ((((com.google.common.hash.SipHashFunction.class.hashCode() ^ this.c) ^ this.d) ^ this.k0) ^ this.k1);
    }

    @Override // com.google.common.hash.HashFunction
    public com.google.common.hash.Hasher newHasher() {
        return new com.google.common.hash.SipHashFunction.SipHasher(this.c, this.d, this.k0, this.k1);
    }

    public java.lang.String toString() {
        return "Hashing.sipHash" + this.c + "" + this.d + "(" + this.k0 + ", " + this.k1 + ")";
    }
}
