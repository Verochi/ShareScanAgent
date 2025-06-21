package kotlin.sequences;

/* JADX INFO: Add missing generic type declarations: [R] */
@kotlin.Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class SequencesKt___SequencesKt$flatMapIndexed$2<R> extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function1<kotlin.sequences.Sequence<? extends R>, java.util.Iterator<? extends R>> {
    public static final kotlin.sequences.SequencesKt___SequencesKt$flatMapIndexed$2 INSTANCE = new kotlin.sequences.SequencesKt___SequencesKt$flatMapIndexed$2();

    public SequencesKt___SequencesKt$flatMapIndexed$2() {
        super(1, kotlin.sequences.Sequence.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    @org.jetbrains.annotations.NotNull
    public final java.util.Iterator<R> invoke(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends R> p0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
        return p0.iterator();
    }
}
