package kotlin.ranges;

@kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0018\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\t\u0010\bø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0018"}, d2 = {"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/UInt;", com.anythink.expressad.foundation.d.c.bT, "endInclusive", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEndInclusive-pVg5ArA", "()I", "getStart-pVg5ArA", "contains", "", "value", "contains-WZ4Q5Ns", "(I)Z", "equals", "other", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
/* loaded from: classes14.dex */
public final class UIntRange extends kotlin.ranges.UIntProgression implements kotlin.ranges.ClosedRange<kotlin.UInt> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.UIntRange.Companion INSTANCE = new kotlin.ranges.UIntRange.Companion(null);

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.UIntRange v = new kotlin.ranges.UIntRange(-1, 0, null);

    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/ranges/UIntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/UIntRange;", "getEMPTY", "()Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @org.jetbrains.annotations.NotNull
        public final kotlin.ranges.UIntRange getEMPTY() {
            return kotlin.ranges.UIntRange.v;
        }
    }

    public UIntRange(int i, int i2) {
        super(i, i2, 1, null);
    }

    public /* synthetic */ UIntRange(int i, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(kotlin.UInt uInt) {
        return m572containsWZ4Q5Ns(uInt.getData());
    }

    /* renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public boolean m572containsWZ4Q5Ns(int value) {
        return kotlin.UnsignedKt.uintCompare(getFirst(), value) <= 0 && kotlin.UnsignedKt.uintCompare(value, getLast()) <= 0;
    }

    @Override // kotlin.ranges.UIntProgression
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (other instanceof kotlin.ranges.UIntRange) {
            if (!isEmpty() || !((kotlin.ranges.UIntRange) other).isEmpty()) {
                kotlin.ranges.UIntRange uIntRange = (kotlin.ranges.UIntRange) other;
                if (getFirst() != uIntRange.getFirst() || getLast() != uIntRange.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ kotlin.UInt getEndInclusive() {
        return kotlin.UInt.m190boximpl(m573getEndInclusivepVg5ArA());
    }

    /* renamed from: getEndInclusive-pVg5ArA, reason: not valid java name */
    public int m573getEndInclusivepVg5ArA() {
        return getLast();
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ kotlin.UInt getStart() {
        return kotlin.UInt.m190boximpl(m574getStartpVg5ArA());
    }

    /* renamed from: getStart-pVg5ArA, reason: not valid java name */
    public int m574getStartpVg5ArA() {
        return getFirst();
    }

    @Override // kotlin.ranges.UIntProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // kotlin.ranges.UIntProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return kotlin.UnsignedKt.uintCompare(getFirst(), getLast()) > 0;
    }

    @Override // kotlin.ranges.UIntProgression
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return ((java.lang.Object) kotlin.UInt.m195toStringimpl(getFirst())) + ".." + ((java.lang.Object) kotlin.UInt.m195toStringimpl(getLast()));
    }
}
