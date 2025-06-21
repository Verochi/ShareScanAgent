package kotlin.sequences;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "it", "Lkotlin/collections/IndexedValue;", "invoke", "(Lkotlin/collections/IndexedValue;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class SequencesKt___SequencesKt$filterIndexed$1<T> extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<kotlin.collections.IndexedValue<? extends T>, java.lang.Boolean> {
    final /* synthetic */ kotlin.jvm.functions.Function2<java.lang.Integer, T, java.lang.Boolean> $predicate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$filterIndexed$1(kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super T, java.lang.Boolean> function2) {
        super(1);
        this.$predicate = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    @org.jetbrains.annotations.NotNull
    public final java.lang.Boolean invoke(@org.jetbrains.annotations.NotNull kotlin.collections.IndexedValue<? extends T> it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return this.$predicate.mo5invoke(java.lang.Integer.valueOf(it.getIndex()), it.getValue());
    }
}
