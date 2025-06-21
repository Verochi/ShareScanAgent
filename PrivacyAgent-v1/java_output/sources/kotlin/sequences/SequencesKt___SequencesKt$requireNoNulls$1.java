package kotlin.sequences;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class SequencesKt___SequencesKt$requireNoNulls$1<T> extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<T, T> {
    final /* synthetic */ kotlin.sequences.Sequence<T> $this_requireNoNulls;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$requireNoNulls$1(kotlin.sequences.Sequence<? extends T> sequence) {
        super(1);
        this.$this_requireNoNulls = sequence;
    }

    @Override // kotlin.jvm.functions.Function1
    @org.jetbrains.annotations.NotNull
    public final T invoke(@org.jetbrains.annotations.Nullable T t) {
        if (t != null) {
            return t;
        }
        throw new java.lang.IllegalArgumentException("null element found in " + this.$this_requireNoNulls + '.');
    }
}
