package kotlin.comparisons;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class ComparisonsKt__ComparisonsKt$compareBy$1<T> implements java.util.Comparator {
    public final /* synthetic */ kotlin.jvm.functions.Function1<T, java.lang.Comparable<?>>[] n;

    /* JADX WARN: Multi-variable type inference failed */
    public ComparisonsKt__ComparisonsKt$compareBy$1(kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Comparable<?>>[] function1Arr) {
        this.n = function1Arr;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int a;
        a = kotlin.comparisons.ComparisonsKt__ComparisonsKt.a(t, t2, this.n);
        return a;
    }
}
