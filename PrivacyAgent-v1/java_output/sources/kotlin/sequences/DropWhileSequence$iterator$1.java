package kotlin.sequences;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001a\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0003\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"kotlin/sequences/DropWhileSequence$iterator$1", "", "next", "()Ljava/lang/Object;", "", "hasNext", "", "a", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "iterator", "", "t", "I", "getDropState", "()I", "setDropState", "(I)V", "dropState", com.umeng.analytics.pro.bo.aN, "Ljava/lang/Object;", "getNextItem", "setNextItem", "(Ljava/lang/Object;)V", "nextItem", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DropWhileSequence$iterator$1<T> implements java.util.Iterator<T>, kotlin.jvm.internal.markers.KMappedMarker {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.Iterator<T> iterator;

    /* renamed from: t, reason: from kotlin metadata */
    public int dropState;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public T nextItem;
    public final /* synthetic */ kotlin.sequences.DropWhileSequence<T> v;

    public DropWhileSequence$iterator$1(kotlin.sequences.DropWhileSequence<T> dropWhileSequence) {
        kotlin.sequences.Sequence sequence;
        this.v = dropWhileSequence;
        sequence = dropWhileSequence.sequence;
        this.iterator = sequence.iterator();
        this.dropState = -1;
    }

    public final void a() {
        kotlin.jvm.functions.Function1 function1;
        while (this.iterator.hasNext()) {
            T next = this.iterator.next();
            function1 = this.v.predicate;
            if (!((java.lang.Boolean) function1.invoke(next)).booleanValue()) {
                this.nextItem = next;
                this.dropState = 1;
                return;
            }
        }
        this.dropState = 0;
    }

    public final int getDropState() {
        return this.dropState;
    }

    @org.jetbrains.annotations.NotNull
    public final java.util.Iterator<T> getIterator() {
        return this.iterator;
    }

    @org.jetbrains.annotations.Nullable
    public final T getNextItem() {
        return this.nextItem;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.dropState == -1) {
            a();
        }
        return this.dropState == 1 || this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.dropState == -1) {
            a();
        }
        if (this.dropState != 1) {
            return this.iterator.next();
        }
        T t = this.nextItem;
        this.nextItem = null;
        this.dropState = 0;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setDropState(int i) {
        this.dropState = i;
    }

    public final void setNextItem(@org.jetbrains.annotations.Nullable T t) {
        this.nextItem = t;
    }
}
