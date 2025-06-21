package kotlin.ranges;

@kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\b\u0017\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB$\b\u0000\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0086\u0002ø\u0001\u0000J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u0010\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0017\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001d"}, d2 = {"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "", "iterator", "", "isEmpty", "", "other", "equals", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "toString", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "J", "first", "t", "last", "", com.umeng.analytics.pro.bo.aN, "getStep", "()J", "step", com.anythink.expressad.foundation.d.c.bT, "endInclusive", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
/* loaded from: classes14.dex */
public class ULongProgression implements java.lang.Iterable<kotlin.ULong>, kotlin.jvm.internal.markers.KMappedMarker {

    /* renamed from: Companion, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.ULongProgression.Companion INSTANCE = new kotlin.ranges.ULongProgression.Companion(null);

    /* renamed from: n, reason: from kotlin metadata */
    public final long first;

    /* renamed from: t, reason: from kotlin metadata */
    public final long last;

    /* renamed from: u, reason: from kotlin metadata */
    public final long step;

    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lkotlin/ranges/ULongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/ULongProgression;", "rangeStart", "Lkotlin/ULong;", "rangeEnd", "step", "", "fromClosedRange-7ftBX0g", "(JJJ)Lkotlin/ranges/ULongProgression;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @org.jetbrains.annotations.NotNull
        /* renamed from: fromClosedRange-7ftBX0g, reason: not valid java name */
        public final kotlin.ranges.ULongProgression m577fromClosedRange7ftBX0g(long rangeStart, long rangeEnd, long step) {
            return new kotlin.ranges.ULongProgression(rangeStart, rangeEnd, step, null);
        }
    }

    public ULongProgression(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new java.lang.IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new java.lang.IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.first = j;
        this.last = kotlin.internal.UProgressionUtilKt.m558getProgressionLastElement7ftBX0g(j, j2, j3);
        this.step = j3;
    }

    public /* synthetic */ ULongProgression(long j, long j2, long j3, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (other instanceof kotlin.ranges.ULongProgression) {
            if (!isEmpty() || !((kotlin.ranges.ULongProgression) other).isEmpty()) {
                kotlin.ranges.ULongProgression uLongProgression = (kotlin.ranges.ULongProgression) other;
                if (this.first != uLongProgression.first || this.last != uLongProgression.last || this.step != uLongProgression.step) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: getFirst-s-VKNKU, reason: not valid java name and from getter */
    public final long getFirst() {
        return this.first;
    }

    /* renamed from: getLast-s-VKNKU, reason: not valid java name and from getter */
    public final long getLast() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = this.first;
        int m215constructorimpl = ((int) kotlin.ULong.m215constructorimpl(j ^ kotlin.ULong.m215constructorimpl(j >>> 32))) * 31;
        long j2 = this.last;
        int m215constructorimpl2 = (m215constructorimpl + ((int) kotlin.ULong.m215constructorimpl(j2 ^ kotlin.ULong.m215constructorimpl(j2 >>> 32)))) * 31;
        long j3 = this.step;
        return ((int) (j3 ^ (j3 >>> 32))) + m215constructorimpl2;
    }

    public boolean isEmpty() {
        long j = this.step;
        int ulongCompare = kotlin.UnsignedKt.ulongCompare(this.first, this.last);
        if (j > 0) {
            if (ulongCompare > 0) {
                return true;
            }
        } else if (ulongCompare < 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @org.jetbrains.annotations.NotNull
    public final java.util.Iterator<kotlin.ULong> iterator() {
        return new kotlin.ranges.ULongProgressionIterator(this.first, this.last, this.step, null);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        java.lang.StringBuilder sb;
        long j;
        if (this.step > 0) {
            sb = new java.lang.StringBuilder();
            sb.append((java.lang.Object) kotlin.ULong.m219toStringimpl(this.first));
            sb.append("..");
            sb.append((java.lang.Object) kotlin.ULong.m219toStringimpl(this.last));
            sb.append(" step ");
            j = this.step;
        } else {
            sb = new java.lang.StringBuilder();
            sb.append((java.lang.Object) kotlin.ULong.m219toStringimpl(this.first));
            sb.append(" downTo ");
            sb.append((java.lang.Object) kotlin.ULong.m219toStringimpl(this.last));
            sb.append(" step ");
            j = -this.step;
        }
        sb.append(j);
        return sb.toString();
    }
}
