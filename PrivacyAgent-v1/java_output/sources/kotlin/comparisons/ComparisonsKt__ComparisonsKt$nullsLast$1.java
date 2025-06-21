package kotlin.comparisons;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "a", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class ComparisonsKt__ComparisonsKt$nullsLast$1<T> implements java.util.Comparator {
    public final /* synthetic */ java.util.Comparator<? super T> n;

    public ComparisonsKt__ComparisonsKt$nullsLast$1(java.util.Comparator<? super T> comparator) {
        this.n = comparator;
    }

    @Override // java.util.Comparator
    public final int compare(@org.jetbrains.annotations.Nullable T t, @org.jetbrains.annotations.Nullable T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return 1;
        }
        if (t2 == null) {
            return -1;
        }
        return this.n.compare(t, t2);
    }
}
