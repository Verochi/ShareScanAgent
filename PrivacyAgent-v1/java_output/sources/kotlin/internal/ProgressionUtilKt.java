package kotlin.internal;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u001a\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0004H\u0002\u001a \u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0002\u001a \u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a \u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0001\u001a \u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0001¨\u0006\n"}, d2 = {"", "a", "b", "c", "", "d", com.anythink.expressad.foundation.d.c.bT, "end", "step", "getProgressionLastElement", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ProgressionUtilKt {
    public static final int a(int i, int i2, int i3) {
        return c(c(i, i3) - c(i2, i3), i3);
    }

    public static final long b(long j, long j2, long j3) {
        return d(d(j, j3) - d(j2, j3), j3);
    }

    public static final int c(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    public static final long d(long j, long j2) {
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }

    @kotlin.PublishedApi
    public static final int getProgressionLastElement(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - a(i2, i, i3);
        }
        if (i3 < 0) {
            return i <= i2 ? i2 : i2 + a(i, i2, -i3);
        }
        throw new java.lang.IllegalArgumentException("Step is zero.");
    }

    @kotlin.PublishedApi
    public static final long getProgressionLastElement(long j, long j2, long j3) {
        if (j3 > 0) {
            return j >= j2 ? j2 : j2 - b(j2, j, j3);
        }
        if (j3 < 0) {
            return j <= j2 ? j2 : j2 + b(j, j2, -j3);
        }
        throw new java.lang.IllegalArgumentException("Step is zero.");
    }
}
