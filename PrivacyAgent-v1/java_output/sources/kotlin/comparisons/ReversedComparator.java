package kotlin.comparisons;

@kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003B\u001f\u0012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003R'\u0010\r\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u00038\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0004\u0010\f¨\u0006\u0010"}, d2 = {"Lkotlin/comparisons/ReversedComparator;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Comparator;", "Lkotlin/Comparator;", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "reversed", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/util/Comparator;", "()Ljava/util/Comparator;", "comparator", "<init>", "(Ljava/util/Comparator;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class ReversedComparator<T> implements java.util.Comparator<T> {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.Comparator<T> comparator;

    public ReversedComparator(@org.jetbrains.annotations.NotNull java.util.Comparator<T> comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        this.comparator = comparator;
    }

    @org.jetbrains.annotations.NotNull
    public final java.util.Comparator<T> a() {
        return this.comparator;
    }

    @Override // java.util.Comparator
    public int compare(T a, T b) {
        return this.comparator.compare(b, a);
    }

    @Override // java.util.Comparator
    @org.jetbrains.annotations.NotNull
    public final java.util.Comparator<T> reversed() {
        return this.comparator;
    }
}
