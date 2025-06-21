package kotlin.comparisons;

@kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a\"\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\"\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\"\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a&\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0010\u001a\u00020\u000f\"\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\n\u0010\u0010\u001a\u00020\u0013\"\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a&\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\t2\n\u0010\u0010\u001a\u00020\u0016\"\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a&\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\f2\n\u0010\u0010\u001a\u00020\u0019\"\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\"\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0004\u001a\"\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\b\u001a\"\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u000b\u001a\"\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010\u000e\u001a&\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0010\u001a\u00020\u000f\"\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0012\u001a&\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\n\u0010\u0010\u001a\u00020\u0013\"\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0015\u001a&\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\t2\n\u0010\u0010\u001a\u00020\u0016\"\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010\u0018\u001a&\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\f2\n\u0010\u0010\u001a\u00020\u0019\"\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lkotlin/UInt;", "a", "b", "maxOf-J1ME1BU", "(II)I", "maxOf", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "Lkotlin/UByte;", "maxOf-Kr8caGY", "(BB)B", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "Lkotlin/UIntArray;", "other", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf-J1ME1BU", "minOf", "minOf-eb3DHEI", "minOf-Kr8caGY", "minOf-5PvTz6A", "minOf-Md2H83M", "minOf-R03FKyM", "minOf-Wr6uiD8", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/comparisons/UComparisonsKt")
/* loaded from: classes14.dex */
class UComparisonsKt___UComparisonsKt {
    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-5PvTz6A, reason: not valid java name */
    public static final short m542maxOf5PvTz6A(short s2, short s3) {
        return kotlin.jvm.internal.Intrinsics.compare(s2 & kotlin.UShort.MAX_VALUE, 65535 & s3) >= 0 ? s2 : s3;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-J1ME1BU, reason: not valid java name */
    public static final int m543maxOfJ1ME1BU(int i, int i2) {
        return kotlin.UnsignedKt.uintCompare(i, i2) >= 0 ? i : i2;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-Kr8caGY, reason: not valid java name */
    public static final byte m544maxOfKr8caGY(byte b, byte b2) {
        return kotlin.jvm.internal.Intrinsics.compare(b & 255, b2 & 255) >= 0 ? b : b2;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.ExperimentalUnsignedTypes
    /* renamed from: maxOf-Md2H83M, reason: not valid java name */
    public static final int m545maxOfMd2H83M(int i, @org.jetbrains.annotations.NotNull int... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        int m205getSizeimpl = kotlin.UIntArray.m205getSizeimpl(other);
        for (int i2 = 0; i2 < m205getSizeimpl; i2++) {
            i = m543maxOfJ1ME1BU(i, kotlin.UIntArray.m204getpVg5ArA(other, i2));
        }
        return i;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.ExperimentalUnsignedTypes
    /* renamed from: maxOf-R03FKyM, reason: not valid java name */
    public static final long m546maxOfR03FKyM(long j, @org.jetbrains.annotations.NotNull long... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        int m229getSizeimpl = kotlin.ULongArray.m229getSizeimpl(other);
        for (int i = 0; i < m229getSizeimpl; i++) {
            j = m548maxOfeb3DHEI(j, kotlin.ULongArray.m228getsVKNKU(other, i));
        }
        return j;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.ExperimentalUnsignedTypes
    /* renamed from: maxOf-Wr6uiD8, reason: not valid java name */
    public static final byte m547maxOfWr6uiD8(byte b, @org.jetbrains.annotations.NotNull byte... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        int m181getSizeimpl = kotlin.UByteArray.m181getSizeimpl(other);
        for (int i = 0; i < m181getSizeimpl; i++) {
            b = m544maxOfKr8caGY(b, kotlin.UByteArray.m180getw2LRezQ(other, i));
        }
        return b;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-eb3DHEI, reason: not valid java name */
    public static final long m548maxOfeb3DHEI(long j, long j2) {
        return kotlin.UnsignedKt.ulongCompare(j, j2) >= 0 ? j : j2;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.ExperimentalUnsignedTypes
    /* renamed from: maxOf-t1qELG4, reason: not valid java name */
    public static final short m549maxOft1qELG4(short s2, @org.jetbrains.annotations.NotNull short... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        int m253getSizeimpl = kotlin.UShortArray.m253getSizeimpl(other);
        for (int i = 0; i < m253getSizeimpl; i++) {
            s2 = m542maxOf5PvTz6A(s2, kotlin.UShortArray.m252getMh2AYeg(other, i));
        }
        return s2;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-5PvTz6A, reason: not valid java name */
    public static final short m550minOf5PvTz6A(short s2, short s3) {
        return kotlin.jvm.internal.Intrinsics.compare(s2 & kotlin.UShort.MAX_VALUE, 65535 & s3) <= 0 ? s2 : s3;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-J1ME1BU, reason: not valid java name */
    public static final int m551minOfJ1ME1BU(int i, int i2) {
        return kotlin.UnsignedKt.uintCompare(i, i2) <= 0 ? i : i2;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-Kr8caGY, reason: not valid java name */
    public static final byte m552minOfKr8caGY(byte b, byte b2) {
        return kotlin.jvm.internal.Intrinsics.compare(b & 255, b2 & 255) <= 0 ? b : b2;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.ExperimentalUnsignedTypes
    /* renamed from: minOf-Md2H83M, reason: not valid java name */
    public static final int m553minOfMd2H83M(int i, @org.jetbrains.annotations.NotNull int... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        int m205getSizeimpl = kotlin.UIntArray.m205getSizeimpl(other);
        for (int i2 = 0; i2 < m205getSizeimpl; i2++) {
            i = m551minOfJ1ME1BU(i, kotlin.UIntArray.m204getpVg5ArA(other, i2));
        }
        return i;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.ExperimentalUnsignedTypes
    /* renamed from: minOf-R03FKyM, reason: not valid java name */
    public static final long m554minOfR03FKyM(long j, @org.jetbrains.annotations.NotNull long... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        int m229getSizeimpl = kotlin.ULongArray.m229getSizeimpl(other);
        for (int i = 0; i < m229getSizeimpl; i++) {
            j = m556minOfeb3DHEI(j, kotlin.ULongArray.m228getsVKNKU(other, i));
        }
        return j;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.ExperimentalUnsignedTypes
    /* renamed from: minOf-Wr6uiD8, reason: not valid java name */
    public static final byte m555minOfWr6uiD8(byte b, @org.jetbrains.annotations.NotNull byte... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        int m181getSizeimpl = kotlin.UByteArray.m181getSizeimpl(other);
        for (int i = 0; i < m181getSizeimpl; i++) {
            b = m552minOfKr8caGY(b, kotlin.UByteArray.m180getw2LRezQ(other, i));
        }
        return b;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-eb3DHEI, reason: not valid java name */
    public static final long m556minOfeb3DHEI(long j, long j2) {
        return kotlin.UnsignedKt.ulongCompare(j, j2) <= 0 ? j : j2;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.ExperimentalUnsignedTypes
    /* renamed from: minOf-t1qELG4, reason: not valid java name */
    public static final short m557minOft1qELG4(short s2, @org.jetbrains.annotations.NotNull short... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        int m253getSizeimpl = kotlin.UShortArray.m253getSizeimpl(other);
        for (int i = 0; i < m253getSizeimpl; i++) {
            s2 = m550minOf5PvTz6A(s2, kotlin.UShortArray.m252getMh2AYeg(other, i));
        }
        return s2;
    }
}
