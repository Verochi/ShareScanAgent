package kotlin.random;

@kotlin.SinceKotlin(version = "1.3")
@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016¨\u0006\u0018"}, d2 = {"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Default", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public abstract class Random {

    /* renamed from: Default, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.random.Random.Companion INSTANCE = new kotlin.random.Random.Companion(null);

    @org.jetbrains.annotations.NotNull
    private static final kotlin.random.Random defaultRandom = kotlin.internal.PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();

    @kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "writeReplace", "", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.random.Random$Default, reason: from kotlin metadata */
    public static final class Companion extends kotlin.random.Random implements java.io.Serializable {

        @kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "readResolve", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* renamed from: kotlin.random.Random$Default$Serialized */
        public static final class Serialized implements java.io.Serializable {

            @org.jetbrains.annotations.NotNull
            public static final kotlin.random.Random.Companion.Serialized INSTANCE = new kotlin.random.Random.Companion.Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final java.lang.Object readResolve() {
                return kotlin.random.Random.INSTANCE;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final java.lang.Object writeReplace() {
            return kotlin.random.Random.Companion.Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public int nextBits(int bitCount) {
            return kotlin.random.Random.defaultRandom.nextBits(bitCount);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return kotlin.random.Random.defaultRandom.nextBoolean();
        }

        @Override // kotlin.random.Random
        @org.jetbrains.annotations.NotNull
        public byte[] nextBytes(int size) {
            return kotlin.random.Random.defaultRandom.nextBytes(size);
        }

        @Override // kotlin.random.Random
        @org.jetbrains.annotations.NotNull
        public byte[] nextBytes(@org.jetbrains.annotations.NotNull byte[] array) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
            return kotlin.random.Random.defaultRandom.nextBytes(array);
        }

        @Override // kotlin.random.Random
        @org.jetbrains.annotations.NotNull
        public byte[] nextBytes(@org.jetbrains.annotations.NotNull byte[] array, int fromIndex, int toIndex) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
            return kotlin.random.Random.defaultRandom.nextBytes(array, fromIndex, toIndex);
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return kotlin.random.Random.defaultRandom.nextDouble();
        }

        @Override // kotlin.random.Random
        public double nextDouble(double until) {
            return kotlin.random.Random.defaultRandom.nextDouble(until);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double from, double until) {
            return kotlin.random.Random.defaultRandom.nextDouble(from, until);
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return kotlin.random.Random.defaultRandom.nextFloat();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return kotlin.random.Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public int nextInt(int until) {
            return kotlin.random.Random.defaultRandom.nextInt(until);
        }

        @Override // kotlin.random.Random
        public int nextInt(int from, int until) {
            return kotlin.random.Random.defaultRandom.nextInt(from, until);
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return kotlin.random.Random.defaultRandom.nextLong();
        }

        @Override // kotlin.random.Random
        public long nextLong(long until) {
            return kotlin.random.Random.defaultRandom.nextLong(until);
        }

        @Override // kotlin.random.Random
        public long nextLong(long from, long until) {
            return kotlin.random.Random.defaultRandom.nextLong(from, until);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(kotlin.random.Random random, byte[] bArr, int i, int i2, int i3, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return random.nextBytes(bArr, i, i2);
    }

    public abstract int nextBits(int bitCount);

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    @org.jetbrains.annotations.NotNull
    public byte[] nextBytes(int size) {
        return nextBytes(new byte[size]);
    }

    @org.jetbrains.annotations.NotNull
    public byte[] nextBytes(@org.jetbrains.annotations.NotNull byte[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        return nextBytes(array, 0, array.length);
    }

    @org.jetbrains.annotations.NotNull
    public byte[] nextBytes(@org.jetbrains.annotations.NotNull byte[] array, int fromIndex, int toIndex) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        if (!(new kotlin.ranges.IntRange(0, array.length).contains(fromIndex) && new kotlin.ranges.IntRange(0, array.length).contains(toIndex))) {
            throw new java.lang.IllegalArgumentException(("fromIndex (" + fromIndex + ") or toIndex (" + toIndex + ") are out of range: 0.." + array.length + '.').toString());
        }
        if (!(fromIndex <= toIndex)) {
            throw new java.lang.IllegalArgumentException(("fromIndex (" + fromIndex + ") must be not greater than toIndex (" + toIndex + ").").toString());
        }
        int i = (toIndex - fromIndex) / 4;
        for (int i2 = 0; i2 < i; i2++) {
            int nextInt = nextInt();
            array[fromIndex] = (byte) nextInt;
            array[fromIndex + 1] = (byte) (nextInt >>> 8);
            array[fromIndex + 2] = (byte) (nextInt >>> 16);
            array[fromIndex + 3] = (byte) (nextInt >>> 24);
            fromIndex += 4;
        }
        int i3 = toIndex - fromIndex;
        int nextBits = nextBits(i3 * 8);
        for (int i4 = 0; i4 < i3; i4++) {
            array[fromIndex + i4] = (byte) (nextBits >>> (i4 * 8));
        }
        return array;
    }

    public double nextDouble() {
        return kotlin.random.PlatformRandomKt.doubleFromParts(nextBits(26), nextBits(27));
    }

    public double nextDouble(double until) {
        return nextDouble(0.0d, until);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double nextDouble(double from, double until) {
        double nextDouble;
        kotlin.random.RandomKt.checkRangeBounds(from, until);
        double d = until - from;
        if (java.lang.Double.isInfinite(d)) {
            if ((java.lang.Double.isInfinite(from) || java.lang.Double.isNaN(from)) ? false : true) {
                if ((java.lang.Double.isInfinite(until) || java.lang.Double.isNaN(until)) ? false : true) {
                    double d2 = 2;
                    double nextDouble2 = nextDouble() * ((until / d2) - (from / d2));
                    nextDouble = from + nextDouble2 + nextDouble2;
                    return nextDouble < until ? java.lang.Math.nextAfter(until, Double.NEGATIVE_INFINITY) : nextDouble;
                }
            }
        }
        nextDouble = from + (nextDouble() * d);
        if (nextDouble < until) {
        }
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public int nextInt(int until) {
        return nextInt(0, until);
    }

    public int nextInt(int from, int until) {
        int nextInt;
        int i;
        int i2;
        int nextInt2;
        boolean z;
        kotlin.random.RandomKt.checkRangeBounds(from, until);
        int i3 = until - from;
        if (i3 > 0 || i3 == Integer.MIN_VALUE) {
            if (((-i3) & i3) == i3) {
                i2 = nextBits(kotlin.random.RandomKt.fastLog2(i3));
            } else {
                do {
                    nextInt = nextInt() >>> 1;
                    i = nextInt % i3;
                } while ((nextInt - i) + (i3 - 1) < 0);
                i2 = i;
            }
            return from + i2;
        }
        do {
            nextInt2 = nextInt();
            z = false;
            if (from <= nextInt2 && nextInt2 < until) {
                z = true;
            }
        } while (!z);
        return nextInt2;
    }

    public long nextLong() {
        return (nextInt() << 32) + nextInt();
    }

    public long nextLong(long until) {
        return nextLong(0L, until);
    }

    public long nextLong(long from, long until) {
        long nextLong;
        boolean z;
        long nextLong2;
        long j;
        long j2;
        int nextInt;
        kotlin.random.RandomKt.checkRangeBounds(from, until);
        long j3 = until - from;
        if (j3 <= 0) {
            do {
                nextLong = nextLong();
                z = false;
                if (from <= nextLong && nextLong < until) {
                    z = true;
                }
            } while (!z);
            return nextLong;
        }
        if (((-j3) & j3) == j3) {
            int i = (int) j3;
            int i2 = (int) (j3 >>> 32);
            if (i != 0) {
                nextInt = nextBits(kotlin.random.RandomKt.fastLog2(i));
            } else if (i2 == 1) {
                nextInt = nextInt();
            } else {
                j2 = (nextBits(kotlin.random.RandomKt.fastLog2(i2)) << 32) + (nextInt() & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT);
            }
            j2 = nextInt & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
        } else {
            do {
                nextLong2 = nextLong() >>> 1;
                j = nextLong2 % j3;
            } while ((nextLong2 - j) + (j3 - 1) < 0);
            j2 = j;
        }
        return from + j2;
    }
}
