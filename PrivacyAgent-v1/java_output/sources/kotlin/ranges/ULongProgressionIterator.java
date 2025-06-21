package kotlin.ranges;

@kotlin.SinceKotlin(version = "1.3")
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\"\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0012ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\u0016\u0010\u0005\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\f\u0010\bR\u001c\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u000e\u0010\bø\u0001\u0001\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lkotlin/ranges/ULongProgressionIterator;", "", "Lkotlin/ULong;", "", "hasNext", "a", "()J", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "J", "finalElement", "t", "Z", com.umeng.analytics.pro.bo.aN, "step", "v", "next", "first", "last", "", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class ULongProgressionIterator implements java.util.Iterator<kotlin.ULong>, kotlin.jvm.internal.markers.KMappedMarker {

    /* renamed from: n, reason: from kotlin metadata */
    public final long finalElement;

    /* renamed from: t, reason: from kotlin metadata */
    public boolean hasNext;

    /* renamed from: u, reason: from kotlin metadata */
    public final long step;

    /* renamed from: v, reason: from kotlin metadata */
    public long next;

    public ULongProgressionIterator(long j, long j2, long j3) {
        this.finalElement = j2;
        boolean z = true;
        int ulongCompare = kotlin.UnsignedKt.ulongCompare(j, j2);
        if (j3 <= 0 ? ulongCompare < 0 : ulongCompare > 0) {
            z = false;
        }
        this.hasNext = z;
        this.step = kotlin.ULong.m215constructorimpl(j3);
        this.next = this.hasNext ? j : j2;
    }

    public /* synthetic */ ULongProgressionIterator(long j, long j2, long j3, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    public long a() {
        long j = this.next;
        if (j != this.finalElement) {
            this.next = kotlin.ULong.m215constructorimpl(this.step + j);
        } else {
            if (!this.hasNext) {
                throw new java.util.NoSuchElementException();
            }
            this.hasNext = false;
        }
        return j;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ kotlin.ULong next() {
        return kotlin.ULong.m214boximpl(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
