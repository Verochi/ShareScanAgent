package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0081@\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003B\u0014\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0007\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0016\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\u0088\u0001\u0013\u0092\u0001\u0004\u0018\u00010\u0003ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/internal/SegmentOrClosed;", "Lkotlinx/coroutines/internal/Segment;", androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, "", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "", "hashCode-impl", "(Ljava/lang/Object;)I", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "other", "", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "equals", "a", "Ljava/lang/Object;", "value", "isClosed-impl", "(Ljava/lang/Object;)Z", "isClosed", "getSegment-impl", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/Segment;", "getSegment$annotations", "()V", "segment", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
@kotlin.jvm.JvmInline
/* loaded from: classes16.dex */
public final class SegmentOrClosed<S extends kotlinx.coroutines.internal.Segment<S>> {

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object value;

    public /* synthetic */ SegmentOrClosed(java.lang.Object obj) {
        this.value = obj;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ kotlinx.coroutines.internal.SegmentOrClosed m805boximpl(java.lang.Object obj) {
        return new kotlinx.coroutines.internal.SegmentOrClosed(obj);
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static <S extends kotlinx.coroutines.internal.Segment<S>> java.lang.Object m806constructorimpl(@org.jetbrains.annotations.Nullable java.lang.Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m807equalsimpl(java.lang.Object obj, java.lang.Object obj2) {
        return (obj2 instanceof kotlinx.coroutines.internal.SegmentOrClosed) && kotlin.jvm.internal.Intrinsics.areEqual(obj, ((kotlinx.coroutines.internal.SegmentOrClosed) obj2).getValue());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m808equalsimpl0(java.lang.Object obj, java.lang.Object obj2) {
        return kotlin.jvm.internal.Intrinsics.areEqual(obj, obj2);
    }

    public static /* synthetic */ void getSegment$annotations() {
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: getSegment-impl, reason: not valid java name */
    public static final S m809getSegmentimpl(java.lang.Object obj) {
        if (obj == kotlinx.coroutines.internal.ConcurrentLinkedListKt.a) {
            throw new java.lang.IllegalStateException("Does not contain segment".toString());
        }
        if (obj != null) {
            return (S) obj;
        }
        throw new java.lang.NullPointerException("null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m810hashCodeimpl(java.lang.Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isClosed-impl, reason: not valid java name */
    public static final boolean m811isClosedimpl(java.lang.Object obj) {
        return obj == kotlinx.coroutines.internal.ConcurrentLinkedListKt.a;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static java.lang.String m812toStringimpl(java.lang.Object obj) {
        return "SegmentOrClosed(value=" + obj + ')';
    }

    public boolean equals(java.lang.Object obj) {
        return m807equalsimpl(getValue(), obj);
    }

    public int hashCode() {
        return m810hashCodeimpl(getValue());
    }

    public java.lang.String toString() {
        return m812toStringimpl(getValue());
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ java.lang.Object getValue() {
        return this.value;
    }
}
