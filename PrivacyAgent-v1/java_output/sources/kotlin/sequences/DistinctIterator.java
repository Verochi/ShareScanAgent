package kotlin.sequences;

@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B)\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u000ej\b\u0012\u0004\u0012\u00028\u0001`\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lkotlin/sequences/DistinctIterator;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "K", "Lkotlin/collections/AbstractIterator;", "", "computeNext", "", com.umeng.analytics.pro.bo.aN, "Ljava/util/Iterator;", com.tencent.open.SocialConstants.PARAM_SOURCE, "Lkotlin/Function1;", "v", "Lkotlin/jvm/functions/Function1;", "keySelector", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Ljava/util/HashSet;", "observed", "<init>", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class DistinctIterator<T, K> extends kotlin.collections.AbstractIterator<T> {

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.Iterator<T> source;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function1<T, K> keySelector;

    /* renamed from: w, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.HashSet<K> observed;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctIterator(@org.jetbrains.annotations.NotNull java.util.Iterator<? extends T> source, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        this.source = source;
        this.keySelector = keySelector;
        this.observed = new java.util.HashSet<>();
    }

    @Override // kotlin.collections.AbstractIterator
    public void computeNext() {
        while (this.source.hasNext()) {
            T next = this.source.next();
            if (this.observed.add(this.keySelector.invoke(next))) {
                setNext(next);
                return;
            }
        }
        done();
    }
}
