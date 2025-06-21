package kotlin.random;

@kotlin.Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a2\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a\u001e\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a&\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010 \u001a\u0014\u0010!\u001a\u00020\b*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\"\u001a\u001e\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0004\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a&\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001c\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u001e\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0002\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"checkUIntRangeBounds", "", "from", "Lkotlin/UInt;", "until", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "nextUBytes", "Lkotlin/UByteArray;", "Lkotlin/random/Random;", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class URandomKt {
    /* renamed from: checkUIntRangeBounds-J1ME1BU, reason: not valid java name */
    public static final void m560checkUIntRangeBoundsJ1ME1BU(int i, int i2) {
        if (!(kotlin.UnsignedKt.uintCompare(i2, i) > 0)) {
            throw new java.lang.IllegalArgumentException(kotlin.random.RandomKt.boundsErrorMessage(kotlin.UInt.m190boximpl(i), kotlin.UInt.m190boximpl(i2)).toString());
        }
    }

    /* renamed from: checkULongRangeBounds-eb3DHEI, reason: not valid java name */
    public static final void m561checkULongRangeBoundseb3DHEI(long j, long j2) {
        if (!(kotlin.UnsignedKt.ulongCompare(j2, j) > 0)) {
            throw new java.lang.IllegalArgumentException(kotlin.random.RandomKt.boundsErrorMessage(kotlin.ULong.m214boximpl(j), kotlin.ULong.m214boximpl(j2)).toString());
        }
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.ExperimentalUnsignedTypes
    @org.jetbrains.annotations.NotNull
    public static final byte[] nextUBytes(@org.jetbrains.annotations.NotNull kotlin.random.Random random, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "<this>");
        return kotlin.UByteArray.m175constructorimpl(random.nextBytes(i));
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.ExperimentalUnsignedTypes
    @org.jetbrains.annotations.NotNull
    /* renamed from: nextUBytes-EVgfTAA, reason: not valid java name */
    public static final byte[] m562nextUBytesEVgfTAA(@org.jetbrains.annotations.NotNull kotlin.random.Random nextUBytes, @org.jetbrains.annotations.NotNull byte[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextUBytes, "$this$nextUBytes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        nextUBytes.nextBytes(array);
        return array;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.ExperimentalUnsignedTypes
    @org.jetbrains.annotations.NotNull
    /* renamed from: nextUBytes-Wvrt4B4, reason: not valid java name */
    public static final byte[] m563nextUBytesWvrt4B4(@org.jetbrains.annotations.NotNull kotlin.random.Random nextUBytes, @org.jetbrains.annotations.NotNull byte[] array, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextUBytes, "$this$nextUBytes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        nextUBytes.nextBytes(array, i, i2);
        return array;
    }

    /* renamed from: nextUBytes-Wvrt4B4$default, reason: not valid java name */
    public static /* synthetic */ byte[] m564nextUBytesWvrt4B4$default(kotlin.random.Random random, byte[] bArr, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = kotlin.UByteArray.m181getSizeimpl(bArr);
        }
        return m563nextUBytesWvrt4B4(random, bArr, i, i2);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    public static final int nextUInt(@org.jetbrains.annotations.NotNull kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "<this>");
        return kotlin.UInt.m191constructorimpl(random.nextInt());
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    public static final int nextUInt(@org.jetbrains.annotations.NotNull kotlin.random.Random random, @org.jetbrains.annotations.NotNull kotlin.ranges.UIntRange range) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(range, "range");
        if (!range.isEmpty()) {
            return kotlin.UnsignedKt.uintCompare(range.getLast(), -1) < 0 ? m565nextUInta8DCA5k(random, range.getFirst(), kotlin.UInt.m191constructorimpl(range.getLast() + 1)) : kotlin.UnsignedKt.uintCompare(range.getFirst(), 0) > 0 ? kotlin.UInt.m191constructorimpl(m565nextUInta8DCA5k(random, kotlin.UInt.m191constructorimpl(range.getFirst() - 1), range.getLast()) + 1) : nextUInt(random);
        }
        throw new java.lang.IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: nextUInt-a8DCA5k, reason: not valid java name */
    public static final int m565nextUInta8DCA5k(@org.jetbrains.annotations.NotNull kotlin.random.Random nextUInt, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextUInt, "$this$nextUInt");
        m560checkUIntRangeBoundsJ1ME1BU(i, i2);
        return kotlin.UInt.m191constructorimpl(nextUInt.nextInt(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: nextUInt-qCasIEU, reason: not valid java name */
    public static final int m566nextUIntqCasIEU(@org.jetbrains.annotations.NotNull kotlin.random.Random nextUInt, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextUInt, "$this$nextUInt");
        return m565nextUInta8DCA5k(nextUInt, 0, i);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    public static final long nextULong(@org.jetbrains.annotations.NotNull kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "<this>");
        return kotlin.ULong.m215constructorimpl(random.nextLong());
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    public static final long nextULong(@org.jetbrains.annotations.NotNull kotlin.random.Random random, @org.jetbrains.annotations.NotNull kotlin.ranges.ULongRange range) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new java.lang.IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        if (kotlin.UnsignedKt.ulongCompare(range.getLast(), -1L) < 0) {
            return m568nextULongjmpaWc(random, range.getFirst(), kotlin.ULong.m215constructorimpl(range.getLast() + kotlin.ULong.m215constructorimpl(1 & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT)));
        }
        if (kotlin.UnsignedKt.ulongCompare(range.getFirst(), 0L) <= 0) {
            return nextULong(random);
        }
        long first = range.getFirst();
        long j = 1 & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
        return kotlin.ULong.m215constructorimpl(m568nextULongjmpaWc(random, kotlin.ULong.m215constructorimpl(first - kotlin.ULong.m215constructorimpl(j)), range.getLast()) + kotlin.ULong.m215constructorimpl(j));
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: nextULong-V1Xi4fY, reason: not valid java name */
    public static final long m567nextULongV1Xi4fY(@org.jetbrains.annotations.NotNull kotlin.random.Random nextULong, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextULong, "$this$nextULong");
        return m568nextULongjmpaWc(nextULong, 0L, j);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: nextULong-jmpaW-c, reason: not valid java name */
    public static final long m568nextULongjmpaWc(@org.jetbrains.annotations.NotNull kotlin.random.Random nextULong, long j, long j2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextULong, "$this$nextULong");
        m561checkULongRangeBoundseb3DHEI(j, j2);
        return kotlin.ULong.m215constructorimpl(nextULong.nextLong(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }
}
