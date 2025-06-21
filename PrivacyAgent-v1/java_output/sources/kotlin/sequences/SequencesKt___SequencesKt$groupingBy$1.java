package kotlin.sequences;

/* JADX INFO: Add missing generic type declarations: [T, K] */
@kotlin.Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0015\u0010\u0002\u001a\u00028\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¨\u0006\u0007"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$groupingBy$1", "Lkotlin/collections/Grouping;", "keyOf", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "sourceIterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes14.dex */
public final class SequencesKt___SequencesKt$groupingBy$1<K, T> implements kotlin.collections.Grouping<T, K> {
    public final /* synthetic */ kotlin.sequences.Sequence<T> a;
    public final /* synthetic */ kotlin.jvm.functions.Function1<T, K> b;

    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$groupingBy$1(kotlin.sequences.Sequence<? extends T> sequence, kotlin.jvm.functions.Function1<? super T, ? extends K> function1) {
        this.a = sequence;
        this.b = function1;
    }

    @Override // kotlin.collections.Grouping
    public K keyOf(T element) {
        return this.b.invoke(element);
    }

    @Override // kotlin.collections.Grouping
    @org.jetbrains.annotations.NotNull
    public java.util.Iterator<T> sourceIterator() {
        return this.a.iterator();
    }
}
