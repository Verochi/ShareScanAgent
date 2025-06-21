package kotlin.comparisons;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes14.dex */
public final class ComparisonsKt__ComparisonsKt$thenByDescending$2<T> implements java.util.Comparator {
    public final /* synthetic */ java.util.Comparator<T> n;
    public final /* synthetic */ java.util.Comparator<java.lang.Object> t;
    public final /* synthetic */ kotlin.jvm.functions.Function1<T, java.lang.Object> u;

    /* JADX WARN: Multi-variable type inference failed */
    public ComparisonsKt__ComparisonsKt$thenByDescending$2(java.util.Comparator<T> comparator, java.util.Comparator<java.lang.Object> comparator2, kotlin.jvm.functions.Function1<? super T, java.lang.Object> function1) {
        this.n = comparator;
        this.t = comparator2;
        this.u = function1;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int compare = this.n.compare(t, t2);
        if (compare != 0) {
            return compare;
        }
        java.util.Comparator<java.lang.Object> comparator = this.t;
        kotlin.jvm.functions.Function1<T, java.lang.Object> function1 = this.u;
        return comparator.compare(function1.invoke(t2), function1.invoke(t));
    }
}
