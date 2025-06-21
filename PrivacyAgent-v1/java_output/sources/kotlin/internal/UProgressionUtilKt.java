package kotlin.internal;

@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0004\u001a*\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0006\u001a*\u0010\f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0004\u001a*\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lkotlin/UInt;", "a", "b", "c", "(III)I", "Lkotlin/ULong;", "(JJJ)J", com.anythink.expressad.foundation.d.c.bT, "end", "", "step", "getProgressionLastElement-Nkh28Cs", "getProgressionLastElement", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class UProgressionUtilKt {
    public static final int a(int i, int i2, int i3) {
        int m263uintRemainderJ1ME1BU = kotlin.UnsignedKt.m263uintRemainderJ1ME1BU(i, i3);
        int m263uintRemainderJ1ME1BU2 = kotlin.UnsignedKt.m263uintRemainderJ1ME1BU(i2, i3);
        int uintCompare = kotlin.UnsignedKt.uintCompare(m263uintRemainderJ1ME1BU, m263uintRemainderJ1ME1BU2);
        int m191constructorimpl = kotlin.UInt.m191constructorimpl(m263uintRemainderJ1ME1BU - m263uintRemainderJ1ME1BU2);
        return uintCompare >= 0 ? m191constructorimpl : kotlin.UInt.m191constructorimpl(m191constructorimpl + i3);
    }

    public static final long b(long j, long j2, long j3) {
        long m265ulongRemaindereb3DHEI = kotlin.UnsignedKt.m265ulongRemaindereb3DHEI(j, j3);
        long m265ulongRemaindereb3DHEI2 = kotlin.UnsignedKt.m265ulongRemaindereb3DHEI(j2, j3);
        int ulongCompare = kotlin.UnsignedKt.ulongCompare(m265ulongRemaindereb3DHEI, m265ulongRemaindereb3DHEI2);
        long m215constructorimpl = kotlin.ULong.m215constructorimpl(m265ulongRemaindereb3DHEI - m265ulongRemaindereb3DHEI2);
        return ulongCompare >= 0 ? m215constructorimpl : kotlin.ULong.m215constructorimpl(m215constructorimpl + j3);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.PublishedApi
    /* renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m558getProgressionLastElement7ftBX0g(long j, long j2, long j3) {
        if (j3 > 0) {
            return kotlin.UnsignedKt.ulongCompare(j, j2) >= 0 ? j2 : kotlin.ULong.m215constructorimpl(j2 - b(j2, j, kotlin.ULong.m215constructorimpl(j3)));
        }
        if (j3 < 0) {
            return kotlin.UnsignedKt.ulongCompare(j, j2) <= 0 ? j2 : kotlin.ULong.m215constructorimpl(j2 + b(j, j2, kotlin.ULong.m215constructorimpl(-j3)));
        }
        throw new java.lang.IllegalArgumentException("Step is zero.");
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.PublishedApi
    /* renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m559getProgressionLastElementNkh28Cs(int i, int i2, int i3) {
        if (i3 > 0) {
            return kotlin.UnsignedKt.uintCompare(i, i2) >= 0 ? i2 : kotlin.UInt.m191constructorimpl(i2 - a(i2, i, kotlin.UInt.m191constructorimpl(i3)));
        }
        if (i3 < 0) {
            return kotlin.UnsignedKt.uintCompare(i, i2) <= 0 ? i2 : kotlin.UInt.m191constructorimpl(i2 + a(i, i2, kotlin.UInt.m191constructorimpl(-i3)));
        }
        throw new java.lang.IllegalArgumentException("Step is zero.");
    }
}
