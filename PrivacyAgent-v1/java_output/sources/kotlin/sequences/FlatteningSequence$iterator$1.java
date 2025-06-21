package kotlin.sequences;

/* JADX INFO: Add missing generic type declarations: [E] */
@kotlin.Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"kotlin/sequences/FlatteningSequence$iterator$1", "", "next", "()Ljava/lang/Object;", "", "hasNext", "a", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "iterator", "t", "getItemIterator", "setItemIterator", "(Ljava/util/Iterator;)V", "itemIterator", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class FlatteningSequence$iterator$1<E> implements java.util.Iterator<E>, kotlin.jvm.internal.markers.KMappedMarker {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.Iterator<T> iterator;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public java.util.Iterator<? extends E> itemIterator;
    public final /* synthetic */ kotlin.sequences.FlatteningSequence<T, R, E> u;

    public FlatteningSequence$iterator$1(kotlin.sequences.FlatteningSequence<T, R, E> flatteningSequence) {
        kotlin.sequences.Sequence sequence;
        this.u = flatteningSequence;
        sequence = flatteningSequence.sequence;
        this.iterator = sequence.iterator();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a() {
        kotlin.jvm.functions.Function1 function1;
        kotlin.jvm.functions.Function1 function12;
        java.util.Iterator<? extends E> it = this.itemIterator;
        if ((it == null || it.hasNext()) ? false : true) {
            this.itemIterator = null;
        }
        while (true) {
            if (this.itemIterator != null) {
                break;
            }
            if (!this.iterator.hasNext()) {
                return false;
            }
            java.lang.Object next = this.iterator.next();
            function1 = this.u.iterator;
            function12 = this.u.transformer;
            java.util.Iterator<? extends E> it2 = (java.util.Iterator) function1.invoke(function12.invoke(next));
            if (it2.hasNext()) {
                this.itemIterator = it2;
                break;
            }
        }
    }

    @org.jetbrains.annotations.Nullable
    public final java.util.Iterator<E> getItemIterator() {
        return this.itemIterator;
    }

    @org.jetbrains.annotations.NotNull
    public final java.util.Iterator<T> getIterator() {
        return this.iterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return a();
    }

    @Override // java.util.Iterator
    public E next() {
        if (!a()) {
            throw new java.util.NoSuchElementException();
        }
        java.util.Iterator<? extends E> it = this.itemIterator;
        kotlin.jvm.internal.Intrinsics.checkNotNull(it);
        return it.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setItemIterator(@org.jetbrains.annotations.Nullable java.util.Iterator<? extends E> it) {
        this.itemIterator = it;
    }
}
