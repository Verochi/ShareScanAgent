package kotlin.sequences;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$sorted$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class SequencesKt___SequencesKt$sorted$1<T> implements kotlin.sequences.Sequence<T> {
    public final /* synthetic */ kotlin.sequences.Sequence<T> a;

    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$sorted$1(kotlin.sequences.Sequence<? extends T> sequence) {
        this.a = sequence;
    }

    @Override // kotlin.sequences.Sequence
    @org.jetbrains.annotations.NotNull
    public java.util.Iterator<T> iterator() {
        java.util.List mutableList = kotlin.sequences.SequencesKt___SequencesKt.toMutableList(this.a);
        kotlin.collections.CollectionsKt__MutableCollectionsJVMKt.sort(mutableList);
        return mutableList.iterator();
    }
}
