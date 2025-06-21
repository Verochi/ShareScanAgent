package kotlin.ranges;

@kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0017\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB$\b\u0000\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0086\u0002ø\u0001\u0000J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u0010\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lkotlin/ranges/UIntProgression;", "", "Lkotlin/UInt;", "", "iterator", "", "isEmpty", "", "other", "equals", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "toString", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", "first", "t", "last", com.umeng.analytics.pro.bo.aN, "getStep", "()I", "step", com.anythink.expressad.foundation.d.c.bT, "endInclusive", "<init>", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
/* loaded from: classes14.dex */
public class UIntProgression implements java.lang.Iterable<kotlin.UInt>, kotlin.jvm.internal.markers.KMappedMarker {

    /* renamed from: Companion, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.UIntProgression.Companion INSTANCE = new kotlin.ranges.UIntProgression.Companion(null);

    /* renamed from: n, reason: from kotlin metadata */
    public final int first;

    /* renamed from: t, reason: from kotlin metadata */
    public final int last;

    /* renamed from: u, reason: from kotlin metadata */
    public final int step;

    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lkotlin/ranges/UIntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/UIntProgression;", "rangeStart", "Lkotlin/UInt;", "rangeEnd", "step", "", "fromClosedRange-Nkh28Cs", "(III)Lkotlin/ranges/UIntProgression;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @org.jetbrains.annotations.NotNull
        /* renamed from: fromClosedRange-Nkh28Cs, reason: not valid java name */
        public final kotlin.ranges.UIntProgression m571fromClosedRangeNkh28Cs(int rangeStart, int rangeEnd, int step) {
            return new kotlin.ranges.UIntProgression(rangeStart, rangeEnd, step, null);
        }
    }

    public UIntProgression(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new java.lang.IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new java.lang.IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.first = i;
        this.last = kotlin.internal.UProgressionUtilKt.m559getProgressionLastElementNkh28Cs(i, i2, i3);
        this.step = i3;
    }

    public /* synthetic */ UIntProgression(int i, int i2, int i3, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (other instanceof kotlin.ranges.UIntProgression) {
            if (!isEmpty() || !((kotlin.ranges.UIntProgression) other).isEmpty()) {
                kotlin.ranges.UIntProgression uIntProgression = (kotlin.ranges.UIntProgression) other;
                if (this.first != uIntProgression.first || this.last != uIntProgression.last || this.step != uIntProgression.step) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: getFirst-pVg5ArA, reason: not valid java name and from getter */
    public final int getFirst() {
        return this.first;
    }

    /* renamed from: getLast-pVg5ArA, reason: not valid java name and from getter */
    public final int getLast() {
        return this.last;
    }

    public final int getStep() {
        return this.step;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.first * 31) + this.last) * 31) + this.step;
    }

    public boolean isEmpty() {
        if (this.step > 0) {
            if (kotlin.UnsignedKt.uintCompare(this.first, this.last) > 0) {
                return true;
            }
        } else if (kotlin.UnsignedKt.uintCompare(this.first, this.last) < 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @org.jetbrains.annotations.NotNull
    public final java.util.Iterator<kotlin.UInt> iterator() {
        return new kotlin.ranges.UIntProgressionIterator(this.first, this.last, this.step, null);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        java.lang.StringBuilder sb;
        int i;
        if (this.step > 0) {
            sb = new java.lang.StringBuilder();
            sb.append((java.lang.Object) kotlin.UInt.m195toStringimpl(this.first));
            sb.append("..");
            sb.append((java.lang.Object) kotlin.UInt.m195toStringimpl(this.last));
            sb.append(" step ");
            i = this.step;
        } else {
            sb = new java.lang.StringBuilder();
            sb.append((java.lang.Object) kotlin.UInt.m195toStringimpl(this.first));
            sb.append(" downTo ");
            sb.append((java.lang.Object) kotlin.UInt.m195toStringimpl(this.last));
            sb.append(" step ");
            i = -this.step;
        }
        sb.append(i);
        return sb.toString();
    }
}
