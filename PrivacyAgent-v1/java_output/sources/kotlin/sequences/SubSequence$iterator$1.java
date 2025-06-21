package kotlin.sequences;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001a\u00020\u0006H\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"kotlin/sequences/SubSequence$iterator$1", "", "", "hasNext", "next", "()Ljava/lang/Object;", "", "a", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "iterator", "", "t", "I", "getPosition", "()I", "setPosition", "(I)V", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class SubSequence$iterator$1<T> implements java.util.Iterator<T>, kotlin.jvm.internal.markers.KMappedMarker {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.Iterator<T> iterator;

    /* renamed from: t, reason: from kotlin metadata */
    public int position;
    public final /* synthetic */ kotlin.sequences.SubSequence<T> u;

    public SubSequence$iterator$1(kotlin.sequences.SubSequence<T> subSequence) {
        kotlin.sequences.Sequence sequence;
        this.u = subSequence;
        sequence = subSequence.sequence;
        this.iterator = sequence.iterator();
    }

    /* JADX WARN: Incorrect condition in loop: B:2:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        int i;
        while (r0 < i && this.iterator.hasNext()) {
            this.iterator.next();
            this.position++;
        }
    }

    @org.jetbrains.annotations.NotNull
    public final java.util.Iterator<T> getIterator() {
        return this.iterator;
    }

    public final int getPosition() {
        return this.position;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i;
        a();
        int i2 = this.position;
        i = this.u.endIndex;
        return i2 < i && this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        int i;
        a();
        int i2 = this.position;
        i = this.u.endIndex;
        if (i2 >= i) {
            throw new java.util.NoSuchElementException();
        }
        this.position++;
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setPosition(int i) {
        this.position = i;
    }
}
