package kotlin.comparisons;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes14.dex */
public final class ComparisonsKt__ComparisonsKt$compareBy$2<T> implements java.util.Comparator {
    public final /* synthetic */ kotlin.jvm.functions.Function1<T, java.lang.Comparable<?>> n;

    /* JADX WARN: Multi-variable type inference failed */
    public ComparisonsKt__ComparisonsKt$compareBy$2(kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Comparable<?>> function1) {
        this.n = function1;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int compareValues;
        kotlin.jvm.functions.Function1<T, java.lang.Comparable<?>> function1 = this.n;
        compareValues = kotlin.comparisons.ComparisonsKt__ComparisonsKt.compareValues(function1.invoke(t), function1.invoke(t2));
        return compareValues;
    }
}
