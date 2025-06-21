package kotlin.streams.jdk8;

@kotlin.Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class StreamsKt$asSequence$$inlined$Sequence$2 implements kotlin.sequences.Sequence<java.lang.Integer> {
    public final /* synthetic */ java.util.stream.IntStream a;

    public StreamsKt$asSequence$$inlined$Sequence$2(java.util.stream.IntStream intStream) {
        this.a = intStream;
    }

    @Override // kotlin.sequences.Sequence
    @org.jetbrains.annotations.NotNull
    public java.util.Iterator<java.lang.Integer> iterator() {
        java.util.PrimitiveIterator.OfInt it;
        it = this.a.iterator();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "iterator()");
        return it;
    }
}
