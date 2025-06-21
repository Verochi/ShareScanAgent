package kotlin.sequences;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002R$\u0010\r\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u0003\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"kotlin/sequences/GeneratorSequence$iterator$1", "", "next", "()Ljava/lang/Object;", "", "hasNext", "", "a", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/lang/Object;", "getNextItem", "setNextItem", "(Ljava/lang/Object;)V", "nextItem", "", "t", "I", "getNextState", "()I", "setNextState", "(I)V", "nextState", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GeneratorSequence$iterator$1<T> implements java.util.Iterator<T>, kotlin.jvm.internal.markers.KMappedMarker {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public T nextItem;

    /* renamed from: t, reason: from kotlin metadata */
    public int nextState = -2;
    public final /* synthetic */ kotlin.sequences.GeneratorSequence<T> u;

    public GeneratorSequence$iterator$1(kotlin.sequences.GeneratorSequence<T> generatorSequence) {
        this.u = generatorSequence;
    }

    public final void a() {
        kotlin.jvm.functions.Function1 function1;
        T t;
        kotlin.jvm.functions.Function0 function0;
        if (this.nextState == -2) {
            function0 = this.u.getInitialValue;
            t = (T) function0.invoke();
        } else {
            function1 = this.u.getNextValue;
            T t2 = this.nextItem;
            kotlin.jvm.internal.Intrinsics.checkNotNull(t2);
            t = (T) function1.invoke(t2);
        }
        this.nextItem = t;
        this.nextState = t == null ? 0 : 1;
    }

    @org.jetbrains.annotations.Nullable
    public final T getNextItem() {
        return this.nextItem;
    }

    public final int getNextState() {
        return this.nextState;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextState < 0) {
            a();
        }
        return this.nextState == 1;
    }

    @Override // java.util.Iterator
    @org.jetbrains.annotations.NotNull
    public T next() {
        if (this.nextState < 0) {
            a();
        }
        if (this.nextState == 0) {
            throw new java.util.NoSuchElementException();
        }
        T t = this.nextItem;
        kotlin.jvm.internal.Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
        this.nextState = -1;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setNextItem(@org.jetbrains.annotations.Nullable T t) {
        this.nextItem = t;
    }

    public final void setNextState(int i) {
        this.nextState = i;
    }
}
