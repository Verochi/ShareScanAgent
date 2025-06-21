package kotlin.collections;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"kotlin/collections/RingBuffer$iterator$1", "Lkotlin/collections/AbstractIterator;", "", "computeNext", "", com.umeng.analytics.pro.bo.aN, "I", me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, "v", "index", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class RingBuffer$iterator$1<T> extends kotlin.collections.AbstractIterator<T> {

    /* renamed from: u, reason: from kotlin metadata */
    public int count;

    /* renamed from: v, reason: from kotlin metadata */
    public int index;
    public final /* synthetic */ kotlin.collections.RingBuffer<T> w;

    public RingBuffer$iterator$1(kotlin.collections.RingBuffer<T> ringBuffer) {
        int i;
        this.w = ringBuffer;
        this.count = ringBuffer.size();
        i = ringBuffer.startIndex;
        this.index = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractIterator
    public void computeNext() {
        java.lang.Object[] objArr;
        if (this.count == 0) {
            done();
            return;
        }
        objArr = this.w.buffer;
        setNext(objArr[this.index]);
        this.index = (this.index + 1) % this.w.capacity;
        this.count--;
    }
}
