package kotlin;

@kotlin.Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0001\u001a\"\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\"\u0010\u000f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\tH\u0001\u001a\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0013H\u0001\u001a\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016\u001a\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0013H\u0001\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0013H\u0000\u001a\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\tH\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"doubleToUInt", "Lkotlin/UInt;", "v", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "uintCompare", "", com.alipay.sdk.m.x.c.c, com.alipay.sdk.m.x.c.d, "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "ulongCompare", "", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToString", "", "base", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
@kotlin.jvm.JvmName(name = "UnsignedKt")
/* loaded from: classes14.dex */
public final class UnsignedKt {
    @kotlin.PublishedApi
    public static final int doubleToUInt(double d) {
        if (java.lang.Double.isNaN(d) || d <= uintToDouble(0)) {
            return 0;
        }
        if (d >= uintToDouble(-1)) {
            return -1;
        }
        return d <= 2.147483647E9d ? kotlin.UInt.m191constructorimpl((int) d) : kotlin.UInt.m191constructorimpl(kotlin.UInt.m191constructorimpl((int) (d - Integer.MAX_VALUE)) + kotlin.UInt.m191constructorimpl(Integer.MAX_VALUE));
    }

    @kotlin.PublishedApi
    public static final long doubleToULong(double d) {
        if (java.lang.Double.isNaN(d) || d <= ulongToDouble(0L)) {
            return 0L;
        }
        if (d >= ulongToDouble(-1L)) {
            return -1L;
        }
        return d < 9.223372036854776E18d ? kotlin.ULong.m215constructorimpl((long) d) : kotlin.ULong.m215constructorimpl(kotlin.ULong.m215constructorimpl((long) (d - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @kotlin.PublishedApi
    public static final int uintCompare(int i, int i2) {
        return kotlin.jvm.internal.Intrinsics.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    @kotlin.PublishedApi
    /* renamed from: uintDivide-J1ME1BU, reason: not valid java name */
    public static final int m262uintDivideJ1ME1BU(int i, int i2) {
        return kotlin.UInt.m191constructorimpl((int) ((i & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) / (i2 & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT)));
    }

    @kotlin.PublishedApi
    /* renamed from: uintRemainder-J1ME1BU, reason: not valid java name */
    public static final int m263uintRemainderJ1ME1BU(int i, int i2) {
        return kotlin.UInt.m191constructorimpl((int) ((i & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) % (i2 & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT)));
    }

    @kotlin.PublishedApi
    public static final double uintToDouble(int i) {
        return (Integer.MAX_VALUE & i) + (((i >>> 31) << 30) * 2);
    }

    @kotlin.PublishedApi
    public static final int ulongCompare(long j, long j2) {
        return kotlin.jvm.internal.Intrinsics.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    @kotlin.PublishedApi
    /* renamed from: ulongDivide-eb3DHEI, reason: not valid java name */
    public static final long m264ulongDivideeb3DHEI(long j, long j2) {
        if (j2 < 0) {
            return ulongCompare(j, j2) < 0 ? kotlin.ULong.m215constructorimpl(0L) : kotlin.ULong.m215constructorimpl(1L);
        }
        if (j >= 0) {
            return kotlin.ULong.m215constructorimpl(j / j2);
        }
        long j3 = ((j >>> 1) / j2) << 1;
        return kotlin.ULong.m215constructorimpl(j3 + (ulongCompare(kotlin.ULong.m215constructorimpl(j - (j3 * j2)), kotlin.ULong.m215constructorimpl(j2)) < 0 ? 0 : 1));
    }

    @kotlin.PublishedApi
    /* renamed from: ulongRemainder-eb3DHEI, reason: not valid java name */
    public static final long m265ulongRemaindereb3DHEI(long j, long j2) {
        if (j2 < 0) {
            return ulongCompare(j, j2) < 0 ? j : kotlin.ULong.m215constructorimpl(j - j2);
        }
        if (j >= 0) {
            return kotlin.ULong.m215constructorimpl(j % j2);
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (ulongCompare(kotlin.ULong.m215constructorimpl(j3), kotlin.ULong.m215constructorimpl(j2)) < 0) {
            j2 = 0;
        }
        return kotlin.ULong.m215constructorimpl(j3 - j2);
    }

    @kotlin.PublishedApi
    public static final double ulongToDouble(long j) {
        return ((j >>> 11) * 2048) + (j & 2047);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ulongToString(long j) {
        return ulongToString(j, 10);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ulongToString(long j, int i) {
        int checkRadix;
        int checkRadix2;
        int checkRadix3;
        if (j >= 0) {
            checkRadix3 = kotlin.text.CharsKt__CharJVMKt.checkRadix(i);
            java.lang.String l = java.lang.Long.toString(j, checkRadix3);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(l, "toString(this, checkRadix(radix))");
            return l;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        checkRadix = kotlin.text.CharsKt__CharJVMKt.checkRadix(i);
        java.lang.String l2 = java.lang.Long.toString(j3, checkRadix);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(l2, "toString(this, checkRadix(radix))");
        sb.append(l2);
        checkRadix2 = kotlin.text.CharsKt__CharJVMKt.checkRadix(i);
        java.lang.String l3 = java.lang.Long.toString(j4, checkRadix2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(l3, "toString(this, checkRadix(radix))");
        sb.append(l3);
        return sb.toString();
    }
}
