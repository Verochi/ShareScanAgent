package kotlin.sequences;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "index", "", "element", "invoke", "(ILjava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class SequencesKt___SequencesKt$onEachIndexed$1<T> extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function2<java.lang.Integer, T, T> {
    final /* synthetic */ kotlin.jvm.functions.Function2<java.lang.Integer, T, kotlin.Unit> $action;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$onEachIndexed$1(kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super T, kotlin.Unit> function2) {
        super(2);
        this.$action = function2;
    }

    public final T invoke(int i, T t) {
        this.$action.mo5invoke(java.lang.Integer.valueOf(i), t);
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ java.lang.Object mo5invoke(java.lang.Integer num, java.lang.Object obj) {
        return invoke(num.intValue(), (int) obj);
    }
}
