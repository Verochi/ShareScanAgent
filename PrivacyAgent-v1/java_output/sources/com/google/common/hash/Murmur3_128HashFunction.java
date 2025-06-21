package com.google.common.hash;

@com.google.errorprone.annotations.Immutable
/* loaded from: classes22.dex */
final class Murmur3_128HashFunction extends com.google.common.hash.AbstractHashFunction implements java.io.Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;
    static final com.google.common.hash.HashFunction MURMUR3_128 = new com.google.common.hash.Murmur3_128HashFunction(0);
    static final com.google.common.hash.HashFunction GOOD_FAST_HASH_128 = new com.google.common.hash.Murmur3_128HashFunction(com.google.common.hash.Hashing.a);

    public static final class Murmur3_128Hasher extends com.google.common.hash.AbstractStreamingHasher {
        public long d;
        public long e;
        public int f;

        public Murmur3_128Hasher(int i) {
            super(16);
            long j = i;
            this.d = j;
            this.e = j;
            this.f = 0;
        }

        public static long h(long j) {
            long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
            long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
            return j3 ^ (j3 >>> 33);
        }

        public static long i(long j) {
            return java.lang.Long.rotateLeft(j * (-8663945395140668459L), 31) * 5545529020109919103L;
        }

        public static long j(long j) {
            return java.lang.Long.rotateLeft(j * 5545529020109919103L, 33) * (-8663945395140668459L);
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public com.google.common.hash.HashCode a() {
            long j = this.d;
            int i = this.f;
            long j2 = j ^ i;
            long j3 = this.e ^ i;
            long j4 = j2 + j3;
            this.d = j4;
            this.e = j3 + j4;
            this.d = h(j4);
            long h = h(this.e);
            long j5 = this.d + h;
            this.d = j5;
            this.e = h + j5;
            return com.google.common.hash.HashCode.fromBytesNoCopy(java.nio.ByteBuffer.wrap(new byte[16]).order(java.nio.ByteOrder.LITTLE_ENDIAN).putLong(this.d).putLong(this.e).array());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void d(java.nio.ByteBuffer byteBuffer) {
            g(byteBuffer.getLong(), byteBuffer.getLong());
            this.f += 16;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void e(java.nio.ByteBuffer byteBuffer) {
            long j;
            long j2;
            long j3;
            long j4;
            long j5;
            long j6;
            long j7;
            long j8;
            long j9;
            long j10;
            long j11;
            long j12;
            long j13;
            long j14;
            this.f += byteBuffer.remaining();
            long j15 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j = 0;
                    j7 = com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(0)) ^ j;
                    this.d ^= i(j7);
                    this.e ^= j(j15);
                    return;
                case 2:
                    j2 = 0;
                    j = j2 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j7 = com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(0)) ^ j;
                    this.d ^= i(j7);
                    this.e ^= j(j15);
                    return;
                case 3:
                    j3 = 0;
                    j2 = j3 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j = j2 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j7 = com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(0)) ^ j;
                    this.d ^= i(j7);
                    this.e ^= j(j15);
                    return;
                case 4:
                    j4 = 0;
                    j3 = j4 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j2 = j3 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j = j2 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j7 = com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(0)) ^ j;
                    this.d ^= i(j7);
                    this.e ^= j(j15);
                    return;
                case 5:
                    j5 = 0;
                    j4 = j5 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j3 = j4 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j2 = j3 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j = j2 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j7 = com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(0)) ^ j;
                    this.d ^= i(j7);
                    this.e ^= j(j15);
                    return;
                case 6:
                    j6 = 0;
                    j5 = j6 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(5)) << 40);
                    j4 = j5 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j3 = j4 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j2 = j3 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j = j2 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j7 = com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(0)) ^ j;
                    this.d ^= i(j7);
                    this.e ^= j(j15);
                    return;
                case 7:
                    j6 = (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(6)) << 48) ^ 0;
                    j5 = j6 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(5)) << 40);
                    j4 = j5 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j3 = j4 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j2 = j3 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j = j2 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j7 = com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(0)) ^ j;
                    this.d ^= i(j7);
                    this.e ^= j(j15);
                    return;
                case 8:
                    j8 = 0;
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= i(j7);
                    this.e ^= j(j15);
                    return;
                case 9:
                    j9 = 0;
                    j8 = j9 ^ com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= i(j7);
                    this.e ^= j(j15);
                    return;
                case 10:
                    j10 = 0;
                    j9 = j10 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j8 = j9 ^ com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= i(j7);
                    this.e ^= j(j15);
                    return;
                case 11:
                    j11 = 0;
                    j10 = j11 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j9 = j10 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j8 = j9 ^ com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= i(j7);
                    this.e ^= j(j15);
                    return;
                case 12:
                    j12 = 0;
                    j11 = j12 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j10 = j11 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j9 = j10 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j8 = j9 ^ com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= i(j7);
                    this.e ^= j(j15);
                    return;
                case 13:
                    j13 = 0;
                    j12 = j13 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(12)) << 32);
                    j11 = j12 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j10 = j11 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j9 = j10 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j8 = j9 ^ com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= i(j7);
                    this.e ^= j(j15);
                    return;
                case 14:
                    j14 = 0;
                    j13 = j14 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(13)) << 40);
                    j12 = j13 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(12)) << 32);
                    j11 = j12 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j10 = j11 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j9 = j10 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j8 = j9 ^ com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= i(j7);
                    this.e ^= j(j15);
                    return;
                case 15:
                    j14 = (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(14)) << 48) ^ 0;
                    j13 = j14 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(13)) << 40);
                    j12 = j13 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(12)) << 32);
                    j11 = j12 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j10 = j11 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j9 = j10 ^ (com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j8 = j9 ^ com.google.common.primitives.UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= i(j7);
                    this.e ^= j(j15);
                    return;
                default:
                    throw new java.lang.AssertionError("Should never get here.");
            }
        }

        public final void g(long j, long j2) {
            long i = i(j) ^ this.d;
            this.d = i;
            long rotateLeft = java.lang.Long.rotateLeft(i, 27);
            long j3 = this.e;
            this.d = ((rotateLeft + j3) * 5) + 1390208809;
            long j4 = j(j2) ^ j3;
            this.e = j4;
            this.e = ((java.lang.Long.rotateLeft(j4, 31) + this.d) * 5) + 944331445;
        }
    }

    public Murmur3_128HashFunction(int i) {
        this.seed = i;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 128;
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return (obj instanceof com.google.common.hash.Murmur3_128HashFunction) && this.seed == ((com.google.common.hash.Murmur3_128HashFunction) obj).seed;
    }

    public int hashCode() {
        return com.google.common.hash.Murmur3_128HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.HashFunction
    public com.google.common.hash.Hasher newHasher() {
        return new com.google.common.hash.Murmur3_128HashFunction.Murmur3_128Hasher(this.seed);
    }

    public java.lang.String toString() {
        return "Hashing.murmur3_128(" + this.seed + ")";
    }
}
