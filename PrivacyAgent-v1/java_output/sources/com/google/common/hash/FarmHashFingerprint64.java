package com.google.common.hash;

/* loaded from: classes22.dex */
final class FarmHashFingerprint64 extends com.google.common.hash.AbstractNonStreamingHashFunction {
    public static final com.google.common.hash.HashFunction n = new com.google.common.hash.FarmHashFingerprint64();

    @com.google.common.annotations.VisibleForTesting
    public static long a(byte[] bArr, int i, int i2) {
        return i2 <= 32 ? i2 <= 16 ? b(bArr, i, i2) : d(bArr, i, i2) : i2 <= 64 ? e(bArr, i, i2) : f(bArr, i, i2);
    }

    public static long b(byte[] bArr, int i, int i2) {
        if (i2 >= 8) {
            long j = (i2 * 2) - 7286425919675154353L;
            long b = com.google.common.hash.LittleEndianByteArray.b(bArr, i) - 7286425919675154353L;
            long b2 = com.google.common.hash.LittleEndianByteArray.b(bArr, (i + i2) - 8);
            return c((java.lang.Long.rotateRight(b2, 37) * j) + b, (java.lang.Long.rotateRight(b, 25) + b2) * j, j);
        }
        if (i2 >= 4) {
            return c(i2 + ((com.google.common.hash.LittleEndianByteArray.a(bArr, i) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) << 3), com.google.common.hash.LittleEndianByteArray.a(bArr, (i + i2) - 4) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT, (i2 * 2) - 7286425919675154353L);
        }
        if (i2 <= 0) {
            return -7286425919675154353L;
        }
        return g((((bArr[i] & 255) + ((bArr[(i2 >> 1) + i] & 255) << 8)) * (-7286425919675154353L)) ^ ((i2 + ((bArr[i + (i2 - 1)] & 255) << 2)) * (-4348849565147123417L))) * (-7286425919675154353L);
    }

