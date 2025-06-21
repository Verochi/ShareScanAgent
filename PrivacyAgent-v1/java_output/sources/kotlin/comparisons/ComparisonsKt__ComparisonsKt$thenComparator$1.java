package kotlin.comparisons;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes14.dex */
public final class ComparisonsKt__ComparisonsKt$thenComparator$1<T> implements java.util.Comparator {
    public final /* synthetic */ java.util.Comparator<T> n;
    public final /* synthetic */ kotlin.jvm.functions.Function2<T, T, java.lang.Integer> t;

    /* JADX WARN: Multi-variable type inference failed */
    public ComparisonsKt__ComparisonsKt$thenComparator$1(java.util.Comparator<T> comparator, kotlin.jvm.functions.Function2<? super T, ? super T, java.lang.Integer> function2) {
        this.n = comparator;
        this.t = function2;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int compare = this.n.compare(t, t2);
        return compare != 0 ? compare : this.t.mo5invoke(t, t2).intValue();
    }
}
