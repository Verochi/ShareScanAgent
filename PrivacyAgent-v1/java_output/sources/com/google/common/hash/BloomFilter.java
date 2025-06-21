package com.google.common.hash;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class BloomFilter<T> implements com.google.common.base.Predicate<T>, java.io.Serializable {
    private final com.google.common.hash.BloomFilterStrategies.LockFreeBitArray bits;
    private final com.google.common.hash.Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final com.google.common.hash.BloomFilter.Strategy strategy;

    public static class SerialForm<T> implements java.io.Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final com.google.common.hash.Funnel<? super T> funnel;
        final int numHashFunctions;
        final com.google.common.hash.BloomFilter.Strategy strategy;

        public SerialForm(com.google.common.hash.BloomFilter<T> bloomFilter) {
            this.data = com.google.common.hash.BloomFilterStrategies.LockFreeBitArray.g(((com.google.common.hash.BloomFilter) bloomFilter).bits.a);
            this.numHashFunctions = ((com.google.common.hash.BloomFilter) bloomFilter).numHashFunctions;
            this.funnel = ((com.google.common.hash.BloomFilter) bloomFilter).funnel;
            this.strategy = ((com.google.common.hash.BloomFilter) bloomFilter).strategy;
        }

        public java.lang.Object readResolve() {
            return new com.google.common.hash.BloomFilter(new com.google.common.hash.BloomFilterStrategies.LockFreeBitArray(this.data), this.numHashFunctions, this.funnel, this.strategy, null);
        }
    }

    public interface Strategy extends java.io.Serializable {
        <T> boolean mightContain(T t, com.google.common.hash.Funnel<? super T> funnel, int i, com.google.common.hash.BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);

        int ordinal();

        <T> boolean put(T t, com.google.common.hash.Funnel<? super T> funnel, int i, com.google.common.hash.BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);
    }

    private BloomFilter(com.google.common.hash.BloomFilterStrategies.LockFreeBitArray lockFreeBitArray, int i, com.google.common.hash.Funnel<? super T> funnel, com.google.common.hash.BloomFilter.Strategy strategy) {
        com.google.common.base.Preconditions.checkArgument(i > 0, "numHashFunctions (%s) must be > 0", i);
        com.google.common.base.Preconditions.checkArgument(i <= 255, "numHashFunctions (%s) must be <= 255", i);
        this.bits = (com.google.common.hash.BloomFilterStrategies.LockFreeBitArray) com.google.common.base.Preconditions.checkNotNull(lockFreeBitArray);
        this.numHashFunctions = i;
        this.funnel = (com.google.common.hash.Funnel) com.google.common.base.Preconditions.checkNotNull(funnel);
        this.strategy = (com.google.common.hash.BloomFilter.Strategy) com.google.common.base.Preconditions.checkNotNull(strategy);
    }

    public /* synthetic */ BloomFilter(com.google.common.hash.BloomFilterStrategies.LockFreeBitArray lockFreeBitArray, int i, com.google.common.hash.Funnel funnel, com.google.common.hash.BloomFilter.Strategy strategy, com.google.common.hash.BloomFilter.AnonymousClass1 anonymousClass1) {
        this(lockFreeBitArray, i, funnel, strategy);
    }

    public static <T> com.google.common.hash.BloomFilter<T> create(com.google.common.hash.Funnel<? super T> funnel, int i) {
        return create(funnel, i);
    }

    public static <T> com.google.common.hash.BloomFilter<T> create(com.google.common.hash.Funnel<? super T> funnel, int i, double d) {
        return create(funnel, i, d);
    }

    public static <T> com.google.common.hash.BloomFilter<T> create(com.google.common.hash.Funnel<? super T> funnel, long j) {
        return create(funnel, j, 0.03d);
    }

    public static <T> com.google.common.hash.BloomFilter<T> create(com.google.common.hash.Funnel<? super T> funnel, long j, double d) {
        return create(funnel, j, d, com.google.common.hash.BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    @com.google.common.annotations.VisibleForTesting
    public static <T> com.google.common.hash.BloomFilter<T> create(com.google.common.hash.Funnel<? super T> funnel, long j, double d, com.google.common.hash.BloomFilter.Strategy strategy) {
        com.google.common.base.Preconditions.checkNotNull(funnel);
        com.google.common.base.Preconditions.checkArgument(j >= 0, "Expected insertions (%s) must be >= 0", j);
        com.google.common.base.Preconditions.checkArgument(d > 0.0d, "False positive probability (%s) must be > 0.0", java.lang.Double.valueOf(d));
        com.google.common.base.Preconditions.checkArgument(d < 1.0d, "False positive probability (%s) must be < 1.0", java.lang.Double.valueOf(d));
        com.google.common.base.Preconditions.checkNotNull(strategy);
        if (j == 0) {
            j = 1;
        }
        long optimalNumOfBits = optimalNumOfBits(j, d);
        try {
            return new com.google.common.hash.BloomFilter<>(new com.google.common.hash.BloomFilterStrategies.LockFreeBitArray(optimalNumOfBits), optimalNumOfHashFunctions(j, optimalNumOfBits), funnel, strategy);
        } catch (java.lang.IllegalArgumentException e) {
            throw new java.lang.IllegalArgumentException("Could not create BloomFilter of " + optimalNumOfBits + " bits", e);
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public static long optimalNumOfBits(long j, double d) {
        if (d == 0.0d) {
            d = Double.MIN_VALUE;
        }
        return (long) (((-j) * java.lang.Math.log(d)) / (java.lang.Math.log(2.0d) * java.lang.Math.log(2.0d)));
    }

    @com.google.common.annotations.VisibleForTesting
    public static int optimalNumOfHashFunctions(long j, long j2) {
        return java.lang.Math.max(1, (int) java.lang.Math.round((j2 / j) * java.lang.Math.log(2.0d)));
    }

    public static <T> com.google.common.hash.BloomFilter<T> readFrom(java.io.InputStream inputStream, com.google.common.hash.Funnel<? super T> funnel) throws java.io.IOException {
        int i;
        int i2;
        int readInt;
        com.google.common.base.Preconditions.checkNotNull(inputStream, "InputStream");
        com.google.common.base.Preconditions.checkNotNull(funnel, "Funnel");
        byte b = -1;
        try {
            java.io.DataInputStream dataInputStream = new java.io.DataInputStream(inputStream);
            byte readByte = dataInputStream.readByte();
            try {
                i2 = com.google.common.primitives.UnsignedBytes.toInt(dataInputStream.readByte());
            } catch (java.lang.RuntimeException e) {
                e = e;
                i2 = -1;
            }
            try {
                readInt = dataInputStream.readInt();
            } catch (java.lang.RuntimeException e2) {
                e = e2;
                b = readByte;
                i = -1;
                throw new java.io.IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b) + " numHashFunctions: " + i2 + " dataLength: " + i, e);
            }
            try {
                com.google.common.hash.BloomFilterStrategies bloomFilterStrategies = com.google.common.hash.BloomFilterStrategies.values()[readByte];
                long[] jArr = new long[readInt];
                for (int i3 = 0; i3 < readInt; i3++) {
                    jArr[i3] = dataInputStream.readLong();
                }
                return new com.google.common.hash.BloomFilter<>(new com.google.common.hash.BloomFilterStrategies.LockFreeBitArray(jArr), i2, funnel, bloomFilterStrategies);
            } catch (java.lang.RuntimeException e3) {
                e = e3;
                b = readByte;
                i = readInt;
                throw new java.io.IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b) + " numHashFunctions: " + i2 + " dataLength: " + i, e);
            }
        } catch (java.lang.RuntimeException e4) {
            e = e4;
            i = -1;
            i2 = -1;
        }
    }

    private java.lang.Object writeReplace() {
        return new com.google.common.hash.BloomFilter.SerialForm(this);
    }

    @Override // com.google.common.base.Predicate
    @java.lang.Deprecated
    public boolean apply(T t) {
        return mightContain(t);
    }

    public long approximateElementCount() {
        double b = this.bits.b();
        return com.google.common.math.DoubleMath.roundToLong(((-java.lang.Math.log1p(-(this.bits.a() / b))) * b) / this.numHashFunctions, java.math.RoundingMode.HALF_UP);
    }

    @com.google.common.annotations.VisibleForTesting
    public long bitSize() {
        return this.bits.b();
    }

    public com.google.common.hash.BloomFilter<T> copy() {
        return new com.google.common.hash.BloomFilter<>(this.bits.c(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.common.hash.BloomFilter)) {
            return false;
        }
        com.google.common.hash.BloomFilter bloomFilter = (com.google.common.hash.BloomFilter) obj;
        return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
    }

    public double expectedFpp() {
        return java.lang.Math.pow(this.bits.a() / bitSize(), this.numHashFunctions);
    }

    public int hashCode() {
        return com.google.common.base.Objects.hashCode(java.lang.Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public boolean isCompatible(com.google.common.hash.BloomFilter<T> bloomFilter) {
        com.google.common.base.Preconditions.checkNotNull(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }

    public boolean mightContain(T t) {
        return this.strategy.mightContain(t, this.funnel, this.numHashFunctions, this.bits);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean put(T t) {
        return this.strategy.put(t, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(com.google.common.hash.BloomFilter<T> bloomFilter) {
        com.google.common.base.Preconditions.checkNotNull(bloomFilter);
        com.google.common.base.Preconditions.checkArgument(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        int i = this.numHashFunctions;
        int i2 = bloomFilter.numHashFunctions;
        com.google.common.base.Preconditions.checkArgument(i == i2, "BloomFilters must have the same number of hash functions (%s != %s)", i, i2);
        com.google.common.base.Preconditions.checkArgument(bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), bloomFilter.bitSize());
        com.google.common.base.Preconditions.checkArgument(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        com.google.common.base.Preconditions.checkArgument(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.e(bloomFilter.bits);
    }

    public void writeTo(java.io.OutputStream outputStream) throws java.io.IOException {
        java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(outputStream);
        dataOutputStream.writeByte(com.google.common.primitives.SignedBytes.checkedCast(this.strategy.ordinal()));
        dataOutputStream.writeByte(com.google.common.primitives.UnsignedBytes.checkedCast(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.a.length());
        for (int i = 0; i < this.bits.a.length(); i++) {
            dataOutputStream.writeLong(this.bits.a.get(i));
        }
    }
}