    public static long c(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    public static long d(byte[] bArr, int i, int i2) {
        long j = (i2 * 2) - 7286425919675154353L;
        long b = com.google.common.hash.LittleEndianByteArray.b(bArr, i) * (-5435081209227447693L);
        long b2 = com.google.common.hash.LittleEndianByteArray.b(bArr, i + 8);
        int i3 = i + i2;
        long b3 = com.google.common.hash.LittleEndianByteArray.b(bArr, i3 - 8) * j;
        return c((com.google.common.hash.LittleEndianByteArray.b(bArr, i3 - 16) * (-7286425919675154353L)) + java.lang.Long.rotateRight(b + b2, 43) + java.lang.Long.rotateRight(b3, 30), b + java.lang.Long.rotateRight(b2 - 7286425919675154353L, 18) + b3, j);
    }

    public static long e(byte[] bArr, int i, int i2) {
        long j = (i2 * 2) - 7286425919675154353L;
        long b = com.google.common.hash.LittleEndianByteArray.b(bArr, i) * (-7286425919675154353L);
        long b2 = com.google.common.hash.LittleEndianByteArray.b(bArr, i + 8);
        int i3 = i + i2;
        long b3 = com.google.common.hash.LittleEndianByteArray.b(bArr, i3 - 8) * j;
        long rotateRight = java.lang.Long.rotateRight(b + b2, 43) + java.lang.Long.rotateRight(b3, 30) + (com.google.common.hash.LittleEndianByteArray.b(bArr, i3 - 16) * (-7286425919675154353L));
        long c = c(rotateRight, b3 + java.lang.Long.rotateRight(b2 - 7286425919675154353L, 18) + b, j);
        long b4 = com.google.common.hash.LittleEndianByteArray.b(bArr, i + 16) * j;
        long b5 = com.google.common.hash.LittleEndianByteArray.b(bArr, i + 24);
        long b6 = (rotateRight + com.google.common.hash.LittleEndianByteArray.b(bArr, i3 - 32)) * j;
        return c(((c + com.google.common.hash.LittleEndianByteArray.b(bArr, i3 - 24)) * j) + java.lang.Long.rotateRight(b4 + b5, 43) + java.lang.Long.rotateRight(b6, 30), b4 + java.lang.Long.rotateRight(b5 + b, 18) + b6, j);
    }

    public static long f(byte[] bArr, int i, int i2) {
        long g = g(-7956866745689871395L) * (-7286425919675154353L);
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long b = 95310865018149119L + com.google.common.hash.LittleEndianByteArray.b(bArr, i);
        int i3 = i2 - 1;
        int i4 = i + ((i3 / 64) * 64);
        int i5 = i3 & 63;
        int i6 = (i4 + i5) - 63;
        long j = 2480279821605975764L;
        int i7 = i;
        while (true) {
            long rotateRight = java.lang.Long.rotateRight(b + j + jArr[0] + com.google.common.hash.LittleEndianByteArray.b(bArr, i7 + 8), 37) * (-5435081209227447693L);
            long rotateRight2 = java.lang.Long.rotateRight(j + jArr[1] + com.google.common.hash.LittleEndianByteArray.b(bArr, i7 + 48), 42) * (-5435081209227447693L);
            long j2 = rotateRight ^ jArr2[1];
            long b2 = rotateRight2 + jArr[0] + com.google.common.hash.LittleEndianByteArray.b(bArr, i7 + 40);
            long rotateRight3 = java.lang.Long.rotateRight(g + jArr2[0], 33) * (-5435081209227447693L);
            h(bArr, i7, jArr[1] * (-5435081209227447693L), j2 + jArr2[0], jArr);
            h(bArr, i7 + 32, rotateRight3 + jArr2[1], b2 + com.google.common.hash.LittleEndianByteArray.b(bArr, i7 + 16), jArr2);
            i7 += 64;
            if (i7 == i4) {
                long j3 = ((j2 & 255) << 1) - 5435081209227447693L;
                long j4 = jArr2[0] + i5;
                jArr2[0] = j4;
                long j5 = jArr[0] + j4;
                jArr[0] = j5;
                jArr2[0] = jArr2[0] + j5;
                long rotateRight4 = java.lang.Long.rotateRight(rotateRight3 + b2 + jArr[0] + com.google.common.hash.LittleEndianByteArray.b(bArr, i6 + 8), 37) * j3;
                long rotateRight5 = java.lang.Long.rotateRight(b2 + jArr[1] + com.google.common.hash.LittleEndianByteArray.b(bArr, i6 + 48), 42) * j3;
                long j6 = rotateRight4 ^ (jArr2[1] * 9);
                long b3 = rotateRight5 + (jArr[0] * 9) + com.google.common.hash.LittleEndianByteArray.b(bArr, i6 + 40);
                long rotateRight6 = java.lang.Long.rotateRight(j2 + jArr2[0], 33) * j3;
                h(bArr, i6, jArr[1] * j3, j6 + jArr2[0], jArr);
                h(bArr, i6 + 32, rotateRight6 + jArr2[1], com.google.common.hash.LittleEndianByteArray.b(bArr, i6 + 16) + b3, jArr2);
                return c(c(jArr[0], jArr2[0], j3) + (g(b3) * (-4348849565147123417L)) + j6, c(jArr[1], jArr2[1], j3) + rotateRight6, j3);
            }
            g = j2;
            j = b2;
            b = rotateRight3;
        }
    }

    public static long g(long j) {
        return j ^ (j >>> 47);
    }

    public static void h(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long b = com.google.common.hash.LittleEndianByteArray.b(bArr, i);
        long b2 = com.google.common.hash.LittleEndianByteArray.b(bArr, i + 8);
        long b3 = com.google.common.hash.LittleEndianByteArray.b(bArr, i + 16);
        long b4 = com.google.common.hash.LittleEndianByteArray.b(bArr, i + 24);
        long j3 = j + b;
        long j4 = b2 + j3 + b3;
        long rotateRight = java.lang.Long.rotateRight(j2 + j3 + b4, 21) + java.lang.Long.rotateRight(j4, 44);
        jArr[0] = j4 + b4;
        jArr[1] = rotateRight + j3;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    @Override // com.google.common.hash.AbstractNonStreamingHashFunction, com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public com.google.common.hash.HashCode hashBytes(byte[] bArr, int i, int i2) {
        com.google.common.base.Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        return com.google.common.hash.HashCode.fromLong(a(bArr, i, i2));
    }

    public java.lang.String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}
