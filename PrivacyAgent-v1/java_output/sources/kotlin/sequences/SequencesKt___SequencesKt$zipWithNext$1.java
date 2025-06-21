package kotlin.sequences;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Lkotlin/Pair;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "a", "b", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class SequencesKt___SequencesKt$zipWithNext$1<T> extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function2<T, T, kotlin.Pair<? extends T, ? extends T>> {
    public static final kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$1 INSTANCE = new kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$1();

    public SequencesKt___SequencesKt$zipWithNext$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.NotNull
    /* renamed from: invoke */
    public final kotlin.Pair<T, T> mo5invoke(T t, T t2) {
        return kotlin.TuplesKt.to(t, t2);
    }
}
