package kotlin.sequences;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¨\u0006\u0004"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class SequencesKt__SequencesKt$Sequence$1 implements kotlin.sequences.Sequence<java.lang.Object> {
    public final /* synthetic */ kotlin.jvm.functions.Function0<java.util.Iterator<java.lang.Object>> a;

    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt__SequencesKt$Sequence$1(kotlin.jvm.functions.Function0<? extends java.util.Iterator<java.lang.Object>> function0) {
        this.a = function0;
    }

    @Override // kotlin.sequences.Sequence
    @org.jetbrains.annotations.NotNull
    public java.util.Iterator<java.lang.Object> iterator() {
        return this.a.invoke();
    }
}
