package kotlin.sequences;

/* JADX INFO: Add missing generic type declarations: [R, T] */
@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\u0005\u001a\u0002H\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Lkotlin/Pair;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "R", "t1", "t2", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class SequencesKt___SequencesKt$zip$1<R, T> extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function2<T, R, kotlin.Pair<? extends T, ? extends R>> {
    public static final kotlin.sequences.SequencesKt___SequencesKt$zip$1 INSTANCE = new kotlin.sequences.SequencesKt___SequencesKt$zip$1();

    public SequencesKt___SequencesKt$zip$1() {
        super(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ java.lang.Object mo5invoke(java.lang.Object obj, java.lang.Object obj2) {
        return mo5invoke((kotlin.sequences.SequencesKt___SequencesKt$zip$1<R, T>) obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.NotNull
    /* renamed from: invoke */
    public final kotlin.Pair<T, R> mo5invoke(T t, R r) {
        return kotlin.TuplesKt.to(t, r);
    }
}
