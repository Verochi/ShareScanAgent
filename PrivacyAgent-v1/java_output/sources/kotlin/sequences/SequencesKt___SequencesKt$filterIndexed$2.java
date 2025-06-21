package kotlin.sequences;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "it", "Lkotlin/collections/IndexedValue;", "invoke", "(Lkotlin/collections/IndexedValue;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class SequencesKt___SequencesKt$filterIndexed$2<T> extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<kotlin.collections.IndexedValue<? extends T>, T> {
    public static final kotlin.sequences.SequencesKt___SequencesKt$filterIndexed$2 INSTANCE = new kotlin.sequences.SequencesKt___SequencesKt$filterIndexed$2();

    public SequencesKt___SequencesKt$filterIndexed$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final T invoke(@org.jetbrains.annotations.NotNull kotlin.collections.IndexedValue<? extends T> it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return it.getValue();
    }
}
