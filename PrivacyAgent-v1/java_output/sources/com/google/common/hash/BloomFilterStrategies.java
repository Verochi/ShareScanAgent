package com.google.common.hash;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes22.dex */
abstract class BloomFilterStrategies implements com.google.common.hash.BloomFilter.Strategy {
    private static final /* synthetic */ com.google.common.hash.BloomFilterStrategies[] $VALUES;
    public static final com.google.common.hash.BloomFilterStrategies MURMUR128_MITZ_32;
    public static final com.google.common.hash.BloomFilterStrategies MURMUR128_MITZ_64;

    /* renamed from: com.google.common.hash.BloomFilterStrategies$1, reason: invalid class name */
    public enum AnonymousClass1 extends com.google.common.hash.BloomFilterStrategies {
        public AnonymousClass1(java.lang.String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t, com.google.common.hash.Funnel<? super T> funnel, int i, com.google.common.hash.BloomFilterStrategies.LockFreeBitArray lockFreeBitArray) {
            long b = lockFreeBitArray.b();
            long asLong = com.google.common.hash.Hashing.murmur3_128().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                if (!lockFreeBitArray.d(i5 % b)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t, com.google.common.hash.Funnel<? super T> funnel, int i, com.google.common.hash.BloomFilterStrategies.LockFreeBitArray lockFreeBitArray) {
            long b = lockFreeBitArray.b();
            long asLong = com.google.common.hash.Hashing.murmur3_128().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            boolean z = false;
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                z |= lockFreeBitArray.f(i5 % b);
            }
            return z;
        }
    }

    /* renamed from: com.google.common.hash.BloomFilterStrategies$2, reason: invalid class name */
    public enum AnonymousClass2 extends com.google.common.hash.BloomFilterStrategies {
        public AnonymousClass2(java.lang.String str, int i) {
            super(str, i, null);
        }

        private long lowerEight(byte[] bArr) {
            return com.google.common.primitives.Longs.fromBytes(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return com.google.common.primitives.Longs.fromBytes(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t, com.google.common.hash.Funnel<? super T> funnel, int i, com.google.common.hash.BloomFilterStrategies.LockFreeBitArray lockFreeBitArray) {
            long b = lockFreeBitArray.b();
            byte[] bytesInternal = com.google.common.hash.Hashing.murmur3_128().hashObject(t, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            for (int i2 = 0; i2 < i; i2++) {
                if (!lockFreeBitArray.d((Long.MAX_VALUE & lowerEight) % b)) {
                    return false;
                }
                lowerEight += upperEight;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t, com.google.common.hash.Funnel<? super T> funnel, int i, com.google.common.hash.BloomFilterStrategies.LockFreeBitArray lockFreeBitArray) {
            long b = lockFreeBitArray.b();
            byte[] bytesInternal = com.google.common.hash.Hashing.murmur3_128().hashObject(t, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            boolean z = false;
            for (int i2 = 0; i2 < i; i2++) {
                z |= lockFreeBitArray.f((Long.MAX_VALUE & lowerEight) % b);
                lowerEight += upperEight;
            }
            return z;
        }
    }

    public static final class LockFreeBitArray {
        public final java.util.concurrent.atomic.AtomicLongArray a;
        public final com.google.common.hash.LongAddable b;

        public LockFreeBitArray(long j) {
            this(new long[com.google.common.primitives.Ints.checkedCast(com.google.common.math.LongMath.divide(j, 64L, java.math.RoundingMode.CEILING))]);
        }

        public LockFreeBitArray(long[] jArr) {
            com.google.common.base.Preconditions.checkArgument(jArr.length > 0, "data length is zero!");
            this.a = new java.util.concurrent.atomic.AtomicLongArray(jArr);
            this.b = com.google.common.hash.LongAddables.a();
            long j = 0;
            for (long j2 : jArr) {
                j += java.lang.Long.bitCount(j2);
            }
            this.b.add(j);
        }

        public static long[] g(java.util.concurrent.atomic.AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                jArr[i] = atomicLongArray.get(i);
            }
            return jArr;
        }

        public long a() {
            return this.b.sum();
        }

        public long b() {
            return this.a.length() * 64;
        }

        public com.google.common.hash.BloomFilterStrategies.LockFreeBitArray c() {
            return new com.google.common.hash.BloomFilterStrategies.LockFreeBitArray(g(this.a));
        }

        public boolean d(long j) {
            return ((1 << ((int) j)) & this.a.get((int) (j >>> 6))) != 0;
        }

        public void e(com.google.common.hash.BloomFilterStrategies.LockFreeBitArray lockFreeBitArray) {
            long j;
            long j2;
            boolean z;
            com.google.common.base.Preconditions.checkArgument(this.a.length() == lockFreeBitArray.a.length(), "BitArrays must be of equal length (%s != %s)", this.a.length(), lockFreeBitArray.a.length());
            for (int i = 0; i < this.a.length(); i++) {
                long j3 = lockFreeBitArray.a.get(i);
                while (true) {
                    j = this.a.get(i);
                    j2 = j | j3;
                    if (j != j2) {
                        if (this.a.compareAndSet(i, j, j2)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    this.b.add(java.lang.Long.bitCount(j2) - java.lang.Long.bitCount(j));
                }
            }
        }

        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.hash.BloomFilterStrategies.LockFreeBitArray) {
                return java.util.Arrays.equals(g(this.a), g(((com.google.common.hash.BloomFilterStrategies.LockFreeBitArray) obj).a));
            }
            return false;
        }

        public boolean f(long j) {
            long j2;
            long j3;
            if (d(j)) {
                return false;
            }
            int i = (int) (j >>> 6);
            long j4 = 1 << ((int) j);
            do {
                j2 = this.a.get(i);
                j3 = j2 | j4;
                if (j2 == j3) {
                    return false;
                }
            } while (!this.a.compareAndSet(i, j2, j3));
            this.b.increment();
            return true;
        }

        public int hashCode() {
            return java.util.Arrays.hashCode(g(this.a));
        }
    }

    static {
        com.google.common.hash.BloomFilterStrategies.AnonymousClass1 anonymousClass1 = new com.google.common.hash.BloomFilterStrategies.AnonymousClass1("MURMUR128_MITZ_32", 0);
        MURMUR128_MITZ_32 = anonymousClass1;
        com.google.common.hash.BloomFilterStrategies.AnonymousClass2 anonymousClass2 = new com.google.common.hash.BloomFilterStrategies.AnonymousClass2("MURMUR128_MITZ_64", 1);
        MURMUR128_MITZ_64 = anonymousClass2;
        $VALUES = new com.google.common.hash.BloomFilterStrategies[]{anonymousClass1, anonymousClass2};
    }

    private BloomFilterStrategies(java.lang.String str, int i) {
    }

    public /* synthetic */ BloomFilterStrategies(java.lang.String str, int i, com.google.common.hash.BloomFilterStrategies.AnonymousClass1 anonymousClass1) {
        this(str, i);
    }

    public static com.google.common.hash.BloomFilterStrategies valueOf(java.lang.String str) {
        return (com.google.common.hash.BloomFilterStrategies) java.lang.Enum.valueOf(com.google.common.hash.BloomFilterStrategies.class, str);
    }

    public static com.google.common.hash.BloomFilterStrategies[] values() {
        return (com.google.common.hash.BloomFilterStrategies[]) $VALUES.clone();
    }
}
